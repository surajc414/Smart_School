package com.trihutt.smartschool;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class UserProfileSetting extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_setting);

        intent = getIntent();
        String id =intent.getStringExtra("StudentId");
        String dayname = intent.getStringExtra("DayName");
        getSupportActionBar().setTitle(dayname);
        Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();

    }
}
