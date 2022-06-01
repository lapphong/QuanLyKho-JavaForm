
package DTO;

import java.io.Serializable;


public class CTPhieuXuat implements Serializable{
    String maPX,maSP,maKH;
    String soluong,dongia,thanhtien;
    String tk1,tk2;

    public String getTk1() {
        return tk1;
    }

    public void setTk1(String tk1) {
        this.tk1 = tk1;
    }

    public String getTk2() {
        return tk2;
    }

    public void setTk2(String tk2) {
        this.tk2 = tk2;
    }


    public String getMaPX() {
        return maPX;
    }

    public void setMaPX(String maPX) {
        this.maPX = maPX;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    
    
    
}
