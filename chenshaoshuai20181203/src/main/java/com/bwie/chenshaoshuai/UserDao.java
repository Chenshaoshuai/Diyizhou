package com.bwie.chenshaoshuai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDao  {
 private SqlHelper sqlHelper;
 private SQLiteDatabase database;

 public UserDao(Context context){
     sqlHelper = new SqlHelper(context);
     database = sqlHelper.getReadableDatabase();
 }
 public void add(String _id,String num){
     ContentValues values = new ContentValues();
     values.put("num",num);
     values.put("_id",_id);
     database.insert("users",null,values);
 }
 public void delAll(){
     database.delete("users",null,null);
 }
 public void del(String _id){
      database.delete("users","_id = ? ",new String[]{_id});
 }
 public List<UserBean> select(){
     ArrayList<UserBean> list = new ArrayList<>();
     Cursor cursor = database.query("users",null,null,null,null,null,null);
     while (cursor.moveToNext()){
         String num = cursor.getString(cursor.getColumnIndex("num"));
         String _id = cursor.getString(cursor.getColumnIndex("_id"));
         UserBean userBean = new UserBean(num,_id);
         list.add(userBean);
     }
     return list;
 }

}
