package mystring;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(8);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty() || map.get(c) != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        No20 no20 = new No20();
        System.out.println(no20.isValid("{()}{(}"));
    }
}
