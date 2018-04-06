package com.example.dainguyen.qltc.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.dainguyen.qltc.Adapter.ArrayAdapterTaiKhoanFrom;
import com.example.dainguyen.qltc.Class.HoatDong;
import com.example.dainguyen.qltc.Class.TaiKhoan;
import com.example.dainguyen.qltc.CustomLayout.moduleNhapSo;
import com.example.dainguyen.qltc.CustomLayout.moduleNhapText;
import com.example.dainguyen.qltc.DataSource.HoatDongDataSource;
import com.example.dainguyen.qltc.DataSource.TaiKhoanDataSource;
import com.example.dainguyen.qltc.ListViewObject.MucThuTien;
import com.example.dainguyen.qltc.R;

import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class GhiChepActivity extends AppCompatActivity {

    Button goToNhapSoTien;
    Button goToDanhMucGhiChep;
    Button btn_ngay_thutien;
    Button  goToDanhMucthu;
    Button gotoDanhSachTaiKhoanHienCo;
    Button btn_soTienConLai;
    Button btn_ghithutien;
    int idTaiKhoan;
    int soTienTrongTaiKhoan;
    int soTienNhap;
    String mucThu;
    String dienGiai;
    String tuTaiKhoan;
    int  ngay;
    int thang;
    int nam;
    public static final int REQUEST_CODE_TIEN =1;
    public static final int REQUEST_CODE_MUCTHU =2;
    public static final int REQUEST_CODE_DIENGIAI =3;
    public static final int REQUEST_CODE_TAIKHOAN =4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghi_chep_);
        anhXa();
        // khỡi tạo giá trị mục định
        giaTriMacDinh();

        final TaiKhoanDataSource dbTk= new TaiKhoanDataSource(this);
        final HoatDongDataSource dbHd=new HoatDongDataSource(this);



        goToNhapSoTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhaptien = new Intent(GhiChepActivity.this,moduleNhapSo.class);
                startActivityForResult(nhaptien,REQUEST_CODE_TIEN);
            }
        });
        goToDanhMucthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mucthu = new Intent(GhiChepActivity.this,MucThuTien.class);
                startActivityForResult(mucthu,REQUEST_CODE_MUCTHU);
            }
        });
        goToDanhMucGhiChep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(GhiChepActivity.this,moduleNhapText.class);
                startActivityForResult(nhapText,REQUEST_CODE_DIENGIAI);
            }
        });



        btn_soTienConLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(GhiChepActivity.this,TaiKhoanActivityFrom.class);
                startActivityForResult(nhapText,REQUEST_CODE_TAIKHOAN);
            }
        });
        gotoDanhSachTaiKhoanHienCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhapText = new Intent(GhiChepActivity.this,TaiKhoanActivityFrom.class);
                startActivityForResult(nhapText,REQUEST_CODE_TAIKHOAN);
            }
        });



        btn_ngay_thutien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear, mMonth, mDay;

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
               final String DAY;

                DatePickerDialog datePickerDialog = new DatePickerDialog(GhiChepActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                monthOfYear+=1;

                                  ngay=dayOfMonth;
                                  thang=monthOfYear;
                                   nam=year;

                                btn_ngay_thutien.setText(dayOfMonth + "-" + (monthOfYear ) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        btn_ghithutien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int temp=soTienNhap+soTienTrongTaiKhoan;
                String updatedTien= Integer.toString(temp);
                String tmpSoTienNhap=Integer.toString(soTienNhap);


                if(soTienNhap==0){
                    thongbao("Bạn chưa nhập số Tiền");
                }
                else if(tuTaiKhoan.equals("")){
                    thongbao("Bạn chưa chọn tài khoản");
                }
                else if(mucThu.equals("")){
                    thongbao("Bạn chưa nhập lí do thu");
                }
                else{
                    thongbao("Ghi thông tin thành công");

                    TaiKhoan x=new TaiKhoan(idTaiKhoan,updatedTien);
                    dbTk.updateSoTienTaiKhoan(x);
                    dbHd.addHoatDong(new HoatDong("Thu",tmpSoTienNhap,mucThu,dienGiai,tuTaiKhoan,ngay,thang,nam));
                    giaTriMacDinh();


                }
            }
        });
    }
    public  void anhXa(){
        goToNhapSoTien=(Button)findViewById(R.id.btn_nhapsotien_thutien);
        goToDanhMucGhiChep=(Button)findViewById(R.id.btn_diengiai_thutien);
        btn_ngay_thutien=(Button)findViewById(R.id. btn_ngay_thutien);
        goToDanhMucthu=(Button)findViewById(R.id.btn_mucthuchi_thutien);
        gotoDanhSachTaiKhoanHienCo=(Button)findViewById(R.id.btn_vaotaikhoan_thutien);
        btn_soTienConLai=(Button)findViewById(R.id.btn_soTienConLai);
        btn_ghithutien=(Button)findViewById(R.id.btn_ghithutien);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_TIEN){
            if(resultCode==RESULT_OK){
                       String ketqua=data.getStringExtra(moduleNhapSo.RESULT_AB);
                soTienNhap=Integer.parseInt(ketqua);
                goToNhapSoTien.setText(soTienNhap+"đ");
            }
        }
        else if(requestCode==REQUEST_CODE_DIENGIAI){
            if(resultCode==RESULT_OK){
                dienGiai=data.getStringExtra(moduleNhapText.RESULT_AB);
                goToDanhMucGhiChep.setText(dienGiai);
            }
        }
        else if(requestCode==REQUEST_CODE_MUCTHU){
            if(resultCode==RESULT_OK){
                mucThu=data.getStringExtra(MucThuTien.RESULT_AB);
                goToDanhMucthu.setText(mucThu);
            }
        }
        else if(requestCode==REQUEST_CODE_TAIKHOAN){
            if(resultCode==RESULT_OK){


                String Stringid=data.getStringExtra(ArrayAdapterTaiKhoanFrom.RESULT_AB);
                TaiKhoanDataSource dbTk= new TaiKhoanDataSource(this);
                idTaiKhoan= parseInt(Stringid);
                TaiKhoan current=dbTk.getTaiKhoan(idTaiKhoan);
                tuTaiKhoan=current.getLoaitaikhoan();
                soTienTrongTaiKhoan=Integer.parseInt(current.getSotien());
                btn_soTienConLai.setText("Tổng  :"+soTienTrongTaiKhoan+" Đ");
                gotoDanhSachTaiKhoanHienCo.setText(current.getLoaitaikhoan());
            }
        }
    }
    public void thongbao(String noidung){
        Toast.makeText(getBaseContext(),noidung,Toast.LENGTH_SHORT).show();
    }
    public void giaTriMacDinh(){
        tuTaiKhoan="";
        mucThu="";
        dienGiai="";
        tuTaiKhoan="";

        btn_ngay_thutien.setText("");
        btn_soTienConLai.setText("");
        goToNhapSoTien.setText("SỐ TIỀN");
        goToDanhMucGhiChep.setText("");
        goToDanhMucthu.setText("");

        gotoDanhSachTaiKhoanHienCo.setText("");



    }

}
