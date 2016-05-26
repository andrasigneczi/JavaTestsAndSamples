package com.company;

public class CloneTest
{
    public static class Class1 implements Cloneable
    {
        public String s1 = "Helló Class1";

        public Class1()
        {

        }

        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class Class2 extends Class1
    {
        public String s2 = "Helló Class2";

        public Class1 c1 = new Class1();

        public Class2()
        {
            super();
        }

        public Object clone() throws CloneNotSupportedException
        {
            Class2 lR = (Class2) super.clone();
            lR.c1 = (Class1) c1.clone();
            return lR;
        }
    }

    public static void main(String... argv)
    {
        Class2 c1 = new Class2();
        Class2 c2 = null;
        try
        {
            c2 = (Class2) c1.clone();
            c2.s1 = "modified1";
            c2.s2 = "modified2";
            c2.c1.s1 = "trick1";
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

    }
}
