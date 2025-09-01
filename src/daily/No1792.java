package daily;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1792 {

    public static void main(String[] args) {
        No1792 self = new No1792();
        int[][] classes = {{280,872},{108,128},{3,665},{93,972},{347,464},{443,584},{809,999},{366,398}};
        double v = self.maxAverageRatio(classes, 77862);
        System.out.println(v);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double avgRatio;
        double sumRatio = 0.0;
        PriorityQueue<Sort> priorityQueue = new PriorityQueue<>();
        Sort[] sorts = new Sort[classes.length];
        for (int i = 0; i < classes.length; i++) {
            sumRatio += (double) classes[i][0] / classes[i][1];
            double v = ((double) classes[i][1] - classes[i][0]) / ((double) classes[i][1] * classes[i][1] + classes[i][1]);
            Sort sort = new Sort(v, i);
            priorityQueue.offer(sort);
        }
        avgRatio = sumRatio / classes.length;


        for (int i = 0; i < extraStudents; i++) {
            Sort poll = priorityQueue.poll();
            avgRatio +=  poll.addRatio/ classes.length;
            int index = poll.num;

            classes[index][0] = classes[index][0] + 1;
            classes[index][1] = classes[index][1] + 1;
            poll.addRatio = ((double) classes[index][1] - classes[index][0]) / ((double) classes[index][1] * classes[index][1] + classes[index][1]);
            priorityQueue.offer(poll);


        }


        return avgRatio;
    }






    class Sort implements Comparable<Sort> {

        public double addRatio;
        public int num;

        public Sort(double addRatio, int num) {
            this.addRatio = addRatio;
            this.num = num;
        }

        public Sort(){}

        @Override
        public int compareTo(Sort o) {
            return o.addRatio > this.addRatio? 1: -1;
        }

//
//        @Override
//        public int compare(Sort o1, Sort o2) {
//            return o1.num > o2.num ? 1 : -1;
//        }
    }
}
