package com.company;

import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class quote {
    String direction;
    String code;
    String data;
    String numble;
    String price;


    public static void main(String[] args) {
        // write your code here
        String test1="Ofr:\n" +
                "041768004 61D 2000W 4.92%";
        String result= parse(test1);


    }
    public static String parse(String s){
        String rexp="ofr";
        Pattern pattern =Pattern.compile(rexp,Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(s);
        if(matcher.find()){
            System.out.println("Found value:"+ matcher.groupCount());
        }else{
            System.out.println("no match");
        }

        /*
        java正则表达式:
  (?i)abc 表示abc都忽略大小写
  a(?i)bc 表示bc忽略大小写
  a((?i)b)c 表示只有b忽略大小写

也可以用Pattern.compile(rexp,Pattern.CASE_INSENSITIVE)表示整体都忽略大小写
         */
        return matcher.group(0);
    }
}
