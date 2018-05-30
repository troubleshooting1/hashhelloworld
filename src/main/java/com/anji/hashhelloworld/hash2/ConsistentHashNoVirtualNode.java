package com.anji.hashhelloworld.hash2;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Description: 不带虚拟节点的一致性Hash算法
 * author: chenqiang
 * date: 2018/5/30 10:30
 */
public class ConsistentHashNoVirtualNode {

    private static String[] servers = {"192.168.0.0:8081", "192.168.0.1:8081", "192.168.0.2:8081", "192.168.0.3:8081", "192.168.0.4:8081"};

    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println(servers[i] + "加入集合，其hash值为" + hash);
            sortedMap.put(hash, servers[i]);
        }
    }

    //使用FNV1_32_HASH算法计算服务器的hash值
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    //应该路由到哪台服务器
    private static String getServer(String node) {
        int hash = getHash(node);
        //得到大于该Hash值得所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        Integer i = subMap.firstKey();
        return subMap.get(i);
    }

    public static void main(String[] args) {
        String[] nodes={"127.0.0.1:1111", "221.226.0.1:2222", "102.211.0.122:3333" , "238.226.0.1:2222", "221.211.0.122:3333"};
        for (int i=0;i<nodes.length;i++){
            System.out.println("["+nodes[i]+"]的hash值为"+getHash(nodes[i])+",被路由到节点["+getServer(nodes[i])+"]");
        }
    }
}
