package com.struct.stack;

/**
 * @Description : 顺序栈
 * @Author : wuqia
 * @Date : 2022/7/26 08:55
 * @Version : 1.0
 **/
public class ArrayStack {

    /**
     * 大小
     */
    private int size;
    /**
     * coutn
     */
    private int count;

    /**
     * 项目
     */
    private String items[];

    public ArrayStack(int size) {
        this.count = 0;
        this.size = size;
        this.items = new String[size];
    }

    public boolean push(String item) {
        if (count == size) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("1");
        arrayStack.push("2");
        System.out.println(arrayStack.push("3"));
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.push("3"));
    }
}
