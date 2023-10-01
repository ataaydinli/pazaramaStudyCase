package com.automated.pazarama.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automated.pazarama.Base.BaseTest.getDriver;
import static com.automated.pazarama.Utilities.ReusableMethods.waitVisibleByLocator;

public class LoginPage  {
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "a[class='btn btn-sm !w-37 px-0 text-gray-500 text-left']")
    public static WebElement SIGNIN_BTN;

    @FindBy(css = "#Username")
    protected static WebElement LOGIN_EMAIL_TEXTBOX;

    @FindBy(css = "#Password")
    protected static WebElement LOGIN_PASSWORD_TEXTBOX;

    @FindBy(css = "#submit-button")
    protected static WebElement LOGIN_CONTINUE_BTN;

    @FindBy(css = "span[class='ml-2.5 overflow-hidden w-full whitespace-nowrap text-ellipsis']")
    protected static WebElement HOMEPAGE_USERNAME_TEXTAREA;

}
