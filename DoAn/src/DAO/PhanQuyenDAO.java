
package DAO;
import DTO.PhanQuyen;
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

public class PhanQuyenDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public PhanQuyenDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addPhanQuyen(PhanQuyen s){
        String sql = "INSERT INTO tblPhanQuyen(ID,maQuyen,tenQuyen) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getID());
            ps.setString(2, s.getMaQuyen());
            ps.setString(3, s.getTenQuyen());
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removePhanQuyen(PhanQuyen id)throws SQLException{
        String sql = "DELETE FROM tblPhanQuyen where ID=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getID());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdatePhanQuyen(PhanQuyen s){
        String sql="update tblPhanQuyen set maQuyen=?,tenQuyen=? where ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(3, s.getID());
            
            ps.setString(1, s.getMaQuyen());
            ps.setString(2, s.getTenQuyen());
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<PhanQuyen> getListPhanQuyen(){// đọc ra
        ArrayList<PhanQuyen> list = new ArrayList<>();
        String sql = "SELECT * FROM tblPhanQuyen";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhanQuyen s = new PhanQuyen();
                s.setID(rs.getString("ID"));
                s.setMaQuyen(rs.getString("maQuyen"));
                s.setTenQuyen(rs.getString("tenQuyen"));
               
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        new PhanQuyenDAO();
    }
}
