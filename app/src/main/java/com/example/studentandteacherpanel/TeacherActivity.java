package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TeacherActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addAStudent, updateResult, importantNotice, classTimeAndLink, manageBlood, viewAllStudent, removeAStudent;
    private StudentDataBaseHelper sDataBase;
    private TeacherDataBaseHelper tDataBase;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        addAStudent=findViewById(R.id.tAddAStudent);
        updateResult=findViewById(R.id.tUpdateResult);
        importantNotice=findViewById(R.id.tPublishNotice);
        classTimeAndLink=findViewById(R.id.tUpdateClassLink);
        manageBlood=findViewById(R.id.tManageBlood);

        viewAllStudent=findViewById(R.id.tViewAllStudent);
        removeAStudent=findViewById(R.id.tRemoveAStudent);

        importantNotice.setOnClickListener(this);
        classTimeAndLink.setOnClickListener(this);
        updateResult.setOnClickListener(this);
        manageBlood.setOnClickListener(this);
        viewAllStudent.setOnClickListener(this);
        addAStudent.setOnClickListener(this);
        removeAStudent.setOnClickListener(this);
        sDataBase=new StudentDataBaseHelper(this);
        tDataBase=new TeacherDataBaseHelper(this);
        sqLiteDatabase=sDataBase.getReadableDatabase();
        sqLiteDatabase=tDataBase.getReadableDatabase();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tPublishNotice:
//                Toast.makeText(this, "Publishing Notice", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,TeacherPublishingNotice.class);
                startActivity(intent);
                break;
            case R.id.tUpdateClassLink:
//                Toast.makeText(this, "Updating class time and link", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(this,TeacherClassTimeAndLink.class);
                startActivity(intent1);
                break;
            case R.id.tUpdateResult:
                Intent intent2=new Intent(this,TeacherUpdatingResult.class);
                startActivity(intent2);
//                Toast.makeText(this, "Updating Result", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tManageBlood:
                Intent intent4=new Intent(this,ManageBlood.class);
                startActivity(intent4);
//                Toast.makeText(this, "Manage blood", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tViewAllStudent:
                Intent intent5=new Intent(this,TeacherViewAllStudent.class);
                startActivity(intent5);
//                Toast.makeText(this, "View all student", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tAddAStudent:
                Intent intentx=new Intent(this,AddAStudent.class);
                startActivity(intentx);
                break;
            case R.id.tRemoveAStudent:
//                Toast.makeText(this, "Remove a student", Toast.LENGTH_SHORT).show();
                Intent intenty=new Intent(this,TeacherRemovingStudent.class);
                startActivity(intenty);
                break;

        }
    }
}