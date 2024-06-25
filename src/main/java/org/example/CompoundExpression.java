package org.example;

/*
    Pair of ComparisonExpression - evaluate to a Boolean result
 */
public abstract class CompoundExpression implements Expression {
    protected ComparisonExpression expressionA;
    protected ComparisonExpression expressionB;

    public CompoundExpression(ComparisonExpression expressionA, ComparisonExpression expressionB) {
        this.expressionA = expressionA;
        this.expressionB = expressionB;
    }
}
