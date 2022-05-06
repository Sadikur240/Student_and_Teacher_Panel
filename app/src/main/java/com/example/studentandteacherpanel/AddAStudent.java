package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAStudent extends AppCompatActivity implements View.OnClickListener {
   private EditText id,name,contactNumber,bloodGroup,uniMail,password;
   private Button enter;
    AddAStudentInformation studentInformation;
    StudentDataBaseHelper x;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_astudent);
        id=findViewById(R.id.addAStudentId);
        name=findViewById(R.id.addAStudentName);
        contactNumber=findViewById(R.id.addAStudentContactNumber);
        bloodGroup=findViewById(R.id.addAStudentBloodGroup);
        uniMail=findViewById(R.id.addAStudentUniMail);
        password=findViewById(R.id.addAStudentPassword);
        enter=findViewById(R.id.addAStudentEnter);
        x=new StudentDataBaseHelper(this);
        enter.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.addAStudentEnter){

            if(TextUtils.isEmpty(id.getText().toString()) || TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(contactNumber.getText().toString()) || TextUtils.isEmpty(bloodGroup.getText().toString()) || TextUtils.isEmpty(uniMail.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(this, "You can't leave blank !", Toast.LENGTH_SHORT).show();
            }
            else{

 studentInformation=new AddAStudentInformation(Integer.parseInt(id.getText().toString()),name.getText().toString(),contactNumber.getText().toString(),bloodGroup.getText().toString(),uniMail.getText().toString(),password.getText().toString(),"","",-1);
               System.out.println(studentInformation.toString());
            boolean y=x.insert(studentInformation);
            if(y){
                Toast.makeText(this, "Added Successfully !", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(this, "Failed to add !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}