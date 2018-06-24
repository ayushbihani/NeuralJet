package Utils;

public class utils {
    private static float min = -50f;
    private static float max = 50f;

    public static float weightInit(){
        return (float)(Math.random()*((max - min) + 1)) + min;
    }
}
