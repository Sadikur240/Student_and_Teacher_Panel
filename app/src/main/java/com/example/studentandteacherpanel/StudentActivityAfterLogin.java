package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StudentActivityAfterLogin extends AppCompatActivity implements View.OnClickListener {
    private Button profile, importantNotice, classTimeAndLink, manageBlood;
    private int id;
    AddAStudentInformation aStudentInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_after_login);
        importantNotice=findViewById(R.id.sPublishNotice);
        classTimeAndLink=findViewById(R.id.sClassLink);
        profile=findViewById(R.id.sProfile);
        manageBlood=findViewById(R.id.sManageBlood);

        Bundle b=getIntent().getExtras();
        id=Integer.parseInt(b.getString("loginId"));
        aStudentInformation=new AddAStudentInformation();

        importantNotice.setOnClickListener(this);
        classTimeAndLink.setOnClickListener(this);
        profile.setOnClickListener(this);
        manageBlood.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

       if(view.getId()==R.id.sPublishNotice){
           Intent intent=new Intent(this,StudentImportantNotice.class);
           startActivity(intent);
       }
        if(view.getId()==R.id.sProfile){
            Intent in=new Intent(this,StudentProfile.class);
            in.putExtra("studentId",id+"");
            startActivity(in);
        }
        if(view.getId()==R.id.sClassLink){
            Intent intent1=new Intent(this,StudentClassTimeAndLink.class);
            startActivity(intent1);
        }
        if(view.getId()==R.id.sManageBlood){
            Intent intent4=new Intent(this,ManageBlood.class);
            startActivity(intent4);
        }
    }
}