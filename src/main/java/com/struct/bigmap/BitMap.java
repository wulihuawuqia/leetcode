package com.struct.bigmap;

import cn.hutool.core.lang.Assert;
import lombok.Data;

/**
 * @Description : 位图简单实现
 * @Author : wuqia
 * @Date : 2022/10/28 09:23
 * @Version : 1.0
 **/
@Data
public class BitMap {


    /**
     * 使用 char存储数据  每个char为16位 能存储16个数字
     */
    private char[] data;

    /**
     * 总的数据量
     */
    private int count;

    private static final int size = 16;

    public BitMap(int count) {
        this.data = new char[count / size + 1];
        this.count = count;
    }

    public void set(int num) {
        if (num > count || num < 0) {
            return;
        }
        int dataIndex = num / size;
        int pos = num % size;
        // 将1 左移 pos 位，然后和 16位的 char 进行 与操作
        this.data[dataIndex] = (char) (this.data[dataIndex] | 1 << pos);
    }

    public boolean get(int num) {
        if (num > count || num < 0) {
            return false;
        }
        int dataIndex = num / size;
        int pos = num % size;
        return (this.data[dataIndex] & (1 << pos)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(Integer.MAX_VALUE);
        bitMap.set(100);
        Assert.isTrue(bitMap.get(100));
        Assert.isFalse(bitMap.get(1000));
        bitMap.set(1010);
        Assert.isTrue(bitMap.get(1010));
    }
}
