package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    private Button studentPanel,teacherPanel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        studentPanel=findViewById(R.id.studentPanel);
        teacherPanel=findViewById(R.id.teacherPanel);
        studentPanel.setOnClickListener(this);
        teacherPanel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.studentPanel){
             Intent intent=new Intent(this,StudentActivity.class);
            startActivity(intent);

        }

        if(view.getId()==R.id.teacherPanel){
            Intent intent=new Intent(this,TeacherActivity.class);
            startActivity(intent);
        }
    }
}