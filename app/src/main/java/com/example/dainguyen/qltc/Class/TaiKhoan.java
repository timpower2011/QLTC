package com.example.dainguyen.qltc.Class;



public class TaiKhoan {

    //private variables
    int idtaikhoan;
    String tentaikhoan;
    String loaitaikhoan;
    String sotien;
    String ghichu;


    public TaiKhoan() {
    }

    public int getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public TaiKhoan(int id, String tentaikhoan, String loaitaikhoan, String sotien, String ghichu) {
        this.idtaikhoan=id;
        this.tentaikhoan = tentaikhoan;
        this.loaitaikhoan=loaitaikhoan;
        this.sotien=sotien;
        this.ghichu=ghichu;
    }

    public TaiKhoan(int idtaikhoan, String sotien) {
        this.idtaikhoan = idtaikhoan;
        this.sotien = sotien;
    }

    public TaiKhoan(int idtaikhoan) {
        this.idtaikhoan = idtaikhoan;

    }

    // constructor
    public TaiKhoan(String tentaikhoan, String loaitaikhoan, String sotien, String ghichu) {
        this.tentaikhoan = tentaikhoan;
        this.loaitaikhoan=loaitaikhoan;
        this.sotien=sotien;
        this.ghichu=ghichu;
    }

}