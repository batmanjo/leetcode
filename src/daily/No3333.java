package daily;

public class No3333 {
    public int possibleStringCount(String word, int k) {
        char c = word.charAt(0);
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != c) {
                c = word.charAt(i);
                count++;
            }
        }
        if(k < count){
            return 0;
        }
        int diff = k - count;
        int diff2 = word.length() - count;

        return (int) (factorial(diff2)/factorial(diff2 - diff));
    }

    private long factorial(int n){
        return n == 1 ? 1 : n * factorial(n-1);
    }

    public static void main(String[] args) {
        No3333 self = new No3333();
        System.out.println(self.possibleStringCount("aaabbb", 4));
    }
}
