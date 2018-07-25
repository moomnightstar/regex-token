package com.company;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class quoteTest {
    private static Quote quotetest=new Quote();

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception{
        String s="Ofr:\n" +
                "61D AA 041768004  17山东公用CP002 2000W 4.92%";
        quotetest.setMessage(s);
    }

    @org.junit.jupiter.api.Test
    void parseDir() {
        quotetest.parseDir();
        assertEquals("Ofr",quotetest.getDirection());
    }

    @org.junit.jupiter.api.Test
    void parseCode() {
        quotetest.parseCode();
        assertEquals("041768004",quotetest.getCode());
    }

    @org.junit.jupiter.api.Test
    void parseNumble() {
        quotetest.parseNumble();
        assertEquals("2000W",quotetest.getNumble());
    }


    @org.junit.jupiter.api.Test
    void parseDate() {
        quotetest.parseDate();
        assertEquals("61D",quotetest.getDate());
    }

    @org.junit.jupiter.api.Test
    void parsePrice() {
        quotetest.parsePrice();
        assertEquals("4.92%",quotetest.getPrice());
    }


}