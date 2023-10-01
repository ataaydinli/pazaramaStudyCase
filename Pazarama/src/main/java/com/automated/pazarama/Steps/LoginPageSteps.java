package com.automated.pazarama.Steps;

import com.automated.pazarama.Pages.LoginPage ;
import com.automated.pazarama.Utilities.* ;
import org.testng.Assert;

import static com.automated.pazarama.Base.BaseTest.getDriver;
import static com.automated.pazarama.Utilities.ReusableMethods.*;

public class LoginPageSteps extends LoginPage {

    public void goTo_PazaramaHomePage() {
        infoMessage("Kullanici browser açarak " + ConfigReader.getProperty("homePageUrl") + " sayfasina giriş yapar.");
        getDriver().get(ConfigReader.getProperty("homePageUrl"));//canfigten homapageurl alınarak url'e gidilir.
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.pazarama.com/","Hatalı URL yönlendirmesi.");
        infoMessage("Kullanıcının " + getDriver().getCurrentUrl() + " adresine başarılı bir şekilde yönlendirildiği doğrulanır.");
    }

    public void login_PazaramaLoginPage() throws InterruptedException {
        infoMessage("Kullanici 'Giriş Yap / Üye Ol ' butonuna tıklar.");
        clickElement(SIGNIN_BTN);//GirişYap&ÜyeOl butonuna tıklanır.

        infoMessage("Kullanici 'E-Posta adresiniz' adlı texbox'a e-posta adresini giriş yapar.");
        clickElement(LOGIN_EMAIL_TEXTBOX);//E-mail textbox tıklanır.
        sendKeysAsACharacters(LOGIN_EMAIL_TEXTBOX,ConfigReader.getProperty("userEmail")); //E-mail text box'a config datasındaki e-mail harfler arasına thread sleep atılarak giriş yapılır

        infoMessage("Kullanici 'Şifreniz' adlı texbox'a şifresini giriş yapar.");
        clickElement(LOGIN_PASSWORD_TEXTBOX);
        sendKeysAsACharacters(LOGIN_PASSWORD_TEXTBOX,ConfigReader.getProperty("password"));////Password text box'a config datasındaki password harfler arasına thread sleep atılarak giriş yapılır.

        infoMessage("Kullanici 'E-Posta' ve 'Şifre' alanlarını doldurarak 'DEVAM' butonuna tıklar.");
        clickElement(LOGIN_CONTINUE_BTN); //DevamEt butonuna tıklanır
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.pazarama.com/","Kullanıcı 'Devam Et' butonuna tıkladıktan sonra yanlış sayfaya yönlendirildi." );
        infoMessage("Kullanıcı üye giriş bilgilerini giriş yaparak " + getDriver().getCurrentUrl() + " adresine yönlendirilir.");
    }

    public void verify_UserInfo(){
        String actualUserInfo = getTextFromElement(HOMEPAGE_USERNAME_TEXTAREA);
        String expectedUserInfo = ConfigReader.getProperty("name")+" "+ConfigReader.getProperty("surname");
        Assert.assertEquals(actualUserInfo,expectedUserInfo);
        infoMessage("Kullanici'nin üyelik bilgilerini doğru girerek başarılı bir şekilde LOGIN olduğu doğrulanır.");
    }

}
