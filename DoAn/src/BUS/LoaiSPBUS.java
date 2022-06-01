/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.LoaiSPDAO;
import DTO.LoaiSP;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class LoaiSPBUS {
    public static ArrayList<LoaiSP> lssp;
    LoaiSPDAO data;
    
    public void DocLoaiSP(){
        data = new LoaiSPDAO();
        if(lssp==null) 
            lssp=new ArrayList();
        lssp=data.getListLoaiSP();
//        for(int i=0;i<lssp.size();i++){
//            System.out.println("Mã loại ở LSPBUS:"+lssp.get(i).getMaloai());
//        }
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (LoaiSP s : lssp) {
            tbl.addRow(new Object[]{
                s.getMaloai(), s.getTenloai()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        LoaiSP s=lssp.get(lssp.size()-1);
        tbl.addRow(new Object[]{ s.getMaloai(), s.getTenloai() });
    }
    
    public boolean KiemTraTrungMaLoai(String maso)
    {
        int sl = lssp.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lssp.get(i).getMaloai().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemLoaiSP(LoaiSP sp) throws SQLException{
        LoaiSPDAO data=new LoaiSPDAO();
        if(sp.getMaloai().equals("")||sp.getTenloai().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        for(LoaiSP x: lssp)
            if(x.getMaloai().equals(sp.getMaloai())){
               JOptionPane.showMessageDialog(null,"MÃ Loại SP đã tồn tại"); 
               return false;
            }
        
        if(data.addLoaiSP(sp)==false)
            return false;
        lssp.add(sp);
        return true;
    }
    
    public boolean XoaLoai(LoaiSP sp) throws SQLException{      
        if(data.removeLoaiSP(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lssp.remove(i);
    }
    
    public boolean SuaLoai(LoaiSP sp) throws SQLException{
        if(sp.getMaloai().equals("") || sp.getTenloai().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateLoaiSP(sp)==true){   
           lssp.add(sp);
            return true;
        }
        return false;
    }
}
