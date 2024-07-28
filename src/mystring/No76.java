package mystring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No76 {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    //暴力解法
    public String minWindow2(String s, String t) {
        if (t.equals(s)) {
            return t;
        }
        int begin = 0, end = s.length();
        Map<Character, Integer> map = new HashMap<>();

        //初始化map
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }


        //初始化end
        HashMap<Character, Integer> tempMap = new HashMap<>(map);
        int sum = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (sum == 0) {
                end = i;
                break;
            }

            char temp = s.charAt(i);
            if (tempMap.containsKey(temp)) {
                if (tempMap.get(temp) > 0) {
                    sum--;
                    tempMap.put(temp, tempMap.get(temp) - 1);
                }
            }
        }


        if (end == s.length()) {
            tempMap = new HashMap<>(map);
            sum = t.length();
            for (int i = end - 1; i >= 0; i--) {
                if (sum == 0) {
                    begin = i + 1;
                    break;
                }

                char temp = s.charAt(i);
                if (tempMap.containsKey(temp)) {
                    if (tempMap.get(temp) > 0) {
                        sum--;
                        tempMap.put(temp, tempMap.get(temp) - 1);
                    }
                }
            }

            if (sum != 0) {
                return "";
            } else {
                return s.substring(begin, end);
            }
        }


        //确定begin初始值
        tempMap = new HashMap<>(map);
        sum = t.length();
        for (int i = end - 1; i >= 0; i--) {
            if (sum == 0) {
                begin = i + 1;
                break;
            }

            char temp = s.charAt(i);
            if (tempMap.containsKey(temp)) {
                if (tempMap.get(temp) > 0) {
                    sum--;
                    tempMap.put(temp, tempMap.get(temp) - 1);
                }
            }
        }


        int fBegin = begin, fEnd = end;
        int min = end - begin;


        //主程序
        for (int i = end; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == s.charAt(begin)) {
                end = i + 1;


                tempMap = new HashMap<>(map);
                sum = t.length();
                for (int j = end - 1; j >= 0; j--) {
                    if (sum == 0) {
                        begin = j + 1;
                        break;
                    }

                    char temp1 = s.charAt(j);
                    if (tempMap.containsKey(temp1)) {
                        if (tempMap.get(temp1) > 0) {
                            sum--;
                            tempMap.put(temp1, tempMap.get(temp1) - 1);
                        }
                    }
                }
                if (begin < end && end - begin <= min) {
                    fBegin = begin;
                    fEnd = end;
                    min = end - begin;

                }
            }
        }



        return s.substring(fBegin, fEnd);
    }
}
