package com.codepath.canidrink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    public EditText etAge;
    //public int age;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etAge = (EditText) findViewById(R.id.etAge);

        user = (User)getIntent().getSerializableExtra("user");

        String ageText = String.valueOf(user.age);
        etAge.setText(ageText);

    }

    public void onSubmit(View view) {

        String ageText = etAge.getText().toString();
        int age = Integer.parseInt(ageText);

        Intent intent = new Intent();
        user.age = age;

        intent.putExtra("user", user);
        intent.putExtra("age", age);

        setResult(RESULT_OK, intent);

        finish();
    }
}
