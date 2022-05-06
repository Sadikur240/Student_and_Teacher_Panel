package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherRemovingStudent extends AppCompatActivity implements View.OnClickListener {
        private EditText studentID;
        private Button remove;
        StudentDataBaseHelper studentDataBaseHelper;
        Cursor cursor;
        int flag=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_removing_student);
        studentID=findViewById(R.id.tRemovingStudentStudentId);
        remove=findViewById(R.id.tRemovingStudentRemoveButton);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        remove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tRemovingStudentRemoveButton){
            if(TextUtils.isEmpty(studentID.getText().toString())){
                Toast.makeText(this, "You can't leave blank", Toast.LENGTH_SHORT).show();
            }
            else{
                cursor=studentDataBaseHelper.getData();
                if(cursor.getCount()==0){
                    Toast.makeText(this, "No student is added yet", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean y = studentDataBaseHelper.removeAStudent(Integer.parseInt(studentID.getText().toString()));

                    if (y) {
                        Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "Wrong id", Toast.LENGTH_SHORT).show();
                        flag = -1;
                    }
                }



            }
        }
    }
}