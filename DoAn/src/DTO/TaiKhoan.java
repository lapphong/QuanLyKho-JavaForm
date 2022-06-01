
package DTO;

import java.io.Serializable;
import java.util.Date;



public class TaiKhoan implements Serializable {
    String username, password, maNV, maQuyen,id;

//    public TaiKhoan(String username, String password, String maNV, String maQuyen, String id) {
//        this.username = username;
//        this.password = password;
//        this.maNV = maNV;
//        this.maQuyen = maQuyen;
//        this.id = id;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }
}
