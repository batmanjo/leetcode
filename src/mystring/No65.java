package mystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No65 {

    static List<String> list = new ArrayList<>();
    static {
        list.addAll(Arrays.asList("n","nd","ndn","ndnesn","ndnen",
                "ndesn","nden","nesn","nen",
                "dn","dnesn","dnen"));
        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            list2.add("s" + s);
        }
        list.addAll(list2);

    }


    public boolean isNumber(String s) {

        char[] chars = s.toCharArray();
        char c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length && sb.length() < 8; i++) {
            if(chars[i] == '+' || chars[i] == '-'){
                sb.append('s');
                c = 's';
                continue;
            }
            if(chars[i] == 'e' || chars[i] == 'E'){
                sb.append('e');
                c = 'e';
                continue;
            }
            if(chars[i] == '.'){
                sb.append('d');
                c = 'd';
                continue;
            }
            if(chars[i] >= '0' && chars[i] <= '9' ){
                if(c != 'n'){
                    sb.append('n');
                    c = 'n';
                }
                continue;
            }
            sb.append(' ');
        }

        return list.contains(sb.toString());
    }

    class TreeNode {
        char val;
        boolean end;
        TreeNode[] children;
    }

    public static void main(String[] args) {
        No65 no65 = new No65();
        System.out.println(no65.isNumber("-.110.e-1"));
    }
}
