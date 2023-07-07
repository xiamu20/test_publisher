package demo;

import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class TestSubString {
    public static void main(String[] args) {
        String s = "a&b&c";
        String[] splits = s.split("&");
        for (String s1: splits
             ) {
            System.out.println(s1);
            
        }

        StringTokenizer stringTokenizer = new StringTokenizer(s, "&");
        HashSet<String> hashSet = new HashSet<>();
        

        while (stringTokenizer.hasMoreElements()) {
            System.out.println("print:" + stringTokenizer.nextToken().toString());
          //  hashSet.add(stringTokenizer.nextToken().toString());

        }
      //  System.out.println(hashSet.size());
    }
}