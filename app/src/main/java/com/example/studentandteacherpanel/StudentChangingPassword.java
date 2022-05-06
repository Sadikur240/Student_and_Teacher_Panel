package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentChangingPassword extends AppCompatActivity implements View.OnClickListener {
        private EditText changePassID,changePassCurrentPassword,changePassNewPassword;
        private Button confirm;
        StudentDataBaseHelper studentDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_changing_password);
        changePassID=findViewById(R.id.changePassId);
        changePassCurrentPassword=findViewById(R.id.changePassCurrentPassword);
        changePassNewPassword=findViewById(R.id.changePassNewPassword);
        confirm=findViewById(R.id.changePassConfirm);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.changePassConfirm){
            if(TextUtils.isEmpty(changePassID.getText().toString()) || TextUtils.isEmpty(changePassCurrentPassword.getText().toString()) || TextUtils.isEmpty(changePassNewPassword.getText().toString()) ){
                Toast.makeText(this, "You can't leave any field blank ", Toast.LENGTH_SHORT).show();
            }
            else{
                Cursor cursor=studentDataBaseHelper.getData();
                if(cursor.getCount()==0){
                    Toast.makeText(this, "Empty database", Toast.LENGTH_SHORT).show();
                }
                else{
                    int flag=-1;
                    while(cursor.moveToNext()){
                        if(changePassID.getText().toString().equals(cursor.getString(0))){
                            flag=0;
                            if(changePassCurrentPassword.getText().toString().equals(cursor.getString(5))){
                               boolean y= studentDataBaseHelper.updatePassword(Integer.parseInt(changePassID.getText().toString()),changePassNewPassword.getText().toString());

                                if(y){
                                    Toast.makeText(this, "Password Updated !", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(this, "Didn't update", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else{
                                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                changePassCurrentPassword.setText("");
                            }
                        }
                        System.out.println("\n\n"+cursor.getString(0));

                    }
                    if(flag==-1){
                        Toast.makeText(this, "Wrong ID", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }
}