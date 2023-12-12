package utils;
import java.util.Random;
public class Utils {


    // Method to generate a random number between 0 (inclusive) and max (exclusive)
    public static int getRandomNumber(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("Max must be greater than 0");
        }

        Random random = new Random();
        return random.nextInt(max);
    }

}
