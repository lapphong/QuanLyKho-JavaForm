
package DAO;
import DTO.SanPham;
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

public class SanPhamDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public SanPhamDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addSP(SanPham s){
        String sql = "INSERT INTO tblSP(maSP,tenSP,maNCC,maLoai) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSP());
            ps.setString(2, s.getTenSP());
            ps.setString(3, s.getMaNCC());
            ps.setString(4, s.getMaLoai());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeSP(SanPham id)throws SQLException{
        String sql = "DELETE FROM tblSP where maSP=?" ;
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
    
    public boolean UpdateSP(SanPham s){
        String sql="update tblSP set tenSP=?,maNCC=?,maLoai=? where maSP=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(4, s.getMaSP());
            
            ps.setString(1, s.getTenSP());
            ps.setString(2, s.getMaNCC());
            ps.setString(3, s.getMaLoai());
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<SanPham> getListSP(){// đọc ra
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM tblSP";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SanPham s = new SanPham();
                s.setMaSP(rs.getString("maSP"));
                s.setTenSP(rs.getString("tenSP"));
                s.setMaNCC(rs.getString("maNCC"));
                s.setMaLoai(rs.getString("maLoai"));
               
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
