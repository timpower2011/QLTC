package com.example.dainguyen.qltc.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.dainguyen.qltc.Adapter.ArrayAdapterHoatDong;
import com.example.dainguyen.qltc.Class.HoatDong;
import com.example.dainguyen.qltc.DataSource.HoatDongDataSource;
import com.example.dainguyen.qltc.R;

import java.util.ArrayList;
import java.util.List;


public class BaoCaoActivity extends AppCompatActivity {
    private ListView lvlichsugiaodich;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lichsugiaodich);
        anhXa();

        ve();

    }
    public  void ve(){
        context = this;


        ArrayList<HoatDong> arrayList=new ArrayList<>();
        HoatDongDataSource tk= new HoatDongDataSource(this);
        List<HoatDong> contacts = tk.getAllHoatDong();

        for (HoatDong cn : contacts) {
            arrayList.add(cn);
        }
        ArrayAdapterHoatDong customAdapter= new ArrayAdapterHoatDong(this,R.layout.lichsugiaodich,arrayList);
        lvlichsugiaodich.setAdapter(customAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            ve();
        }
    }
    void anhXa(){
        lvlichsugiaodich=(ListView)findViewById(R.id.lvlichsugiaodich);

    }



}
