package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.*;

public class readthetext {

    public static void main(String[] args) {
        // write your code here
        //System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

        File file=new File("./res/报价消息格式样本05.txt");
        readtxtline(file);


    }

    public static void readtxtline(File file){
        BufferedReader reader=null;
        String temp=null;
        try{
            reader=new BufferedReader(new FileReader(file));

            if((temp=reader.readLine())!=null){
                while((temp=reader.readLine())!=null){
                    String [] arr=temp.split("\\s+");
                    for(String ss:arr){
                        System.out.print(ss+" ");
                    }
                    System.out.println("");
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
}
