package com.chahar.common;


import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.MissingPropertyException;
import groovy.util.Eval;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GroovyScriptUtils {
    private GroovyScriptUtils() {
        //Avoid class instantiation
    }

    public static Map<String, Object> executeScript(final String script) {
        final Map<String, Object> groovyContext = prepareGroovyContext();

        final Binding binding = new Binding(groovyContext);
        final GroovyShell groovyShell = new GroovyShell(binding);

        Map<String, Object> outputResult = null;
        try {
            final Object result = groovyShell.evaluate(script);
            outputResult = prepareOutputResult(groovyContext, script, result, null);

            System.out.println(result);
        } catch (final MissingPropertyException e) {
            outputResult = prepareOutputResult(groovyContext, script, null, e);

            System.out.println(e);
        }

        return outputResult;
    }

    public static String executeScripts(final String script) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream saveSystemOut = System.out;
        System.setOut(new PrintStream(buffer));

        Eval.me(script);

        System.setOut(saveSystemOut);
        String output = buffer.toString().trim();
        return output;
    }

    public static String executeScripts(Object obj, final String script) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream saveSystemOut = System.out;
        System.setOut(new PrintStream(buffer));
        /*try{
             Eval.x(obj,script);
        }catch(CompilationFailedException e){
            e.printStackTrace();
        }*/
        Eval.x(obj, script);
        System.setOut(saveSystemOut);
        String output = buffer.toString().trim();
        return output;
    }

    private static Map<String, Object> prepareGroovyContext() {
        final Map<String, Object> groovyContext = new HashMap<>();
        groovyContext.put("now", new Date());
        groovyContext.put("user", "groovyUser");

        return groovyContext;
    }

    private static Map<String, Object> prepareOutputResult(Map<String, Object> groovyContext,
                                                           final String script, final Object scriptOutput, final Exception exp) {
        final Map<String, Object> result = new HashMap<>();
        result.put("groovyContext", groovyContext);
        result.put("script", script);

        if (scriptOutput != null) {
            System.out.println(scriptOutput);
            result.put("output", scriptOutput);
        }

        if (exp != null) {
            result.put("exception", exp.getLocalizedMessage());
        }
        return result;
    }
}
