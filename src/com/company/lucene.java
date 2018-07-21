package com.company;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;


public class lucene {private static void doToken(TokenStream ts) throws IOException {
    ts.reset();
    CharTermAttribute cta = ts.getAttribute(CharTermAttribute.class);
    while (ts.incrementToken()) {
        System.out.print(cta.toString() + "|");
    }
    System.out.println();
    ts.end();
    ts.close();
}

    public static void main(String[] args) throws IOException {
        String [] chineseText = {"出隔夜1000W。" ,
                "出最后8000万隔夜，押利率" ,
                "便宜出秒到1到7天资金1亿，押利率可拆分，要的小窗",
                "出整量7D、14D、21D,自营押利率" ,
                "出1D-21D资金，押利率，限自营户" ,
                "出7000万6M~押券宽松~限银行"};
        // Lucene 的中文分词器 SmartChineseAnalyzer
        try (Analyzer smart = new SmartChineseAnalyzer()) {
            TokenStream ts;
            System.out.println("smart中文分词器，中文分词效果：");
            for(String arr:chineseText) {
                ts = smart.tokenStream("content", arr);
                doToken(ts);
            }
        }

    }
}
