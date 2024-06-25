package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/*
    Represents a Variable Value - obtained by calling a method on some class
 */
public class VariableExpression implements Expression {
    private Object lookup;
    private String methodName;

    public VariableExpression(Object lookup, String methodName) {
        this.lookup = lookup;
        this.methodName = methodName;
    }

    public void interpret(Context c) {
        try {
            Object source = c.get(lookup);
            if(source != null) {
                Method method = source.getClass().getMethod(methodName, null);
                Object result = method.invoke(source, null);
                c.addVariable(this, result);
            }
        } catch(NoSuchMethodException exc) {
            System.out.println("NoSuchMethodException ...");
        } catch(IllegalAccessException exc) {
            System.out.println("IllegalAccessException ...");
        } catch (InvocationTargetException exc) {
            System.out.println("InvocationTargetException ...");
        }
    }
}
