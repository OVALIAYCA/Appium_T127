package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverterApp {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    AllCurrencyPage page = new AllCurrencyPage();


    @Test
    public void allCurrencyTest() throws IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        
        // uygulamanin acildigi dogrulanir

        Assert.assertTrue(page.headerText.isDisplayed());

        
        // cevirmek istedigimiz para birimi zloty olarak secilir

        ReusableMethods.coordinateClick(435,347,500);
        ReusableMethods.scrollWithUiScrollable("Polish Zloty");
        

        // cevirelecek olan para birimi Tl olarak secilir

       ReusableMethods.coordinateClick(465,465,500);
       ReusableMethods.scrollWithUiScrollable("Turkish Lira");
       

        // cevrilen tutar screenShot olarak kaydedilir
        ReusableMethods.scrollWithUiScrollable("1");
        ReusableMethods.scrollWithUiScrollable("5");
        ReusableMethods.scrollWithUiScrollable("3");
        ReusableMethods.scrollWithUiScrollable("8");

        //File file = driver.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(file,new File("ExchangeRateForZlotyToTl.jpg"));
        ReusableMethods.getScreenshot("ZlotyToTl");

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        
        // kullaniciya sms olarak bildirilir
    }
}
