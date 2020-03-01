package com.stack;


import java.util.Stack;

/**
 * @author
 * @date 2020-01-13 15:53
 */
public class MyStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else if (value < getMin()) {
            minStack.push(value);
        } else {
            minStack.push(getMin());
        }
        dataStack.push(value);
    }

    public int pop(){
        if (dataStack.isEmpty()){
            throw new RuntimeException("栈空");
        }
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return minStack.peek();
    }

}
