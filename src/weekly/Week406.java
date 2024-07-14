package weekly;

import util.RandomUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Week406 {

    public String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] % 2 == charArray[i + 1] % 2) {
                if (charArray[i + 1] < charArray[i]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[i + 1];
                    charArray[i + 1] = temp;
                    break;
                }
            }

        }

        return new String(charArray);
    }


    public ListNode modifiedList(int[] nums, ListNode head) {
        // ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while (head != null) {
            boolean flag = true;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == head.val) {
//                    flag = false;
//                    break;
//                }
//            }

            if (set.contains(head.val)) {
                flag = false;
            }
            if (flag) {
                pre.next = new ListNode(head.val);
                pre = pre.next;
            }
            head = head.next;
        }
        return res.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /* wrong solution
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[][] dp = new int[m][n];


        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + verticalCut[i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][0] = dp[i - 1][0] + horizontalCut[i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min((dp[i - 1][j] + horizontalCut[i - 1] + dp[0][j]), (dp[i][j - 1] + verticalCut[j - 1]  + dp[i][0]));
            }
        }

        return dp[m - 1][n - 1];
    }*/

    public static void main(String[] args) {
        Week406 week406 = new Week406();
//        System.out.println(week406.getSmallestString("314"));
//        for (int i = 0; i < 100; i++) {
//            String s = RandomUtil.randomString(10, "1234567890");
//            System.out.println(s + "  " + week406.getSmallestString(s));
//        }

//        System.out.println(week406.modifiedList(new int[]{1, 2, 3}, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))))));


//        System.out.println(week406.minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));

    }
}
