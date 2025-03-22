package daily;

import java.util.Arrays;

public class No2680 {

    public long maximumOr(int[] nums, int k) {
        Arrays.sort(nums);
        int m = findMax(nums[nums.length - 1]);
        long broder = 1 << m;
        long compare = nums[nums.length - 1] >> (m + 1 - k);

        long middle = 0;
        int start = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < broder) {
                middle = middle | nums[i];
            } else {
                start = i;
                break;
            }
        }
        long max = middle;


        for (int i = nums.length - 1; i >= start; i--) {
            if ((nums[i] >> (m + 1 - k)) >= compare) {
                long temp = middle;
                for (int j = start; j < nums.length; j++) {
                    if (j == i) {
                        temp = temp | ((long)nums[j] << k);
                    } else {
                        temp = temp | nums[j];
                    }
                }
                if (max < temp) {
                    max = temp;
                }
            }

        }

        return max;
    }

    private int findMax(int n) {
        int count = 0;
        while (n != 1) {
            n = n >> 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        No2680 self = new No2680();
//        System.out.println(self.maximumOr(new int[]{1, 2, 3, 4, 5}, 2));
        int i = 4;
        int j = i >> 1;
        System.out.println(i);
        System.out.println(self.findMax(8));


    }
}
