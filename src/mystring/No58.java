package mystring;

import java.util.*;

public class No58 {


    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    return res;
                }
            } else {
                res++;
                flag = true;
            }
        }

        return res;
    }

}
