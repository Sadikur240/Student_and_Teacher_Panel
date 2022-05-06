package com.example.studentandteacherpanel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDataBaseHelper extends SQLiteOpenHelper {
    private final static String studentDatabase="studentDatabase.db";
    public StudentDataBaseHelper(@Nullable Context context) {
        super(context, studentDatabase, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sq="create table studentDataTable (id integer primary key,name text,contactNumber text,bloodGroup text,uniMail text,password text,commentFromTeacher text,commentToTeacher text,result double)";
        sqLiteDatabase.execSQL(sq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insert(AddAStudentInformation o){
        
        SQLiteDatabase sq = this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",o.getId());
        contentValues.put("name",o.getName());
        contentValues.put("contactNumber",o.getContactNumber());
        contentValues.put("bloodGroup",o.getBloodGroup());
        contentValues.put("uniMail",o.getUniMail());
        contentValues.put("password",o.getPassword());
        contentValues.put("commentFromTeacher",o.getCommentFromTeacher());
        contentValues.put("commentToTeacher",o.getCommentToTeacher());
        contentValues.put("result",o.getResult());
        long r=sq.insert("studentDataTable",null,contentValues);
        if(r==-1){
            return false;
        }
        else return true;
    }

    public boolean updatePassword(int id,String password){
        SQLiteDatabase sq=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("password",password);
        Cursor cursor= sq.rawQuery("select * from studentDataTable where id =?",new String[]{id+""});
        long r=sq.update("studentDataTable",contentValues,"id =?",new String[]{id+""});
            if(r==-1){
                return false;
            }
            else return true;

    }

    public Cursor getProfile(int id){
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("select * from studentDataTable where id=?",new String[]{id+""});
        return c;
    }
    public boolean updateResult(int id, double result){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("result",result);
        sqLiteDatabase.rawQuery("select * from studentDataTable where id =?",new String[]{id+""});
        long r=sqLiteDatabase.update("studentDataTable",contentValues,"id =?",new String[]{id+""});
        if(r==-1){
            return false;
        }
        else return true;
    }
    public Cursor getData(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from studentDataTable",null);
        return cursor;
    }
    public boolean removeAStudent(int id){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        sqLiteDatabase.rawQuery("select * from studentDataTable where id =?",new String[]{id+""});
        long r=sqLiteDatabase.delete("studentDataTable","id =?",new String[]{id+""});
        if (r == -1) {
            return false;
        }
        else {return true;}
    }
}
