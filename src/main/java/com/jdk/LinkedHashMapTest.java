package com.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description : 验证
 * @Author : wuqia
 * @Date : 2022/9/1 09:48
 * @Version : 1.0
 **/
@Slf4j
public class LinkedHashMapTest {

    @Test
    public void test1() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(3, 11);
        map.put(1, 11);
        map.put(5, 11);
        map.put(2, 11);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            log.error("key:{}", entry.getKey());
        }
    }

    @Test
    public void test2() {
        Map<Integer, Integer> map = new LinkedHashMap<>(4, 0.75F, true);
        map.put(3, 11);
        map.put(1, 11);
        map.put(5, 11);
        map.put(2, 11);
        map.put(3, 12);
        map.get(1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            log.error("key:{}", entry.getKey());
        }
        log.error("get(3L):{}", map.get(new Long(3L)));
        log.error("get(3):{}", map.get(new Integer(3)));
    }
}
