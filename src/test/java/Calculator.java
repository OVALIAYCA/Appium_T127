import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

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
        /*bu satır önemli. UiAuomator2 sadece android 6 dan yüksek android sistemleri ile çalışır
         android 6 ve düşük versiyonlar için UiAuomator kullanılır
         platformName, platformVersion ve AutomationName olmazsa olmazıdır.
         */

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


















    }
}
