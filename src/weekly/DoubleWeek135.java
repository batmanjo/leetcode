package weekly;

import util.RandomUtil;

import java.util.*;

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
            if (isRemove[i]) count++;

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

    // false answer
    public int minChanges(int[] nums, int k) {
        int len = nums.length / 2;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 0; i < len; i++) {
            left[i] = nums[i];
            right[i] = nums[nums.length - i - 1];
        }
        int[] dif = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dif[i] = Math.abs(left[i] - right[i]);
            if (map.containsKey(dif[i])) {
                map.put(dif[i], map.get(dif[i]) + 1);
            } else {
                map.put(dif[i], 1);
            }
        }


        // 按value从大到小排序map
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).toList();
        int min = nums.length;
        for (int j = 0; j < list.size(); j++) {
            int x = list.get(j).getKey();
            int count = 0;

            if(len - list.get(j).getValue() >= min){
                return min;
            }
            for (int i = 0; i < len; i++) {
                if(!(dif[i] == x)){
                    if(Math.max(left[i], right[i]) - x < 0 && Math.min(left[i], right[i]) + x > k){
                        count +=2;
                    }else{
                        count++;
                    }

                }
            }
            if(count < min){
                min = count;
            }
        }
        return min;
    }




    public static void main(String[] args) {

        DoubleWeek135 doubleWeek135 = new DoubleWeek135();
            System.out.println(doubleWeek135.minChanges(new int[]{9,2,7,7,8,9,1,5,1,9,4,9,4,7},9));
//        for (int i = 0; i < 100; i++) {
//            String s = RandomUtil.randomString(10, "abcd");
//            System.out.println(s + "  " + doubleWeek135.minimumLength2(s));
//        }
    }

}
