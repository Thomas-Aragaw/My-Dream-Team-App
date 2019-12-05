package com.guuzotech.favoriteplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    Button mButtonRegister;
    EditText mTextUsername, mTextPassword, mTextCnfPassword;
    TextView mTextvViewLogin;
    PlayerDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new PlayerDatabaseHelper(this);

        mTextUsername =(EditText) findViewById(R.id.edittext_username);
        mTextPassword =(EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword =(EditText) findViewById(R.id.edittext_cnf_password);
        mButtonRegister= (Button) findViewById(R.id.button_Register);
        mTextvViewLogin= (TextView) findViewById(R.id.textview_login);

        mTextvViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(registerintent);

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if (db.checkUserName(mTextUsername.getText().toString().trim())) {
                    Toast t = Toast.makeText(RegisterActivity.this, "This username already exists.", Toast.LENGTH_SHORT);
                    t.show();
                } else {

                    if (pwd.equals(cnf_pwd)) {
                        long val = db.addUser(user, pwd);
                        if (val > 0) {
                            Toast t = Toast.makeText(RegisterActivity.this, "you have registered", Toast.LENGTH_SHORT);
                            t.show();
                            Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(moveToLogin);
                        } else {
                            Toast t = Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT);
                            t.show();
                        }


                    } else {
                        Toast t = Toast.makeText(RegisterActivity.this, "you have registered", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            }
        });
    }
}
