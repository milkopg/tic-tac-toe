#Start a game
@tag
Feature: Game start
Acceptance tests for start game

@tag1
Scenario: Player X won
Given Current player is X
When Player X and Player O moves 
Then Player X won

@tag2
Scenario: Player O won
Given Current player is X
When Player X and Player O moves 
Then Player O won

@tag3
Scenario: Draw game
Given Current player is X
When Player X and Player O moves 
Then Draw game



#Booking a room
#@tag
#Feature: Room Booking
#	Acceptance tests for booking a room at the hotel

#@tag1
#Scenario: Existing customer books empty room
#Given The user is an existing customer "Joe" "User"
#When The user books room 123 for 5 nights
#Then The user should receive message confirming booking