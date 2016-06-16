package com.company;

import java.util.HashMap;
import java.util.Map;

public class StaticBlock
{
    private Map<Integer, String> accountsMap = new HashMap<>();

    {
        accountsMap.put(1, "Hello 1");
    }

    public StaticBlock()
    {
        System.out.println(accountsMap.get(1));
    }

    public static void main(String... argv)
    {
        new StaticBlock();
    }
}
