package daily;



public class No2595 {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if((n & 1) == 1){
                if(flag){
                    res[0]++;
                }else{
                    res[1]++;
                }
            }
            n = n >> 1;
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        No2595 self = new No2595();
        System.out.println(self.evenOddBit(5));
        System.out.println(self.evenOddBit(2));
    }
}
