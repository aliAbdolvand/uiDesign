package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        EditText editText=findViewById(R.id.edit_text_profile);
        String texValue=getIntent().getStringExtra(MainActivity.Extra_Key_FullName);
        editText.setText(texValue);
        Button button=findViewById(R.id.btn_edit_change);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(MainActivity.Extra_Key_FullName,fullname);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}