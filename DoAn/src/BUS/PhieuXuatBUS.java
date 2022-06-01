/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAO.PhieuXuatDAO;
import DTO.PhieuXuat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PhieuXuatBUS {
    public static ArrayList<PhieuXuat> lsk;
    PhieuXuatDAO data;
    public void DocPX(){
        data = new PhieuXuatDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListPhieuXuat();
    }
    public void showTable(DefaultTableModel tbl) {
        for (PhieuXuat s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaPX(),s.getMaNV(),s.getNgayXuat()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        PhieuXuat s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaPX(),s.getMaNV(),s.getNgayXuat() });
    }
    public boolean KiemTraTrungMaPX(String maso)
    {
        int sl = lsk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lsk.get(i).getMaPX().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemPX(PhieuXuat sp) throws SQLException{
        PhieuXuatDAO data=new PhieuXuatDAO();
        if(sp.getMaNV().equals("")||sp.getMaPX().equals("") || sp.getNgayXuat().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListPhieuXuat();
               
        if(data.addPhieuXuat(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaPX(PhieuXuat sp) throws SQLException{      
        if(data.removePhieuXuat(sp)==true){   
            return true;
        }
        return false;
    }
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    public boolean SuaPX(PhieuXuat sp) throws SQLException{
        if(sp.getMaNV().equals("")||sp.getMaPX().equals("") || sp.getNgayXuat().equals("") ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdatePhieuXuat(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }  
    
     public ArrayList thongkehd4tc(){
        ArrayList a=new ArrayList();
        PhieuXuatDAO dao=new PhieuXuatDAO();
        a=dao.thongkehd4tc();
        return a;
    }
     
    public ArrayList TimKiemPXTrongKhoangXY(){
        ArrayList<PhieuXuat> tmp=new ArrayList<PhieuXuat>();

       try {
           if(lsk==null)
               DocPX();

           for(PhieuXuat px:lsk){
               int year=px.getNgayXuat().getYear()+1900;
               System.out.println(year);
               if(year >= 2018 && year <= 2021){
                   tmp.add(px);
               }
           }

       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return tmp;
    }
}
