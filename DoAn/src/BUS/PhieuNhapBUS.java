
package BUS;
import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PhieuNhapBUS {
    public static ArrayList<PhieuNhap> lsk;
    PhieuNhapDAO data;
    public void DocPN(){
        data = new PhieuNhapDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListPhieuNhap();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (PhieuNhap s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaPN(),s.getMaNCC(),s.getMaNV(),s.getNgayNhap()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        PhieuNhap s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaPN(),s.getMaNCC(),s.getMaNV(),s.getNgayNhap() });
    }
    
    public boolean KiemTraTrungMaPN(String maso)
    {
        int sl = lsk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lsk.get(i).getMaPN().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemPN(PhieuNhap sp) throws SQLException{
        PhieuNhapDAO data=new PhieuNhapDAO();
        if(sp.getMaNV().equals("")||sp.getMaPN().equals("") || sp.getMaNCC().equals("") || sp.getNgayNhap().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListPhieuNhap();
        
        
        if(data.addPhieuNhap(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaPN(PhieuNhap sp) throws SQLException{      
        if(data.removePhieuNhap(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    public boolean SuaPN(PhieuNhap sp) throws SQLException{
        if(sp.getMaNV().equals("")||sp.getMaPN().equals("") || sp.getMaNCC().equals("") || sp.getNgayNhap().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdatePhieuNhap(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
    
    
}
