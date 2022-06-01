
package DAO;
import DTO.PhieuNhap;
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

public class PhieuNhapDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public PhieuNhapDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addPhieuNhap(PhieuNhap s){
        String sql = "INSERT INTO tblPhieuNhap(maPN,maNCC,maNV,ngayN) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaPN());
            ps.setString(2, s.getMaNCC());
            ps.setString(3, s.getMaNV());
            ps.setDate(4, new Date(s.getNgayNhap().getTime()));
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removePhieuNhap(PhieuNhap id)throws SQLException{
        String sql = "DELETE FROM tblPhieuNhap where maPN=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaPN());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdatePhieuNhap(PhieuNhap s){
        String sql="update tblPhieuNhap set maNCC=?,maNV=?,ngayN=? where maPN=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(4, s.getMaPN());
            
            ps.setString(1, s.getMaNCC());
            ps.setString(2, s.getMaNV());
            ps.setDate(3, new Date(s.getNgayNhap().getTime()));
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<PhieuNhap> getListPhieuNhap(){// đọc ra
        ArrayList<PhieuNhap> list = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuNhap";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuNhap s = new PhieuNhap();
                s.setMaPN(rs.getString("maPN"));
                s.setMaNCC(rs.getString("maNCC"));
                s.setMaNV(rs.getString("maNV"));
                s.setNgayNhap(rs.getDate("ngayN"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        new PhieuNhapDAO();
    }
}
