package weekly;

import util.RandomUtil;

public class Weekly407 {
    public int minChanges(int n, int k) {
        // 将n,k转换为二进制

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        String ns = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        while (k > 0) {
            sb2.append(k % 2);
            k /= 2;
        }
        String ks = sb2.toString();
        if (sb2.length() > sb.length()) {
            return -1;
        }
        int ans = 0;
        for (int i = ks.length() - 1; i >= 0; i--) {
            if (ks.charAt(i) - ns.charAt(i) == 1) {
                return -1;
            }
            if (ks.charAt(i) - ns.charAt(i) == -1) {
                ans++;
            }
        }
        for (int i = ns.length() - 1; i >= ks.length(); i--) {
            if (ns.charAt(i) == '1') {
                ans++;
            }
        }
        return ans;

    }

    public boolean doesAliceWin(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    public int maxOperations(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        int left = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '1') {
                count++;
                if (charArray[i + 1] == '0') {
                    left = left + count;
                }

            }
        }
        return left;
    }

    public long minimumOperations(int[] nums, int[] target) {
        long ans = 0;
        int[] dif = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dif[i] = nums[i] - target[i];
        }

        for (int i = 0; i < dif.length; i++) {
            if (dif[i] == 0) {
                continue;
            }
            int min = 0;
            int count = 0;
            int pre = 0;

        }
        return ans;
    }


    public static void main(String[] args) {
        Weekly407 weekly407 = new Weekly407();

        System.out.println(weekly407.minimumOperations(new int[]{9, 2, 6, 10, 4, 8, 3, 4, 2, 3}, new int[]{9, 5, 5, 1, 7, 9, 8, 7, 6, 5}));
//        System.out.println(weekly407.minChanges(44, 2));
//        System.out.println(weekly407.maxOperations("10011010101"));
//        for (int i = 0; i < 20; i++) {
//            weekly407.minChanges(RandomUtil.randomInt(20), RandomUtil.randomInt(20));


//        [9,2,6,10,4,8,3,4,2,3]
//[9,5,5,1,7,9,8,7,6,5]
//        }
    }

}
