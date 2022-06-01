
package DAO;
import DTO.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NhanVienDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public NhanVienDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addNV(NhanVien s){
        String sql = "INSERT INTO tblNV(maNV,tenNV,gioiTinh,chucVu,CMND,diaChi) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaNV());
            ps.setString(2, s.getTenNV());
            ps.setString(3, s.getGioitinh());
            ps.setString(4, s.getChucvu());
            ps.setString(5, s.getCMND());
            ps.setString(6, s.getDiaChi());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removeNV(NhanVien id){
        String sql = "DELETE FROM tblNV where maNV=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaNV());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }
    
    public boolean UpdateNV(NhanVien s){
        String sql="update tblNV set tenNV=?,gioiTinh=?,chucVu=?,CMND=?,diaChi=? where maNV=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(6, s.getMaNV());
            
            ps.setString(1, s.getTenNV());
            ps.setString(2, s.getGioitinh());
            ps.setString(3, s.getChucvu());
            ps.setString(4, s.getCMND());
            ps.setString(5, s.getDiaChi());
            
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NhanVien> getListNV(){// đọc ra
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM tblNV";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien s = new NhanVien();
                s.setMaNV(rs.getString("maNV"));
                s.setTenNV(rs.getString("tenNV"));
                s.setGioitinh(rs.getString("gioiTinh"));
                s.setChucvu(rs.getString("chucVu"));
                s.setCMND(rs.getString("CMND"));
                s.setDiaChi(rs.getString("diaChi"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
