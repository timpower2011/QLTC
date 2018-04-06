package com.example.dainguyen.qltc.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dainguyen.qltc.Class.TaiKhoan;
import com.example.dainguyen.qltc.CustomLayout.moduleNhapSo;
import com.example.dainguyen.qltc.CustomLayout.moduleNhapText;
import com.example.dainguyen.qltc.DataSource.TaiKhoanDataSource;
import com.example.dainguyen.qltc.ListViewObject.MucTaiKhoan;
import com.example.dainguyen.qltc.R;

public class ThemTaiKhoanActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_TIEN =1;
    public static final int REQUEST_CODE_MUCTHU =2;
    public static final int REQUEST_CODE_DIENGIAI =3;
    public static final int REQUEST_CODE_TAIKHOAN =4;
    public static final int REQUEST_CODE_TEN =2;
    Button btn_loaitaikhoan;
    Button   btn_nhapsotien;
    Button    btn_gotentaikhoan;
    Button btn_goGhiChu;
    Button    btn_luu;
    Button   btn_huybo;
    String soTien,tuTaiKhoan,tenTaiKhoan,ghiChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tai_khoan);

        anhXa();

        action();
    }
    public  void anhXa(){
        btn_loaitaikhoan=(Button)findViewById(R.id.btn_loaitaikhoan);
        btn_nhapsotien=(Button)findViewById(R.id.btn_nhapsotien);
        btn_gotentaikhoan=(Button)findViewById(R.id.btn_gotentaikhoan);
        btn_goGhiChu=(Button)findViewById(R.id.btn_goGhiChu);
        btn_luu=(Button)findViewById(R.id.btn_luu);
        btn_huybo=(Button)findViewById(R.id.btn_huybo);
    }
    public void action(){
        btn_nhapsotien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhaptien = new Intent(ThemTaiKhoanActivity.this,moduleNhapSo.class);
                startActivityForResult(nhaptien,REQUEST_CODE_TIEN);
            }
        });
        btn_loaitaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taikhoan = new Intent(ThemTaiKhoanActivity.this,MucTaiKhoan.class);
                startActivityForResult(taikhoan,REQUEST_CODE_TAIKHOAN);

            }
        });
        btn_gotentaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(ThemTaiKhoanActivity.this,moduleNhapText.class);
                startActivityForResult(nhapText,REQUEST_CODE_TEN);
            }
        });
        btn_goGhiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(ThemTaiKhoanActivity.this,moduleNhapText.class);
                startActivityForResult(nhapText,REQUEST_CODE_DIENGIAI);
            }
        });
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaiKhoanDataSource tk= new TaiKhoanDataSource(v.getContext());
                 String tempTenTaiKhoan=btn_gotentaikhoan.getText().toString();
                 String tempTuTaiKhoan=btn_loaitaikhoan.getText().toString();
                if(tempTenTaiKhoan.equals("")){
                    thongbao("Chưa nhập tên tài khoản");
                }
                else if(tempTuTaiKhoan.equals("")){
                    thongbao("Chưa nhập loại tài khoản");
                }
                else{
                    tk.addTaiKhoan(new TaiKhoan(tenTaiKhoan,tuTaiKhoan,soTien,ghiChu));
                    btn_gotentaikhoan.setText("");
                    tenTaiKhoan="";
                    thongbao("Đã thêm vào cơ sõ dữ liệu");
                    Intent intent = new Intent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    setResult(RESULT_OK,intent);
                    finish();

                }

            }
        });
        btn_huybo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemTaiKhoanActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_TIEN){
            if(resultCode==RESULT_OK){
                soTien=data.getStringExtra(moduleNhapSo.RESULT_AB);
                btn_nhapsotien.setText(soTien);
            }
        }
        else if(requestCode==REQUEST_CODE_TEN){
            if(resultCode==RESULT_OK){
                tenTaiKhoan=data.getStringExtra(moduleNhapText.RESULT_AB);
                btn_gotentaikhoan.setText(tenTaiKhoan);
            }
        }
        else if(requestCode==REQUEST_CODE_DIENGIAI){
            if(resultCode==RESULT_OK){
                ghiChu=data.getStringExtra(moduleNhapText.RESULT_AB);

                btn_goGhiChu.setText(ghiChu);
            }
        }
        else if(requestCode==REQUEST_CODE_TAIKHOAN){
            if(resultCode==RESULT_OK){
                tuTaiKhoan=data.getStringExtra(MucTaiKhoan.RESULT_AB);
                btn_loaitaikhoan.setText(tuTaiKhoan);
                ImageView img_minhhoa=(ImageView)findViewById(R.id.img_minhhoa);
                if(tuTaiKhoan.equals("Tiền mặt")){
                    img_minhhoa.setImageResource(R.drawable.tienmat);
                }
                else if(tuTaiKhoan.equals("Tài khoản ngân hàng ")){
                    img_minhhoa.setImageResource(R.drawable.taikhoannganhang);
                }
                else if(tuTaiKhoan.equals("Thẻ tín dụng")){
                    img_minhhoa.setImageResource(R.drawable.atm);
                }
                else if(tuTaiKhoan.equals("Tài khoản đầu tư")){
                    img_minhhoa.setImageResource(R.drawable.taikhoandautu);
                }
                else if(tuTaiKhoan.equals("Tài khoản tiết kiệm")){
                    img_minhhoa.setImageResource(R.drawable.heo);
                }
                else if(tuTaiKhoan.equals("Khác")){
                    img_minhhoa.setImageResource(R.drawable.khac);
                }

            }
        }



    }
    public void thongbao(String noidung){
        Toast.makeText(getBaseContext(),noidung,Toast.LENGTH_SHORT).show();
    }
}
