
package DAO;
import DTO.NCC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class NCCDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public NCCDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Tutorial;"
                    + "username=sa;password=123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addNCC(NCC s){
        String sql = "INSERT INTO tblNCC(maNCC,tenNCC) "
                + "VALUES(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaNCC());
            ps.setString(2, s.getTenNCC());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean removeNCC(NCC id){
        String sql = "DELETE FROM tblNCC where maNCC=?" ;
         try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id.getMaNCC());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Xóa thành công !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
    }
     
    public boolean UpdateNCC(NCC s){
        String sql="update tblNCC set tenNCC=? where maNCC=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(2, s.getMaNCC());
            ps.setString(1, s.getTenNCC());
           
            int a=ps.executeUpdate();
            if(a>0)
                JOptionPane.showMessageDialog(null, "Edit thành công !");
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<NCC> getListNCC(){// đọc ra
        ArrayList<NCC> list = new ArrayList<>();
        String sql = "SELECT * FROM tblNCC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NCC s = new NCC();
                s.setMaNCC(rs.getString("maNCC"));
                s.setTenNCC(rs.getString("tenNCC"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     
    
}
