package com.trihutt.smartschool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class StudentRegistrationFormDatabase extends SQLiteOpenHelper {


    public static final int DB_VERSION=5;
    public static final String DB_NAME="SchoolReg";
    public static final String TABLE_STD_REGISTRATION="StudentRegistration";
    public static final String COLLUMN_REG_ID = "Id";
    public static final String COLLUMN_REG_FULL_NAME= "FullName";
    public static final String COLLUMN_REG_EMAIL="Email";
    public static final String COLLUMN_REG_PASSWORD="Password";
    public static final String COLLUMN_REG_REPASSWORD="RPassword";
    public static final String COLLUMN_REG_MOBILE="Mobile";
    public static final String COLLUMN_REG_GENDER="Gender";
    public static final String COLLUMN_REG_CITY="City";
    public static final String COLLUMN_REG_NOTIFICATION="Notification";

    public static final String TABLE_STD_HOBBY ="StdHobby";
    public static final String COLLUMN_HOBBY_ID="Id";
    public static final String COLLUMN_HOBYY_NAME="Hobby";
    public static final String COLLUMN_STD_ID="Std_Id";


    public StudentRegistrationFormDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //This is the student regisrtation form table
        String std_registration = " create table " + StudentRegistrationFormDatabase.TABLE_STD_REGISTRATION + " ( " + StudentRegistrationFormDatabase.COLLUMN_REG_ID + " INTEGER PRIMARY KEY ," + StudentRegistrationFormDatabase.COLLUMN_REG_FULL_NAME + " text ," + StudentRegistrationFormDatabase.COLLUMN_REG_EMAIL + " text ," + StudentRegistrationFormDatabase.COLLUMN_REG_PASSWORD + " text , " + StudentRegistrationFormDatabase.COLLUMN_REG_REPASSWORD + " text , "
                + StudentRegistrationFormDatabase.COLLUMN_REG_MOBILE + " text, "
                + StudentRegistrationFormDatabase.COLLUMN_REG_GENDER + " text, "
                + StudentRegistrationFormDatabase.COLLUMN_REG_CITY + " text, "
                + StudentRegistrationFormDatabase.COLLUMN_REG_NOTIFICATION + " text " + " ) ";

        sqLiteDatabase.execSQL(std_registration);


        //This is the derived table from student registration that is called Hobby Table.

        String std_hobby = " CREATE TABLE " + StudentRegistrationFormDatabase.TABLE_STD_HOBBY + " ( " + StudentRegistrationFormDatabase.COLLUMN_HOBBY_ID + " INTEGER PRIMARY KEY," + StudentRegistrationFormDatabase.COLLUMN_HOBYY_NAME + " text," + StudentRegistrationFormDatabase.COLLUMN_STD_ID + " text" + ")";
        sqLiteDatabase.execSQL(std_hobby);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" drop table if EXISTs " + StudentRegistrationFormDatabase.TABLE_STD_REGISTRATION);
        sqLiteDatabase.execSQL(" drop table if EXISTs " + StudentRegistrationFormDatabase.TABLE_STD_HOBBY);
        onCreate(sqLiteDatabase);
    }
}
