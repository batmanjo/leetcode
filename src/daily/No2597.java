package daily;


import java.util.Arrays;

public class No2597 {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        // 计算nums[i] + K存在的个数
        int count = 0;
        int temp = 0;

        for (int i = 0,j = 0; i < nums.length; i++) {
            temp = nums[i] + k;
            while (j < nums.length){
                if(nums[j] == temp){
                    count++;
                    j++;
                }else if(nums[j] > temp){
                    break;
                }else{
                    j++;
                }
            }
        }
        return combination(nums.length - count);
    }


    private int combination(int n){
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += factorial(n) / (factorial(i) * factorial(n - i));
        }
        return res;
    }

    // 阶乘
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // 0! 和 1! 都等于 1
        }
        return n * factorial(n - 1); // 递归调用
    }

    public static void main(String[] args) {
        System.out.println(new No2597().beautifulSubsets(new int[]{2, 4, 6}, 2));
    }
}
