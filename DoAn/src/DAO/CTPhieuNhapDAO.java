
package DAO;
import DTO.CTPhieuNhap;
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


public class CTPhieuNhapDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public CTPhieuNhapDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addCTPhieuNhap(CTPhieuNhap s){
        String sql = "INSERT INTO tblCTPhieuNhap(maPN,maSP,soluong,dongia,thanhTien) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaPN());
            ps.setString(2, s.getMaSP());
            ps.setString(3, s.getSoluong());
            ps.setString(4, s.getDongia());
            ps.setString(5, s.getThanhtien());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeCTPhieuNhap(CTPhieuNhap id)throws SQLException{
        String sql = "DELETE FROM tblCTPhieuNhap where maPN=? AND maSP=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaPN());
            ps.setString(2, id.getMaSP());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdateCTPhieuNhap(CTPhieuNhap s){
        String sql="update tblCTPhieuNhap set soluong=?,dongia=?,thanhTien=? where maPN=? AND maSP=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(4, s.getMaPN());
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
    
    public ArrayList<CTPhieuNhap> getListCTPhieuNhap(){// đọc ra
        ArrayList<CTPhieuNhap> list = new ArrayList<>();
        String sql = "SELECT * FROM tblCTPhieuNhap";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CTPhieuNhap s = new CTPhieuNhap();
                s.setMaPN(rs.getString("maPN"));
                s.setMaSP(rs.getString("maSP"));
                s.setSoluong(rs.getString("soluong"));
                s.setDongia(rs.getString("dongia"));
                s.setThanhtien(rs.getString("thanhTien"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
