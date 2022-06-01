
package DAO;
import DTO.CTPhieuXuat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CTPhieuXuatDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CTPhieuXuatDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addCTPhieuXuat(CTPhieuXuat s){
        String sql = "INSERT INTO tblCTPhieuXuat(maPX,maSP,maKH,soluong,dongia,thanhtien) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaPX());
            ps.setString(2, s.getMaSP());
            ps.setString(3, s.getMaKH());
            ps.setString(4, s.getSoluong());
            ps.setString(5, s.getDongia());
            ps.setString(6, s.getThanhtien());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeCTPhieuXuat(CTPhieuXuat id) throws SQLException{
        String sql = "DELETE FROM tblCTPhieuXuat where maPX=? AND maSP=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaPX());
            ps.setString(2, id.getMaSP());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       
    public boolean UpdateCTPhieuXuat(CTPhieuXuat s){
        String sql="update tblCTPhieuXuat set soluong=?,dongia=?,thanhtien=? where maPX=? AND maSP=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(4, s.getMaPX());
            ps.setString(5, s.getMaSP());
            
            ps.setString(1, s.getSoluong());
            ps.setString(2, s.getDongia());
            ps.setString(3, s.getThanhtien());
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<CTPhieuXuat> getListCTPhieuXuat(){// đọc ra
        ArrayList<CTPhieuXuat> list = new ArrayList<>();
        String sql = "SELECT * FROM tblCTPhieuXuat";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuXuat s=new CTPhieuXuat();
                s.setMaPX(rs.getString("maPX"));
                s.setMaSP(rs.getString("maSP"));
                s.setMaKH(rs.getString("maKH"));
                s.setSoluong(rs.getString("soluong"));
                s.setDongia(rs.getString("dongia"));
                s.setThanhtien(rs.getString("thanhtien"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<CTPhieuXuat> ThongKeSPDaBan(){
        ArrayList<CTPhieuXuat> dshd=new ArrayList<CTPhieuXuat>();
        try {           
            String query="SELECT maSP,SUM(CAST(soluong as int)) from tblCTPhieuXuat GROUP BY maSP";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuXuat hddto=new CTPhieuXuat();
                hddto.setMaPX(rs.getString(1));
                hddto.setTk1(rs.getString(2));
  
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Lỗi đọc");
        }
        return dshd;
    }
    
    public ArrayList<CTPhieuXuat> ThongKeDoanhThuSPDaBan(){
        ArrayList<CTPhieuXuat> dshd=new ArrayList<CTPhieuXuat>();
        try {           
            String query="SELECT SUM(CAST(thanhtien as int)) from tblCTPhieuXuat";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuXuat hddto=new CTPhieuXuat();
                hddto.setTk2(rs.getString(1));
  
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Lỗi đọc");
        }
        return dshd;
    }
}
