package com.example.registrationlogin;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.util.Patterns;

import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.Techniques;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    EditText editTextName,editTextRegistrationEmail,editTextRegistrationPassword;
    RadioButton radioButtonMale,radioButtonFemale,radioButtonOther;
    CheckBox checkBoxJava,checkBoxAndroid,checkBoxWeb;
    Button buttonRegister;
    String stringRegisterEmail,stringRegisterPassword;
    String stringUserName,stringGenderMale,stringGenderFemale,stringGenderOther,stringCheckBoxJava,stringCheckBoxAndroid,stringCheckBoxWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //read all variables
        editTextName = findViewById(R.id.editTextName);
        editTextRegistrationEmail = findViewById(R.id.editTextEmailId);
        editTextRegistrationPassword = findViewById(R.id.editTextPassword);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonOther = findViewById(R.id.radioButtonOther);
        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxAndroid = findViewById(R.id.checkBoxAndroid);
        checkBoxWeb = findViewById(R.id.checkBoxWeb);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stringRegisterEmail = editTextRegistrationEmail.getText().toString();
                stringRegisterPassword = editTextRegistrationPassword.getText().toString();

                if(!validateUserName() | !validateEmail() | !validatePassword()){
                    Toast.makeText(getApplicationContext(),"Please check entered details...",Toast.LENGTH_LONG).show();
                }else{
                    getLogin();
                }

            }
            private boolean validateUserName(){
                stringUserName = editTextName.getText().toString().trim();

                if(stringUserName.isEmpty()){


                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.editTextName));
                    editTextName.setError("Field can't be empty");
                    return false;
                }else if(stringUserName.length() > 15){
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.editTextName));
                    editTextName.setError("UserName too long");
                    return false;
                } else {
                    editTextName.setError(null);
                    return true;
                }

            }

            private boolean validateEmail(){
                stringRegisterEmail = editTextRegistrationEmail.getText().toString().trim();

                if(stringRegisterEmail.isEmpty()){

                    YoYo.YoYoString yoYoString = YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.editTextEmailId));
                    editTextRegistrationEmail.setError("Field can't be empty");
                    return false;
                }else if(!Patterns.EMAIL_ADDRESS.matcher(stringRegisterEmail).matches()){
                    YoYo.YoYoString yoYoString = YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.editTextEmailId));
                    editTextRegistrationEmail.setError("Please enter a valid email address");
                    return false;
                } else {
                    editTextRegistrationEmail.setError(null);
                    return true;
                }
            }

            private boolean validatePassword(){
                stringRegisterPassword = editTextRegistrationPassword.getText().toString().trim();
                if(stringRegisterPassword.isEmpty()){
                    YoYo.YoYoString yoYoString = YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.editTextPassword));
                    editTextRegistrationPassword.setError("Field can't be empty!");
                    return false;
                }
                else if (!PASSWORD_PATTERN.matcher(stringRegisterPassword).matches()){
                   YoYo.YoYoString yoYoString = YoYo.with(Techniques.Tada)
                           .duration(700)
                          .repeat(5)
                            .playOn(findViewById(R.id.editTextPassword));
                   editTextRegistrationPassword.setError("Password too weak..");
                    return false;
               }


                else{
                    editTextRegistrationPassword.setError(null);
                    return true;
                }
            }



            private void getLogin() {
                Intent intentObj = new Intent(MainActivity.this,LoginActivity.class);

                Bundle bundleObject = new Bundle();
                bundleObject.putString("registerEmail",stringRegisterEmail);
                bundleObject.putString("registerPassword",stringRegisterPassword);
                intentObj.putExtras(bundleObject);

                startActivity(intentObj);

            }
        });
    }
}






















//            private void getNameValidate() {
//                if(stringName.isEmpty()){
//                    editTextName.setError("Name can't be empty!");
//                }
//                else if(stringName.length() < 2){
//                    editTextName.setError("Name can't be single letter!");
//                }else{
//                    getRegisterEmailValidate();
//                }
//
//            }

//            private void getRegisterEmailValidate() {
//                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//
//                if(stringRegisterEmail.isEmpty()){
//                    editTextRegistrationEmail.setError("Email can't be empty!");
//                }else if (!(stringRegisterEmail.matches(emailPattern))) {
//                    Toast.makeText(getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
//                    getRegistrationPasswordValidate();
//                }
//            }
//
//            private void getRegistrationPasswordValidate() {
//                String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.* [@#$%^&+=!])(?=\\S+$).{4,}$";
//
//                if(stringRegisterPassword.isEmpty()){
//                    editTextRegistrationPassword.setError("Password cam't be empty!");
//                }else if (!(stringRegisterPassword.matches(PASSWORD_PATTERN))){
//                    Toast.makeText(getApplicationContext(), "Valid password", Toast.LENGTH_SHORT).show();
//                    getGender();
//                }
//            }
//
//            private void getGender() {
//
//                if(radioButtonMale.isChecked()){
//                    stringGenderMale = radioButtonMale.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Male", Toast.LENGTH_SHORT).show();
//                    getCourse();
//                }else if(radioButtonFemale.isChecked()){
//                    stringGenderFemale = radioButtonFemale.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Female", Toast.LENGTH_SHORT).show();
//                    getCourse();
//                }else{
//                    stringGenderOther = radioButtonOther.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Other", Toast.LENGTH_SHORT).show();
//                    getCourse();
//                }
//
//            }
//
//            private void getCourse() {
//
//                if(checkBoxJava.isChecked()){
//                    stringCheckBoxJava = checkBoxJava.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Java", Toast.LENGTH_SHORT).show();
//                    getLogin();
//
//                }else if(checkBoxAndroid.isChecked()){
//                    stringCheckBoxAndroid = checkBoxAndroid.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_SHORT).show();
//                    getLogin();
//                }else{
//                    stringCheckBoxWeb = checkBoxWeb.getText().toString();
//                    Toast.makeText(getApplicationContext(), "Web", Toast.LENGTH_SHORT).show();
//                    getLogin();
//                }
//            }
