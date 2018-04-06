package com.example.dainguyen.qltc.Class;


public class HoatDong {
    int id;
    String  HoatDong;
    String  SoTien;
    String LiDo;
    String DienGiai;
    String TuTaiKhoan;
    int Ngay;
    int Thang;
    int Nam;
    public HoatDong(){

    }
    public HoatDong(int id, String hoatDong, String soTien, String liDo, String dienGiai, String tuTaiKhoan, int ngay, int thang , int nam ) {
        this.id = id;
        HoatDong = hoatDong;
        SoTien = soTien;
        LiDo = liDo;
        DienGiai = dienGiai;
        TuTaiKhoan = tuTaiKhoan;
        Ngay = ngay;
        Thang = thang;
        Nam = nam;
    }
    public HoatDong( String hoatDong, String soTien, String liDo, String dienGiai, String tuTaiKhoan, int ngay, int thang , int nam ) {

        HoatDong = hoatDong;
        SoTien = soTien;
        LiDo = liDo;
        DienGiai = dienGiai;
        TuTaiKhoan = tuTaiKhoan;
        Ngay = ngay;
        Thang = thang;
        Nam = nam;
    }

    public HoatDong(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoatDong() {
        return HoatDong;
    }

    public void setHoatDong(String hoatDong) {
        HoatDong = hoatDong;
    }

    public String getSoTien() {
        return SoTien;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    public String getLiDo() {
        return LiDo;
    }

    public void setLiDo(String liDo) {
        LiDo = liDo;
    }

    public String getDienGiai() {
        return DienGiai;
    }

    public void setDienGiai(String dienGiai) {
        DienGiai = dienGiai;
    }

    public String getTuTaiKhoan() {
        return TuTaiKhoan;
    }

    public void setTuTaiKhoan(String tuTaiKhoan) {
        TuTaiKhoan = tuTaiKhoan;
    }

    public int getNgay() {
        return Ngay;
    }

    public void setNgay(int ngay) {
        Ngay = ngay;
    }

    public int getThang() {
        return Thang;
    }

    public void setThang(int thang) {
        Thang = thang;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int nam) {
        Nam = nam;
    }
}

