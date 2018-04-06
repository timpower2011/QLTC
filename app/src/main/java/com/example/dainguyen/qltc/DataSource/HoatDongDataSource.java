package com.example.dainguyen.qltc.DataSource;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dainguyen.qltc.Class.HoatDong;

import java.util.ArrayList;
import java.util.List;

public class HoatDongDataSource extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "hoatdong";

    private static final String TABLE_HOATDONG = "hoatdong_thuchi";


    private static final String KEY_ID = "id";
    private static final String KEY_HOATDONG = "hoatdong";
    private static final String KEY_SOTIEN = "sotien";
    private static final String KEY_LIDO = "lido";
    private static final String KEY_DIENGIAI = "diengiai";
    private static final String KEY_TUTAIKHOAN = "tutaikhoan";
    private static final String KEY_NGAY = "ngay";
    private static final String KEY_THANG = "thang";
    private static final String KEY_NAM = "nam";

    public HoatDongDataSource(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_HOATDONG + "("
                + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_HOATDONG + " TEXT," +
                KEY_SOTIEN + " TEXT," +
                KEY_LIDO + " TEXT," +
                KEY_DIENGIAI + " TEXT," +
                KEY_TUTAIKHOAN + " TEXT," +
                KEY_NGAY + " INTEGER," +
                KEY_THANG + " INTEGER," +
                KEY_NAM + " INTEGER" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOATDONG);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public  void addHoatDong(HoatDong hoatdong) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HOATDONG, hoatdong.getHoatDong()); // Contact Name
        values.put(KEY_SOTIEN, hoatdong.getSoTien()); // Contact Phone
        values.put(KEY_LIDO, hoatdong.getLiDo()); // Contact Name
        values.put(KEY_DIENGIAI, hoatdong.getDienGiai());
        values.put(KEY_TUTAIKHOAN, hoatdong.getTuTaiKhoan()); // Contact Name
        values.put(KEY_NGAY, hoatdong.getNgay());
        values.put(KEY_THANG, hoatdong.getThang());
        values.put(KEY_NAM, hoatdong.getNam());
        // Inserting Row
        db.insert(TABLE_HOATDONG, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
   public HoatDong getHoatDong(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HOATDONG, new String[]{KEY_ID,
                        KEY_HOATDONG, KEY_SOTIEN, KEY_LIDO, KEY_DIENGIAI, KEY_TUTAIKHOAN, KEY_NGAY, KEY_THANG, KEY_NAM}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        HoatDong hoatdong = new HoatDong(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)),Integer.parseInt(cursor.getString(8)));

        return hoatdong;
    }

    // Getting All Contacts
    public List<HoatDong> getAllHoatDong() {
        List<HoatDong> HoatDongList = new ArrayList<HoatDong>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HOATDONG;
        //String selectQuery = "SELECT  * FROM " + TABLE_TAIKHOAN +" WHERE "+ KEY_ID + " = 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HoatDong contact = new HoatDong();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setHoatDong(cursor.getString(1));
                contact.setSoTien(cursor.getString(2));
                contact.setLiDo(cursor.getString(3));
                contact.setDienGiai(cursor.getString(4));
                contact.setTuTaiKhoan(cursor.getString(5));
                contact.setNgay(Integer.parseInt(cursor.getString(6)));
                contact.setThang(Integer.parseInt(cursor.getString(7)));
                contact.setNam(Integer.parseInt(cursor.getString(8)));
                // Adding contact to list
                HoatDongList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return HoatDongList;
    }
    public List<HoatDong> getAllHoatDongTrongNgay(int TIME,String HoatDong) {
        List<HoatDong> HoatDongList = new ArrayList<HoatDong>();


        String selectQuery = "SELECT  * FROM " + TABLE_HOATDONG +" WHERE "+ KEY_NGAY + " = "+ TIME +" AND "+ KEY_HOATDONG + " = "+ HoatDong;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HoatDong contact = new HoatDong();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setHoatDong(cursor.getString(1));
                contact.setSoTien(cursor.getString(2));
                contact.setLiDo(cursor.getString(3));
                contact.setDienGiai(cursor.getString(4));
                contact.setTuTaiKhoan(cursor.getString(5));
                contact.setNgay(Integer.parseInt(cursor.getString(6)));
                contact.setThang(Integer.parseInt(cursor.getString(7)));
                contact.setNam(Integer.parseInt(cursor.getString(8)));
                HoatDongList.add(contact);
            } while (cursor.moveToNext());
        }

        return HoatDongList;
    }
    public List<HoatDong> getAllHoatDongTrongThang(int TIME,String HoatDong) {
        List<HoatDong> HoatDongList = new ArrayList<HoatDong>();


        String selectQuery = "SELECT  * FROM " + TABLE_HOATDONG +" WHERE "+ KEY_THANG + " = "+ TIME +" AND "+ KEY_HOATDONG + " = "+ HoatDong;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HoatDong contact = new HoatDong();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setHoatDong(cursor.getString(1));
                contact.setSoTien(cursor.getString(2));
                contact.setLiDo(cursor.getString(3));
                contact.setDienGiai(cursor.getString(4));
                contact.setTuTaiKhoan(cursor.getString(5));
                contact.setNgay(Integer.parseInt(cursor.getString(6)));
                contact.setThang(Integer.parseInt(cursor.getString(7)));
                contact.setNam(Integer.parseInt(cursor.getString(8)));
                HoatDongList.add(contact);
            } while (cursor.moveToNext());
        }

        return HoatDongList;
    }
    public List<HoatDong> getAllHoatDongTrongNam(int TIME,String HoatDong) {
        List<HoatDong> HoatDongList = new ArrayList<HoatDong>();


        String selectQuery = "SELECT  * FROM " + TABLE_HOATDONG +" WHERE "+ KEY_NAM + " = "+ TIME +" AND "+ KEY_HOATDONG + " = "+ HoatDong;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HoatDong contact = new HoatDong();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setHoatDong(cursor.getString(1));
                contact.setSoTien(cursor.getString(2));
                contact.setLiDo(cursor.getString(3));
                contact.setDienGiai(cursor.getString(4));
                contact.setTuTaiKhoan(cursor.getString(5));
                contact.setNgay(Integer.parseInt(cursor.getString(6)));
                contact.setThang(Integer.parseInt(cursor.getString(7)));
                contact.setNam(Integer.parseInt(cursor.getString(8)));
                HoatDongList.add(contact);
            } while (cursor.moveToNext());
        }

        return HoatDongList;
    }
    public List<HoatDong> getAllHoatDongToanBo(String HoatDong) {
        List<HoatDong> HoatDongList = new ArrayList<HoatDong>();


        String selectQuery = "SELECT  * FROM " + TABLE_HOATDONG +" WHERE "+ KEY_HOATDONG + " = "+ HoatDong;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HoatDong contact = new HoatDong();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setHoatDong(cursor.getString(1));
                contact.setSoTien(cursor.getString(2));
                contact.setLiDo(cursor.getString(3));
                contact.setDienGiai(cursor.getString(4));
                contact.setTuTaiKhoan(cursor.getString(5));
                contact.setNgay(Integer.parseInt(cursor.getString(6)));
                contact.setThang(Integer.parseInt(cursor.getString(7)));
                contact.setNam(Integer.parseInt(cursor.getString(8)));
                HoatDongList.add(contact);
            } while (cursor.moveToNext());
        }

        return HoatDongList;
    }


    /*
    public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
        db.close();
    }

*/
    // Getting contacts Count
    public int getHoatDongCount() {
        String countQuery = "SELECT  * FROM " + TABLE_HOATDONG;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


}