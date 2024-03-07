package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
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

        ReusableMethods.hardWait(1);

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        for (int i = 0; i < 3; i++) {

            ReusableMethods.coordinateClick(550,1700,750);

        }

        //ReusableMethods.scrollDown(500); aşağı kaydırma hızını biz belirledik sadece.Parametre olarak waitActiongirdik.
        //ReusableMethods.scrollUp(500); yukarı kaydırma hızını biz belirledik sadece.Parametre olarak waitActiongirdik.

        // Trip type,one way olarak secilir
        ReusableMethods.hardWait(2);
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

        ReusableMethods.hardWait(1);

        ReusableMethods.coordinateClick(482,289,1000);

        ReusableMethods.hardWait(1);

        page.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir

        ReusableMethods.coordinateClick(452,924,500);
        driver.getKeyboard().pressKey("Antalya");

        ReusableMethods.hardWait(3);

        ReusableMethods.coordinateClick(482,289,1000);

        ReusableMethods.hardWait(1);

        page.chooseButton.click();


        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.coordinateClick(485,1052,500);
        ReusableMethods.coordinateClick(689,1108,500);
        ReusableMethods.coordinateClick(700,1722,500);

        // search butonuna tiklanir
        ReusableMethods.coordinateClick(561,1194,500);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.coordinateClick(244,261,500);
        ReusableMethods.coordinateClick(528,574,500);
        ReusableMethods.coordinateClick(528,254,500);
        ReusableMethods.coordinateClick(498,1455,500);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        AndroidElement enUcuzBilet = driver.findElementByXPath("(//*[@class='android.widget.TextView'])[12]");
        String sonuc = enUcuzBilet.getText();

        driver.sendSMS("5555555555","Çevirmek istediğiniz para birimi sonucu : " + sonuc);

    }

}
