package myarray;

import java.util.Arrays;

public class No2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i + 1] - nums[i]);
        }
        return min;
    }
}
