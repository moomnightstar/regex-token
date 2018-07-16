package com.company;



import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class quote {
    static String direction;
    String code;
    String data;
    String numble;
    String price;

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

            while((temp=reader.readLine())!=null){
                Matcher matcher= parseDir(temp);
                if(matcher.find()){
                    //System.out.println("Found value:"+);
                    direction=matcher.group(1);
                    System.out.println(direction);
                }else{
                    System.out.println("no match");
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
