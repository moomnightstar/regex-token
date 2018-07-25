package com.company;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class quoteTest {
    private static quote quotetest=new quote();

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception{
        String s="Ofr:\n" +
                "61D AA 041768004  17山东公用CP002 2000W 4.92%";
        quotetest.setMessage(s);
    }

    @org.junit.jupiter.api.Test
    void parseDir() {
        quote.parseDir();
        assertEquals("Ofr",quotetest.getDirection());
    }

    @org.junit.jupiter.api.Test
    void parseCode() {
        quote.parseCode();
        assertEquals("041768004",quotetest.getCode());
    }

    @org.junit.jupiter.api.Test
    void parseNumble() {
        quote.parseNumble();
        assertEquals("2000W",quotetest.getNumble());
    }


    @org.junit.jupiter.api.Test
    void parseDate() {
        quote.parseDate();
        assertEquals("61D",quotetest.getDate());
    }

    @org.junit.jupiter.api.Test
    void parsePrice() {
        quote.parsePrice();
        assertEquals("4.92%",quotetest.getPrice());
    }


}