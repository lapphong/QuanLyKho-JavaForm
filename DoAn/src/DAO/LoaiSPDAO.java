
package DAO;
import DTO.LoaiSP;
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

public class LoaiSPDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public LoaiSPDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addLoaiSP(LoaiSP s){
        String sql = "INSERT INTO tblLoai(maLoai,tenLoai) "
                + "VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaloai());
            ps.setString(2, s.getTenloai());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeLoaiSP(LoaiSP id)throws SQLException{
        String sql = "DELETE FROM tblLoai where maLoai=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaloai());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdateLoaiSP(LoaiSP s){
        String sql="update tblLoai set tenLoai=? where maLoai=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, s.getMaloai());
            
            ps.setString(1, s.getTenloai());
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<LoaiSP> getListLoaiSP(){// đọc ra
        ArrayList<LoaiSP> list = new ArrayList<>();
        String sql = "SELECT * FROM tblLoai";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoaiSP s = new LoaiSP();
                s.setMaloai(rs.getString("maLoai"));
                s.setTenloai(rs.getString("tenLoai"));
               
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
