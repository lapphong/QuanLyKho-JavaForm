
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhachHangBUS {
    public static ArrayList<KhachHang> lssp;
    KhachHangDAO data;
    
    public void DocKH(){
        data = new KhachHangDAO();
        if(lssp==null) 
            lssp=new ArrayList();
        lssp=data.getListKH();
//        for(int i=0;i<lssp.size();i++){
//            System.out.println("Mã loại ở LSPBUS:"+lssp.get(i).getMaloai());
//        }
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (KhachHang s : lssp) {
            tbl.addRow(new Object[]{
                s.getMaKH(), s.getTenKH(),s.getDiaChi(),s.getSDT()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        KhachHang s=lssp.get(lssp.size()-1);
        tbl.addRow(new Object[]{ s.getMaKH(), s.getTenKH(),s.getDiaChi(),s.getSDT() });
    }
    
    public boolean KiemTraTrungMaKH(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getMaKH().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemKH(KhachHang sp) throws SQLException{
        KhachHangDAO data=new KhachHangDAO();
        if(sp.getMaKH().equals("")||sp.getTenKH().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        
        if(data.addKH(sp)==false)
            return false;
        lssp.add(sp);
        return true;
    }
    
    public boolean XoaKH(KhachHang sp) throws SQLException{      
        if(data.removeKH(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lssp.remove(i);
    }
    
    public boolean SuaTTKH(KhachHang sp) throws SQLException{
         if(sp.getMaKH().equals("")||sp.getTenKH().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateKH(sp)==true){   
           lssp.add(sp);
            return true;
        }
        return false;
    }
    
}
