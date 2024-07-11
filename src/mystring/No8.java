package mystring;

import util.RandomUtil;

public class No8 {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (flag && s.charAt(i) == ' ') {
                continue;
            }

            if (flag && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sb.append(s.charAt(i));
                flag = false;
                continue;
            }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
                flag = false;
                continue;
            }
            break;
        }
        if (sb.length() == 0) {
            return 0;
        } else {
            try {
                return Integer.valueOf(sb.toString());
            } catch (Exception e) {
                if (sb.length() == 1) {
                    return 0;
                }
                if (sb.toString().charAt(0) == '-') {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
    }

    public int myAtoi2(String s) {
        int sign = 1;
        int res = 0;
        int m = s.length();
        int i = 0;
        // 去除空格
        while (i < m && s.charAt(i) == ' ') {
            i++;
        }
        int start = i;
        for (; i < m; i++) {
            char c = s.charAt(i);
            if (i == start && c == '+') {
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //        for (int i = 0; i < 100; i++) {
//            String s = RandomUtil.randomString(100);
//            try {
//                System.out.println(s + "  " + new No8().myAtoi(s));
//            }catch (Exception e){
//                System.out.println("error" + s);
//            }
//        }
        System.out.println(new No8().myAtoi("-----+++++2202343423+"));

    }


}
