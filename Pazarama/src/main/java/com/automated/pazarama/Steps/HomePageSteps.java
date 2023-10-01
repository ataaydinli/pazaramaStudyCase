package com.automated.pazarama.Steps;

import com.automated.pazarama.Pages.HomePage;
import com.automated.pazarama.Utilities.ReusableMethods;
import org.testng.Assert;

import java.util.*;

import static com.automated.pazarama.Utilities.ReusableMethods.*;

public class HomePageSteps extends HomePage {

    public  void  get_ItemSizeCategory(){
        int itemSize = METROMENU_CATEGORIES_ITEMS.size();
        infoMessage("Metro menü kategorisinde " + itemSize + " adet item olduğu doğrulanır.");

    }
    public void select_RandomCategory() throws InterruptedException{
        Random random = new Random(); // Random sınıfından random objesi oluşturulur
        int randomCategorySize = random.nextInt(METROMENU_CATEGORIES_ITEMS.size());// Metro menü size'ına göre rastgele bir sayı generate edilir
        hoverElement(METROMENU_CATEGORIES_ITEMS.get(randomCategorySize),5);//Metro menü listesi içinden yukarıda rastgele oluşturulmuş sayıya ait kategori hover edilir
        int randomCategorySubItemSize = random.nextInt(METROMENU_CATEGORY_SUBITEM_TEXT.size());//Rastgele seçilen kategoriden kategori içindeki item size'ına göre rastgele bir takam generate edilir
        String strRandomSubCategory = METROMENU_CATEGORY_SUBITEM_TEXT.get(randomCategorySubItemSize).getText();//Random generate edilen alt kategorinin ismi string değişkeni ile tutulur
        clickElement(METROMENU_CATEGORY_SUBITEM_TEXT.get(randomCategorySubItemSize));//Random generate edilen rakama göre alt kategoriye click aksiyonu gerçekleştirilir
        Thread.sleep(4000);
        infoMessage("Menüden rastgele --> " + strRandomSubCategory + " kategorisi seçilerek , kategoriye tıklanır." );
    }
    public void compare_ProductText() throws InterruptedException{
        Random random = new Random();// Random sınıfından random objesi oluşturulur
        scrollToBottom(getDriver());//80 adet ürün yüklenmesi için sayfanın en altına scroll yapılır
        Thread.sleep(2000);
        int randomFavoriteButton = random.nextInt(NONFAVORITE_ITEM_BTN.size());//Favori olarak seçilmeyen favori butonları size'ına göre rastgele sayı generate edilir
        clickWithJS(NONFAVORITE_ITEM_BTN.get(randomFavoriteButton));//Random oluşturulan sayıya göre seçilen favori butonuna tıklanır
        Thread.sleep(3000);
        String strFavoriteProduct = getTextFromElement(FAVORITE_PRODUCT_TEXT.get(randomFavoriteButton));//Favoriye eklenmiş ürünün text'i string olarak tutulur
        infoMessage(strFavoriteProduct + " adlı ürün favorilere eklenir.");
        scrollToTop(getDriver());//Sayfa en başına scroll edilir
        Thread.sleep(1000);
        clickWithJS(HEADER_FAVORITESTS_BTN);//Headerdaki FAVORILERIM butonuna dom üzerinden tıklanır
        Thread.sleep(6500);
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.pazarama.com/hesabim/begendiklerim","Kullanıcı FAVORILERIM sayfasına yönlendirilmemiştir.");
        infoMessage("Kullanıcı başarılı bir şekilde " + getDriver().getCurrentUrl() + " adresine yönlendirilir.");
        String favoriteProductInList = HEARTEDITEMTEXT.get(0).getText();//Listenin ilk ürününün text'i string değişkende tutulur
        Assert.assertEquals(strFavoriteProduct,favoriteProductInList,"Favoriye eklenen ürün favoriler listesine eklenmemiştir.");//Favoriye eklenmiş ürün adının favorilerim listesine eklendiği kontrolü yapılır
        infoMessage("Favoriye eklenen --> " + "'" + favoriteProductInList + "'" + " adlı ürünün favoriler listesine başarılı bir şekilde eklendiği doğrulanır.");
        }

}

