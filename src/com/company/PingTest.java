package com.company;

/**
 * Created by andras.igneczi on 22/10/2015.
 * ICMP
 * TCP/IP
 * Trace route
 * Report
 */
public class PingTest {
    static public void ICMP()
    {
        int lDelay = 5;
        int lTimeout = 10;
        String lHost = "www.index.hu";

    }

    static public void TCP_IP_HTTP_REQUEST() throws Exception
    {
        int lDelay = 5;
        int lTimeout = 10;
        String lUrl = "http://www.google.com/search?q=mkyong";

        HttpRequest http = new HttpRequest();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet( lUrl );

        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();
    }

    static public void TraceRoute()
    {

    }
}

