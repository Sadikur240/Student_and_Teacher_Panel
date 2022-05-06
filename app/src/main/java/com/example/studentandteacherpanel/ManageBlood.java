package com.example.studentandteacherpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManageBlood extends AppCompatActivity implements View.OnClickListener {
    private Button aP,bP,oP,abP,aN,bN,oN,abN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_blood);


        aP=findViewById(R.id.aPositive);
        bP=findViewById(R.id.bPositive);
        oP=findViewById(R.id.oPositive);
        abP=findViewById(R.id.abPositive);
        aN=findViewById(R.id.aNegative);
        bN=findViewById(R.id.bNegative);
        oN=findViewById(R.id.oNegative);
        abN=findViewById(R.id.abNegative);


        aP.setOnClickListener(this);
        bP.setOnClickListener(this);
        oP.setOnClickListener(this);
        abP.setOnClickListener(this);
        aN.setOnClickListener(this);
        bN.setOnClickListener(this);
        oN.setOnClickListener(this);
        abN.setOnClickListener(this);
    }
    public void go(String s){
        Intent intent=new Intent(this,StudentsWithBloodGroup.class);
        intent.putExtra("bg",s+"");
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aPositive:
                go("a+");
                break;
            case R.id.bPositive:
                go("b+");
                break;
            case R.id.oPositive:

                go("o+");
                break;
            case R.id.abPositive:

                go("ab+");
                break;
            case R.id.aNegative:

                go("a-");
                break;
            case R.id.bNegative:

                go("b-");
                break;
            case R.id.oNegative:

                go("o-");
                break;
            case R.id.abNegative:

                go("ab-");
                break;

        }
    }
}