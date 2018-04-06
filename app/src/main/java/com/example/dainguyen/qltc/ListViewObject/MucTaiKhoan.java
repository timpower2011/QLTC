package com.example.dainguyen.qltc.ListViewObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dainguyen.qltc.R;

import java.util.ArrayList;



public class MucTaiKhoan extends AppCompatActivity {
    public static String RESULT_AB ="result_ab";

    private ListView lvTut;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_muctaikhoan);

        context = this;

        connectView();
        loadData();

    }

    private void connectView() {
        lvTut = (ListView) findViewById(R.id.lv_mucthutien);
        lvTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String dataUserChoice=listData.get(i);

                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,dataUserChoice);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                setResult(RESULT_OK,intent);
                finish();


            }
        });
    }

    private void loadData() {

        listData = new ArrayList<>();
        listData.add("Tiền mặt");
        listData.add("Tài khoản ngân hàng ");
        listData.add("Thẻ tín dụng");
        listData.add("Tài khoản đầu tư");
        listData.add("Tài khoản tiết kiệm");
        listData.add("Khác");

        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);

        lvTut.setAdapter(adapter);
    }


}