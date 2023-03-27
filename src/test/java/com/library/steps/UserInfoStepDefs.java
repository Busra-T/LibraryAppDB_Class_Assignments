package com.library.steps;


import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserInfoStepDefs {

    String actualUserCount;

    @Given("Establish the database connection")
    public void establishTheDatabaseConnection() {
        //DB_Util.createConnection();
    }

    @When("Execute query to get all IDs from users")
    public void executeQueryToGetAllIDsFromUsers() {
        String query = "select count(id) from users";
        DB_Util.runQuery(query);

        actualUserCount = DB_Util.getFirstRowFirstColumn();
        //Remember: local variable over global variable rule

        System.out.println("actualUserCount = " + actualUserCount);
    }

    @Then("verify all users has unique ID")
    public void verifyAllUsersHasUniqueID() {
        String query="select distinct count(id) from users";
        String expectedUserCount = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCount = " + expectedUserCount);

        Assert.assertEquals(expectedUserCount,actualUserCount);


        // DB_Util.destroy();
    }


}
