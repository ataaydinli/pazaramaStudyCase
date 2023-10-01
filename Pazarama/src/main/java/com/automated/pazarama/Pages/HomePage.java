package com.automated.pazarama.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.automated.pazarama.Base.BaseTest.getDriver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='flex h-17 relative z-40']/li")
    public static List<WebElement> METROMENU_CATEGORIES_ITEMS;

    @FindBy(xpath = "//div[@class='mega-menu-category']//ul/li/a")
    public static List<WebElement> METROMENU_CATEGORY_SUBITEM_TEXT;

    @FindBy(xpath = "//span[@name='heart']")
    protected static List<WebElement> NONFAVORITE_ITEM_BTN;

    @FindBy(xpath = "//li[@class='px-3']//a[@href='/hesabim/begendiklerim']")
    protected static WebElement HEADER_FAVORITESTS_BTN;

    @FindBy(xpath = "//div[@class='line-clamp-2 text-gray-600 h-9 text-xs leading-4.5 mb-1.5']")
    protected static List<WebElement> FAVORITE_PRODUCT_TEXT;

    @FindBy(css = "[class*='line-clamp-2 text-gray-600 h-9 text-xs']")
    protected static List<WebElement> HEARTEDITEMTEXT;



}
