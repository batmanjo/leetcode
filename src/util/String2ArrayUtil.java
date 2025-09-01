package util;

public class String2ArrayUtil {
    public static void main(String[] args) {
        String s = "[[280,872],[108,128],[3,665],[93,972],[347,464],[443,584],[809,999],[366,398]]";
        String s1 = s.replaceAll("\\[", "{").replaceAll("]", "}");
        System.out.println(s1);
    }
}
