package daily;

import java.util.HashSet;
import java.util.Set;

public class No2829 {
    public int minimumSum(int n, int k) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        // set.add(k);
        int count = 1;
        for (int i = 0; i < n; i++) {
            while (set.contains(count)) {
                count++;
            }
            res += count;
            set.add(k - count);
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        No2829 self = new No2829();
        System.out.println(self.minimumSum(5, 4));

    }
}
