package com.example.dainguyen.qltc.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dainguyen.qltc.Adapter.ArrayAdapterTaiKhoanMain;
import com.example.dainguyen.qltc.Class.TaiKhoan;
import com.example.dainguyen.qltc.DataSource.TaiKhoanDataSource;
import com.example.dainguyen.qltc.R;

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanActivityMain extends AppCompatActivity {
    private ListView lvdanhsachtaikhoan;
    private Context context;
    Button btn_themTaiKhoan;
    TextView txt_tongtien;
    int tongSoTienTatCaTaiKhoan=0;
    TaiKhoanDataSource tk;
    public static final int REQUEST_CODE_TAIKHOAN =4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachtaikhoan);
        anhXa();
        action();
        ve();

    }
    public  void ve(){
        context = this;


        ArrayList<TaiKhoan> arrayList=new ArrayList<>();
        final ArrayList<Integer>dayIdItem = new ArrayList<Integer>();

        tk= new TaiKhoanDataSource(this);
        int soLuongTaiKhoan= tk.getProfilesCount();
        Log.d("INFO",soLuongTaiKhoan+"");
        if(soLuongTaiKhoan==0){
            thongbao("Chưa có tài khoản, bạn cần tạo tài khoản");
        }

       else{
            List<TaiKhoan> contacts = tk.getAllTaiKhoan();

            for (TaiKhoan cn : contacts) {
                String soTienString=cn.getSotien();
                tongSoTienTatCaTaiKhoan+=Integer.parseInt(soTienString);
                arrayList.add(cn);
                dayIdItem.add(cn.getIdtaikhoan());
            }
            ArrayAdapterTaiKhoanMain customAdapter= new ArrayAdapterTaiKhoanMain(this,R.layout.danhsachtaikhoan,arrayList);
            lvdanhsachtaikhoan.setAdapter(customAdapter);
            txt_tongtien.setText("Tổng tiền hiện có :"+tongSoTienTatCaTaiKhoan+"");

            lvdanhsachtaikhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   int stt= dayIdItem.get(position);

                    Intent ClickOnListView = new Intent(TaiKhoanActivityMain.this,ChinhSuaTaiKhoanActivity.class);
                    ClickOnListView.putExtra("id",stt);
                    startActivityForResult(ClickOnListView,REQUEST_CODE_TAIKHOAN);
                    tongSoTienTatCaTaiKhoan=0;
                }
            });

        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
             ve();
        }
    }
    void anhXa(){
         txt_tongtien=(TextView)findViewById(R.id.txt_tongtien);
        lvdanhsachtaikhoan=(ListView)findViewById(R.id.lvdanhsachtaikhoan);
        btn_themTaiKhoan=(Button)findViewById(R.id.btn_themTaiKhoan);
    }
    void action(){
        btn_themTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaiKhoanActivityMain.this, ThemTaiKhoanActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
    public void thongbao(String noidung){
        Toast.makeText(getBaseContext(),noidung,Toast.LENGTH_SHORT).show();
    }


}
