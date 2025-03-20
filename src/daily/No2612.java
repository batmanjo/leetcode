package daily;

import java.util.*;


/**
 * 694测试用例超时
 */
public class No2612 {
    public static Set<Integer> set = new HashSet<>();
    public static List<Node> list = new ArrayList<>();

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] res = new int[n];
        int[] steps = new int[k];
        for (int i = 0; i < k; i++) {
            steps[i] = -k + 1 + 2 * i;
        }
        res[p] = 0;
        Node root = new Node();
        root.val = p;
        root.count = 0;
        set.add(p);
        list.add(root);
        sort(banned, steps, n);
        Arrays.fill(res, -1);
        fill(res, root);
        set = new HashSet<>();
        list = new ArrayList<>();
        return res;
    }


    class Node {
        public int val;
        public int count;
        public List<Node> children = new ArrayList<>();


        public void addNode(Node father, Node child) {
            child.count = father.count + 1;
            father.children.add(child);
        }
    }

    public void sort( int[] banned, int[] steps, int max) {
        List<Node> tempList = new ArrayList<>();

        if (list.size() == 0 || set.size() >= max - banned.length) {
            return;
        }
        for (Node node : list) {
            for (int i = 0; i < steps.length; i++) {
                int temp = steps[i] + node.val;
                if (temp >= max || temp < 0) {
                    continue;
                }

                if ((temp + node.val) / 2.0 - steps.length / 2.0 <= -1 || (temp + node.val) / 2.0 + steps.length / 2.0 > max ) {
                    continue;
                }
//            if (steps[i] > 0 && temp < steps.length - node.val) {
//                continue;
//            }
//
//            if (steps[i] < 0 && temp > 2 * max - node.val - steps.length) {
//                continue;
//            }
                if (contains(banned, temp)) {
                    continue;
                }
                if (set.add(temp)) {
                    Node tempNode = new Node();
                    tempNode.val = temp;
                    node.addNode(node, tempNode);
                    tempList.add(tempNode);
                }
            }
        }
        list = tempList;
        sort(banned, steps, max);
    }

    private boolean contains(int[] banned, int val) {
        for (int i = 0; i < banned.length; i++) {
            if (val == banned[i]) {
                return true;
            }
        }
        return false;
    }

    public void fill(int[] res, Node root) {
        res[root.val] = root.count;
        for (Node child : root.children) {
            fill(res, child);
        }
    }

    public static void main(String[] args) {
        No2612 self = new No2612();
        int[] res = self.minReverseOperations(4, 0, new int[]{}, 4);
        System.out.println(Arrays.toString(res));

    }


}
