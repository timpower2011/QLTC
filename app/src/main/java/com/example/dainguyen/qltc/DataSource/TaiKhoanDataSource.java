package com.example.dainguyen.qltc.DataSource;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dainguyen.qltc.Class.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDataSource extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "AccountManager";


    private static final String TABLE_TAIKHOAN = "taikhoan";

    private static final String KEY_ID = "id";
    private static final String KEY_TENTK = "TENTK";
    private static final String KEY_LOAITK = "LOAITK";
    private static final String KEY_SOTIEN = "SOTIENTK";
    private static final String KEY_GHICHU = "GHICHUTK";
    public TaiKhoanDataSource(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TAIKHOAN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TENTK + " TEXT,"
                + KEY_LOAITK + " TEXT," + KEY_SOTIEN + " TEXT," + KEY_GHICHU + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TAIKHOAN);

        // Create tables again
        onCreate(db);
    }

    public void addTaiKhoan(TaiKhoan contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TENTK, contact.getTentaikhoan()); // Contact Name
        values.put(KEY_LOAITK, contact.getLoaitaikhoan()); // Contact Phone
        values.put(KEY_SOTIEN, contact.getSotien());
        values.put(KEY_GHICHU, contact.getGhichu());
        // Inserting Row
        db.insert(TABLE_TAIKHOAN, null, values);
        db.close(); // Closing database connection
    }

    public TaiKhoan getTaiKhoan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TAIKHOAN, new String[]{KEY_ID,
                        KEY_TENTK, KEY_LOAITK, KEY_SOTIEN, KEY_GHICHU}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        TaiKhoan contact = new TaiKhoan(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        // return contact
        return contact;
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        List<TaiKhoan> contactList = new ArrayList<TaiKhoan>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TAIKHOAN ;
        //String selectQuery = "SELECT  * FROM " + TABLE_TAIKHOAN +" WHERE "+ KEY_ID + " = 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                TaiKhoan contact = new TaiKhoan();
                contact.setIdtaikhoan(Integer.parseInt(cursor.getString(0)));
                contact.setTentaikhoan(cursor.getString(1));
                contact.setLoaitaikhoan(cursor.getString(2));
                contact.setSotien(cursor.getString(3));
                contact.setGhichu(cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public int updateTaiKhoan(TaiKhoan contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TENTK, contact.getTentaikhoan());
        values.put(KEY_LOAITK, contact.getLoaitaikhoan());
        values.put(KEY_SOTIEN, contact.getSotien());
        values.put(KEY_GHICHU, contact.getGhichu());
        // updating row
        return db.update(TABLE_TAIKHOAN, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getIdtaikhoan())});
    }
    public int updateSoTienTaiKhoan(TaiKhoan contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
     values.put(KEY_SOTIEN, contact.getSotien());

        return db.update(TABLE_TAIKHOAN, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getIdtaikhoan())});
    }

    // Deleting single contact
    public void deleteTaiKhoan(TaiKhoan contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TAIKHOAN, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getIdtaikhoan())});
        db.close();
    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TAIKHOAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }


}