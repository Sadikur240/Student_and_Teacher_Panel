package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {
   private EditText studentId,studentPassword;
   private Button studentEnter;
   private TextView studentChangePass;
   StudentDataBaseHelper studentDataBaseHelper;
   SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    studentId=findViewById(R.id.sEnterId);
    studentPassword=findViewById(R.id.sEnterPassword);
    studentChangePass=findViewById(R.id.sChangePass);
    studentEnter=findViewById(R.id.sLogin);
    studentDataBaseHelper=new StudentDataBaseHelper(this);
    sqLiteDatabase=studentDataBaseHelper.getReadableDatabase();
    studentEnter.setOnClickListener(this);
    studentChangePass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.sLogin){

           if(TextUtils.isEmpty(studentId.getText().toString()) || TextUtils.isEmpty(studentPassword.getText().toString()) ){
               Toast.makeText(this, "You can't leave blank", Toast.LENGTH_SHORT).show();
           }
           else{
            int flag=-1;
                Cursor cursor=studentDataBaseHelper.getData();
                if(cursor.getCount()==0){
                    Toast.makeText(this, "You are not added yet", Toast.LENGTH_SHORT).show();
                }
                else {
                    while (cursor.moveToNext()) {
                        if (Integer.parseInt(cursor.getString(0)) == Integer.parseInt(studentId.getText().toString())) {
                            flag = 0;
                            if (cursor.getString(5).equals(studentPassword.getText().toString())) {
                                Toast.makeText(this, "Successfully logged in...", Toast.LENGTH_LONG).show();

                                Intent i=new Intent(this,StudentActivityAfterLogin.class);
                                i.putExtra("loginId",cursor.getString(0));
                                startActivity(i);
                            } else {
                                Toast.makeText(this, "Wrong Password ! ", Toast.LENGTH_SHORT).show();
                                studentPassword.setText("");
                            }
                        }


                    }
                    if (flag == -1) {
                        Toast.makeText(this, "You are not added yet", Toast.LENGTH_SHORT).show();
                        studentId.setText("");
                        studentPassword.setText("");
                    }

                }
                }
        }

        if(view.getId()==R.id.sChangePass){
            Intent in=new Intent(this,StudentChangingPassword.class);
            startActivity(in);

        }
    }
}