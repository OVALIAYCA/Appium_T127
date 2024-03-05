package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
    public void arabamAppTest() throws InterruptedException {

        //driver.activateApp("com.dogan.arabam");

        //uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan ara']").click();

        // kategori olarak otomobil secilir
        //driver.findElementByXPath("//*[@text='Otomobil']").click(); //geleneksel tıklama yöntemi
        //touchaction ise koordinat ile locate alma yöntemi
        Thread.sleep(1000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(994,500)).release().perform();
        //press ile tıkladık -  point option ile koordinat seçtik , release ile parmak kalktı
        //perform action için gerekli.
        //koordinatlar inspectorden seçilir.
        Thread.sleep(1000);



        // arac olarak Volkswagen secilir
        /* action.press(PointOption.point(482,1516))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))//bu satır aşağı kaydırma parmak hareketini hızlandırıyor.
                .moveTo(PointOption.point(482,320))
                .release().perform(); */

        //waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))//bu satır aşağı kaydırma parmak hareketini hızlandırıyor.
        //bu sayede 4 kere kaydırma için kod blogu yazmak zorunda kalmadık.
        //eğer 4 kere yazma geeği duyarsak loop içine alırız.
        //ya da yaptığımız gibi 5 kere kaydırma yaparak hız ayarını değiştirebiliriz.

        for (int i = 0; i < 5; i++) {

            action.press(PointOption.point(482,1516))//kaydırma yapmak için belirlenen ilk nokta
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(750)))//bu satır aşağı kaydırma parmak hareketinin hızını belirliyor.
                    .moveTo(PointOption.point(482,320)) //kaydırma işleminin son evresi
                    .release().perform();
            
        }

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        Thread.sleep(1000);

        // Paket secimi yapilir
        action.press(PointOption.point(416,722)).release().perform();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        AndroidElement enUcuzFiyatElementi=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]");
        Thread.sleep(3000);
        String aracinSonFiyati = enUcuzFiyatElementi.getText();
        System.out.println(aracinSonFiyati);
        //aracinSonFiyati = aracinSonFiyati.replaceAll("\\.","").replaceAll(" TL","");
        //nokta-boşluk ve TL yazısından kurtulduk. string manipulation.

        aracinSonFiyati=aracinSonFiyati.replaceAll("\\D","");
        System.out.println(aracinSonFiyati);

        Assert.assertTrue(Integer.parseInt(aracinSonFiyati)>500000);
        //parametrenin değişkenini istediğimiz değişkene çevirdik.

    }
}
