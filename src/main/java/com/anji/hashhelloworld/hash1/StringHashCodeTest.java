package com.anji.hashhelloworld.hash1;

/**
 * Description:
 * author: chenqiang
 * date: 2018/5/30 10:26
 */
public class StringHashCodeTest {
    public static void main(String[] args) {
        System.out.println("192.168.0.0:111的哈希值："+"192.168.0.0:8181".hashCode());
        System.out.println("192.168.0.1:111的哈希值："+"192.168.0.1:8181".hashCode());
        System.out.println("192.168.0.2:111的哈希值："+"192.168.0.2:8181".hashCode());
        System.out.println("192.168.0.3:111的哈希值："+"192.168.0.3:8181".hashCode());
        System.out.println("192.168.0.4:111的哈希值："+"192.168.0.4:8181".hashCode());
        System.out.println("192.168.0.4:111的哈希值："+"192.168.1.4:8181".hashCode());
    }
}
