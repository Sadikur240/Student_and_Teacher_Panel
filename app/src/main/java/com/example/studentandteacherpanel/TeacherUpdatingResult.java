package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TeacherUpdatingResult extends AppCompatActivity implements View.OnClickListener {
    private TextView resultText;
    private EditText studentId, newResult;
    private Button update;
    Cursor cursor;
    int flag=-1;
    StudentDataBaseHelper studentDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teacher_updating_result);
        resultText=findViewById(R.id.tUpdatingResultText);
        studentId=findViewById(R.id.tUpdatingResultStudentId);
        newResult=findViewById(R.id.tUpdatingResultNewResult);
        update=findViewById(R.id.tUpdatingResultButton);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        result();
        update.setOnClickListener(this);

    }
public void result(){
        cursor=studentDataBaseHelper.getData();
    if(cursor.getCount()==0){
        resultText.setText("No student yet.");
        studentId.setEnabled(false);
        newResult.setEnabled(false);
        update.setEnabled(false);
    }
    else{
        String sx="                                      ";
        String sx1="                             ";
        String string="     "+"ID"+sx+"RESULT"+"\n";
        StringBuffer stringBuffer=new StringBuffer();

        while(cursor.moveToNext()){
            String x="  ---";
            if(Double.parseDouble(cursor.getString(8))==-1){
                stringBuffer.append(cursor.getString(0)+sx1+x+"\n");
            }
                else{stringBuffer.append(cursor.getString(0)+sx1+cursor.getString(8)+"\n");}
        }
        string=string+stringBuffer;
        resultText.setText(string);

    }
}
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tUpdatingResultButton){

            if(TextUtils.isEmpty(studentId.getText().toString()) || TextUtils.isEmpty(newResult.getText().toString())){
                Toast.makeText(this, "You can't leave blank", Toast.LENGTH_SHORT).show();
            }
            else {
                cursor=studentDataBaseHelper.getData();

                int id = Integer.parseInt(studentId.getText().toString());
                double res = Double.parseDouble(newResult.getText().toString());

                while (cursor.moveToNext()){
                    if((studentId.getText().toString() ).equals(cursor.getString(0))){
                        flag=0;
                    }
                }
               boolean y= studentDataBaseHelper.updateResult(id,res);
                System.out.println(flag);
               if(flag==-1){
                   Toast.makeText(this, "Wrong id", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
                   flag=-1;
               }
                result();
            }

        }
    }
}