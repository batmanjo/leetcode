package util;

public class RandomUtil {

    public static final String baseChars = "01234567890abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase();

    public static String randomString(int length) {
        return randomString(length, baseChars);
    }

    public static String randomString(int length, String baseChars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(baseChars.charAt((int) (Math.random() * baseChars.length())));
        }
        return sb.toString();
    }

    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int randomInt(int max) {
        return randomInt(0, max);
    }
}


