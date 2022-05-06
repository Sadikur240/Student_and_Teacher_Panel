package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StudentClassTimeAndLink extends AppCompatActivity implements View.OnClickListener {
    private TextView classTime;
    private Button classLink;
    private TeacherDataBaseHelper teacherDataBaseHelper;
    private Cursor cursor;
   private  String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_class_time_and_link);
        classTime=findViewById(R.id.studentClassTimeAndLinkClassTime);
        classLink=findViewById(R.id.studentClassTimeAndLinkClassLink);
        teacherDataBaseHelper=new TeacherDataBaseHelper(this);
        time();
    classLink.setOnClickListener(this);

    }
public void time(){
    cursor=teacherDataBaseHelper.getData();
    if(cursor.getCount()==0){
        classTime.setText("No class time has been given yet.");
    }
    else{
        while(cursor.moveToNext()){
            classTime.setText(cursor.getString(2));
        }
    }
}

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.studentClassTimeAndLinkClassLink){
            cursor=teacherDataBaseHelper.getData();
            if(cursor.getCount()==0){
                Toast.makeText(this, "No link has been given yet.", Toast.LENGTH_SHORT).show();
            }
            else{
                while(cursor.moveToNext()){
                    s=cursor.getString(3);
                }
                Uri uri=Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        }
    }
}