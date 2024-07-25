package mystring;

import java.util.ArrayList;
import java.util.List;

public class No68 {

    // 暴力解法
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int length = -1;
        int begin = 0;
        int count;
        for (int i = 0; i < words.length; i++) {
            length += words[i].length() + 1;
            if(length > maxWidth){
                length = length - words[i].length() - 1;
                count = i - begin;
                StringBuilder temp = new StringBuilder();


                if(count == 1){
                    temp.append(words[begin]);
                    for (int k = 0; k < maxWidth - length; k++) {
                        temp.append(" ");
                    }
                }else {
                    int gap = (maxWidth - length) / (count - 1) + 1;
                    int remainder = (maxWidth - length) % (count - 1);
                    System.out.println(gap + " " + remainder);
                    for (int j = begin; j < i; j++) {
                        temp.append(words[j]);
                        if (j == i - 1) {
                            break;
                        }
                        for (int k = 0; k < gap; k++) {
                            temp.append(" ");
                        }
                        if (remainder > 0) {
                            temp.append(" ");
                            remainder--;
                        }
                    }
                }
                System.out.println(temp.length());
                res.add(temp.toString());
                begin = i;
                length = -1;
                i--;
            }
        }

        StringBuilder temp = new StringBuilder();
        while(begin < words.length - 1){

            temp.append(words[begin]);
            temp.append(" ");
            begin++;
        }
        temp.append(words[begin]);
        for (int i = 0; i < maxWidth - length; i++) {
            temp.append(" ");
        }
        res.add(temp.toString());
        return res;
    }

    // todo  贪心
}
