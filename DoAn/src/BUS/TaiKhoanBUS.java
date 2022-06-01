
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanBUS {
    public static ArrayList<TaiKhoan> lstk;
    TaiKhoanDAO data;
    public void DocTaiKhoan(){
        data = new TaiKhoanDAO();
        if(lstk==null) 
            lstk=new ArrayList();
        lstk=data.getListTaiKhoan();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (TaiKhoan s : lstk) {
            tbl.addRow(new Object[]{
                s.getId(), s.getMaQuyen(), s.getMaNV(), s.getUsername(), s.getPassword()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        TaiKhoan s=lstk.get(lstk.size()-1);
        tbl.addRow(new Object[]{ s.getId(), s.getMaQuyen(), s.getMaNV(), s.getUsername(), s.getPassword() });
    }
    
    public boolean KiemTraTrungMaNV(String maso)
    {
        int sl = lstk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lstk.get(i).getMaNV().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean KiemTraTrungID(String maso)
    {
        int sl = lstk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lstk.get(i).getId().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemTK(TaiKhoan sp) throws SQLException{
        TaiKhoanDAO data=new TaiKhoanDAO();
        if(sp.getId().equals("")||sp.getMaQuyen().equals("") || sp.getMaNV().equals("") || sp.getUsername().equals("")||sp.getPassword().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lstk==null)
            lstk=data.getListTaiKhoan();
        
        for(TaiKhoan x: lstk)
            if(x.getMaNV().equals(sp.getMaNV())){
               JOptionPane.showMessageDialog(null,"MÃ NV đã tồn tại"); 
               return false;
            }
        
        if(data.addTK(sp)==false)
            return false;
        lstk.add(sp);
        return true;
    }
    
    public boolean XoaTK(TaiKhoan sp) throws SQLException{      
        if(data.removeTK(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lstk.remove(i);
    }
    
    
    public boolean SuaTK(TaiKhoan sp) throws SQLException{
        if(sp.getMaQuyen().equals("") || sp.getMaNV().equals("") || sp.getUsername().equals("")||sp.getPassword().equals("")){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateTK(sp)==true){   
           lstk.add(sp);
            return true;
        }
        return false;
    }
    
}
