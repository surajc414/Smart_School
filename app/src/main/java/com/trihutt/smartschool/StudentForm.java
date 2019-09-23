package com.trihutt.smartschool;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class StudentForm extends AppCompatActivity {

    EditText fullname,email,password,re_password,mobile;
    Spinner city_list;
    RadioGroup rg_gender;
    Switch sw_noti;
    String notif,gender,city;
    CheckBox write_program,read_blog,listening_music,learn_programming;
    Button register;

    /*Creating a object of StudentRegistrationFormDatabase class */

    StudentRegistrationFormDatabase databaseHandler;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        getSupportActionBar().setTitle("Registration Form");
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionbarcolor)));

        databaseHandler = new StudentRegistrationFormDatabase(this);


        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.repassword);
        mobile = findViewById(R.id.mobile);
        city_list = findViewById(R.id.city);
        rg_gender = findViewById(R.id.rg_gender);

        write_program = findViewById(R.id.program);
        read_blog = findViewById(R.id.readblog);
        listening_music = findViewById(R.id.listenmusic);
        learn_programming = findViewById(R.id.learnprogramming);

        city = city_list.getSelectedItem().toString();
        sw_noti = findViewById(R.id.switch1);

        register = findViewById(R.id.register);
    }

        public void btnRegister(View view){

            db = databaseHandler.getWritableDatabase();
                ContentValues values = new ContentValues();
                ContentValues values2 = new ContentValues();

                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_FULL_NAME,fullname.getText().toString());
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_EMAIL,email.getText().toString());
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_PASSWORD,password.getText().toString());
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_REPASSWORD,re_password.getText().toString());
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_MOBILE,mobile.getText().toString());
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_GENDER,gender);
                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_CITY,city);

                if(sw_noti.isChecked())
                    notif = "yes";
                else
                    notif = "no";

                values.put(StudentRegistrationFormDatabase.COLLUMN_REG_NOTIFICATION,notif);
           long id  =     db.insert(StudentRegistrationFormDatabase.TABLE_STD_REGISTRATION,null,values);

            Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();

                if(write_program.isChecked())
                {
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_HOBYY_NAME,write_program.getText().toString());
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_STD_ID,String.valueOf(id));
                }

                if(read_blog.isChecked()){
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_HOBYY_NAME,read_blog.getText().toString());
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_STD_ID,String.valueOf(id));
                }

                if(listening_music.isChecked()){
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_HOBYY_NAME,listening_music.getText().toString());
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_STD_ID,String.valueOf(id));
                }

                if(learn_programming.isChecked()){

                    values2.put(StudentRegistrationFormDatabase.COLLUMN_HOBYY_NAME,learn_programming.getText().toString());
                    values2.put(StudentRegistrationFormDatabase.COLLUMN_STD_ID,String.valueOf(id));
                }

                db.insert(StudentRegistrationFormDatabase.TABLE_STD_HOBBY,null,values2);

                db.close();
                Toast.makeText(getApplicationContext(),"Registration Successfull...",Toast.LENGTH_SHORT).show();
            }


}
