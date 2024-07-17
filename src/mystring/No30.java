package mystring;

import java.util.*;
import java.util.stream.Collectors;

public class No30 {
    // 暴力解法 超时
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        List<String> collect = Arrays.stream(words).collect(Collectors.toList());
        int wLength = words[0].length();
        int index = 0;
        for (int i = 0; i < s.length() - wLength * words.length + 1; i++) {
            String sub = s.substring(i, i + wLength);
            List<String> subSet = new ArrayList<>(collect);
            index = i;
            while (subSet.contains(sub)) {
                index += wLength;
                subSet.remove(sub);
                if (subSet.isEmpty()) {
                    result.add(i);
                    break;
                }
                if (index + wLength > s.length()) {
                    break;
                }
                sub = s.substring(index, index + wLength);
            }
        }
        return result;
    }


    // 麻了
    public List<Integer> findSubstring2(String s, String[] words) {
        int length = words[0].length();
        List<Integer> result = new ArrayList<>();
        List<String> base = Arrays.stream(words).collect(Collectors.toList());

        for (int i = 0; i < length; i++) {
            int index = i;
            Queue<String> queue = new LinkedList<>();
            List<String> list = Arrays.stream(words).collect(Collectors.toList());
            while (true) {
                if (index + length > s.length()) break;

                String sub = s.substring(index, index + length);
                if (list.isEmpty() && base.contains(sub)) {
                    while (true) {
                        String peek = queue.peek();
                        list.add(peek);
                        queue.poll();
                        if (peek == null || peek.equals(sub)) break;
                    }
                }

                 if (list.contains(sub)) {
                    queue.add(sub);
                    list.remove(sub);
                } else if (base.contains(sub)) {
                    while (true) {
                        String peek = queue.peek();
                        queue.poll();
                        if (peek == null || peek.equals(sub)){
                            queue.add(sub);
                            break;
                        }
                        list.add(peek);
                    }
                } else {
                    list.addAll(queue);
                    queue.clear();
                }

                if (list.isEmpty()) {
                    result.add(index - length * (words.length - 1));
                }
                index += length;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        No30 no30 = new No30();
        System.out.println(no30.findSubstring2("bcabbcaabbccacacbabccacaababcbb", new String[]{"c","b","a","c","a","a","a","b","c"}));
    }
}
