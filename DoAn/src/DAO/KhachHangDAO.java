
package DAO;
import DTO.KhachHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KhachHangDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public KhachHangDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addKH(KhachHang s){
        String sql = "INSERT INTO tblKH(maKH,tenKH,diaChi,SDT) "
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaKH());
            ps.setString(2, s.getTenKH());
            ps.setString(3, s.getDiaChi());
            ps.setString(4, s.getSDT());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeKH(KhachHang id){
        String sql = "DELETE FROM tblKH where maKH=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaKH());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }
    
    public boolean UpdateKH(KhachHang s){
        String sql="update tblKH set tenKH=?,diaChi=?,SDT=? where maKH=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(4, s.getMaKH());
            ps.setString(1, s.getTenKH());
            ps.setString(2, s.getDiaChi());
            ps.setString(3, s.getSDT());
           
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<KhachHang> getListKH(){// đọc ra
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM tblKH";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang s = new KhachHang();
                s.setMaKH(rs.getString("maKH"));
                s.setTenKH(rs.getString("tenKH"));
                s.setDiaChi(rs.getString("diaChi"));
                s.setSDT(rs.getString("SDT"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
