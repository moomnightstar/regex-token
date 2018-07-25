package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quote {
    public static String message;
    private static String direction;
    private static String code;
    private static String date;
    private static String numble;
    private static String price;


    public static void setMessage(String message) {
        Quote.message = message;
    }


    public static void parseDir(){
        String rexp="ofr";
        Pattern pattern =Pattern.compile(rexp,Pattern.CASE_INSENSITIVE);//Pattern.compile(rexp,Pattern.CASE_INSENSITIVE)表示整体都忽略大小写
        Matcher matcher =pattern.matcher(message);
        if(matcher.find()) {
            direction = matcher.group(0);
        }

    }

    public static void parseCode(){
        String rexp="([0-9]+\\.(IB|SH))|([0-9]{9})";
        Pattern pattern =Pattern.compile(rexp);
        Matcher matcher =pattern.matcher(message);
        if(matcher.find()){
            code=matcher.group(0);
        }else{
            code="no code";

        }
    }

    public static void parseNumble(){
        String rexp="[0-9]+W";
        Pattern pattern =Pattern.compile(rexp);
        Matcher matcher =pattern.matcher(message);
        if(matcher.find()){
            numble=matcher.group(0);

        }

    }

    public static void parseDate(){
        String rexp="[0-9]+(\\.[0-9]+)*(D|Y)(\\+[0-9]+(\\.[0-9]+)*(D|Y))*";
        Pattern pattern =Pattern.compile(rexp);
        Matcher matcher =pattern.matcher(message);
        if(matcher.find()){
            date=matcher.group(0);

        }

    }

    public static void parsePrice(){
        String rexp="[0-9]+\\.[0-9]+\\%";
        Pattern pattern =Pattern.compile(rexp);
        Matcher matcher =pattern.matcher(message);
        if(matcher.find()){
            price=matcher.group(0);

        }
        else{
            rexp="估值([0-9]+\\.[0-9]+)";
            pattern =Pattern.compile(rexp);
            matcher =pattern.matcher(message);
            if(matcher.find()){
                price=matcher.group(0);
                price=price.replaceAll("估值","")+"%";

            }
        }
    }
    public static String getCode() {
        return code;
    }

    public static String getMessage() {
        return message;
    }

    public static String getDate() {
        return date;
    }

    public static String getDirection() {
        return direction;
    }

    public static String getNumble() {
        return numble;
    }

    public static String getPrice() {
        return price;
    }

}
