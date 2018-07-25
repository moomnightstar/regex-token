package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.*;
import java.util.Map;
import java.util.HashMap;


public class readthetext {

    public static void main(String[] args) {
        // write your code here
        //System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        File file=new File("./res/报价消息格式样本05.txt");
        readtxtline(file);


    }

    public static void readtxtline(File file){
        String[] head =new String[]{"代码","证券名称","最新评级", "剩余期限", "估值", "面值万"};
        BufferedReader reader=null;
        String temp=null;
        Map map =new HashMap();
        StringBuffer err=new StringBuffer();
        Map<String,String> m=new HashMap<>();
        int line=0;
        try{
            reader=new BufferedReader(new FileReader(file));

            if((temp=reader.readLine())!=null){
                String [] arr=temp.split("\\s+");
                for(int i=0;i<head.length;i++){
                    for(int j=0;j<arr.length;j++){
                        if(head[i].equals(arr[j])){
                            map.put(head[i],j);
                            break;
                        }
                        if(j==arr.length-1){
                            err.append(head[i]).append(",");
                        }
                    }
                }
                if(err.length()!=0){
                    System.out.println("缺少表头："+err.toString());
                }
                else {
                    System.out.println(map);

                    while ((temp = reader.readLine()) != null) {
                        arr = temp.split("\\s+");
                        line++;
                        for(int i=0;i<arr.length;i++){
                            //System.out.println(arr[(int)map.get(head[i])]);
                            //System.out.println(head[i]+line);
                            m.put(head[i]+line,arr[(int)map.get(head[i])]);
                        }
                    }
                }
            }

            for(int i=1;i<=line;i++){
                for(int j=0;j<head.length;j++){
                    System.out.print(m.get(head[j]+i)+" ");
                }
                System.out.println("");
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
