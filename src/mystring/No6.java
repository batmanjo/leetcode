package mystring;

import util.RandomUtil;

import java.util.Random;

public class No6 {

    // 常规解法
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        int width = s.length() / (2 * numRows - 2) * numRows + numRows;
        char[][] chars = new char[numRows][width];
        // 方向
        boolean isDown = true;
        int row = 0;
        int col = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[row][col] = s.charAt(i);
            if (isDown) {
                if (row + 1 >= numRows) {
                    row--;
                    col++;
                    isDown = false;
                } else {
                    row++;
                }
            } else {
                if (row == 0) {
                    row++;
                    isDown = true;
                } else {
                    row--;
                    col++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < width; j++) {
                if (chars[i][j] != 0) {
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }

    // 优化解法
    public String convert2(String s, int numRows) {
        if (s.length() <= numRows || numRows <= 1) {
            return s;
        }

        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++){
            rows[i] = "";
        }

        boolean flag = true;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[temp] += s.charAt(i);
            if(flag){
                temp++;
                if (temp == numRows ){
                    flag = false;
                    temp-=2;
                }
            }else{
                temp--;
                if (temp == -1){
                    flag = true;
                    temp+=2;
                }
            }

        }

        return String.join("", rows);
    }


    public static void main(String[] args) {
        System.out.println(new No6().convert2("AB", 1));
        for (int i = 0; i < 1000; i++) {
            String s = RandomUtil.randomString((int) (Math.random() * 1000));
            int a = (int)(Math.random() * 1000);
            try {
                new No6().convert2(s, a);
//                System.out.println(new No6().convert2(s, a));
            }catch (Exception e){
                System.out.println(s + " " + a);
            }
        }

    }


}
