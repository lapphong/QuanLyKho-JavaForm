
package DAO;

import DTO.Kho;
import DTO.TaiKhoan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class KhoDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public KhoDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addSP(Kho s){
        String sql = "INSERT INTO tblKho(maSP,tenSP,maLoai,ngay,gia,giaxuat,soluong) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSP());
            ps.setString(2, s.getTenSP());
            ps.setString(3, s.getMaLoai());
            ps.setDate(4, new Date(s.getNgayNhap().getTime()));
            ps.setString(5, s.getDongia());
            ps.setString(6, s.getGiaxuat());
            ps.setString(7, s.getSl());

            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeSP(Kho id){
        String sql = "DELETE FROM tblKho where maSP=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaSP());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }
    
    public boolean UpdateSP(Kho s){
        String sql="update tblKho set tenSP=?,maLoai=?,ngay=?,gia=?,giaxuat=?,soluong=? where maSP=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(7, s.getMaSP());
            
            ps.setString(1, s.getTenSP());
            ps.setString(2, s.getMaLoai());
            ps.setDate(3, new Date(s.getNgayNhap().getTime()));
            ps.setString(4, s.getDongia());
            ps.setString(5, s.getGiaxuat());
            ps.setString(6, s.getSl());

            
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Kho> getListKho(){// đọc ra
        ArrayList<Kho> list = new ArrayList<>();
        String sql = "SELECT * FROM tblKho";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Kho s = new Kho();
                s.setMaSP(rs.getString("maSP"));
                s.setTenSP(rs.getString("tenSP"));
                s.setMaLoai(rs.getString("maLoai"));
                s.setNgayNhap(rs.getDate("ngay"));
                s.setDongia(rs.getString("gia"));
                s.setGiaxuat(rs.getString("giaxuat"));
                s.setSl(rs.getString("soluong"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
      public boolean Sua2(Kho s){
        String sql="update tblKho set tenSP=?,maLoai=?,ngay=?,gia=?,giaxuat=?,soluong=? where maSP=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(7, s.getMaSP());
            
            ps.setString(1, s.getTenSP());
            ps.setString(2, s.getMaLoai());
            ps.setDate(3, new Date(s.getNgayNhap().getTime()));
            ps.setString(4, s.getDongia());
            ps.setString(5, s.getGiaxuat());
            ps.setString(6, s.getSl());

            
            int a=ps.executeUpdate();
            if(a>0)
                //JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
