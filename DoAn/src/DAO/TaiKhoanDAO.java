
package DAO;
import DTO.TaiKhoan;
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

public class TaiKhoanDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public TaiKhoanDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addTK(TaiKhoan s){
        String sql = "INSERT INTO tblUsers(ID, pQuyen, maNV, Username, Password) "
                + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getId());
            ps.setString(2, s.getMaQuyen());
            ps.setString(3, s.getMaNV());
            ps.setString(4, s.getUsername());
            ps.setString(5, s.getPassword());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeTK(TaiKhoan id)throws SQLException{
        String sql = "DELETE FROM tblUsers where ID=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getId());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdateTK(TaiKhoan s){
        String sql="update tblUsers set pQuyen=?,maNV=?,Username=?,Password=? where ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(5, s.getId());
            
            ps.setString(1, s.getMaQuyen());
            ps.setString(2, s.getMaNV());
            ps.setString(3, s.getUsername());
            ps.setString(4, s.getPassword());
            
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<TaiKhoan> getListTaiKhoan(){// đọc ra
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sql = "SELECT * FROM tblUsers";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiKhoan s = new TaiKhoan();
                s.setId(rs.getString("ID"));
                s.setMaQuyen(rs.getString("pQuyen"));
                s.setMaNV(rs.getString("maNV"));
                s.setUsername(rs.getString("Username"));
                s.setPassword(rs.getString("Password"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        new LoginDAO();
//    }
    
}
