package utilities;

public class HardWait {

    public static void hardWait(int duration){

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
