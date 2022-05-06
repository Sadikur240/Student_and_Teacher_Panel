package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class TeacherViewAllStudent extends AppCompatActivity {
    private TextView textView;
    StudentDataBaseHelper studentDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view_all_student);
        textView=findViewById(R.id.teacherViewAllStudentTextview);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        Cursor cursor=studentDataBaseHelper.getData();
        if(cursor.getCount()==0){
            textView.setText("No student yet !");
        }
        else{
            StringBuffer stringBuffer=new StringBuffer();
            while (cursor.moveToNext()){
                stringBuffer.append("\nID : "+cursor.getString(0));
                stringBuffer.append("\nName : "+cursor.getString(1));
                stringBuffer.append("\nContact : "+cursor.getString(2)+"\n\n");
            }
            textView.setText(stringBuffer);
        }

    }
}