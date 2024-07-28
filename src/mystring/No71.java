package mystring;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No71 {
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] ss = path.split("/");
        for (String s : ss) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                queue.pollLast();
            } else {
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

}
