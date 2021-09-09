package com.kyndryl.task.service.play;

import static com.kyndryl.task.util.Constants.MESSAGE_GAME_ENDS;
import static com.kyndryl.task.util.Constants.MESSAGE_PLAYER_WON;
import static com.kyndryl.task.util.Constants.TASK_DELAY;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyndryl.task.dto.PlayDto;
import com.kyndryl.task.enums.PlayerEnum;
import com.kyndryl.task.event.NextMoveEvent;
import com.kyndryl.task.event.EventPublisher;
import com.kyndryl.task.service.drawing.DrawingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayServiceImpl implements PlayService, Runnable, ApplicationListener<NextMoveEvent> {

	private static AtomicBoolean running = new AtomicBoolean(true);

	private final AtomicInteger count = new AtomicInteger(0);

	private static List<int[][]> POSITION_LIST = new ArrayList<int[][]>();
	
	private static BlockingQueue<PlayDto> blockingQueue = new LinkedBlockingDeque<>();

	static {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					POSITION_LIST.add(new int[][] { { i, j } });
				}
			}
		}
	}

	private final DrawingService drawingService;

	private final EventPublisher eventPublisher;

	private final ScheduledExecutorService scheduledExecutorService;

	private char[][] board;

	@Autowired
	public PlayServiceImpl(final DrawingService drawingService, 
			final EventPublisher eventPublisher) {
		this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
		this.drawingService = drawingService;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void startGame() {
		this.board = drawingService.drawBoard();
		while (running.get()) {

			try {
				scheduledExecutorService.scheduleAtFixedRate(this, TASK_DELAY, TASK_DELAY, TimeUnit.SECONDS).get();
			} catch (InterruptedException | ExecutionException | CancellationException e) {
				log.error("Exited");
			}
		}
	}

	@Override
	public void nextMove() {
		final int nextIndex = new Random().ints(0, POSITION_LIST.size()).findFirst().getAsInt();

		final int realRow = POSITION_LIST.get(nextIndex)[0][0];
		final int realCol = POSITION_LIST.get(nextIndex)[0][1];

		final PlayerEnum player = PlayerEnum.nextPlayer();
		POSITION_LIST.remove(nextIndex);
		final PlayDto playDto = new PlayDto(realRow, realCol, player);
		eventPublisher.publishCustomEvent(playDto);
	}
	
	@Override
	public void markMove(final PlayDto playDto) {
		board[playDto.getRow()][playDto.getColumn()] = playDto.getPlayer().toString().charAt(0);
	}

	private String playerHasWon() {
		// Check each row
		for (int i = 0; i < 5; i++) {
			final boolean equalRow = i % 2 == 0 && (board[i][0] == board[i][2] && board[i][2] == board[i][4])
					&& board[i][0] != ' ';
			if ((equalRow && board[i][0] == 'O') || (equalRow && board[i][0] == 'X')) {
				// System.out.println(String.format(MESSAGE_PLAYER_WON, board[i][0]));
				return String.format(MESSAGE_PLAYER_WON, board[i][0]);
			}
		}

		// Check each column
		for (int j = 0; j < 5; j++) {
			final boolean equalCol = j % 2 == 0 && board[0][j] == board[2][j] && board[2][j] == board[4][j]
					&& board[0][j] != ' ';
			if (equalCol && board[0][j] != 'O' || equalCol && board[0][j] != 'X') {
				// System.out.println(String.format(MESSAGE_PLAYER_WON, board[0][j]));
				return String.format(MESSAGE_PLAYER_WON, board[0][j]);
			}
		}

		// Check the diagonals
		final boolean leftDiagonal = board[0][0] == board[2][2] && board[2][2] == board[4][4] && board[0][0] != ' ';
		if ((leftDiagonal && board[0][0] != 'O') || (leftDiagonal && board[0][0] != 'X')) {
			// System.out.println(String.format(MESSAGE_PLAYER_WON, board[0][0]));
			return String.format(MESSAGE_PLAYER_WON, board[0][0]);
		}

		// right diagonal
		final boolean rightDiagonal = board[4][0] == board[2][2] && board[2][2] == board[0][4] && board[4][0] != ' ';
		if ((rightDiagonal && board[4][0] != 'O') || (rightDiagonal && board[4][0] != 'X')) {
			// System.out.println(String.format(MESSAGE_PLAYER_WON, board[4][0]));
			return String.format(MESSAGE_PLAYER_WON, board[4][0]);
		}

		return Strings.EMPTY;
	}

	@Override
	public void endGame(final String reason) {
		running = new AtomicBoolean(false);
		System.out.println(reason);
		scheduledExecutorService.shutdown();
	}

	@Override
	public void run() {
		if (!Strings.isEmpty(playerHasWon())) {
			endGame(playerHasWon());
			return;
		}

		if (count.getAndIncrement() == 9) {
			endGame(MESSAGE_GAME_ENDS);
			return;
		}

		//final PlayDto playDto = nextMove();
		nextMove();
		final PlayDto playDto = blockingQueue.poll();
		markMove(playDto);
		drawingService.printBoard(board);
	}

	@Override
	public void onApplicationEvent(final NextMoveEvent event) {
		final PlayDto playDto = (PlayDto) event.getSource();
		System.out.println("Received event data:=" + playDto );
		blockingQueue.add(playDto);
	}

}
