package com.company;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class quote {
    static String direction;
    static String code;
    static String date;
    static String numble;
    static String price;

    public static void main(String[] args) {
        // write your code here
        //System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

        File file=new File("./res/报价消息格式样本.txt");
        readtxtline(file);


    }

    public static void readtxtline(File file){
        BufferedReader reader=null;
        String temp=null;
        int line=1;
        try{
            reader=new BufferedReader(new FileReader(file));

            if((temp=reader.readLine())!=null){
                Matcher matcher= parseDir(temp);
                if(matcher.find()){
                    //System.out.println("Found value:"+);
                    direction=matcher.group(0);
                    while((temp=reader.readLine())!=null){
                        System.out.println(temp);
                        System.out.print(direction+" ");
                        matcher=parseCode(temp);
                        if(matcher.find()){
                            code=matcher.group(0);
                            System.out.print(code+" ");
                        }else{
                            System.out.print("(no code) ");
                        }
                        matcher=parseDate(temp);
                        if(matcher.find()){
                            date=matcher.group(0);
                            System.out.print(date+" ");
                        }
                        matcher=parseNumble(temp);
                        if(matcher.find()){
                            numble=matcher.group(0);
                            System.out.print(numble+" ");
                        }else{
                            matcher=parseNumble2(temp);
                            if(matcher.find()){
                                numble=matcher.group(0);
                                System.out.print(numble+"W ");
                            }
                        }
                        matcher=parsePrice(temp);
                        if(matcher.find()){
                            price=matcher.group(0);
                            System.out.print(price+" ");
                        }
                        else{
                            matcher=parsePrice2(temp);
                            if(matcher.find()){
                                price=matcher.group(0);
                                price=price.replaceAll("估值","")+"%";
                                System.out.print(price+" ");
                            }
                        }
                        System.out.println("");
                        //System.out.println(direction+" "+code+" "+numble+" "+date+" "+price);
                    }

                }else{
                    System.out.println("direction no match");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static Matcher parseDir(String s){
        String rexp="ofr";
        Pattern pattern =Pattern.compile(rexp,Pattern.CASE_INSENSITIVE);//Pattern.compile(rexp,Pattern.CASE_INSENSITIVE)表示整体都忽略大小写
        Matcher matcher =pattern.matcher(s);
        return matcher;

    }
    public static Matcher parseCode(String s){
        String code="([0-9]+\\.(IB|SH))|([0-9]{9})";
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
    public static Matcher parseNumble2(String s){
        String numble="[0-9]{4}";
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
       
        Pattern pattern =Pattern.compile(price);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }
    public static Matcher parsePrice2(String s){
        String price2="估值([0-9]+\\.[0-9]+)";
        Pattern pattern =Pattern.compile(price2);
        Matcher matcher =pattern.matcher(s);
        return matcher;
    }
}
