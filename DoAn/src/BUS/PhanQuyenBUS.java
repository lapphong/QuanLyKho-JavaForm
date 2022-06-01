
package BUS;
import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PhanQuyenBUS {
     public static ArrayList<PhanQuyen> lssp;
    PhanQuyenDAO data;
    
    public void DocPhanQuyen(){
        data = new PhanQuyenDAO();
        if(lssp==null) 
            lssp=new ArrayList();
        lssp=data.getListPhanQuyen();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (PhanQuyen s : lssp) {
            tbl.addRow(new Object[]{
                s.getID(),s.getMaQuyen(), s.getTenQuyen()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        PhanQuyen s=lssp.get(lssp.size()-1);
        tbl.addRow(new Object[]{ s.getID(),s.getMaQuyen(), s.getTenQuyen()});
    }
    
    public boolean KiemTraTrungID(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getID().equals(maso))
                return false;
        }
        return true;
    }
   
    public boolean KiemTraTrungMaQuyen(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getMaQuyen().equals(maso))
                return true;
        }
        return false;
    }

    
     public boolean ThemPhanQuyen(PhanQuyen sp) throws SQLException{
        PhanQuyenDAO data=new PhanQuyenDAO();
        if(sp.getMaQuyen().equals("")||sp.getTenQuyen().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(data.addPhanQuyen(sp)==false)
            return false;
        lssp.add(sp);
        return true;
    }
    
    public boolean XoaPhanQuyen(PhanQuyen sp) throws SQLException{      
        if(data.removePhanQuyen(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lssp.remove(i);
    }
    
    public boolean SuaPhanQuyen(PhanQuyen sp) throws SQLException{
        if(sp.getMaQuyen().equals("") || sp.getTenQuyen().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdatePhanQuyen(sp)==true){   
           lssp.add(sp);
            return true;
        }
        return false;
    }
}
