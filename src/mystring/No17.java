package mystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17 {
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, Character[]> map = new HashMap<>();

            map.put('2', new Character[]{'a', 'b', 'c'});
            map.put('3', new Character[]{'d', 'e', 'f'});
            map.put('4', new Character[]{'g', 'h', 'i'});
            map.put('5', new Character[]{'j', 'k', 'l'});
            map.put('6', new Character[]{'m', 'n', 'o'});
            map.put('7', new Character[]{'p', 'q', 'r', 's'});
            map.put('8', new Character[]{'t', 'u', 'v'});
            map.put('9', new Character[]{'w', 'x', 'y', 'z'});

            String temp = "";
            List<String> list = new ArrayList<>();

            return append(list, digits, digits.length(), map, temp);
        }

        private List<String> append(List<String> list,
                                    String s, int length, Map<Character, Character[]> map, String temp) {
            if (s == null || s.length() == 0) {
                list.add("");
                list.clear();
                return list;
            }
            String temp2 = temp;
            if (length == temp.length() + 1) {

                for (int i = 0; i < map.get(s.charAt(temp.length())).length; i++) {
                    temp = temp + map.get(s.charAt(temp.length()))[i];
                    list.add(temp);
                    temp = temp2;

                }
            } else {
                for (int i = 0; i < map.get(s.charAt(temp.length())).length; i++) {
                    temp = temp + map.get(s.charAt(temp.length()))[i];
                    list = append(list, s, length, map, temp);
                    temp = temp2;
                }
            }

            return list;
        }
    }

    Map<Character, Character[]> map = new HashMap<>();

    {
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        for (int i = 0; i < map.get(digits.charAt(0)).length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(digits.charAt(0))[i]);
            append(list, sb, digits, 1);
        }

        return list;
    }

    private void append(List<String> list, StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            list.add(sb.toString());
        } else {
            for (int i = 0; i < map.get(s.charAt(index)).length; i++) {
                StringBuilder sb2 = new StringBuilder(sb);
                sb2.append(map.get(s.charAt(index))[i]);
                append(list, sb2, s, index + 1);
            }
        }
    }


}
