package Runner;

import com.automated.pazarama.Utilities.StepInit ;
import org.testng.annotations.Test;

public class PazaramaCase extends StepInit {

    @Test(description = "https://www.pazarama.com web sitesine giriş yapılır.Login olunabildiği doğrulanır", groups = {"a:Ata Aydinli", "t:Pazarama Case Study"})
    public void pazaramaCaseStudy() throws InterruptedException {
        loginPageSteps.goTo_PazaramaHomePage();
        loginPageSteps.login_PazaramaLoginPage();
        loginPageSteps.verify_UserInfo();
        homePageSteps.get_ItemSizeCategory();
        homePageSteps.select_RandomCategory();
        homePageSteps.compare_ProductText();
    }
}
