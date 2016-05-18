package com.company;

import java.lang.reflect.ParameterizedType;

/**
 * Created by andras.igneczi on 06/04/2016.
 */
public class Generic<T>
{
    private T mInstance;

    T getInstance( Class<T> cls )
    {
        try
        {
            mInstance = cls.newInstance();
            if( mInstance instanceof String )
            {
                System.out.println( "This is string" );
            }
            return mInstance;
        }
        catch( InstantiationException e )
        {
            e.printStackTrace();
        }
        catch( IllegalAccessException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    T getInstance2()
    {
        try
        {
            mInstance = ( (Class<T>)( (ParameterizedType)getClass().getGenericSuperclass() ).getActualTypeArguments()[ 0 ] ).newInstance();
            if( mInstance instanceof String )
            {
                System.out.println( "This is string" );
            }
            return mInstance;
        }
        catch( InstantiationException e )
        {
            e.printStackTrace();
        }
        catch( IllegalAccessException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String... args)
    {
        Generic<String> lG = new Generic<String>();
        String o = lG.getInstance( String.class );
        o = o.concat( "hello" );
        System.out.println( o );

        String o2 = lG.getInstance2();
        o2 = o2.concat( "hello" );
        System.out.println( o2 );
    }
}
