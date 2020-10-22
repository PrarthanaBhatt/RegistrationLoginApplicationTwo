package com.example.registrationlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextLoginId,editTextLoginPassword;
    Button buttonLogin;

    String stringRegisterEmail,stringRegisterPassword,stringLoginEmail,stringLoginPassword;
    String string_login_UserName,string_login_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init() {
        editTextLoginId = findViewById(R.id.editTextLoginId);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                getBundleData();

                stringLoginEmail = editTextLoginId.getText().toString();
                stringLoginPassword = editTextLoginPassword.getText().toString();

                getValidationLogin();

            }

            private void getBundleData() {
                Bundle bundleLoginObject = getIntent().getExtras();

                stringRegisterEmail = bundleLoginObject.getString("registerEmail");
                stringRegisterPassword = bundleLoginObject.getString("registerPassword");

            }
            private void getValidationLogin() {
                if(stringLoginEmail.isEmpty())
                {
                    editTextLoginId.setError("Please enter Login email...");
                    Toast.makeText(getApplicationContext(),"Please enter Login email...",Toast.LENGTH_LONG).show();
                }else if(stringLoginPassword.isEmpty())
                {
                    editTextLoginPassword.setError("Please enter Login password...");
                    Toast.makeText(getApplicationContext(),"Please enter Login password...",Toast.LENGTH_LONG).show();
                }else
                {
                    if(stringLoginEmail.equals(stringRegisterEmail))
                    {
                        if (stringLoginPassword.equals(stringRegisterPassword))
                        {
                            Toast.makeText(getApplicationContext(),"Login Successful...",Toast.LENGTH_LONG).show();
//                            Intent intentObj = new Intent(LoginActivity.this,StudentInformation.class);
//
//                            startActivity(intentObj);

                            Intent intent = new Intent(LoginActivity.this,StudentInformation.class);



                            Bundle bundleObject = new Bundle();
                            bundleObject.putString("registerEmail",stringLoginEmail);
                            bundleObject.putString("registerPassword",stringLoginPassword);
                            intent.putExtras(bundleObject);

                            startActivity(intent);

                            finish();
                        }else
                        {
                            editTextLoginId.setError("Password Incorrect...");
                        }
                    }else
                    {
                        editTextLoginId.setError("Email Incorrect...");
                    }
                }
            }
        });
    }
}