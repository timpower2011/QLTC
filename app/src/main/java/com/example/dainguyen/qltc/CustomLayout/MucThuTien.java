package com.example.dainguyen.qltc.CustomLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.dainguyen.qltc.R;

import java.util.ArrayList;



public class MucThuTien extends AppCompatActivity {

    public static String RESULT_AB ="result_ab";
    private ListView lvTut;
    private ArrayList<String> listData;
    private ArrayAdapter<String> adapter;

    private EditText editTut;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mucthutien);

        context = this;

        connectView();
        loadData();

    }

    private void connectView() {
        lvTut = (ListView) findViewById(R.id.lv_mucthutien);
        lvTut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Intent intent = new Intent(MucThuTien.this,MainActivity.class);
                String dataUserChoice=listData.get(i);

                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,dataUserChoice);
                setResult(RESULT_OK,intent);
                finish();


            }
        });
    }

    private void loadData() {

        listData = new ArrayList<>();
        listData.add("Lương");
        listData.add("Được cho tặng");
        listData.add("Thưởng");
        listData.add("Tiền lãi tiết kiệm");
        listData.add("Khác");

        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listData);

        lvTut.setAdapter(adapter);
    }


}