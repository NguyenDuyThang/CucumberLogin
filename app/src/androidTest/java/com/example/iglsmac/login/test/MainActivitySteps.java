package com.example.iglsmac.login;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.*;

public class MainActivitySteps {
    private String[] emailArray = {"kcpmt2@gmail.com", "hoami123@gmail.com"};
    private String[] passwordArray = {"123456", "hoami"};
    private String email = null;
    private String password = null;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mActivityRule.launchActivity(null);
        mActivityRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {

    }

    @When("^I enter {email}")
    public void I_enter_email(String email){
        this.email = email;
        onView(withId(R.id.editEmail)).perform(typeText(email));
    }

    @When("^I enter {password}")
    public void I_enter_password(String password){
        this.password = password;
        onView(withId(R.id.editPassword)).perform(typeText(password));
    }

    @When(("I press button login"))
    public void I_press_button_login(){
        onView(withId(R.id.btnLogin)).perform(click());
    }

    @Then("^I should be told {answer}")
    public void I_should_be_told(String expectedAnswer){
        Boolean existed = false;
        for(int i = 0;i < this.emailArray.length; i++){
            if(this.emailArray[i].equals(this.email) && this.passwordArray[i].equals(this.password)){
                existed = true;
                break;
            }
        }
        if(existed){
            assertEquals(expectedAnswer, "Success");
        }
        else{
            assertEquals(expectedAnswer, "Fail");
        }
    }
}
