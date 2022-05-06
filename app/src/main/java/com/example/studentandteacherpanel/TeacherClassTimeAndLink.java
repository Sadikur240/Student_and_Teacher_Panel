package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherClassTimeAndLink extends AppCompatActivity implements View.OnClickListener {
    private EditText classLink,classTime;
    private Button update;
    TeacherDataBaseHelper teacherDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class_time_and_link);
        classLink=findViewById(R.id.tClassTimeAndLinkClassLink);
        classTime=findViewById(R.id.tClassTimeAndLinkClassTime);
        update=findViewById(R.id.tClassTimeAndLinkUpdateButton);
        teacherDataBaseHelper=new TeacherDataBaseHelper(this);
        update.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tClassTimeAndLinkUpdateButton){
            if(TextUtils.isEmpty(classLink.getText().toString())  || TextUtils.isEmpty(classTime.getText().toString()) ){
                Toast.makeText(this, "You can't leave blank !", Toast.LENGTH_SHORT).show();
            }
            else{
                String cl=classLink.getText().toString();
                String ct=classTime.getText().toString();
                Cursor cursor=teacherDataBaseHelper.getData();
                if(cursor.getCount()==0){
                    System.out.println("count=0");
                    teacherDataBaseHelper.insert("",ct+"",cl+"");
                }
                else{
                    boolean y=teacherDataBaseHelper.updateClassTimeAndLink(1,cl+"",ct+"");
                    if(y){
                        Toast.makeText(this, "Updated !", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Update failed !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}