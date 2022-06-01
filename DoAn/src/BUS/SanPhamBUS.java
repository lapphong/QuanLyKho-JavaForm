
package BUS;
import DAO.SanPhamDAO;
import DTO.SanPham;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SanPhamBUS {
    public static ArrayList<SanPham> lssp;
    SanPhamDAO data;
    
    public void DocSP(){
        data = new SanPhamDAO();
        if(lssp==null) 
            lssp=new ArrayList();
        lssp=data.getListSP();
//        for(int i=0;i<lssp.size();i++){
//            System.out.println("Mã loại ở LSPBUS:"+lssp.get(i).getMaloai());
//        }
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (SanPham s : lssp) {
            tbl.addRow(new Object[]{
                s.getMaSP(), s.getTenSP(),s.getMaNCC(),s.getMaLoai()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        SanPham s=lssp.get(lssp.size()-1);
        tbl.addRow(new Object[]{ s.getMaSP(), s.getTenSP(),s.getMaNCC(),s.getMaLoai() });
    }
    
    public boolean KiemTraTrungMaSP(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getMaSP().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean KiemTraTrungTenSP(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getTenSP().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean KiemTraTrungMaLoai(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getMaLoai().equals(maso))
                return false;
        }
        return true;
    }
    
     public boolean ThemSP(SanPham sp) throws SQLException{
        SanPhamDAO data=new SanPhamDAO();
        if(sp.getMaSP().equals("")||sp.getTenSP().equals("") || sp.getMaNCC().equals("") || sp.getMaLoai().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        for(SanPham x: lssp)
            if(x.getMaSP().equals(sp.getMaSP())){
               JOptionPane.showMessageDialog(null,"MÃ SP đã tồn tại"); 
               return false;
            }
        
        if(data.addSP(sp)==false)
            return false;
        lssp.add(sp);
        return true;
    }
     
     public boolean XoaSP(SanPham sp) throws SQLException{      
        if(data.removeSP(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lssp.remove(i);
    }
    
    public boolean SuaSP(SanPham sp) throws SQLException{
        if(sp.getMaSP().equals("")||sp.getTenSP().equals("") || sp.getMaNCC().equals("") || sp.getMaLoai().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateSP(sp)==true){   
           lssp.add(sp);
            return true;
        }
        return false;
    }
    
}
