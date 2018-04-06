package com.example.dainguyen.qltc.CustomLayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dainguyen.qltc.R;

public class moduleNhapText extends AppCompatActivity {
    public static String RESULT_AB ="result_ab";


EditText EditTextDescription;
   Button btnDone;
    Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edittext);
        btnDone=(Button)findViewById(R.id.btnDone);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        EditTextDescription=(EditText) findViewById(R.id.EditTextDescription);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung=EditTextDescription.getText().toString();


                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,noidung);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung="";


                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,noidung);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }



}
