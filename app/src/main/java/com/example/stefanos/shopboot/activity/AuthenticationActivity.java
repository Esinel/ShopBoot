package com.example.stefanos.shopboot.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.stefanos.shopboot.R;

public class AuthenticationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
    }

    public void unlockList(){
        String shoppingListPassword = getIntent().getStringExtra("password");
        String userPassword = ((TextView) findViewById(R.id.password)).getText().toString();
        if (shoppingListPassword.equals(userPassword)){
            Intent returnIntent = new Intent();
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }else{
            ((TextView) findViewById(R.id.password)).setError("Password incorrect!");
        }

    }
}
