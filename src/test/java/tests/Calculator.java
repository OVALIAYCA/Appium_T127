package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator {


    AndroidDriver<AndroidElement> driver;
    //Android cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
    //AndroidDriver<MobileElement> driver2;
    //Android cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
    //IOSDriver<IOSElement> iosDriver;
    //IOS cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
    //AppiumDriver<MobileElement> appiumDriver;
    //her ikisinde de çalışır. Her iki platformda da işlemleri yapabilmemizi sağlayan
    //driver objesi

    @Test
    public void ilkHesapAppTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        //capabilities.setCapability("deviceName","Pixel 2"); üstteki ile aynı.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/aycaergunovali/Documents/Appium_T127/apps/Calculator_8.4 (503542421)_Apkpure.apk");
        /*bu satır önemli. UiAuomator2 sadece android 6 dan yüksek android sistemleri ile çalışır
         android 6 ve düşük versiyonlar için UiAuomator kullanılır
         platformName, platformVersion ve AutomationName olmazsa olmazıdır.
         */

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // kullanici gerekli kurulumlari yapar
        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // 200 un 7 katininin 1400 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("7").click();
        driver.findElementByAccessibilityId("equals").click();
        String sonuc = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println(sonuc);


        Assert.assertEquals(Integer.parseInt(sonuc),1400);
        //parseInt string sonucu integer a çevirip karşılaştırma yaptık.



    }
}
