
package DAO;
import DTO.PhieuXuat;
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

public class PhieuXuatDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public PhieuXuatDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addPhieuXuat(PhieuXuat s){
        String sql = "INSERT INTO tblPhieuXuat(maPX,maNV,ngayX) "
                + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaPX());
            ps.setString(2, s.getMaNV());
            ps.setDate(3, new Date(s.getNgayXuat().getTime()));
           
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean removePhieuXuat(PhieuXuat id)throws SQLException{
        String sql = "DELETE FROM tblPhieuXuat where maPX=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaPX());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean UpdatePhieuXuat(PhieuXuat s){
        String sql="update tblPhieuXuat set maNV=?,ngayX=? where maPX=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(3, s.getMaPX());
            
            ps.setString(1, s.getMaNV());
            ps.setDate(2, new Date(s.getNgayXuat().getTime()));

            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<PhieuXuat> getListPhieuXuat(){// đọc ra
        ArrayList<PhieuXuat> list = new ArrayList<>();
        String sql = "SELECT * FROM tblPhieuXuat";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuXuat s = new PhieuXuat();
                s.setMaPX(rs.getString("maPX"));
                s.setMaNV(rs.getString("maNV"));
                s.setNgayXuat(rs.getDate("ngayX"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     public ArrayList<PhieuXuat> thongkehd4tc(){
        ArrayList<PhieuXuat> dshd=new ArrayList<PhieuXuat>();
        try {
            String query="SELECT tblCTPhieuXuat.maSP,tblPhieuXuat.maNV,tblCTPhieuXuat.maKH,SUM(CAST(thanhtien as int)),YEAR(tblPhieuXuat.ngayX) FROM tblCTPhieuXuat,tblPhieuXuat WHERE tblCTPhieuXuat.maPX=tblPhieuXuat.maPX GROUP by tblCTPhieuXuat.maSP,tblPhieuXuat.maNV,YEAR(tblPhieuXuat.ngayX),tblCTPhieuXuat.maKH";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PhieuXuat hddto=new PhieuXuat();
                hddto.setMaPX(rs.getString(1));
                hddto.setMaNV(rs.getString(2));
                hddto.setA(rs.getString(3));
                hddto.setB(rs.getString(4));
                hddto.setC(rs.getString(5));
                dshd.add(hddto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Lỗi Đọc");
        }
        return dshd;
    }
    
}
