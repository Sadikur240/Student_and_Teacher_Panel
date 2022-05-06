package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherPublishingNotice extends AppCompatActivity implements View.OnClickListener {
        private Button publishNoticeButton;
        private EditText publishNoticeEditText;
        TeacherDataBaseHelper teacherDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_publishing_notice);
        publishNoticeButton=findViewById(R.id.tButtonUpdatePublishNotice);
        publishNoticeEditText=findViewById(R.id.tPublishNoticeEditText);

        teacherDataBaseHelper=new TeacherDataBaseHelper(this);
        Cursor c=teacherDataBaseHelper.getData();
        while (c.moveToNext()){
            if(c.getString(1)!=""){
                publishNoticeEditText.setText(c.getString(1));
            }
        }
        publishNoticeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.tButtonUpdatePublishNotice){

           if(TextUtils.isEmpty(publishNoticeEditText.getText().toString())){
               Toast.makeText(this, "You can't leave blank !", Toast.LENGTH_SHORT).show();}
           else {
               String s = publishNoticeEditText.getText().toString();
               Cursor cursor = teacherDataBaseHelper.getData();

               if (cursor.getCount() == 0) {
                   System.out.println("getCount = 0 ");
                   teacherDataBaseHelper.insert(s + "", "", "");
               } else {
                   boolean y = teacherDataBaseHelper.updatePublishNotice(1, s + "");
                   if (y) {
                       Toast.makeText(this, "Updated !", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(this, "Update failed !", Toast.LENGTH_SHORT).show();
                   }
               }
           }
        }
    }
}