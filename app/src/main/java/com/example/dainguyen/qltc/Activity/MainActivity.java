package com.example.dainguyen.qltc.Activity;

import android.annotation.TargetApi;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.dainguyen.qltc.R;

public class MainActivity extends TabActivity implements View.OnClickListener  {
    ImageButton ImageButtonTab1,ImageButtonTab2,ImageButtonTab4,ImageButtonTab3,ImageButtonTab5;
    Animation animation;
    TabHost tabHost;
    Color color;
    TabHost.TabSpec ThongKeSpec;
    LinearLayout LinearLayoutTabControl,LinearLayoutTabCustomControl;
    int tabon=0;
    float initialX;
    Button Ghi;

    private  int columnIndex, position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature( Window.FEATURE_NO_TITLE );

// Remove notification bar
        this.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );




        setContentView(R.layout.activity_main);
        getActionBar();

        SetTabHost();
        anhxa();
        ImageButtonTab1.setOnClickListener(this);
        ImageButtonTab2.setOnClickListener(this);
        ImageButtonTab3.setOnClickListener(this);
        ImageButtonTab4.setOnClickListener(this);
        ImageButtonTab5.setOnClickListener(this);
        //ImageButtonTab1.setImageResource(R.drawable.note_selected);


    }

    // ánh xạ cái view của Activity Main
    private void anhxa() {

        //LinearLayoutTabCustomControl=(LinearLayout)findViewById(R.id.LinearLayoutTabCustomControl);
      //  LinearLayoutTabControl=(LinearLayout)findViewById(R.id.LinearLayoutTabControl);
        ImageButtonTab1=(ImageButton)  findViewById(R.id.ImageButtonTab1);
        ImageButtonTab2=(ImageButton)  findViewById(R.id.ImageButtonTab2);
        ImageButtonTab3=(ImageButton)  findViewById(R.id.ImageButtonTab3);
        ImageButtonTab4=(ImageButton)  findViewById(R.id.ImageButtonTab4);
        ImageButtonTab5=(ImageButton)  findViewById(R.id.ImageButtonTab5);
       // Ghi=(Button)findViewById(R.id.GHI);
        //animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        SetTabOff(tabon);
        switch (view.getId()){
            case  R.id.ImageButtonTab1:
            {
                ImageButtonTab1.setImageResource(R.drawable.ghichep);
                tabHost.setCurrentTab(0);
            }break;
            case R.id.ImageButtonTab2:
            {
                ImageButtonTab2.setImageResource(R.drawable.butchi);
                tabHost.setCurrentTab(1);
            }break;
            case R.id.ImageButtonTab3:{
                ImageButtonTab3.setImageResource(R.drawable.thongke);
                tabHost.setCurrentTab(2);
            }break;
            case R.id.ImageButtonTab4:{
                ImageButtonTab4.setImageResource(R.drawable.vi);

                tabHost.setCurrentTab(3);
             break;
            }

            case R.id.ImageButtonTab5:{
                ImageButtonTab5.setImageResource(R.drawable.ghichep);
                tabHost.setCurrentTab(4);

            }

        }
        tabon=tabHost.getCurrentTab();
    }
    private void SetTabOff(int tab){
        switch (tab){
            case 0:{
                ImageButtonTab1.setImageResource(R.drawable.ghichep_khongmau);
            } break;
            case 1:{
                ImageButtonTab2.setImageResource(R.drawable.butchi_khongmau);
            } break;
            case 2:{
                ImageButtonTab3.setImageResource(R.drawable.thongke_khongmau);
            } break;
            case 3:{
                ImageButtonTab4.setImageResource(R.drawable.vi_khongmau);
            }
            break;

            case 4:{
                ImageButtonTab5.setImageResource(R.drawable.ghichep_khongmau);
            }

        }
    }
    // set tabhost gồm 4 tab
    private void SetTabHost(){
        tabHost = getTabHost();

        TabHost.TabSpec ThuTien = tabHost.newTabSpec("thu chi");
        ThuTien.setIndicator("thu chi");
        Intent ThuChiactivity = new Intent(this,GhiChepActivity.class);
        ThuTien.setContent(ThuChiactivity);

        TabHost.TabSpec ChiTien = tabHost.newTabSpec("chi tiền");
        ChiTien.setIndicator("chi tiền");
        Intent ThongKeactivity = new Intent(this,ChiTienActivity.class);
        ChiTien.setContent(ThongKeactivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));


        TabHost.TabSpec TaiKhoanSpec = tabHost.newTabSpec("tai khoan");
        TaiKhoanSpec.setIndicator("tài khoản");
        Intent TaiKhoanactivity = new Intent(this,TaiKhoanActivityMain.class);
        TaiKhoanSpec.setContent(TaiKhoanactivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));




        TabHost.TabSpec CaiDatSpec = tabHost.newTabSpec("cai dat");
        CaiDatSpec.setIndicator("cài đặt");
        Intent CaiDatactivity = new Intent(this, BaoCaoActivity.class);
        CaiDatSpec.setContent(CaiDatactivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        TabHost.TabSpec Bosung = tabHost.newTabSpec("bosung ");
        Bosung.setIndicator("bổ sung");
        Intent ThongKe = new Intent(this, ThongKeActivity.class);
        Bosung.setContent(ThongKe.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

        tabHost.addTab(ThuTien);
        tabHost.addTab(ChiTien);
        tabHost.addTab(TaiKhoanSpec);

        tabHost.addTab(CaiDatSpec);
        tabHost.addTab(Bosung);

    }


}