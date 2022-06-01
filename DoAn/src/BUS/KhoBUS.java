
package BUS;


import DAO.KhoDAO;
import DTO.Kho;
import DTO.LoaiSP;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhoBUS {
    public static ArrayList<Kho> lsk;
    KhoDAO data;
    public void DocKho(){
        data = new KhoDAO();
        if(lsk==null) 
            lsk=new ArrayList();
        lsk=data.getListKho();
    }
    
    public void showTable(DefaultTableModel tbl) {
        for (Kho s : lsk) {
            tbl.addRow(new Object[]{
                s.getMaSP(), s.getTenSP(),s.getMaLoai(), s.getNgayNhap(), s.getDongia(),s.getGiaxuat(), s.getSl()
            });
        }
    }
    
    public void showResult(DefaultTableModel tbl){
        Kho s=lsk.get(lsk.size()-1);
        tbl.addRow(new Object[]{ s.getMaSP(), s.getTenSP(),s.getMaLoai(), s.getNgayNhap(), s.getDongia(),s.getGiaxuat(), s.getSl()  });
    }
    
    public boolean KiemTraTrungMaSP(String maso)
    {
        int sl = lsk.size();
        for(int i = 0; i < sl; ++i)
        {
            if (lsk.get(i).getMaSP().equals(maso))
                return false;
        }
        return true;
    }
    
    public boolean ThemSP(Kho sp) throws SQLException{
        KhoDAO data=new KhoDAO();
        if(sp.getMaSP().equals("")||sp.getMaLoai().equals("") || sp.getNgayNhap().equals("") || sp.getTenSP().equals("")  ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
        
        if(lsk==null)
            lsk=data.getListKho();
        
        for(Kho x: lsk)
            if(x.getMaSP().equals(sp.getMaSP())){
               JOptionPane.showMessageDialog(null,"MÃ SP đã tồn tại Muốn thêm thì sửa Số lượng nhé Babe"); 
               return false;
            }
        
        try{
            sp.getSl();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Số lượng không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
        }
        
        try{
            sp.getDongia();
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Gía không hợp lệ(vui lòng nhập số nguyên dương)");
            return false;
        }
        
        if(data.addSP(sp)==false)
            return false;
        lsk.add(sp);
        return true;
    }
    
    public boolean XoaSP(Kho sp) throws SQLException{      
        if(data.removeSP(sp)==true){   
            return true;
        }
        return false;
    }
    
    public void xoavitrids(int i){
        lsk.remove(i);
    }
    
    public boolean SuaSP(Kho sp) throws SQLException{
        if(sp.getMaSP().equals("")||sp.getMaLoai().equals("") || sp.getNgayNhap().equals("") || sp.getTenSP().equals("")  ){
            JOptionPane.showMessageDialog(null,"Vui Lòng điền đầy đủ ");
            return false;
        }
            
       if(data.UpdateSP(sp)==true){   
           lsk.add(sp);
            return true;
        }
        return false;
    }
    
    public Kho TimTheoMa(String ma){
        if(lsk==null) 
            lsk=new ArrayList<Kho>();
        KhoDAO data=new KhoDAO();
        lsk=data.getListKho();
        for(Kho kh:lsk){
            if(kh.getMaSP().equals(ma)){
                return kh;
            }
        }
        return null;
    }
    
     public void SuaSanPham2(Kho sp) throws SQLException{
        KhoDAO data= new KhoDAO();
        
        KhoDAO spdao=new KhoDAO();
        
        
        LoaiSPBUS lspbus=new LoaiSPBUS();
        if(LoaiSPBUS.lssp==null)
            lspbus.DocLoaiSP();
        
        if(lsk==null) 
            lsk=new ArrayList<Kho>();
        lsk=spdao.getListKho();
        
        int pos=-1;
        for(int i=0;i<lsk.size();++i){
            if(lsk.get(i).getMaSP().equals(sp.getMaSP()))
            {
                KhoDAO dao=new KhoDAO();
                pos=i;
                lsk.get(i).setTenSP(sp.getTenSP());
                lsk.get(i).setSl(sp.getSl());
                lsk.get(i).setNgayNhap(sp.getNgayNhap());
                lsk.get(i).setDongia(sp.getDongia());
                lsk.get(i).setGiaxuat(sp.getGiaxuat());
                lsk.get(i).setMaLoai(sp.getMaLoai());;
                dao.Sua2(sp);
                break;
            }
        }
        
    }
    
}
