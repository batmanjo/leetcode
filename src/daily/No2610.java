package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No2610 {

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((k, v) -> {

            for (Integer i = 0; i < v; i++) {
                if (i >= res.size()) {
                    res.add(new ArrayList<>());

                }
                res.get(i).add(k);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        No2610 self = new No2610();
        self.findMatrix(new int[]{1,3,4,1,2,3,1});
    }

}
