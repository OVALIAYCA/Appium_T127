package apkYukleme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {

    AndroidDriver<AndroidElement> driver;
    @Test
    public void apkYukleme() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        //capabilities.setCapability("deviceName","Pixel 2"); üstteki ile aynı.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/aycaergunovali/Documents/Appium_T127/apps/arabam.com_5.1.6_Apkpure.apk");
        /*bu satır önemli. UiAuomator2 sadece android 6 dan yüksek android sistemleri ile çalışır
         android 6 ve düşük versiyonlar için UiAuomator kullanılır
         platformName, platformVersion ve AutomationName olmazsa olmazıdır.
         */

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
}
