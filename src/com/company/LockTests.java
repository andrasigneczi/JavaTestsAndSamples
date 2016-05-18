package com.company;

import sun.rmi.runtime.Log;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Semaphore;

/**
 * Created by Andras on 30/11/2015.
 */
public class LockTests {

    private volatile String mVolatileString = new String();
    private String mStandardString = new String();
    private Semaphore mSemaphor = new Semaphore( 1 );
    private final int mRepeatCount = 100000000;

    public int VolatileTest() {
        LocalDateTime lT1 = LocalDateTime.now();
        for (int i = 0; i < mRepeatCount; i++) {
            mVolatileString = String.valueOf(i);
        }


        LocalDateTime tempDateTime = LocalDateTime.from( lT1 );
        long lMillis = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println( "volatile test result: " + lMillis );
        return 0;
    }


    public void SemaphoreTest()
    {
        LocalDateTime lT1 = LocalDateTime.now();

        try {
            mSemaphor.acquire();
            for (int i = 0; i < mRepeatCount; i++) {
                mStandardString = String.valueOf(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            mSemaphor.release();
        }

        LocalDateTime tempDateTime = LocalDateTime.from( lT1 );
        long lMillis = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println( "semaphore test result: " + lMillis );
    }

    public void SynchrinosedTest1()
    {
        LocalDateTime lT1 = LocalDateTime.now();

        synchronized ( this )
        {
            for (int i = 0; i < mRepeatCount; i++) {
                mStandardString = String.valueOf(i);
            }
        }

        LocalDateTime tempDateTime = LocalDateTime.from( lT1 );
        long lMillis = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println( "synchronised test1 result: " + lMillis );
    }

    public void SynchrinosedTest2()
    {
        LocalDateTime lT1 = LocalDateTime.now();

        synchronized ( mStandardString )
        {
            for (int i = 0; i < mRepeatCount; i++) {
                mStandardString = String.valueOf(i);
            }
        }

        LocalDateTime tempDateTime = LocalDateTime.from( lT1 );
        long lMillis = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println( "synchronised test2 result: " + lMillis );
    }

    public void SynchrinosedTest3()
    {
        LocalDateTime lT1 = LocalDateTime.now();

        synchronized ( LockTests.class )
        {
            for (int i = 0; i < mRepeatCount; i++) {
                mStandardString = String.valueOf(i);
            }
        }

        LocalDateTime tempDateTime = LocalDateTime.from( lT1 );
        long lMillis = tempDateTime.until( LocalDateTime.now(), ChronoUnit.MILLIS);
        System.out.println( "synchronised test3 result: " + lMillis );
    }

    public static void main(String... args) throws Exception
    {
        LockTests lT1 = new LockTests();
        lT1.VolatileTest();
        lT1.SemaphoreTest();
        lT1.SynchrinosedTest1();
        lT1.SynchrinosedTest2();
        lT1.SynchrinosedTest3();
    }
}
