package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StudentProfile extends AppCompatActivity {
    private TextView profileName,profileId,profileResult,profileUnimail;
    StudentDataBaseHelper studentDataBaseHelper;
   private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        Bundle b=getIntent().getExtras();
        id=Integer.parseInt(b.getString("studentId"));
        profileName=findViewById(R.id.studentProfileName);
        profileId=findViewById(R.id.studentProfileId);
        profileResult=findViewById(R.id.studentProfileResult);
        profileUnimail=findViewById(R.id.studentProfileUnimail);
        profile();
    }
    public void profile(){

        Cursor cursor=studentDataBaseHelper.getData();
        while (cursor.moveToNext()){
            if(Integer.parseInt(cursor.getString(0))==id){
                System.out.println("Worked");

                profileName.setText(cursor.getString(1));
                profileId.setText(cursor.getString(0));
                if(Double.parseDouble(cursor.getString(8))==-1){
                    profileResult.setText("---");
                }
                else{
                    profileResult.setText(cursor.getString(8));
                }
                profileUnimail.setText(cursor.getString(4));
            }
        }
    }
}