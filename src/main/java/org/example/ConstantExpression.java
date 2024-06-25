package org.example;

/*
    Represents a Constant Value
 */
public class ConstantExpression implements Expression {
    private Object value;

    public ConstantExpression(Object value) {
        this.value = value;
    }

    public void interpret(Context c) {
        c.addVariable(this, value);
    }
}
