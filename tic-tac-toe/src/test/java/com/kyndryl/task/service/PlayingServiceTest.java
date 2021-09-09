//package com.kyndryl.task.service;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//
//import com.kyndryl.task.TicTacToeApplication;
//
//import cucumber.api.java8.En;
//
//@SpringBootTest(classes = TicTacToeApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
//public class PlayingServiceTest implements En{
//	Given("Current player is X")
//
//	    And("with the following phone numbers", (DataTable phoneDt) -> {
//	      List<Phone> phoneList = phoneDt.asList(Phone.class);
//	      super.testContext()
//	          .getPayload(Employee.class)
//	          .setPhones(phoneList);
//	    });
//
//	    When("user saves the new employee {string}", (String testContext) -> {
//	      String createEmployeeUrl = "/v1/employees";
//
//	      // AbstractSteps class makes the POST call and stores response in TestContext
//	      executePost(createEmployeeUrl);
//	    });
//
//	    /**
//	     * This can be moved to a Class named 'CommonSteps.java so that it can be reused.
//	     */
//	    Then("the save {string}", (String expectedResult) -> {
//	      Response response = testContext().getResponse();
//
//	      switch (expectedResult) {
//	        case "IS SUCCESSFUL":
//	          assertThat(response.statusCode()).isIn(200, 201);
//	          break;
//	        case "FAILS":
//	          assertThat(response.statusCode()).isBetween(400, 504);
//	          break;
//	        default:
//	          fail("Unexpected error");
//	      }
//	    });
//}
