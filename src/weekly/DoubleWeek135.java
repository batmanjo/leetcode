package weekly;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoubleWeek135 {
    public String losingPlayer(int x, int y) {
        int b = y / 4;
        return Math.min(x, b) % 2 == 1 ? "Alice" : "Bob";
    }


    public int minimumLength(String s) {
        if (s.length() <= 2) {
            return s.length();
        }

        char[] charArray = s.toCharArray();
        boolean[] isRemove = new boolean[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            isRemove[i] = true;
        }


        for (int i = 0; i < charArray.length; i++) {
            if (isRemove[i]) {
                boolean flag = false;
                for (int j = i + 1; j < charArray.length; j++) {
                    if (!flag && isRemove[j] && charArray[i] == charArray[j]) {
                        flag = true;
                        continue;
                    }
                    if (charArray[i] == charArray[j] && isRemove[j]) {
                        isRemove[j] = false;
                        isRemove[i] = false;
                        break;
                    }
                }
            }

        }

        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(isRemove[i]) count++;

        }
        return count;

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i < charArray.length; i++) {
//            if (isRemove[i]) {
//                sb.append(charArray[i]);
//            }
//        }
//        System.out.println(sb);
//        return sb.length();

    }

    public int minChanges(int[] nums, int k) {
        return 0;
    }


    public static void main(String[] args) {

        DoubleWeek135 doubleWeek135 = new DoubleWeek135();
//        for (int i = 0; i < 100; i++) {
//            String s = RandomUtil.randomString(10, "abcd");
//            System.out.println(s + "  " + doubleWeek135.minimumLength2(s));
//        }
    }

}
