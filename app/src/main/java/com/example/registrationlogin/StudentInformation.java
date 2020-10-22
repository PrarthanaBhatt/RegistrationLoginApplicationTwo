package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StudentInformation extends AppCompatActivity {

    String string_login_UserName_Show,string_login_Password_Show,received_value_id;
   // TextView getMsgLogin,getMsgLoginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

        Bundle bundleLoginObject = getIntent().getExtras();

        string_login_UserName_Show = bundleLoginObject.getString("LoginName");
        string_login_Password_Show = bundleLoginObject.getString("LoginPassword");


//        getMsgLogin.setText(string_login_UserName_Show);
//        getMsgLoginPassword.setText(string_login_Password_Show);

        Toast.makeText(getApplicationContext(),string_login_UserName_Show,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),string_login_Password_Show,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Login Successful...",Toast.LENGTH_LONG).show();

        finish();
    }
}