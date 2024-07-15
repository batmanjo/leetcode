package mystring;

import java.util.Arrays;

public class No14 {
    public String longestCommonPrefix(String[] strs) {
        int[] lens = new int[strs.length];
        for(int i = 0;i<strs.length;i++){
            lens[i] = strs[i].length();
        }
        Arrays.sort(lens);
        int len = lens[0];
        StringBuilder str = new StringBuilder();
        char c;
        for(int i = 0;i<len;i++){
            c = strs[0].charAt(i);
            for(int j = 0;j<strs.length;j++){
                if(strs[j].charAt(i)!=c){
                    return str.toString();
                }
                if(j==strs.length-1){
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
    public String longestCommonPrefix2(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].length() <= i){
                    return stringBuilder.toString();
                }
                if(flag){
                    flag = c == strs[j].charAt(i);
                }else {
                    break;
                }
            }
            if(flag){
                stringBuilder.append(c);

            }else {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        int c;
        c =  'e' ^ 'e' ^ 'e';
        System.out.println(c);
    }
}
