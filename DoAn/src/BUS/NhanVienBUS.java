
package BUS;
import DAO.NhanVienDAO;
import DTO.NhanVien;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhanVienBUS {
    public static ArrayList<NhanVien> lsk;
    NhanVienDAO data;
    public void DocNV(){
        data = new NhanVienDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListNV();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (NhanVien s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaNV(), s.getTenNV(),s.getGioitinh(), s.getChucvu(),s.getCMND(),s.getDiaChi()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        NhanVien s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaNV(), s.getTenNV(),s.getGioitinh(), s.getChucvu(),s.getCMND(),s.getDiaChi()  });
    }
    
    public boolean KiemTraTrungMaNV(String maso)
    {
        int sl = lsk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lsk.get(i).getMaNV().equals(maso))
                return false;
        }
        return true;
    }
    public boolean ThemNV(NhanVien sp) throws SQLException{
        NhanVienDAO data=new NhanVienDAO();
        if(sp.getMaNV().equals("")||sp.getTenNV().equals("") || sp.getCMND().equals("") || sp.getDiaChi().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListNV();
        
        for(NhanVien x: lsk)
            if(x.getMaNV().equals(sp.getMaNV())){
               JOptionPane.showMessageDialog(null,"MÃ NV đã tồn tại"); 
               return false;
            }
        
        if(data.addNV(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaNV(NhanVien sp) throws SQLException{      
        if(data.removeNV(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    public boolean SuaNV(NhanVien sp) throws SQLException{
        if(sp.getMaNV().equals("")||sp.getTenNV().equals("") || sp.getGioitinh().equals("") || sp.getChucvu().equals("") || sp.getCMND().equals("") || sp.getDiaChi().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateNV(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
    
}
