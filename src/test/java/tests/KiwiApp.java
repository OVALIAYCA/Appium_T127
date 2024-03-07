package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.HardWait;
import utilities.ReusableMethods;


public class KiwiApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage page = new KiwiPage();


    @Test
    public void kiwiAppTest()  {



        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        page.guestButton.isDisplayed();

        // misafir olarak devam et e tiklanir
        page.guestButton.click();

        HardWait.hardWait(1000);

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        for (int i = 0; i < 3; i++) {

            ReusableMethods.coordinateClick(550,1700,750);

        }

        //ReusableMethods.scrollDown(500); aşağı kaydırma hızını biz belirledik sadece.Parametre olarak waitActiongirdik.
        //ReusableMethods.scrollUp(500); yukarı kaydırma hızını biz belirledik sadece.Parametre olarak waitActiongirdik.

        // Trip type,one way olarak secilir
        HardWait.hardWait(2500);
        ReusableMethods.coordinateClick(300,620,1000);
        ReusableMethods.coordinateClick(478,1455,500);


        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.coordinateClick(508,775,500);
        ReusableMethods.coordinateClick(1026,135,500);



        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        //page.departureText.sendKeys("Istanbul");
        if(!driver.isKeyboardShown()){
            page.departureText.sendKeys("Ankara");
        }
        else {
            driver.getKeyboard().pressKey("Istanbul");
        }

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir

        // search butonuna tiklanir

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }

}
