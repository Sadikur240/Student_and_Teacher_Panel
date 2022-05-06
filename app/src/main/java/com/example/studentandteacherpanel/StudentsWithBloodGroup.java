package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class StudentsWithBloodGroup extends AppCompatActivity {
    private TextView textView;
    StudentDataBaseHelper studentDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_with_blood_group);
        Bundle b=getIntent().getExtras();
        String s=b.getString("bg");
        textView=findViewById(R.id.studentsWithBloodGroupTextview);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        Cursor cursor=studentDataBaseHelper.getData();
        if (cursor.getCount()==0){
            textView.setText("No student is added yet !");
        }
        else{
            StringBuffer stringBuffer=new StringBuffer();
            int flag=-1;
            while (cursor.moveToNext()){
                if(cursor.getString(3).equals(s)){
                    flag=0;
                    stringBuffer.append("\nID : "+cursor.getString(0));
                    stringBuffer.append("\nName : "+cursor.getString(1));
                    stringBuffer.append("\nContact : "+cursor.getString(2)+"\n");
                }
            }
            if(flag==-1){
                textView.setText("Sorry, there is no student with "+s);
            }
            else {textView.setText(stringBuffer);}
        }
    }
}