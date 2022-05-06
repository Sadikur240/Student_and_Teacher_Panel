package com.example.studentandteacherpanel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

public class TeacherDataBaseHelper extends SQLiteOpenHelper {
    private static final String s="teacherDatabase.db";
    public TeacherDataBaseHelper(@Nullable Context context) {
        super(context, s, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s1="create table teacherTable (id integer primary key,importantNotice text, classTime text, classLink text)";
        sqLiteDatabase.execSQL(s1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insert(String importantNotice,String classTime,String classLink){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",1);
        cv.put("importantNotice",importantNotice);
        cv.put("classTime",classTime);
        cv.put("classLink",classLink);
        long r=sqLiteDatabase.insert("teacherTable",null,cv);
        if(r==-1){
            return false;
        }
        else return true;
    }
    public Cursor getData(){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from teacherTable",null);
        return cursor;
    }
    public boolean updatePublishNotice(int ID, String importantNotice){
        SQLiteDatabase sq=this.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("importantNotice",importantNotice);
       Cursor cursor= sq.rawQuery("select * from teacherTable where id =?",new String[]{ID+""});
        long r=sq.update("teacherTable",cv,"id =?",new String[]{ID+""});
        if(r==-1){
            return false;
        }
        else return true;
    }
    public boolean updateClassTimeAndLink(int id, String cl, String ct){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("classLink",cl);
        contentValues.put("classTime",ct);
        Cursor c=sqLiteDatabase.rawQuery("select * from teacherTable where id =?",new String[]{id+""});
        long r= sqLiteDatabase.update("teacherTable",contentValues,"id =?",new String[]{id+""});
        if(r==-1){
            return false;
        }
        else return true;
    }
}
