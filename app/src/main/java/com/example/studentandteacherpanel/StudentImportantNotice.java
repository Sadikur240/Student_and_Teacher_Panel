package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class StudentImportantNotice extends AppCompatActivity {
    private TextView textView;
    TeacherDataBaseHelper teacherDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_important_notice);
        textView=findViewById(R.id.studentImportantNoticeTextView);
        teacherDataBaseHelper=new TeacherDataBaseHelper(this);
        view();
    }
    public void view(){
        Cursor cursor=teacherDataBaseHelper.getData();
        if(cursor.getCount()==0){
            textView.setText("Teacher have not published any notice yet.");
        }

        else{
            while(cursor.moveToNext()){
                String s=cursor.getString(1);
                if(s==""){
                    textView.setText("Teacher have not published any notice yet.");
                }
                else {textView.setText(s);}
            }
        }
    }
}