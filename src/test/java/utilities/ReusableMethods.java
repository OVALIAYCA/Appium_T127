package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {


    public static void coordinateClick(int xCoordinate, int yCoordinate, int standbyTime) {

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xCoordinate,yCoordinate))
                                .release()
                                .perform();

        try {
            Thread.sleep(standbyTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void scrollDown(int waitAction){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(500,1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,285))
                .release()
                .perform();


    }

    public static void scrollUp(int waitAction){
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(500,285))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,1500))
                .release()
                .perform();
    }

    public static void scrollScreen(int xPress, int yPress, int waitAction, int xMoveTo, int yMoveTo, int threadSleep){

        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(xMoveTo,yMoveTo))
                .release()
                .perform();

        try {
            Thread.sleep(threadSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }


    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static void hardWait(int duration){

        try {
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
