package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String mName;
    String aName;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int mAge;

    public Person( int aAge, String aName ) {
        mAge = aAge;
        mName = aName;
    }

    public int getAge() {
        return mAge;
    }

    public void printPerson() {
        System.out.println( "Nev: " + mName + "; Kor: " + mAge );
    }

    public Sex getGender() {
        return Sex.MALE;
    }

    public String getEmailAddress() {
        return "v@gmail.com";
    }

    public static List<Person> createRoster() {
        List<Person> lRetValue = new ArrayList<>();
        lRetValue.add( new Person( 10, "Kata" ));
        lRetValue.add( new Person( 12, "Peti" ));
        lRetValue.add( new Person( 14, "Dani" ));
        lRetValue.add( new Person( 20, "Juci" ));
        lRetValue.add( new Person( 26, "Zoli" ));
        return lRetValue;
    }
}
