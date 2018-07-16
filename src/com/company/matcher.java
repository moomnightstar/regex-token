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

}
