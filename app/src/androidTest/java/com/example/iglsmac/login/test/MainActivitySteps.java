package com.example.iglsmac.login.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.iglsmac.login.MainActivity;
import com.example.iglsmac.login.R;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.Rule;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;

import static org.junit.Assert.*;

public class MainActivitySteps {
    private String[] emailArray = {"kcpm@gmail.com", "hoami@gmail.com"};
    private String[] passwordArray = {"qwerty", "hoami"};
    private String email = null;
    private String password = null;

    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);
    private Activity activity = null;

    @Before
    public void launchActivity() throws Exception {
        mActivityRule.launchActivity(null);
        this.activity = mActivityRule.getActivity();
    }

    @After
    public void finishActivity() throws Exception {
        mActivityRule.getActivity().finish();
    }

//    @Given("I have a LoginActivity")
//    public void I_have_a_LoginActivity() {
//        if(mActivityRule.getActivity() != null){
//            assertNotNull(mActivityRule.getActivity());
//        }
//    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        this.email = email;
        onView(ViewMatchers.withId(com.example.iglsmac.login.R.id.editEmail)).perform(typeText(email));
    }

    @When("I enter password {string}")
    public void i_enter_password(String password){
        this.password = password;
        onView(ViewMatchers.withId(com.example.iglsmac.login.R.id.editPassword)).perform(typeText(password));
    }

    @When(("I press button login"))
    public void i_press_button_login(){
        onView(ViewMatchers.withId(R.id.btnLogin)).perform(click());
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer){
        Boolean existed = false;
        for(int i = 0;i < this.emailArray.length; i++){
            if(this.emailArray[i].equals(this.email) && this.passwordArray[i].equals(this.password)){
                existed = true;
                break;
            }
        }
//        if(this.email.equals("kcpm@gmail.com") && this.password.equals("qwerty")){
//            assertEquals(expectedAnswer, "Fail");
//        }
//        else
//            assertEquals(expectedAnswer, "Fail");
        if(existed){
            assertEquals(expectedAnswer, "Success");
        }
        else{
            assertEquals(expectedAnswer, "Fail");
        }
    }
}
