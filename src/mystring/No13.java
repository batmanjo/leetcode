package mystring;

import java.util.HashMap;
import java.util.Map;

public class No13 {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i != s.length() - 1 && s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                    continue;
                } else if (i != s.length() - 1 && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                    continue;
                } else {
                    result++;
                }
            }

            if (s.charAt(i) == 'V') {
                result += 5;
            }

            if (s.charAt(i) == 'X') {
                if (i != s.length() - 1 && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                    continue;
                } else if (i != s.length() - 1 && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                    continue;
                } else {
                    result += 10;
                }
            }

            if (s.charAt(i) == 'L') {
                result += 50;
            }

            if (s.charAt(i) == 'C') {
                if (i != s.length() - 1 && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                    continue;
                } else if (i != s.length() - 1 && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                    continue;
                } else {
                    result += 100;
                }
            }

            if (s.charAt(i) == 'D') {
                result += 500;
            }

            if (s.charAt(i) == 'M') {
                result += 1000;
            }

        }
        return result;
    }


    Map<Character,Integer> map = new HashMap<>(8);

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }



    public int romanToInt2(String s) {

        Integer res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        res += map.get(s.charAt(s.length() - 1));
        return res;

    }

    private int getValue(char c) {

        return map.getOrDefault(c, 0);
    }
}
