package mystring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No12 {
    public String intToRoman(int num) {

        String s = String.valueOf(num);
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                list.set(j,getNext(list.get(j)));
            }
            String base = getBase(s.charAt(i));
            for (char c : base.toCharArray()) {
                list.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private char getNext(char c){
        switch (c){
            case 'I':
                return 'X';
            case 'X':
                return 'C';
            case 'C':
                return 'M';
            case 'V':
                return 'L';
            case 'L':
                return 'D';
            default:
                return ' ';
        }
    }
    private String getBase(char c){
        switch (c){
            case '1':
                return "I";
            case '2':
                return "II";
            case '3':
                return "III";
            case '4':
                return "IV";
            case '5':
                return "V";
            case '6':
                return "VI";
            case '7':
                return "VII";
            case '8':
                return "VIII";
            case '9':
                return "IX";
            default:
                return "";
        }
    }


    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
    static class Foo{
        char current;
        char next;
        Foo nextFoo;

        public Foo(char current) {
            this.current = current;
        }

        public Foo setNext(char next) {
            this.next = next;
            Foo foo = new Foo(next);
            nextFoo = foo;
            return foo;
        }


        public String toString() {
            return current + " " + next + " " + nextFoo;
        }
    }

    public static void main(String[] args) {
        No12 no12 = new No12();

        System.out.println(no12.intToRoman(3999));
    }






}
