package com.example.iglsmac.login.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.TextView;

import com.example.iglsmac.login.MainActivity;
import com.example.iglsmac.login.R;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.junit.Rule;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;

import static org.junit.Assert.*;

public class MainActivitySteps {

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

    @Given("I enter email and password \"([^\"]*)\" \"([^\"]*)\"$")
    public  void i_enter_email_and_password(String email, String password) {
        onView(ViewMatchers.withId(R.id.editEmail)).perform(typeText(email), closeSoftKeyboard());
        onView(ViewMatchers.withId(R.id.editPassword)).perform(typeText(password), closeSoftKeyboard());
    }

    @When("I press button login")
    public void i_press_button_login() {
        onView(ViewMatchers.withId(R.id.btnLogin)).perform(click());
    }

    @Then("I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        TextView announce = (TextView)this.activity.findViewById(R.id.announceText);
        String result = announce.getText().toString();
        assertEquals(expectedAnswer, result);
    }

//    @Given("I have a LoginActivity")
//    public void I_have_a_LoginActivity() {
//        if(mActivityRule.getActivity() != null){
//            assertNotNull(mActivityRule.getActivity());
//        }
//    }
//
//    @When("I enter email {string}")
//    public void i_enter_email(String email) {
//        onView(ViewMatchers.withId(com.example.iglsmac.login.R.id.editEmail)).perform(typeText(email), closeSoftKeyboard());
//    }
//
//    @When("I enter password {string}")
//    public void i_enter_password(String password){
//        onView(ViewMatchers.withId(com.example.iglsmac.login.R.id.editPassword)).perform(typeText(password), closeSoftKeyboard());
//    }
//
//    @When(("I press button login"))
//    public void i_press_button_login(){
//        onView(ViewMatchers.withId(R.id.btnLogin)).perform(click());
//    }
//
//    @Then("I should be told {string}")
//    public void i_should_be_told(String expectedAnswer){
//        TextView announce = (TextView)this.activity.findViewById(R.id.announceText);
//        String result = announce.getText().toString();
//
//        assertEquals(expectedAnswer, result);
//    }
}
