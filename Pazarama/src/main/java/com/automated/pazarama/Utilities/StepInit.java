package com.automated.pazarama.Utilities;

import com.automated.pazarama.Base.BaseTest ;

import com.automated.pazarama.Steps.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class StepInit extends BaseTest {

    private static final int DELAY = 10;
    public static WebDriverWait webDriverWait;
    public static Actions action;
    public static Faker faker;
    public static SoftAssert softAssert;
    public static ReusableMethods reusableMethods;

    public static LoginPageSteps loginPageSteps;
    public static HomePageSteps homePageSteps;


    public static void init() {
        softAssert = new SoftAssert();
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(DELAY));
        action = new Actions(getDriver());
        faker = new Faker();
        reusableMethods = new ReusableMethods();


        loginPageSteps = new LoginPageSteps();
        homePageSteps = new HomePageSteps();
    }
}
