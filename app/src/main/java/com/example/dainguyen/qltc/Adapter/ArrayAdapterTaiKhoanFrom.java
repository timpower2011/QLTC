package com.example.dainguyen.qltc.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dainguyen.qltc.Class.TaiKhoan;
import com.example.dainguyen.qltc.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;




public class ArrayAdapterTaiKhoanFrom  extends android.widget.ArrayAdapter{
    public static String RESULT_AB ="result_ab";
    private Context context;

    private  int resource;
    private ArrayList<TaiKhoan> arrContact;
    public ArrayAdapterTaiKhoanFrom (@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<TaiKhoan> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrContact=objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.danhsachtaikhoan_columd,parent,false);
        ImageView imgHinhMinhHoa =(ImageView) convertView.findViewById(R.id.imgHinhMinhHoa);
        TextView txtSoTien= (TextView) convertView.findViewById(R.id.txtSoTien);
        TextView txtTenTaiKhoan= (TextView) convertView.findViewById(R.id.txtTenTaiKhoan);



        final TaiKhoan contact= arrContact.get(position);
        //TaiKhoan contact= arrContact.get(position); // lấy ra vi tri thuoc tinh trog array

        //tv_color.setBackgroundColor(contact.getColor());
        //tv_color.setText((position+1)+"");
        String TenTaiKhoan=contact.getLoaitaikhoan();
        txtTenTaiKhoan.setText(TenTaiKhoan);
        txtSoTien.setText(contact.getSotien());

        if(TenTaiKhoan.equals("Tiền mặt")){
            imgHinhMinhHoa.setImageResource(R.drawable.tienmat);
        }
        else if(TenTaiKhoan.equals("Tài khoản ngân hàng ")){
            imgHinhMinhHoa.setImageResource(R.drawable.taikhoannganhang);
        }
        else if(TenTaiKhoan.equals("Thẻ tín dụng")){
            imgHinhMinhHoa.setImageResource(R.drawable.atm);
        }
        else if(TenTaiKhoan.equals("Tài khoản đầu tư")){
            imgHinhMinhHoa.setImageResource(R.drawable.taikhoandautu);
        }
        else if(TenTaiKhoan.equals("Tài khoản tiết kiệm")){
            imgHinhMinhHoa.setImageResource(R.drawable.heo);
        }
        else if(TenTaiKhoan.equals("Khác")){
            imgHinhMinhHoa.setImageResource(R.drawable.khac);
        }



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int IdTaiKhoan=contact.getIdtaikhoan();
                String SO = String.valueOf(IdTaiKhoan);
                Intent intent = new Intent();
                intent.putExtra(RESULT_AB, SO);
                ((Activity)v.getContext()).setResult(RESULT_OK, intent);
                ((Activity)v.getContext()).finish();

            }
        });

        return convertView;




    }
}

