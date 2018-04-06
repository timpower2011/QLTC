package com.example.dainguyen.qltc.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dainguyen.qltc.Class.HoatDong;
import com.example.dainguyen.qltc.R;

import java.util.ArrayList;


public class ArrayAdapterHoatDong extends android.widget.ArrayAdapter{
    public static String RESULT_AB ="result_ab";
    private Context context;

    private  int resource;
    private ArrayList<HoatDong> arrContact;
    public ArrayAdapterHoatDong (@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<HoatDong> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrContact=objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.lichsugiaodich_columd,parent,false);

        TextView txt_tieude= (TextView) convertView.findViewById(R.id.txt_tieude);
        TextView txt_mucchi= (TextView) convertView.findViewById(R.id.txt_mucchi);
        TextView txt_sotien= (TextView) convertView.findViewById(R.id.txt_sotien);
        TextView  txtngay= (TextView) convertView.findViewById(R.id.txtngay);


        final HoatDong contact= arrContact.get(position);

        txt_tieude.setText(contact.getHoatDong());
        txt_mucchi.setText(contact.getLiDo());
        txt_sotien.setText(contact.getSoTien());
        int ngay= contact.getNgay();
        int thang=contact.getThang();
        int nam=contact.getNam();
        txtngay.setText(ngay+"/"+thang+"/"+nam);

        return convertView;




    }
}

