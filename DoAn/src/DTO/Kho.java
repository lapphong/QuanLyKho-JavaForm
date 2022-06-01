
package DTO;

import java.io.Serializable;
import java.util.Date;


public class Kho implements Serializable{
    String maSP,tenSP,maLoai;
    Date ngayNhap;
    String sl,dongia,giaxuat;

    public Kho() {
        
    }

    public String getGiaxuat() {
        return giaxuat;
    }

    public void setGiaxuat(String giaxuat) {
        this.giaxuat = giaxuat;
    }
    
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    
    
    
}
