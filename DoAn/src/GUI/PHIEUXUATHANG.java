/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.CTPhieuXuatBUS;
import BUS.KhachHangBUS;
import BUS.KhoBUS;
import BUS.NCCBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuXuatBUS;
import BUS.SanPhamBUS;
import DTO.CTPhieuXuat;
import DTO.PhieuXuat;
import DTO.KhachHang;
import DTO.Kho;
import DTO.NCC;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import DTO.WritePDF;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;  

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 *
 * @author DELL
 */
public class PHIEUXUATHANG extends javax.swing.JDialog {
    DefaultTableModel model,model1;
    PhieuXuatBUS bus;
    CTPhieuXuatBUS ctbus;
    /**
     * Creates new form LoaiSPForm
     */
    private HomeForm home;
    public PHIEUXUATHANG(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        bus=new PhieuXuatBUS();
        bus.DocPX();
        ctbus=new CTPhieuXuatBUS();
        ctbus.DocCTPX();
        model =(DefaultTableModel)tblPhieuXuat.getModel();
        bus.showTable(model);
        model1 =(DefaultTableModel)tbl_CTPX.getModel();
        ctbus.showTable(model1);
        
        loadcmbMaNV();
        loadcmbMaSP();
        loadcmbMaKH();
        loadcmbMaPX_CTPX();
        txtDonGia_CTPX.setEditable(false);
    }   
    
    public void loadcmbMaNV(){
        DefaultComboBoxModel monv=new DefaultComboBoxModel();
        NhanVienBUS bus=new NhanVienBUS();
        bus.DocNV();
        for(NhanVien dto: NhanVienBUS.lsk){
            monv.addElement(dto.getMaNV());
        }
        cmbMaNV.setModel(monv);
    }
    public void loadcmbMaSP(){
        DefaultComboBoxModel mosp=new DefaultComboBoxModel();
        //SanPhamBUS bus=new SanPhamBUS();
        KhoBUS khob=new KhoBUS();
        khob.DocKho();
        for(Kho dto: khob.lsk){
            mosp.addElement(dto.getMaSP());
        }
        cmbMaSP_CTPX.setModel(mosp);
    }
    
    public void loadcmbMaKH(){
        DefaultComboBoxModel mdkh=new DefaultComboBoxModel();
        KhachHangBUS bus=new KhachHangBUS();
        bus.DocKH();
        for(KhachHang kh: KhachHangBUS.lssp)
            mdkh.addElement(kh.getMaKH());
        cmbMaKH_CTPX.setModel(mdkh);
    }
    public void loadcmbMaPX_CTPX(){
        DefaultComboBoxModel moma = new DefaultComboBoxModel();
        PhieuXuatBUS bus=new PhieuXuatBUS();
        bus.DocPX();
        for(PhieuXuat p: PhieuXuatBUS.lsk)
        {
            moma.addElement(p.getMaPX());           
        }
        cmbMaPX_CTPX.setModel(moma);
    }
    
    public void CapNhatCongSoLuongSanPhamTrongKho(String other){
        try {
            Kho a=new Kho();
            KhoBUS bkho=new KhoBUS();
            a=bkho.TimTheoMa(cmbMaSP_CTPX.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())+Integer.parseInt(other)));

            bkho.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void CapNhatTruSoLuongSanPhamTrongKho(String other){
        try {
            Kho a=new Kho();
            KhoBUS bkho=new KhoBUS();
            a=bkho.TimTheoMa(cmbMaSP_CTPX.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())-Integer.parseInt(other)));
            bkho.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void CapNhatSuaSoLuongSanPhamTrongKho(String pre,String after){
        try {
            Kho a=new Kho();
            KhoBUS bus=new KhoBUS();
            a=bus.TimTheoMa(cmbMaSP_CTPX.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())+Integer.parseInt(pre)-Integer.parseInt(after)));
            bus.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        cmbMaNV = new javax.swing.JComboBox<>();
        btnThemPX = new javax.swing.JButton();
        btnSuaPX = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnLoadDSPX = new javax.swing.JButton();
        btnXoaPX = new javax.swing.JButton();
        btnXuatPDF_PX = new javax.swing.JButton();
        btnXuatExcel_PX = new javax.swing.JButton();
        btnDocExcel_PX = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiemDSPX = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnThemCTPX = new javax.swing.JButton();
        btnXoaCTPX = new javax.swing.JButton();
        btnSuaCTPX = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDonGia_CTPX = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSoluong_CTPX = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtThanhTien_CTPX = new javax.swing.JTextField();
        cmbMaSP_CTPX = new javax.swing.JComboBox<>();
        btnLoadCTPX = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbMaKH_CTPX = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTimKiem_CTPX = new javax.swing.JTextField();
        btnTim_CTPX = new javax.swing.JButton();
        cmbMaPX_CTPX = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmbThongKe = new javax.swing.JComboBox<>();
        btnThongKe = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cmbTimKiemNangCao = new javax.swing.JComboBox<>();
        btnTimKiemNangCao = new javax.swing.JButton();
        btnXuatPDF_CTPX = new javax.swing.JButton();
        btnXuatExcel_CTPX = new javax.swing.JButton();
        btnDocExcel_CTPX = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuXuat = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_CTPX = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN PHIẾU XUẤT HÀNG");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Mã PX");

        txtMaPX.setPreferredSize(new java.awt.Dimension(6, 27));

        jLabel4.setText("Ngày nhập");

        jLabel5.setText("Mã NV");

        txtNgay.setPreferredSize(new java.awt.Dimension(6, 27));

        cmbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaNV.setPreferredSize(new java.awt.Dimension(64, 27));
        cmbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPX, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        btnThemPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThemPX.setText("Thêm PX");
        btnThemPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPXActionPerformed(evt);
            }
        });

        btnSuaPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        btnSuaPX.setText("Sửa PX");
        btnSuaPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPXActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Back.png"))); // NOI18N
        jButton1.setText("Trở lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLoadDSPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo.png"))); // NOI18N
        btnLoadDSPX.setText("Load DS PX");
        btnLoadDSPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDSPXActionPerformed(evt);
            }
        });

        btnXoaPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoaPX.setText("Xóa PX");
        btnXoaPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPXActionPerformed(evt);
            }
        });

        btnXuatPDF_PX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        btnXuatPDF_PX.setText("Xuất PDF");
        btnXuatPDF_PX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPDF_PXActionPerformed(evt);
            }
        });

        btnXuatExcel_PX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnXuatExcel_PX.setText("Xuất Excel");
        btnXuatExcel_PX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcel_PXActionPerformed(evt);
            }
        });

        btnDocExcel_PX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Folder.png"))); // NOI18N
        btnDocExcel_PX.setText("Đọc Excel");
        btnDocExcel_PX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocExcel_PXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXoaPX, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnLoadDSPX, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaPX, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXuatPDF_PX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXuatExcel_PX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDocExcel_PX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaPX, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(btnLoadDSPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemPX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatPDF_PX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSuaPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXuatExcel_PX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDocExcel_PX, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tìm Kiếm");

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        btnTimKiemDSPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find.png"))); // NOI18N
        btnTimKiemDSPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDSPXActionPerformed(evt);
            }
        });

        btnThemCTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThemCTPX.setText("Thêm");
        btnThemCTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTPXActionPerformed(evt);
            }
        });

        btnXoaCTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoaCTPX.setText("Xóa");
        btnXoaCTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTPXActionPerformed(evt);
            }
        });

        btnSuaCTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        btnSuaCTPX.setText("Sửa");
        btnSuaCTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTPXActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã PXH");

        jLabel8.setText("Mã SP");

        jLabel9.setText("Thành Tiền");

        jLabel10.setText("Số Lượng");
        jLabel10.setPreferredSize(new java.awt.Dimension(20, 16));

        txtSoluong_CTPX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoluong_CTPXFocusLost(evt);
            }
        });
        txtSoluong_CTPX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoluong_CTPXKeyPressed(evt);
            }
        });

        jLabel11.setText("Đơn giá");

        txtThanhTien_CTPX.setEditable(false);
        txtThanhTien_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTien_CTPXActionPerformed(evt);
            }
        });

        cmbMaSP_CTPX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaSP_CTPX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbMaSP_CTPXFocusLost(evt);
            }
        });
        cmbMaSP_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaSP_CTPXActionPerformed(evt);
            }
        });

        btnLoadCTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo.png"))); // NOI18N
        btnLoadCTPX.setText("LOAD DL");
        btnLoadCTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCTPXActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã KH");

        cmbMaKH_CTPX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Tìm kiếm");

        txtTimKiem_CTPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiem_CTPXMouseClicked(evt);
            }
        });
        txtTimKiem_CTPX.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTimKiem_CTPXInputMethodTextChanged(evt);
            }
        });
        txtTimKiem_CTPX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiem_CTPXKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem_CTPXKeyReleased(evt);
            }
        });

        btnTim_CTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find.png"))); // NOI18N
        btnTim_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTim_CTPXActionPerformed(evt);
            }
        });

        cmbMaPX_CTPX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("THỐNG KÊ");

        cmbThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê sản phẩm đã bán", "Thống kê tổng doanh thua sản phẩm đã bán", "Thống kê tiền SP phiếu xuất theo Năm,NV,Khách hàng", "Item 4" }));
        cmbThongKe.setBorder(new javax.swing.border.MatteBorder(null));

        btnThongKe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 51, 0));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3d bar chart.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel12)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("TÌM KIẾM NÂNG CAO");

        cmbTimKiemNangCao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phiếu Xuất có năm nằm trong khoảng 2019-2021", "Phiếu xuất có SP sốlượng>=50 và TổngTiền>=50 củ", " " }));

        btnTimKiemNangCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnTimKiemNangCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNangCaoActionPerformed(evt);
            }
        });

        btnXuatPDF_CTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        btnXuatPDF_CTPX.setText("Xuất PDF");
        btnXuatPDF_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPDF_CTPXActionPerformed(evt);
            }
        });

        btnXuatExcel_CTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnXuatExcel_CTPX.setText("Xuất Excel");
        btnXuatExcel_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcel_CTPXActionPerformed(evt);
            }
        });

        btnDocExcel_CTPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Folder.png"))); // NOI18N
        btnDocExcel_CTPX.setText("Đọc Excel");
        btnDocExcel_CTPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocExcel_CTPXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTimKiemNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiemNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTimKiem_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnTim_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(btnThemCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnXoaCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSuaCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLoadCTPX))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbMaSP_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMaKH_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbMaPX_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDonGia_CTPX, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(txtSoluong_CTPX)
                                            .addComponent(txtThanhTien_CTPX))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnXuatPDF_CTPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXuatExcel_CTPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDocExcel_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMaPX_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoluong_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMaSP_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(txtThanhTien_CTPX)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMaKH_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTim_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTimKiem_CTPX, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadCTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnXuatPDF_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatExcel_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDocExcel_CTPX, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(cmbTimKiemNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiemNangCao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("CHI TIẾT PHIẾU XUẤT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemDSPX, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemDSPX, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        tblPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PX", "Mã NV", "Ngày xuất"
            }
        ));
        tblPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuXuatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhieuXuat);

        tbl_CTPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PX", "Mã SP", "Mã KH", "Số lượng", "Đơn giá", "Thành Tiền"
            }
        ));
        tbl_CTPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CTPXMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_CTPX);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 347, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 326, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPXActionPerformed
        int row=tblPhieuXuat.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để xóa");
            check1=false;
        }
        if(check1==true){
            PhieuXuat std = bus.lsk.get(row);
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    bus.xoavitrids(row);
                    bus.XoaPX(std);
                    txtMaPX.setText("");
                    cmbMaNV.setSelectedIndex(0);
                    txtNgay.setText("");
                    txtMaPX.requestFocus();
                    txtMaPX.setEnabled(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.removeRow(row);
            }else {
                JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !!!");
            }
        }
    }//GEN-LAST:event_btnXoaPXActionPerformed

    private void btnThemPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPXActionPerformed
        PhieuXuat s=new PhieuXuat();
               
        boolean check=true;
        String mapx=txtMaPX.getText();
        if(!bus.KiemTraTrungMaPX(mapx)){
            JOptionPane.showMessageDialog(rootPane, "Trùng mã phiếu xuất !");
            check=false;
            txtMaPX.requestFocus();
        }
        s.setMaPX(mapx);
        s.setMaNV(cmbMaNV.getSelectedItem().toString());
               
        try {
            s.setNgayXuat(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày,\n Định dạng:dd/MM/yyyy");
            txtNgay.requestFocus();
            check=false;
        }
        
        if(check==true){
            try {
                if(bus.ThemPX(s)==true){
                    bus.showResult(model);
                    JOptionPane.showMessageDialog(rootPane, "Thêm PX thành công!");
                    loadcmbMaPX_CTPX();
                    bus.DocPX();
                    
                    txtMaPX.setText("");
                    cmbMaNV.setSelectedIndex(0);
                    
                    txtNgay.setText("");
                    txtMaPX.requestFocus();
                    txtMaPX.setEnabled(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành cong ! Chắc là sai 1 chỗ gì đó rầu");
            }
        }
    }//GEN-LAST:event_btnThemPXActionPerformed

    private void btnSuaPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPXActionPerformed
        PhieuXuat s = new PhieuXuat();
        boolean check=true;

        int row=tblPhieuXuat.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để sủa");
            check1=false;
        }
        if(check1==true){
            s.setMaPX(txtMaPX.getText());
            
            s.setMaNV(cmbMaNV.getSelectedItem().toString());
            try {
                s.setNgayXuat(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày,\n Định dạng:dd/MM/yyyy");
                txtNgay.requestFocus();
                check=false;
            }
            if(check==true){
                try {
                    if(bus.SuaPX(s)==true){                       
                        bus.DocPX();
                        model.setRowCount(0);
                        bus.showTable(model);
                        txtMaPX.setText("");                       
                        cmbMaNV.setSelectedIndex(0);
                        txtNgay.setText("");
                        txtMaPX.requestFocus();
                        txtMaPX.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Edit thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnSuaPXActionPerformed

    private void btnLoadDSPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDSPXActionPerformed
        Vector a= new Vector();
        a.add("Mã PX");
        a.add("Mã NV");
        a.add("Ngày Xuất");

        model = new DefaultTableModel(a,0);
        model.setRowCount(0);
        bus.showTable(model);
        tblPhieuXuat.setModel(model);
        txtTimKiem_CTPX.setText("");
    }//GEN-LAST:event_btnLoadDSPXActionPerformed

    private void btnTimKiemDSPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDSPXActionPerformed
        String b=txtTimKiem.getText();
        boolean check=false;
        for(int i=0;i<bus.lsk.size();i++){
            if(bus.lsk.get(i).getMaPX().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lsk.get(i).getMaPX(), bus.lsk.get(i).getMaNV(), bus.lsk.get(i).getNgayXuat()
                });
                break;
            }
            else if(bus.lsk.get(i).getMaNV().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lsk.get(i).getMaPX(), bus.lsk.get(i).getMaNV(), bus.lsk.get(i).getNgayXuat()
                });
                break;
            }
        }
        if(check==false){
            JOptionPane.showMessageDialog(rootPane, "Không có Mã PX hay Mã NV trong bảng nhóe !");
            model.setRowCount(0);
        }
    }//GEN-LAST:event_btnTimKiemDSPXActionPerformed

    
    
    private void btnThemCTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTPXActionPerformed
        CTPhieuXuat s=new CTPhieuXuat();
        PhieuXuatBUS bpx = new PhieuXuatBUS();
        KhoBUS kho=new KhoBUS();
        bpx.DocPX();
        
        boolean check=true;
        String dg=txtDonGia_CTPX.getText();
        String sl=txtSoluong_CTPX.getText();
        float tt=Float.parseFloat(dg)*Float.parseFloat(sl);

        s.setMaPX(cmbMaPX_CTPX.getSelectedItem().toString());
        s.setMaKH(cmbMaKH_CTPX.getSelectedItem().toString());
        s.setMaSP(cmbMaSP_CTPX.getSelectedItem().toString());
        s.setDongia(dg);
        s.setSoluong(sl);
        s.setThanhtien(txtThanhTien_CTPX.getText());
        
        if(check==true){
            try {
                if(ctbus.ThemCTPX(s)==true){
                    ctbus.showResult(model1);
                    JOptionPane.showMessageDialog(rootPane, "Thêm CTPX thành công!");
                                      
                    ctbus.DocCTPX();
                    bpx.DocPX();
                    kho.DocKho();
                    CapNhatTruSoLuongSanPhamTrongKho(txtSoluong_CTPX.getText());
                    kho.DocKho();
                    cmbMaPX_CTPX.setSelectedIndex(0);
                    cmbMaSP_CTPX.setSelectedIndex(0);
                    cmbMaKH_CTPX.setSelectedIndex(0);
                    txtDonGia_CTPX.setText("");
                    txtSoluong_CTPX.setText("");
                    txtThanhTien_CTPX.setText("");   
                    cmbMaPX_CTPX.setEnabled(true);
                    cmbMaSP_CTPX.setEnabled(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành cong ! Chắc là sai 1 chỗ gì đó rầu");
            }
        }
    }//GEN-LAST:event_btnThemCTPXActionPerformed

    private void btnXoaCTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTPXActionPerformed
        int i=tbl_CTPX.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Chọn dòng để xóa");
            return;
        }
        else{
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa ?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    CTPhieuXuat ctpx=new CTPhieuXuat();
                    PhieuXuatBUS bpx=new PhieuXuatBUS();
                    KhoBUS kho=new KhoBUS();
                    ctpx.setMaPX(cmbMaPX_CTPX.getSelectedItem().toString());
                    ctpx.setMaSP(cmbMaSP_CTPX.getSelectedItem().toString());
                    ctpx.setSoluong(txtSoluong_CTPX.getText());
                                        
                    if(ctbus.XoaCTPX(ctpx)==true){
                        for(int j=0;j<ctbus.lsk.size();++j){
                            if(ctbus.lsk.get(j).getMaPX().equals(ctpx.getMaPX()) && ctbus.lsk.get(j).getMaSP().equals(ctpx.getMaSP()))
                                ctbus.xoavitrids(j);
                            }
                        ctbus.DocCTPX();
                        bpx.DocPX();
                        kho.DocKho();

                        CapNhatCongSoLuongSanPhamTrongKho(txtSoluong_CTPX.getText());
                        
                        cmbMaPX_CTPX.setSelectedIndex(0);
                        cmbMaSP_CTPX.setSelectedIndex(0);
                        cmbMaKH_CTPX.setSelectedIndex(0);
                        txtDonGia_CTPX.setText("");
                        txtSoluong_CTPX.setText("");
                        txtThanhTien_CTPX.setText(""); 
                        cmbMaPX_CTPX.setEnabled(true);
                        cmbMaSP_CTPX.setEnabled(true);
                    }
                    model1.removeRow(i);
                } catch (Exception ex) {
                    Logger.getLogger(CTPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !!!");
            }
        }
    }//GEN-LAST:event_btnXoaCTPXActionPerformed

    private void btnSuaCTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTPXActionPerformed
        int i=tbl_CTPX.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Chọn dòng để xóa");
            return;
        }
        else{
            CTPhieuXuat s =new CTPhieuXuat();
            PhieuXuatBUS bpx=new PhieuXuatBUS();
            KhoBUS kho=new KhoBUS();
            bpx.DocPX();
            
            boolean check=true;           
            String dg=txtDonGia_CTPX.getText();
            String sl=txtSoluong_CTPX.getText();
            s.setMaPX(cmbMaPX_CTPX.getSelectedItem().toString());
            s.setMaKH(cmbMaKH_CTPX.getSelectedItem().toString());
            s.setMaSP(cmbMaSP_CTPX.getSelectedItem().toString());
            s.setDongia(dg);
            s.setSoluong(sl);
            s.setThanhtien(txtThanhTien_CTPX.getText());
            
            String pre_sl=ctbus.TimTheoMa(s);
            if(check==true){
                try {
                    if(ctbus.SuaCTPX(s)==true){
                        kho.DocKho();
                        CapNhatSuaSoLuongSanPhamTrongKho(pre_sl,s.getSoluong());
                        ctbus.DocCTPX();
                        bpx.DocPX();
                       
                        model1.setRowCount(0);  
                        ctbus.showTable(model1);
                        
                        txtDonGia_CTPX.setText("");
                        txtSoluong_CTPX.setText("");
                        txtThanhTien_CTPX.setText("");
                        cmbMaPX_CTPX.setSelectedIndex(0);
                        cmbMaSP_CTPX.setSelectedIndex(0);
                        cmbMaKH_CTPX.setSelectedIndex(0);
                        cmbMaPX_CTPX.setEnabled(true);
                        cmbMaSP_CTPX.setEnabled(true);
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(PHIEUXUATHANG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }           
        }
    }//GEN-LAST:event_btnSuaCTPXActionPerformed

    private void txtThanhTien_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTien_CTPXActionPerformed

    }//GEN-LAST:event_txtThanhTien_CTPXActionPerformed

    private void btnLoadCTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCTPXActionPerformed
        Vector a= new Vector();
        a.add("Mã PX");
        a.add("Mã SP");
        a.add("Mã KH");
        a.add("Số lượng");
        a.add("Đơn giá");
        a.add("Thành tiền");
        model1 = new DefaultTableModel(a,0);
        model1.setRowCount(0);
        ctbus.showTable(model1);
        tbl_CTPX.setModel(model1);
        txtTimKiem_CTPX.setText("");
        cmbMaPX_CTPX.setEnabled(true);
        cmbMaSP_CTPX.setEnabled(true);
    }//GEN-LAST:event_btnLoadCTPXActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        txtMaPX.setText("");
        
        cmbMaNV.setSelectedIndex(0);
        txtNgay.setText("");
        txtMaPX.setEnabled(true);
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtSoluong_CTPXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoluong_CTPXKeyPressed
        int tong;
        String gia=txtDonGia_CTPX.getText();
        String sl=txtSoluong_CTPX.getText();
        KhoBUS khob=new KhoBUS();
        khob.DocKho();

        try {
            for(Kho dto: khob.lsk)
            {
                if(dto.getMaSP().equals(cmbMaSP_CTPX.getSelectedItem().toString()))
                {
                    String s2=dto.getSl();
                    int slK=Integer.parseInt(s2);
                    if(Integer.parseInt(sl)>slK)
                    {
                        JOptionPane.showMessageDialog(null,"Số lượng chỉ còn lại: "+slK);
                        txtSoluong_CTPX.requestFocus();
                        return;
                    }
                }
            }
            tong=Integer.parseInt(gia) * Integer.parseInt(sl);
        
            if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                txtThanhTien_CTPX.setText(Integer.toString(tong));
            }           
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtSoluong_CTPXKeyPressed

    private void cmbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMaNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int comfirmed=JOptionPane.showConfirmDialog(null,
        "Bạn muốn trở lại","Exit program message box",
        JOptionPane.YES_OPTION);
        if(comfirmed==JOptionPane.YES_OPTION)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTim_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTim_CTPXActionPerformed
        String b=txtTimKiem_CTPX.getText();
        boolean check=false;
        for(int i=0;i<ctbus.lsk.size();i++){
            if(ctbus.lsk.get(i).getMaPX().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model1.setRowCount(0);
                model1.addRow(new Object[]{
                    ctbus.lsk.get(i).getMaPX(), ctbus.lsk.get(i).getMaSP(), ctbus.lsk.get(i).getMaKH(), ctbus.lsk.get(i).getDongia(), ctbus.lsk.get(i).getSoluong(), ctbus.lsk.get(i).getThanhtien()
                });
                break;
            }
            else if(ctbus.lsk.get(i).getMaSP().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model1.setRowCount(0);
                model1.addRow(new Object[]{
                    ctbus.lsk.get(i).getMaPX(), ctbus.lsk.get(i).getMaSP(), ctbus.lsk.get(i).getMaKH(), ctbus.lsk.get(i).getDongia(), ctbus.lsk.get(i).getSoluong(), ctbus.lsk.get(i).getThanhtien()
                });
                break;
            }
            else if(ctbus.lsk.get(i).getMaKH().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model1.setRowCount(0);
                model1.addRow(new Object[]{
                    ctbus.lsk.get(i).getMaPX(), ctbus.lsk.get(i).getMaSP(), ctbus.lsk.get(i).getMaKH(), ctbus.lsk.get(i).getDongia(), ctbus.lsk.get(i).getSoluong(), ctbus.lsk.get(i).getThanhtien()
                });
                break;
            }           
        }
        if(check==false){
            JOptionPane.showMessageDialog(rootPane, "Không có Mã PX,Mã NV hay Mã KH trong bảng nhóe !");
            model.setRowCount(0);
        }
    }//GEN-LAST:event_btnTim_CTPXActionPerformed

    private void cmbMaSP_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaSP_CTPXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMaSP_CTPXActionPerformed

    private void cmbMaSP_CTPXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbMaSP_CTPXFocusLost
        KhoBUS khob=new KhoBUS();
        khob.DocKho();
        for(Kho dto: khob.lsk){
            if(dto.getMaSP().equals(cmbMaSP_CTPX.getSelectedItem().toString()))
            {
                txtDonGia_CTPX.setText(dto.getGiaxuat().toString());
                txtSoluong_CTPX.requestFocus();
                break;
            }
        }       
    }//GEN-LAST:event_cmbMaSP_CTPXFocusLost

    private void txtSoluong_CTPXFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoluong_CTPXFocusLost
        
    }//GEN-LAST:event_txtSoluong_CTPXFocusLost

    private void tblPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuXuatMouseClicked
        int row=tblPhieuXuat.getSelectedRow();
        txtMaPX.setText(tblPhieuXuat.getModel().getValueAt(row, 0).toString());
        txtMaPX.setEnabled(false);
        cmbMaNV.setSelectedItem(tblPhieuXuat.getValueAt(row, 1).toString());
        txtNgay.setText(tblPhieuXuat.getModel().getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblPhieuXuatMouseClicked

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiem_CTPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiem_CTPXMouseClicked
        txtDonGia_CTPX.setText("");
        txtSoluong_CTPX.setText("");
        txtThanhTien_CTPX.setText("");      
        cmbMaPX_CTPX.setEnabled(true);
        cmbMaSP_CTPX.setEnabled(true);
    }//GEN-LAST:event_txtTimKiem_CTPXMouseClicked

    private void txtTimKiem_CTPXKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem_CTPXKeyPressed
        
    }//GEN-LAST:event_txtTimKiem_CTPXKeyPressed

    private void tbl_CTPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CTPXMouseClicked
        int row=tbl_CTPX.getSelectedRow();
        cmbMaPX_CTPX.setSelectedItem(tbl_CTPX.getValueAt(row, 0).toString());
        cmbMaSP_CTPX.setSelectedItem(tbl_CTPX.getValueAt(row, 1).toString());
        cmbMaKH_CTPX.setSelectedItem(tbl_CTPX.getValueAt(row, 2).toString());
        txtSoluong_CTPX.setText(tbl_CTPX.getValueAt(row, 3).toString());
        txtDonGia_CTPX.setText(tbl_CTPX.getValueAt(row, 4).toString());
        txtThanhTien_CTPX.setText(tbl_CTPX.getValueAt(row, 5).toString());
        cmbMaPX_CTPX.setEnabled(false);
        cmbMaSP_CTPX.setEnabled(false);
    }//GEN-LAST:event_tbl_CTPXMouseClicked

    private void txtTimKiem_CTPXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem_CTPXKeyReleased
       
    }//GEN-LAST:event_txtTimKiem_CTPXKeyReleased

    private void txtTimKiem_CTPXInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTimKiem_CTPXInputMethodTextChanged
        
    }//GEN-LAST:event_txtTimKiem_CTPXInputMethodTextChanged

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        String chon=cmbThongKe.getSelectedItem().toString();       
        if(chon.equals("Thống kê sản phẩm đã bán")){
            CTPhieuXuatBUS pxbus=new CTPhieuXuatBUS();
            ArrayList<CTPhieuXuat> a=new ArrayList<CTPhieuXuat>();
            a=pxbus.ThongKeSPdaBan();
            Vector he= new Vector();
            he.add("Mã sản phẩm");
            he.add("Số lượng sản phẩm đã bán");
            model1 = new DefaultTableModel(he,0);
            for(int i=0;i<a.size();++i){
                Vector r=new Vector();
                r.add(a.get(i).getMaPX());
                r.add(a.get(i).getTk1());
                model1.addRow(r);
            }
            tbl_CTPX.setModel(model1);
        }
        else if(chon.equals("Thống kê tổng doanh thua sản phẩm đã bán"))
        {
            CTPhieuXuatBUS pxbus=new CTPhieuXuatBUS();
            ArrayList<CTPhieuXuat> a=new ArrayList<CTPhieuXuat>();
            a=pxbus.ThongKeDoanhThuSPDaBan();
            Vector he= new Vector();
            he.add("Tổng doanh thu sản phẩm đã bán");
            model1 = new DefaultTableModel(he,0);
            for(int i=0;i<a.size();++i){
                Vector r=new Vector();
                r.add(a.get(i).getTk2());
                model1.addRow(r);
            }
            tbl_CTPX.setModel(model1);
        }
        else if(chon.equals("Thống kê tiền SP phiếu xuất theo Năm,NV,Khách hàng")){
            PhieuXuatBUS pxbus=new PhieuXuatBUS();
            ArrayList<PhieuXuat> a=new ArrayList<PhieuXuat>();
            a=pxbus.thongkehd4tc();
            Vector he= new Vector();
            he.add("Mã SP");
            he.add("Mã NV");
            he.add("Mã KH");
            he.add("Thành Tiền");
            he.add("Năm");
            model1 = new DefaultTableModel(he,0);
            for(int i=0;i<a.size();++i){
                Vector r=new Vector();
                r.add(a.get(i).getMaPX());
                r.add(a.get(i).getMaNV());
                r.add(a.get(i).getA());
                r.add(a.get(i).getB());
                r.add(a.get(i).getC());
                
                model1.addRow(r);
            }
            tbl_CTPX.setModel(model1);
        }
        
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnTimKiemNangCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNangCaoActionPerformed
        PhieuXuatBUS bus=new PhieuXuatBUS();
        CTPhieuXuatBUS buss=new CTPhieuXuatBUS();
        ArrayList<PhieuXuat> a=new ArrayList<>();
        ArrayList<CTPhieuXuat> ctpx=new ArrayList<>();
        String chon=cmbTimKiemNangCao.getSelectedItem().toString();
        if(chon.equals("Phiếu Xuất có năm nằm trong khoảng 2019-2021"))
        {
            a=bus.TimKiemPXTrongKhoangXY();
            if(a!=null){
                Vector b= new Vector();
                b.add("Mã PX");
                b.add("Mã NV");
                b.add("Ngày Xuất");
                model = new DefaultTableModel(b,0);
                for(PhieuXuat dto: a){
                    Vector r=new Vector();
                    r.add(dto.getMaPX());
                    r.add(dto.getMaNV());
                    r.add(dto.getNgayXuat());

                    model.addRow(r);
                }
                tblPhieuXuat.setModel(model);
            }
        }
        else if(chon.equals("Phiếu xuất có SP sốlượng>=50 và TổngTiền>=50 củ")){
            ctpx=buss.TimPXLonHonXvaTTLonHonY();
            if(ctpx!=null){
                Vector b= new Vector();
                b.add("Mã PX");
                b.add("Mã SP");
                b.add("Số lượng");
                b.add("Tổng tiền");
                model1=new DefaultTableModel(b,0);
                for(CTPhieuXuat dto: ctpx){
                    Vector r=new Vector();
                    r.add(dto.getMaPX());
                    r.add(dto.getMaSP());
                    r.add(dto.getSoluong());
                    r.add(dto.getThanhtien());

                    model1.addRow(r);
                }
                tbl_CTPX.setModel(model1);
            }
        }
        
    }//GEN-LAST:event_btnTimKiemNangCaoActionPerformed

    private void btnXuatExcel_PXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcel_PXActionPerformed
         WritableWorkbook wordbook;

        try{
            wordbook = Workbook.createWorkbook(new File("PhieuXuat.xls"));
            WritableSheet sheet=wordbook.createSheet("PhieuXuat", 0);

            sheet.addCell(new Label(0,0,"Mã PX"));
            sheet.addCell(new Label(1,0,"Mã NV"));
            sheet.addCell(new Label(2,0,"Ngày Xuất"));

          
            int row=1;
            for(PhieuXuat kh : PhieuXuatBUS.lsk){
                sheet.addCell(new Label(0,row,kh.getMaPX()));
                sheet.addCell(new Label(1,row,kh.getMaNV()));
                sheet.addCell(new Label(2,row++,kh.getNgayXuat().toString()));
            }

            wordbook.write();
            wordbook.close();
            JOptionPane.showMessageDialog(null,"Xuất thành công");
        } catch (IOException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatExcel_PXActionPerformed

    private void btnXuatExcel_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcel_CTPXActionPerformed
        WritableWorkbook wordbook;

        try{
            wordbook = Workbook.createWorkbook(new File("CTPhieuXuat.xls"));
            WritableSheet sheet=wordbook.createSheet("CTPhieuXuat", 0);

            sheet.addCell(new Label(0,0,"Mã PX"));
            sheet.addCell(new Label(1,0,"Mã SP"));
            sheet.addCell(new Label(2,0,"Mã KH"));
            sheet.addCell(new Label(3,0,"Số lượng"));
            sheet.addCell(new Label(4,0,"Đơn giá"));
            sheet.addCell(new Label(5,0,"Thành tiền"));
          
            int row=1;
            for(CTPhieuXuat kh : CTPhieuXuatBUS.lsk){
                sheet.addCell(new Label(0,row,kh.getMaPX()));
                sheet.addCell(new Label(1,row,kh.getMaSP()));
                sheet.addCell(new Label(2,row,kh.getMaKH()));
                sheet.addCell(new Label(3,row,kh.getSoluong()));
                sheet.addCell(new Label(4,row,kh.getDongia()));
                sheet.addCell(new Label(5,row++,kh.getThanhtien()));
            }

            wordbook.write();
            wordbook.close();
            JOptionPane.showMessageDialog(null,"Xuất thành công");
        } catch (IOException ex) {
            Logger.getLogger(CTPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(CTPhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatExcel_CTPXActionPerformed

    private void btnDocExcel_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocExcel_CTPXActionPerformed
        model1.setRowCount(0);
        Workbook wordbook;
        JFileChooser jc=new JFileChooser();
        int vv=jc.showOpenDialog(jLabel7);
        if(vv==0){
            File link=jc.getSelectedFile();
            try{
                wordbook=Workbook.getWorkbook(link);
                Sheet sheet=wordbook.getSheet(0);
                int row=sheet.getRows();
                int col=sheet.getColumns();

                for(int i=1;i<row;++i){
                    Vector r=new Vector();
                    for(int j=0;j<col;++j)
                    {
                        Cell cell=sheet.getCell(j, i);
                        r.add(cell.getContents());
                    }
                    model1.addRow(r);
                }
                tbl_CTPX.setModel(model1);
                wordbook.close();
            }
            catch (IOException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BiffException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDocExcel_CTPXActionPerformed

    private void btnDocExcel_PXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocExcel_PXActionPerformed
        model.setRowCount(0);
        Workbook wordbook;
        JFileChooser jc=new JFileChooser();
        int vv=jc.showOpenDialog(jLabel2);
        if(vv==0){
            File link=jc.getSelectedFile();
            try{
                wordbook=Workbook.getWorkbook(link);
                Sheet sheet=wordbook.getSheet(0);
                int row=sheet.getRows();
                int col=sheet.getColumns();

                for(int i=1;i<row;++i){
                    Vector r=new Vector();
                    for(int j=0;j<col;++j)
                    {
                        Cell cell=sheet.getCell(j, i);
                        r.add(cell.getContents());
                    }
                    model.addRow(r);
                }
                tblPhieuXuat.setModel(model);
                wordbook.close();
            }
            catch (IOException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BiffException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDocExcel_PXActionPerformed

    private void btnXuatPDF_PXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPDF_PXActionPerformed
        new WritePDF().xuatPDF(tblPhieuXuat);
    }//GEN-LAST:event_btnXuatPDF_PXActionPerformed

    private void btnXuatPDF_CTPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPDF_CTPXActionPerformed
        new WritePDF().xuatPDF(tbl_CTPX);
    }//GEN-LAST:event_btnXuatPDF_CTPXActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PHIEUXUATHANG dialog = new PHIEUXUATHANG(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDocExcel_CTPX;
    private javax.swing.JButton btnDocExcel_PX;
    private javax.swing.JButton btnLoadCTPX;
    private javax.swing.JButton btnLoadDSPX;
    private javax.swing.JButton btnSuaCTPX;
    private javax.swing.JButton btnSuaPX;
    private javax.swing.JButton btnThemCTPX;
    private javax.swing.JButton btnThemPX;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiemDSPX;
    private javax.swing.JButton btnTimKiemNangCao;
    private javax.swing.JButton btnTim_CTPX;
    private javax.swing.JButton btnXoaCTPX;
    private javax.swing.JButton btnXoaPX;
    private javax.swing.JButton btnXuatExcel_CTPX;
    private javax.swing.JButton btnXuatExcel_PX;
    private javax.swing.JButton btnXuatPDF_CTPX;
    private javax.swing.JButton btnXuatPDF_PX;
    private javax.swing.JComboBox<String> cmbMaKH_CTPX;
    private javax.swing.JComboBox<String> cmbMaNV;
    private javax.swing.JComboBox<String> cmbMaPX_CTPX;
    private javax.swing.JComboBox<String> cmbMaSP_CTPX;
    private javax.swing.JComboBox<String> cmbThongKe;
    private javax.swing.JComboBox<String> cmbTimKiemNangCao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPhieuXuat;
    private javax.swing.JTable tbl_CTPX;
    private javax.swing.JTextField txtDonGia_CTPX;
    private javax.swing.JTextField txtMaPX;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoluong_CTPX;
    private javax.swing.JTextField txtThanhTien_CTPX;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem_CTPX;
    // End of variables declaration//GEN-END:variables
}
