package daily;


public class No2502 {

    static class Allocator {

        static int[] memory;

        public Allocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int cnt = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == 0) {
                    cnt++;
                    if (cnt == size) {
                        for (int j = 0; j < cnt; j++) {
                            memory[i - j] = mID;
                        }
                        return i - cnt + 1;
                    }
                } else {
                    cnt = 0;
                }
            }
            return -1;
        }

        public int freeMemory(int mID) {
            int cnt = 0;
            for (int i = 0; i < memory.length; i++) {
                if(memory[i] == mID){
                    memory[i] = 0;
                    cnt++;
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(10);
        loc.allocate(1, 1);
        loc.allocate(1, 2);
        loc.allocate(1, 3);
        loc.freeMemory(2);
    }


}
