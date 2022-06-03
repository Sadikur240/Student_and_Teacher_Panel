package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TeacherUpdatingResult extends AppCompatActivity implements View.OnClickListener {
    private TextView resultText;
    private EditText studentId, newResult;
    private Button update;
    private List<ModerOfUpdatingResult> studentList;
    private AdapterOfUpdatingResult adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    Cursor cursor;
    int flag=-1;
    StudentDataBaseHelper studentDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teacher_updating_result);
        studentId=findViewById(R.id.tUpdatingResultStudentId);
        newResult=findViewById(R.id.tUpdatingResultNewResult);
        update=findViewById(R.id.tUpdatingResultButton);
        studentDataBaseHelper=new StudentDataBaseHelper(this);
        result();

        update.setOnClickListener(this);

    }

    private void recyclerViewUpdate() {
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new AdapterOfUpdatingResult(studentList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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
        studentList=new ArrayList<>();
        while(cursor.moveToNext()){
            if(Double.parseDouble(cursor.getString(8))==-1){
                studentList.add(new ModerOfUpdatingResult(cursor.getString(0)+"","---"));
            }
                else{
                studentList.add(new ModerOfUpdatingResult(cursor.getString(0)+"",cursor.getString(8)+""));
                }
        }
        recyclerViewUpdate();
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