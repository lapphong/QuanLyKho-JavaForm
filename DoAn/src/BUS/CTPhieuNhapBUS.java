
package BUS;
import DAO.CTPhieuNhapDAO;
import DTO.CTPhieuNhap;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CTPhieuNhapBUS {
    public static ArrayList<CTPhieuNhap> lsk;
    CTPhieuNhapDAO data;
    public void DocCTPN(){
        data = new CTPhieuNhapDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListCTPhieuNhap();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (CTPhieuNhap s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaPN(),s.getMaSP(),s.getSoluong(),s.getDongia(),s.getThanhtien()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        CTPhieuNhap s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaPN(),s.getMaSP(),s.getSoluong(),s.getDongia(),s.getThanhtien() });
    }
    
    public boolean ThemCTPN(CTPhieuNhap sp) throws SQLException{
        CTPhieuNhapDAO data=new CTPhieuNhapDAO();
        if(sp.getMaSP().equals("")||sp.getMaPN().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListCTPhieuNhap();
        
        
        if(data.addCTPhieuNhap(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaCTPN(CTPhieuNhap sp) throws SQLException{      
        if(data.removeCTPhieuNhap(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    public boolean SuaCTPN(CTPhieuNhap sp) throws SQLException{
        if(sp.getMaSP().equals("")||sp.getMaPN().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateCTPhieuNhap(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
    
    public String TimTheoMa(CTPhieuNhap dto){
        if(lsk==null)
            DocCTPN();
        for(CTPhieuNhap x: lsk){
            if(x.getMaSP().equals(dto.getMaSP()))
                return x.getSoluong();
        }
        return "0";
    }
}
