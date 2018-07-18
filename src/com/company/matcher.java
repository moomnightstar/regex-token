package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matcher {
    public static Matcher parseDir(String s){
        String rexp="ofr";
        Pattern pattern =Pattern.compile(rexp,Pattern.CASE_INSENSITIVE);
        Matcher matcher =pattern.matcher(s);
        return matcher;

        /*
        java正则表达式:
  (?i)abc 表示abc都忽略大小写
  a(?i)bc 表示bc忽略大小写
  a((?i)b)c 表示只有b忽略大小写

也可以用Pattern.compile(rexp,Pattern.CASE_INSENSITIVE)表示整体都忽略大小写
         */
    }
    public static Matcher parseCode(String s){
        String code="[0-9]+\\.(IB|SH)";
        Pattern pattern =Pattern.compile(code);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }
    public static Matcher parseNumble(String s){
        String numble="[0-9]+W";
        Pattern pattern =Pattern.compile(numble);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }
    public static Matcher parseDate(String s){
        String date="[0-9]+(\\.[0-9]+)*(D|Y)(\\+[0-9]+(\\.[0-9]+)*(D|Y))*";
        Pattern pattern =Pattern.compile(date);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }
    public static Matcher parsePrice(String s){
        String price="[0-9]+\\.[0-9]+\\%";
        String price2="估值([0-9]+\\.[0-9]+)";
        Pattern pattern =Pattern.compile(price);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }

    public static void main(String[] args){
        String test="Ofr:\n" +
                "61D AA 041768004 17山东公用CP002 2000W 4.92%\n" +
                "115D+2Y 136009.SH 15红星01 5.90 AAA/AA+ 2000(行权)\n" +
                "4.16Y 17宝安02 AA+/AAA 6.02% 1000";
        Matcher matcher=parseCode(test);
        if(matcher.find()){
            System.out.println("find: "+ matcher.group(0));
        }
    }

}
