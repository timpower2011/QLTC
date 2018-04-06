package com.example.dainguyen.qltc.Activity;

import android.app.Dialog;
import android.content.Context;
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

public class ChinhSuaTaiKhoanActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_TIEN =1;
    public static final int REQUEST_CODE_MUCTHU =2;
    public static final int REQUEST_CODE_DIENGIAI =3;
    public static final int REQUEST_CODE_TAIKHOAN =4;
    public static final int REQUEST_CODE_TEN =2;
    Button btn_loaitaikhoan;
    Button   btn_nhapsotien;
    Button    btn_gotentaikhoan;
    Button btn_goGhiChu;
    Button    btn_xoataikhoan;
    Button   btn_capnhattaikhoan;
    Button   btn_quayve;
    String soTien,tuTaiKhoan,tenTaiKhoan,ghiChu;
    int idTaiKhoan;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinhsua_tai_khoan);


        Intent intent = this.getIntent();
         idTaiKhoan= intent.getIntExtra("id",0);
        TaiKhoanDataSource tk= new TaiKhoanDataSource(this);
        TaiKhoan taiKhoanCu=tk.getTaiKhoan(idTaiKhoan);
        anhXa();
        loadThongTin(taiKhoanCu);
        action();

    }
    public  void loadThongTin(TaiKhoan taiKhoanCu){

        tenTaiKhoan=taiKhoanCu.getTentaikhoan();
        tuTaiKhoan=taiKhoanCu.getLoaitaikhoan();
        ghiChu=taiKhoanCu.getGhichu();
        soTien=taiKhoanCu.getSotien();

        btn_loaitaikhoan.setText(taiKhoanCu.getLoaitaikhoan());
        veHinhMinhHoa(taiKhoanCu.getLoaitaikhoan());
        btn_nhapsotien.setText(taiKhoanCu.getSotien());
        btn_gotentaikhoan.setText(taiKhoanCu.getTentaikhoan());
        btn_goGhiChu.setText(taiKhoanCu.getGhichu());

    }
    public  void anhXa(){
        btn_quayve=(Button)findViewById(R.id.btn_quayve);
        btn_loaitaikhoan=(Button)findViewById(R.id.btn_loaitaikhoan);
        btn_nhapsotien=(Button)findViewById(R.id.btn_nhapsotien);
        btn_gotentaikhoan=(Button)findViewById(R.id.btn_gotentaikhoan);
        btn_goGhiChu=(Button)findViewById(R.id.btn_goGhiChu);
        btn_xoataikhoan=(Button)findViewById(R.id.btn_xoataikhoan);
        btn_capnhattaikhoan=(Button)findViewById(R.id.btn_capnhattaikhoan);
    }
    public void action(){
        btn_nhapsotien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhaptien = new Intent(ChinhSuaTaiKhoanActivity.this,moduleNhapSo.class);
                startActivityForResult(nhaptien,REQUEST_CODE_TIEN);
            }
        });
        btn_loaitaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taikhoan = new Intent(ChinhSuaTaiKhoanActivity.this,MucTaiKhoan.class);
                startActivityForResult(taikhoan,REQUEST_CODE_TAIKHOAN);

            }
        });
        btn_gotentaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(ChinhSuaTaiKhoanActivity.this,moduleNhapText.class);
                startActivityForResult(nhapText,REQUEST_CODE_TEN);
            }
        });
        btn_goGhiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(ChinhSuaTaiKhoanActivity.this,moduleNhapText.class);
                startActivityForResult(nhapText,REQUEST_CODE_DIENGIAI);
            }
        });



        btn_xoataikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_thong_bao);
                dialog.show();
                Button dialogButtonCancel = (Button) dialog.findViewById(R.id.btn_huybo);
                Button dialogButtonOk = (Button) dialog.findViewById(R.id.btn_dongy);
                dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TaiKhoanDataSource tk= new TaiKhoanDataSource(v.getContext());
                        TaiKhoan x= new TaiKhoan(idTaiKhoan);
                        tk.deleteTaiKhoan(x);
                        thongbao("Đã xóa tài khoan");

                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });


            }
        });
        btn_capnhattaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //soTien,tenTaiKhoan,ghiChu,tuTaiKhoan,idTaiKhoan;)

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.activity_thong_bao);
                dialog.show();
                Button dialogButtonCancel = (Button) dialog.findViewById(R.id.btn_huybo);
                Button dialogButtonOk = (Button) dialog.findViewById(R.id.btn_dongy);
                dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TaiKhoan x= new TaiKhoan(idTaiKhoan,tenTaiKhoan,tuTaiKhoan,soTien,ghiChu);
                        TaiKhoanDataSource tk= new TaiKhoanDataSource(v.getContext());
                        tk.updateTaiKhoan(x);
                        thongbao("Cập nhật tài khoản thành công");
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });






            }
        });
        btn_quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChinhSuaTaiKhoanActivity.this,MainActivity.class);
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
                veHinhMinhHoa(tuTaiKhoan);

            }
        }



    }
    public void thongbao(String noidung){
        Toast.makeText(getBaseContext(),noidung,Toast.LENGTH_SHORT).show();
    }
    public void veHinhMinhHoa(String tuTaiKhoan){
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
