package com.stack;

import com.sun.xml.internal.bind.v2.model.core.ID;
import mytest.zinc.In;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 */
public class QueueToStack {
    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(queueToStack.pop());
        }

    }

    private Queue<Integer> data;
    private Queue<Integer> help;

    public QueueToStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    //正常push添加进入Queue
    public void push(int value) {
        data.add(value);
    }

    //当在pop的时候,pop只留下一个元素,并把pop出来的元素加入到help队列中
    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }


    public void swap() {
        Queue<Integer> temp;
        temp = data;
        help = temp;
    }
}