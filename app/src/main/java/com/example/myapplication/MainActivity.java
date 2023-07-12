package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintsChangedListener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String Extra_Key_FullName="fullname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveBtn=findViewById(R.id.btn_save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"click on save information",Toast.LENGTH_SHORT).show();
            }
        });
        RadioGroup radioGroup=findViewById(R.id.radioGroup_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonAlborz:
                        Toast.makeText(MainActivity.this,"alborz is checkd",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonTehran:
                        Toast.makeText(MainActivity.this,"tehran is checkd",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonGilan:
                        Toast.makeText(MainActivity.this,"gilan is checkd",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        Button editProfile=findViewById(R.id.btn_main_editProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EditProfile.class);
                TextView textView2=findViewById(R.id.textView);
                intent.putExtra(Extra_Key_FullName,textView2.getText().toString());
                startActivityForResult(intent,37);
            }
        });
    Button website=findViewById(R.id.button4);
    website.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(intent);
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 37 && resultCode == Activity.RESULT_OK && data != null) {
            String fullname = data.getStringExtra(Extra_Key_FullName);
            TextView textView = findViewById(R.id.textView);
                textView.setText(fullname);
        }
    }
}
