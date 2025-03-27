package daily;

public class No2712 {
    public long minimumCost(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[i + 1]) {
                res = res + i + 1;
            }
        }
        for (int i = charArray.length - 1 ;i  > charArray.length / 2; i--) {
            if (charArray[i] != charArray[i - 1]) {
                res = res + charArray.length - i;
            }
        }
        return res;
    }
}
