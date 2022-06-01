
package BUS;
import DAO.CTPhieuXuatDAO;
import DTO.CTPhieuXuat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CTPhieuXuatBUS {
    public static ArrayList<CTPhieuXuat> lsk;
    CTPhieuXuatDAO data;
    public void DocCTPX(){
        data = new CTPhieuXuatDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListCTPhieuXuat();
    }
    public void showTable(DefaultTableModel tbl) {
        for (CTPhieuXuat s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaPX(),s.getMaSP(),s.getMaKH(),s.getSoluong(),s.getDongia(),s.getThanhtien()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        CTPhieuXuat s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaPX(),s.getMaSP(),s.getMaKH(),s.getSoluong(),s.getDongia(),s.getThanhtien() });
    }
    
    public boolean ThemCTPX(CTPhieuXuat sp) throws SQLException{
        CTPhieuXuatDAO data=new CTPhieuXuatDAO();
        if(sp.getMaSP().equals("")||sp.getMaPX().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListCTPhieuXuat();
        
        
        if(data.addCTPhieuXuat(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaCTPX(CTPhieuXuat sp) throws SQLException {      
        if(data.removeCTPhieuXuat(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    public boolean SuaCTPX(CTPhieuXuat sp) throws SQLException{
        if(sp.getMaSP().equals("")||sp.getMaPX().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateCTPhieuXuat(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
    
    public String TimTheoMa(CTPhieuXuat dto){
        if(lsk==null)
            DocCTPX();
        for(CTPhieuXuat x: lsk){
            if(x.getMaSP().equals(dto.getMaSP()))
                return x.getSoluong();
        }
        return "0";
    }
    
    public ArrayList ThongKeSPdaBan(){
        ArrayList a=new ArrayList();
        CTPhieuXuatDAO dao=new CTPhieuXuatDAO();
        a=dao.ThongKeSPDaBan();
        return a;
    }
    
    public ArrayList ThongKeDoanhThuSPDaBan(){
        ArrayList a=new ArrayList();
        CTPhieuXuatDAO dao=new CTPhieuXuatDAO();
        a=dao.ThongKeDoanhThuSPDaBan();
        return a;
    }
    
    public ArrayList TimPXLonHonXvaTTLonHonY(){
        ArrayList<CTPhieuXuat> tmp=new ArrayList<CTPhieuXuat>();

       try {
           if(lsk==null)
               DocCTPX();

           for(CTPhieuXuat px:lsk){
               int  sl=Integer.parseInt(px.getSoluong());
               int tt=Integer.parseInt(px.getThanhtien());
               
               if(sl>= 50 && tt >= 50000000){
                   tmp.add(px);
               }
           }

       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return tmp;
    }
    
    
}
