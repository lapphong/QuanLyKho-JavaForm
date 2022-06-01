
package BUS;
import DAO.NCCDAO;
import DTO.NCC;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NCCBUS {
    public static ArrayList<NCC> lsk;
    NCCDAO data;
    
    public void DocNCC(){
        data = new NCCDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListNCC();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (NCC s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaNCC(), s.getTenNCC()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        NCC s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaNCC(), s.getTenNCC()  });
    }
    
    public boolean KiemTraTrungMaNCC(String maso)
    {
        int sl = lsk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lsk.get(i).getMaNCC().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemNCC(NCC sp) throws SQLException{
        NCCDAO data=new NCCDAO();
        if(sp.getMaNCC().equals("")||sp.getTenNCC().equals("")  ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListNCC();
        
        for(NCC x: lsk)
            if(x.getMaNCC().equals(sp.getMaNCC())){
               JOptionPane.showMessageDialog(null,"MÃ NCC đã tồn tại "); 
               return false;
            }
        
        if(data.addNCC(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaNCC(NCC sp) throws SQLException{      
        if(data.removeNCC(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    
    public boolean SuaNCC(NCC sp) throws SQLException{
        if(sp.getMaNCC().equals("")||sp.getTenNCC().equals("")  ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateNCC(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
}
