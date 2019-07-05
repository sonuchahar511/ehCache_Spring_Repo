package com.chahar.common;

public class GroovyScriptApp {
    public static void main(String[] args) {
        final String groovyScript = " \" This is $user and time is $now \" ";
        //final String groovyScript = " \" This is $user and time is $now 1112\" ";

        GroovyScriptUtils.executeScript(groovyScript);
    }
}
