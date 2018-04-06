package com.example.dainguyen.qltc.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dainguyen.qltc.Class.HoatDong;
import com.example.dainguyen.qltc.DataSource.HoatDongDataSource;
import com.example.dainguyen.qltc.R;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

//txttongthutheothang

public class ThongKeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongkethuchi);
        RelativeLayout RelativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout);

        Calendar c = GregorianCalendar.getInstance();

      TextView txt_ngay=(TextView)findViewById(R.id.txt_ngay);
        TextView txt_thang=(TextView)findViewById(R.id.txt_thang);
        TextView txt_nam=(TextView)findViewById(R.id.txt_nam);
        int YEAR = c.get(Calendar.YEAR);
        int MOUNTH = c.get(Calendar.MONTH);
        int TODAY = c.get(Calendar.DATE);
        MOUNTH+=1;


         txt_ngay.setText("Hôm nay ngày :" +TODAY+"/"+MOUNTH+"/"+YEAR);
        txt_thang.setText("Tháng này    :" +MOUNTH+"/"+YEAR);
          txt_nam.setText("Năm nay      :" +YEAR);






        final HoatDongDataSource dbHd=new HoatDongDataSource(this);


        veDoThiTheoNgay(dbHd,TODAY);
        veDoThiTheoThang(dbHd,MOUNTH);
        veDoThiTheoNam(dbHd,YEAR);
        veDoThiToanbo(dbHd);


















    }
    public  void veDoThiTheoNgay(HoatDongDataSource dbHd,int today){
        final  TextView tv_thuNgay=(TextView)findViewById(R.id.tv_thuNgay);
        final TextView tv_chiNgay=(TextView)findViewById(R.id.tv_chiNgay);
        final TextView txtsotienthungay=(TextView)findViewById(R.id.txtsotienthungay);
        final TextView txtsotienchingay=(TextView)findViewById(R.id.txtsotienchingay);
        RelativeLayout.LayoutParams Rl_thuNgay = (RelativeLayout.LayoutParams) tv_thuNgay.getLayoutParams();
        RelativeLayout.LayoutParams Rl_chiNgay = (RelativeLayout.LayoutParams) tv_chiNgay.getLayoutParams();
        int tongTienChi=0;
        int tongTienThu=0;
        List<HoatDong> contacts = dbHd.getAllHoatDongTrongNgay(today,"'Thu'");
        for (HoatDong cn : contacts) {
            tongTienThu +=Integer.parseInt(cn.getSoTien());
        }
        contacts = dbHd.getAllHoatDongTrongNgay(today,"'Chi'");
        for (HoatDong cn : contacts) {
            tongTienChi+=Integer.parseInt(cn.getSoTien());
        }
        if(tongTienThu>tongTienChi){
            if(tongTienChi==0){      // TRƯỜNG HỢP CHI =0 , KHÔNG THE CHIA CHO 0 LAM TI LE
                Rl_thuNgay.width = 400;    //set do dai mac dinh
                Rl_chiNgay.width=0;
            }
            else{
                Rl_thuNgay.width = 400;    //set do dai mac dinh
                float chenhLenh=(float) tongTienThu/(float) tongTienChi;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le

                Rl_chiNgay.width=(int)doDai;
                // ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienThu<tongTienChi){
            if(tongTienThu==0){  // trường hợp khộn có thu
                // thu =0 , nen ko thễ chia cho 0 , set mặc định (  width thu =0) width chi =400
                Rl_thuNgay.width = 0;    //set do dai mac dinh
                Rl_chiNgay.width=400;
            }
            else {
                Rl_chiNgay.width = 400;    //set do dai mac dinh
                float chenhLenh=tongTienChi/tongTienThu;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le
                Rl_thuNgay.width=(int)doDai;// ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienChi==tongTienThu&&tongTienThu==0) {
            Rl_thuNgay.width=0;
            Rl_chiNgay.width=0;

        }
        else if(tongTienChi==tongTienThu&&tongTienChi>0){
            Rl_thuNgay.width=400;
            Rl_chiNgay.width=400;
        }

         txtsotienchingay.setText(tongTienChi+"");
        txtsotienthungay.setText(tongTienThu+"");

        tv_thuNgay.setLayoutParams(Rl_thuNgay);
        tv_chiNgay.setLayoutParams(Rl_chiNgay);
    }
    public  void veDoThiTheoThang(HoatDongDataSource dbHd,int month){
        final  TextView tv_thuThang=(TextView)findViewById(R.id.tv_thuThang);
        final TextView tv_chiThang=(TextView)findViewById(R.id.tv_chiThang);
        final TextView txttongthutheothang=(TextView)findViewById(R.id.txttongthutheothang);
        final TextView txttongchitheothang=(TextView)findViewById(R.id.txttongchitheothang);
        RelativeLayout.LayoutParams Rl_thuThang = (RelativeLayout.LayoutParams) tv_thuThang.getLayoutParams();
        RelativeLayout.LayoutParams Rl_chiThang = (RelativeLayout.LayoutParams) tv_chiThang.getLayoutParams();
        int tongTienChi=0;
        int tongTienThu=0;
        List<HoatDong> contacts = dbHd.getAllHoatDongTrongThang(month,"'Thu'");
        for (HoatDong cn : contacts) {
            tongTienThu +=Integer.parseInt(cn.getSoTien());
        }
        contacts = dbHd.getAllHoatDongTrongThang(month,"'Chi'");
        for (HoatDong cn : contacts) {
            tongTienChi+=Integer.parseInt(cn.getSoTien());
        }
        if(tongTienThu>tongTienChi){
            if(tongTienChi==0){      // TRƯỜNG HỢP CHI =0 , KHÔNG THE CHIA CHO 0 LAM TI LE
                Rl_thuThang.width = 400;    //set do dai mac dinh
                Rl_chiThang.width=0;
            }
            else{
                Rl_thuThang.width = 400;    //set do dai mac dinh
                float chenhLenh=(float) tongTienThu/(float) tongTienChi;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le

                Rl_chiThang.width=(int)doDai;
                // ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienThu<tongTienChi){
            if(tongTienThu==0){  // trường hợp khộn có thu
                // thu =0 , nen ko thễ chia cho 0 , set mặc định (  width thu =0) width chi =400
                Rl_thuThang.width = 0;    //set do dai mac dinh
                Rl_chiThang.width=400;
            }
            else {
                Rl_chiThang.width = 400;    //set do dai mac dinh
                float chenhLenh=tongTienChi/tongTienThu;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le
                Rl_thuThang.width=(int)doDai;// ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienChi==tongTienThu&&tongTienThu==0) {
            Rl_thuThang.width=0;
            Rl_chiThang.width=0;

        }
        else if(tongTienChi==tongTienThu&&tongTienChi>0){
            Rl_thuThang.width=400;
            Rl_chiThang.width=400;
        }

        txttongchitheothang.setText(tongTienChi+"");
        txttongthutheothang.setText(tongTienThu+"");

        tv_thuThang.setLayoutParams(Rl_thuThang);
        tv_chiThang.setLayoutParams(Rl_chiThang);
    }
    public  void veDoThiTheoNam(HoatDongDataSource dbHd,int year){
        final  TextView tv_thuNam=(TextView)findViewById(R.id.tv_thuNam);
        final TextView tv_chiNam=(TextView)findViewById(R.id.tv_chiNam);
        final TextView txttongthutheonam=(TextView)findViewById(R.id.txttongthutheonam);
        final TextView txttongchitheonam=(TextView)findViewById(R.id.txttongchitheonam);
        RelativeLayout.LayoutParams Rl_thuNam = (RelativeLayout.LayoutParams) tv_thuNam.getLayoutParams();
        RelativeLayout.LayoutParams Rl_chiNam = (RelativeLayout.LayoutParams) tv_chiNam.getLayoutParams();
        int tongTienChi=0;
        int tongTienThu=0;
        List<HoatDong> contacts = dbHd.getAllHoatDongTrongNam(year,"'Thu'");
        for (HoatDong cn : contacts) {
            tongTienThu +=Integer.parseInt(cn.getSoTien());
        }
        contacts = dbHd.getAllHoatDongTrongNam(year,"'Chi'");
        for (HoatDong cn : contacts) {
            tongTienChi+=Integer.parseInt(cn.getSoTien());
        }
        if(tongTienThu>tongTienChi){
            if(tongTienChi==0){      // TRƯỜNG HỢP CHI =0 , KHÔNG THE CHIA CHO 0 LAM TI LE
                Rl_thuNam.width = 400;    //set do dai mac dinh
                Rl_chiNam.width=0;
            }
            else{
                Rl_thuNam.width = 400;    //set do dai mac dinh
                float chenhLenh=(float) tongTienThu/(float) tongTienChi;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le

                Rl_chiNam.width=(int)doDai;
                // ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienThu<tongTienChi){
            if(tongTienThu==0){  // trường hợp khộn có thu
                // thu =0 , nen ko thễ chia cho 0 , set mặc định (  width thu =0) width chi =400
                Rl_thuNam.width = 0;    //set do dai mac dinh
                Rl_chiNam.width=400;
            }
            else {
                Rl_chiNam.width = 400;    //set do dai mac dinh
                float chenhLenh=tongTienChi/tongTienThu;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le
                Rl_thuNam.width=(int)doDai;// ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienChi==tongTienThu&&tongTienThu==0) {
            Rl_thuNam.width=0;
            Rl_chiNam.width=0;

        }
        else if(tongTienChi==tongTienThu&&tongTienChi>0){
            Rl_thuNam.width=400;
            Rl_chiNam.width=400;
        }

        txttongchitheonam.setText(tongTienChi+"");
        txttongthutheonam.setText(tongTienThu+"");

        tv_thuNam.setLayoutParams(Rl_thuNam);
        tv_chiNam.setLayoutParams(Rl_chiNam);
    }
    public  void veDoThiToanbo(HoatDongDataSource dbHd){

        final TextView tv_thuToanBo=(TextView)findViewById(R.id.tv_thuToanBo);
        final TextView tv_chiToanBo=(TextView)findViewById(R.id.tv_chiToanBo);

        final TextView txttongthu=(TextView)findViewById(R.id.txttongthu);
        final TextView txttongchi=(TextView)findViewById(R.id.txttongchi);

        RelativeLayout.LayoutParams Rl_thutoanBo = (RelativeLayout.LayoutParams) tv_thuToanBo.getLayoutParams();
        RelativeLayout.LayoutParams Rl_chitoanBo = (RelativeLayout.LayoutParams) tv_chiToanBo.getLayoutParams();


        int tongTienChi=0;
        int tongTienThu=0;
        List<HoatDong> contacts = dbHd.getAllHoatDongToanBo("'Thu'");
        for (HoatDong cn : contacts) {
            tongTienThu +=Integer.parseInt(cn.getSoTien());
        }
        contacts = dbHd.getAllHoatDongToanBo("'Chi'");
        for (HoatDong cn : contacts) {
            tongTienChi+=Integer.parseInt(cn.getSoTien());
        }
        if(tongTienThu>tongTienChi){
            if(tongTienChi==0){      // TRƯỜNG HỢP CHI =0 , KHÔNG THE CHIA CHO 0 LAM TI LE
                Rl_thutoanBo.width = 400;    //set do dai mac dinh
                Rl_chitoanBo.width=0;
            }
            else{
                Rl_thutoanBo.width = 400;    //set do dai mac dinh
                float chenhLenh=(float) tongTienThu/(float) tongTienChi;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le

                Rl_chitoanBo.width=(int)doDai;
                // ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienThu<tongTienChi){
            if(tongTienThu==0){  // trường hợp khộn có thu
                // thu =0 , nen ko thễ chia cho 0 , set mặc định (  width thu =0) width chi =400
                Rl_thutoanBo.width = 0;    //set do dai mac dinh
                Rl_chitoanBo.width=400;
            }
            else {
                Rl_chitoanBo.width = 400;    //set do dai mac dinh
                float chenhLenh=tongTienChi/tongTienThu;
                float doDai=400/chenhLenh; // tim ra chenh lenh ti le
                Rl_thutoanBo.width=(int)doDai;// ve theo dung ti le , voi 100% la 400px
            }

        }
        else if(tongTienChi==tongTienThu&&tongTienThu==0) {
            Rl_thutoanBo.width=0;
            Rl_chitoanBo.width=0;

        }
        else if(tongTienChi==tongTienThu&&tongTienChi>0){
            Rl_thutoanBo.width=400;
            Rl_chitoanBo.width=400;
        }

        txttongchi.setText(tongTienChi+"");
        txttongthu.setText(tongTienThu+"");

        tv_thuToanBo.setLayoutParams(Rl_thutoanBo);
        tv_chiToanBo.setLayoutParams(Rl_chitoanBo);
    }
}