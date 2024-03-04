package day2;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamApp {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void arabamSetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        //capabilities.setCapability("deviceName","Pixel 2"); üstteki ile aynı.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        //hangi uygulama üstünde çalışmak istiyorsak o uygulamanın kimlik bilgisini yazıyoruz
        //appPackage bilgisi ekleniyor. appPackage ismi sabit.Value değişiyor.

        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        //appPackage da belirlenen uygulamanın hangi sayfasından başlanacağını belirleyen aktiviti değeri



        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void arabamAppTest(){

        //driver.activateApp("com.dogan.arabam");

        //uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan ara']").click();
        // kategori olarak otomobil secilir
        // arac olarak Volkswagen secilir
        // arac markasi olarak passat secilir
        // 1.4 TSI BlueMotion secilir
        // Paket secimi yapilir
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir


    }

}
