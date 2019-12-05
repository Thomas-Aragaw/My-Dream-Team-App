package com.guuzotech.favoriteplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Button mButtonLogin;
     EditText mTextUsername, mTextPassword;
     TextView mTextvViewRegister;
     PlayerDatabaseHelper db;
     SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new PlayerDatabaseHelper(this);
        sqlDB = db.getReadableDatabase();

        mTextUsername =(EditText) findViewById(R.id.edittext_username);
        mTextPassword =(EditText) findViewById(R.id.edittext_password);
        mButtonLogin= (Button) findViewById(R.id.login_btn);
        mTextvViewRegister= (TextView) findViewById(R.id.textview_register);

        mTextvViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerintent);

            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String user =mTextUsername.getText().toString().trim();
                String pwd =mTextPassword.getText().toString().trim();

                  Boolean res =db.checkUser(user,pwd);



                  if (res == true){
                      User.setUName(user);
                      Intent homeintent = new Intent(MainActivity.this, TopLevelActivity.class);
                      startActivity(homeintent);
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_SHORT);

                  }
            }
        });

        sqlDB.close();

    }
}

