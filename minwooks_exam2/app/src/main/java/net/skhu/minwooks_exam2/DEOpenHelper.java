package net.skhu.minwooks_exam2;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

/**
 * Created by jaery on 2018-05-04.
 */

class DEOpenHelper {

    private static final String DATABASE_NAME = "Log.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;


    private class DatabaseHelper extends SQLiteOpenHelper {

        // 생성자
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateDB._CREATE);

        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+CreateDB._TABLENAME);
            onCreate(db);
        }


    }

    public DEOpenHelper(Context context){
        this.mCtx = context;
    }

    public int getCount(){
        Cursor cursor= mDB.rawQuery("select * from Log",null);
        return cursor.getCount();
    }
    /*public byte[] findBitmap(int position) {
        Cursor cursor = mDB.rawQuery("select * from Log where num=" + "'" + position + "'", null);

        if(cursor.moveToFirst()) {
            do {
                return cursor.getBlob(1);
            } while (cursor.moveToNext());
        }
        return null;
    }
*/

    public String findcontent(int position)
    {
        Cursor cursor= mDB.rawQuery("select * from Log where num="+"'"+position+"'",null);

        if(cursor.moveToFirst()) {
            do {
                return cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return null;

    }

    public void insert( String content)
    {
/*
        SQLiteStatement p= mDB.compileStatement("INSERT INTO Log(num,img,content) values (?,?,?)");

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] data=stream.toByteArray();

        p.bindString(1,""+getCount());
        p.bindBlob(2,data);
        p.bindString(3,content);

        p.execute();
       */
        mDB.execSQL("INSERT INTO Log " + "VALUES ("+"'"+ getCount()+"','"+content+"');");

    }



    public DEOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        mDB.close();
    }

    public void clear(){
        mDB.execSQL("delete from "+CreateDB._TABLENAME);
    }

}
