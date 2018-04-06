package com.example.dainguyen.qltc.CustomLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dainguyen.qltc.R;

public class moduleNhapSo extends AppCompatActivity implements View.OnClickListener{
    public static final String TITLE = "title";
    private TextView HienThi;

    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button clean;
    private Button cleanALL;
    private Button number0;
    private Button number000;
    private Button DONE;
    public static String RESULT_AB ="result_ab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_banphim);
        khoiTaoView();
        setClickEvent();

    }
    public  void khoiTaoView(){
        HienThi=(TextView)findViewById(R.id.tvtHienThi);
        number0=(Button)findViewById(R.id.btn_0);
        number000=(Button)findViewById(R.id.btn_000);
        number1=(Button)findViewById(R.id.btn_1);
        number2=(Button)findViewById(R.id.btn_2);
        number3=(Button)findViewById(R.id.btn_3);
        number4=(Button)findViewById(R.id.btn_4);
        number5=(Button)findViewById(R.id.btn_5);
        number6=(Button)findViewById(R.id.btn_6);
        number7=(Button)findViewById(R.id.btn_7);
        number8=(Button)findViewById(R.id.btn_8);
        number9=(Button)findViewById(R.id.btn_9);
        clean=(Button)findViewById(R.id.btn_xoa);
        cleanALL=(Button)findViewById(R.id.cleanALL);
        DONE=(Button)findViewById(R.id.btn_done);
    }
    public void setClickEvent(){
        number0.setOnClickListener(this);
        number000.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        clean.setOnClickListener(this);
        cleanALL.setOnClickListener(this);
        DONE.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                HienThi.append("0");
                break;
            case R.id.btn_000:
                HienThi.append("000");
                break;
            case R.id.btn_1:
                HienThi.append("1");
                break;
            case R.id.btn_2:
                HienThi.append("2");
                break;
            case R.id.btn_3:
                HienThi.append("3");
                break;
            case R.id.btn_4:
                HienThi.append("4");
                break;
            case R.id.btn_5:
                HienThi.append("5");
                break;
            case R.id.btn_6:
                HienThi.append("6");
                break;
            case R.id.btn_7:
                HienThi.append("7");
                break;
            case R.id.btn_8:
                HienThi.append("8");
                break;
            case R.id.btn_9:
                HienThi.append("9");
                break;
            case R.id.cleanALL:
                HienThi.setText("");
                break;
            case R.id.btn_xoa:
                String afterDelete=deleteOneNumber(HienThi.getText().toString());
                HienThi.setText(afterDelete);
                break;
            case R.id.btn_done:
                String sotien=HienThi.getText().toString();
                if(sotien.equals("")){
                    sotien="0";

                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra(RESULT_AB,sotien);
                    setResult(RESULT_OK,intent);
                    finish();
                }



                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //startActivity(intent);
                break;

        }

    }
    public String deleteOneNumber(String number){
        int length=number.length();
        if(length>1){
            String temp=number.substring(0,length-1);
            return temp;
        }
        else{
            return "0";
        }
    }

}
