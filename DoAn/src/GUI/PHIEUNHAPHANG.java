/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.CTPhieuNhapBUS;
import BUS.KhoBUS;
import BUS.NCCBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.CTPhieuNhap;
import DTO.Kho;
import DTO.NCC;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.SanPham;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class PHIEUNHAPHANG extends javax.swing.JDialog {
    DefaultTableModel model,model1;
    PhieuNhapBUS bus;
    CTPhieuNhapBUS ctbus;
    /**
     * Creates new form LoaiSPForm
     */
    private HomeForm home;
    public PHIEUNHAPHANG(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home=(HomeForm) parent;
        bus=new PhieuNhapBUS();
        bus.DocPN();
        ctbus=new CTPhieuNhapBUS();
        ctbus.DocCTPN();
        model =(DefaultTableModel)tblPhieuNhap.getModel();
        bus.showTable(model);
        model1 =(DefaultTableModel)tblCTPhieuNhap.getModel();
        ctbus.showTable(model1);
        loadcmbMaNCC();
        loadcmbMaNV();
        loadMaSP_CT();
    }

    public void loadcmbMaNCC(){
        DefaultComboBoxModel mocb=new DefaultComboBoxModel();
        NCCBUS bus=new NCCBUS();
        bus.DocNCC();
        for(NCC dto: NCCBUS.lsk){
            mocb.addElement(dto.getMaNCC());
        }
        cmbMaNCC.setModel(mocb);
    }
    
    public void loadcmbMaNV(){
        DefaultComboBoxModel mocb=new DefaultComboBoxModel();
        NhanVienBUS bus=new NhanVienBUS();
        bus.DocNV();
        for(NhanVien dto: NhanVienBUS.lsk){
            mocb.addElement(dto.getMaNV());
        }
        cmbMaNV.setModel(mocb);
    }
    
    public void loadMaSP_CT(){
        DefaultComboBoxModel mdsp=new DefaultComboBoxModel();
        SanPhamBUS bus=new SanPhamBUS();
        bus.DocSP();
        for(SanPham sp: SanPhamBUS.lssp)
            mdsp.addElement(sp.getMaSP());
        cmbMaSP_CT.setModel(mdsp);
    }
    
    public void CapNhatCongSoLuongSanPhamTrongKho(){
        try {
            Kho a=new Kho();
            KhoBUS bus=new KhoBUS();
            a=bus.TimTheoMa(cmbMaSP_CT.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())+Integer.parseInt(txtSoluong.getText())));

            bus.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void CapNhatTruSoLuongSanPhamTrongKho(String a1){
        try {
            Kho a=new Kho();
            KhoBUS bus=new KhoBUS();
            a=bus.TimTheoMa(cmbMaSP_CT.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())-Integer.parseInt(a1)));
            bus.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void CapNhatSuaSoLuongSanPhamTrongKho(String a1,String a2){
        try {
            Kho a=new Kho();
            KhoBUS bus=new KhoBUS();
            a=bus.TimTheoMa(cmbMaSP_CT.getSelectedItem().toString());
            a.setSl(String.valueOf(Integer.parseInt(a.getSl())+Integer.parseInt(a2)-Integer.parseInt(a1)));
            bus.SuaSanPham2(a);
        } catch (SQLException ex) {
            Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(Level.SEVERE, null, ex);
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
        txtMaPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        cmbMaNCC = new javax.swing.JComboBox<>();
        cmbMaNV = new javax.swing.JComboBox<>();
        btnXoaPN = new javax.swing.JButton();
        btnThemPN = new javax.swing.JButton();
        btnSuaPN = new javax.swing.JButton();
        btnLoadDSPN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiemDSPN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTPhieuNhap = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnThemCTPhieuNhap = new javax.swing.JButton();
        btnXoaCT = new javax.swing.JButton();
        btnSuaCT = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaPN_CT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        cmbMaSP_CT = new javax.swing.JComboBox<>();
        btnLoadDLCT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN PHIẾU NHẬP HÀNG");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Mã PNH");

        txtMaPN.setPreferredSize(new java.awt.Dimension(6, 27));

        jLabel3.setText("Mã NCC");

        jLabel4.setText("Ngày nhập");

        jLabel5.setText("Mã NV");

        txtNgay.setPreferredSize(new java.awt.Dimension(6, 27));

        cmbMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaNCC.setPreferredSize(new java.awt.Dimension(64, 27));
        cmbMaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaNCCActionPerformed(evt);
            }
        });

        cmbMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaNV.setPreferredSize(new java.awt.Dimension(64, 27));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnXoaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoaPN.setText("Xóa PN");
        btnXoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPNActionPerformed(evt);
            }
        });

        btnThemPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThemPN.setText("Thêm PN");
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });

        btnSuaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        btnSuaPN.setText("Sửa PN");
        btnSuaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPNActionPerformed(evt);
            }
        });

        btnLoadDSPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo.png"))); // NOI18N
        btnLoadDSPN.setText("Load DS PN");
        btnLoadDSPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDSPNActionPerformed(evt);
            }
        });

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

        btnTimKiemDSPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find.png"))); // NOI18N
        btnTimKiemDSPN.setText("Tìm kiếm");
        btnTimKiemDSPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDSPNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadDSPN, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemDSPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemPN, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnXoaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTimKiemDSPN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PNH", "Mã NCC", "Mã NV", "Ngày nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        tblCTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PNH", "Mã SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTPhieuNhap);

        btnThemCTPhieuNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThemCTPhieuNhap.setText("Thêm chi tiết");
        btnThemCTPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTPhieuNhapActionPerformed(evt);
            }
        });

        btnXoaCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoaCT.setText("Xóa chi tiết");
        btnXoaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTActionPerformed(evt);
            }
        });

        btnSuaCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        btnSuaCT.setText("Sửa chi tiết");
        btnSuaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã PNH");

        jLabel8.setText("Mã SP");

        jLabel9.setText("Thành Tiền");

        txtDonGia.setEditable(false);

        jLabel10.setText("Số Lượng");
        jLabel10.setPreferredSize(new java.awt.Dimension(20, 16));

        txtSoluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoluongKeyPressed(evt);
            }
        });

        jLabel11.setText("Đơn giá");

        txtThanhTien.setEditable(false);
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        cmbMaSP_CT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaSP_CT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbMaSP_CTFocusLost(evt);
            }
        });

        btnLoadDLCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo.png"))); // NOI18N
        btnLoadDLCT.setText("LOAD DL");
        btnLoadDLCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDLCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btnThemCTPhieuNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaCT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadDLCT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMaSP_CT, 0, 103, Short.MAX_VALUE)
                    .addComponent(txtMaPN_CT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(205, 205, 205))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCTPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadDLCT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaPN_CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMaSP_CT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 497, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cmbMaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMaNCCActionPerformed

    private void btnXoaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPNActionPerformed
        int row=tblPhieuNhap.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để sủa");
            check1=false;
        }
        if(check1==true){
            PhieuNhap std = bus.lsk.get(row);
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    bus.xoavitrids(row);
                    bus.XoaPN(std);
                    txtMaPN.setText("");
                    cmbMaNCC.setSelectedIndex(0);
                    cmbMaNV.setSelectedIndex(0);
                    txtNgay.setText("");
                    txtMaPN.requestFocus();
                    txtMaPN.setEnabled(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                model.removeRow(row);
            }else {
                JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !!!");
            }
        }
    }//GEN-LAST:event_btnXoaPNActionPerformed

    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed
        PhieuNhap s=new PhieuNhap();
        PhieuNhapBUS bus=new PhieuNhapBUS();
        
        boolean check=true;
        String mapn=txtMaPN.getText();
        if(!bus.KiemTraTrungMaPN(mapn)){
            JOptionPane.showMessageDialog(rootPane, "Trùng mã phiếu nhập !");
            check=false;
            txtMaPN.requestFocus();
        }
        s.setMaPN(mapn);
        s.setMaNCC(cmbMaNCC.getSelectedItem().toString());
        s.setMaNV(cmbMaNV.getSelectedItem().toString());
        try {
            s.setNgayNhap(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày,\n Định dạng:dd/MM/yyyy");
            txtNgay.requestFocus();
            check=false;
        }
        
        if(check==true){
            try {
                if(bus.ThemPN(s)==true){
                    bus.showResult(model);
                    JOptionPane.showMessageDialog(rootPane, "Thêm PN thành công!");
                    bus.DocPN();
                    
                    txtMaPN.setText("");
                    cmbMaNCC.setSelectedIndex(0);
                    cmbMaNV.setSelectedIndex(0);
                    txtNgay.setText("");
                    txtMaPN.requestFocus();
                    txtMaPN.setEnabled(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành cong ! Chắc là sai 1 chỗ gì đó rầu");
            }
        }
    }//GEN-LAST:event_btnThemPNActionPerformed

    private void btnSuaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPNActionPerformed
        PhieuNhap s = new PhieuNhap();
        boolean check=true;

        int row=tblPhieuNhap.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để sủa");
            check1=false;
        }
        if(check1==true){
            s.setMaPN(txtMaPN.getText());
            s.setMaNCC(cmbMaNCC.getSelectedItem().toString());
            s.setMaNV(cmbMaNV.getSelectedItem().toString());
            try {
                s.setNgayNhap(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgay.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày,\n Định dạng:dd/MM/yyyy");
                txtNgay.requestFocus();
                check=false;
            }
            if(check==true){
                try {
                    if(bus.SuaPN(s)==true){
                        model.setRowCount(0);
                        bus.DocPN();
                        bus.showTable(model);
                        txtMaPN.setText("");
                        cmbMaNCC.setSelectedIndex(0);
                        cmbMaNV.setSelectedIndex(0);
                        txtNgay.setText("");
                        txtMaPN.requestFocus();
                        txtMaPN.setEnabled(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Edit thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnSuaPNActionPerformed

    private void btnLoadDSPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDSPNActionPerformed
        model.setRowCount(0);
        bus.showTable(model);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLoadDSPNActionPerformed

    private void btnTimKiemDSPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDSPNActionPerformed
        String b=txtTimKiem.getText();
        boolean check=false;
        for(int i=0;i<bus.lsk.size();i++){
            if(bus.lsk.get(i).getMaPN().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lsk.get(i).getMaPN(), bus.lsk.get(i).getMaNCC(), bus.lsk.get(i).getMaNV(), bus.lsk.get(i).getNgayNhap()
                });
                break;
            }
            else if(bus.lsk.get(i).getMaNV().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lsk.get(i).getMaPN(), bus.lsk.get(i).getMaNCC(), bus.lsk.get(i).getMaNV(), bus.lsk.get(i).getNgayNhap()
                });
                break;
            }
        }
        if(check==false){
            JOptionPane.showMessageDialog(rootPane, "Không có MãPN hay MãNV trong bảng nhóe !");
            model.setRowCount(0);
        }
    }//GEN-LAST:event_btnTimKiemDSPNActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row=tblPhieuNhap.getSelectedRow();
        txtMaPN.setText(tblPhieuNhap.getModel().getValueAt(row, 0).toString());
        txtMaPN.setEnabled(false);
        cmbMaNCC.setSelectedItem(tblPhieuNhap.getValueAt(row, 1).toString());
        cmbMaNV.setSelectedItem(tblPhieuNhap.getValueAt(row, 2).toString());
        txtNgay.setText(tblPhieuNhap.getModel().getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void tblCTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuNhapMouseClicked
        int row=tblCTPhieuNhap.getSelectedRow();
        txtMaPN_CT.setText(tblCTPhieuNhap.getModel().getValueAt(row, 0).toString());
        cmbMaSP_CT.setSelectedItem(tblCTPhieuNhap.getValueAt(row, 1).toString());
        txtDonGia.setText(tblCTPhieuNhap.getModel().getValueAt(row, 3).toString());
        txtSoluong.setText(tblCTPhieuNhap.getModel().getValueAt(row, 2).toString());
        txtThanhTien.setText(tblCTPhieuNhap.getModel().getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblCTPhieuNhapMouseClicked

    private void btnThemCTPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTPhieuNhapActionPerformed
        CTPhieuNhap s=new CTPhieuNhap();
        PhieuNhapBUS pn=new PhieuNhapBUS();
        KhoBUS kho=new KhoBUS();
        pn.DocPN();
        
        boolean check=true;
        String mapn=txtMaPN_CT.getText();
        if(pn.KiemTraTrungMaPN(mapn)==true){
            check=false;
            JOptionPane.showMessageDialog(rootPane, "Mã PN ko tồn tại");
            txtMaPN_CT.requestFocus();
        }
        s.setMaPN(mapn);
        
        s.setMaSP(cmbMaSP_CT.getSelectedItem().toString());
        s.setDongia(txtDonGia.getText());
        s.setSoluong(txtSoluong.getText());
        s.setThanhtien(txtThanhTien.getText());
        
        if(check==true){
            try {
                if(ctbus.ThemCTPN(s)==true){
                    ctbus.showResult(model1);
                    JOptionPane.showMessageDialog(rootPane, "Thêm CTPN thành công!");
                    
                    
                    ctbus.DocCTPN();
                    pn.DocPN();
                    kho.DocKho();
                    CapNhatCongSoLuongSanPhamTrongKho();
                    txtMaPN_CT.setText("");
                    txtDonGia.setText("");
                    txtSoluong.setText("");
                    txtThanhTien.setText("");
                    cmbMaSP_CT.setSelectedIndex(0);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành cong ! Chắc là sai 1 chỗ gì đó rầu");
            }
        }
    }//GEN-LAST:event_btnThemCTPhieuNhapActionPerformed

    private void btnXoaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTActionPerformed
        int i=tblCTPhieuNhap.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Chọn dòng để xóa");
            return;
        }
        else{
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    CTPhieuNhap cthddto=new CTPhieuNhap();
                    PhieuNhapBUS pn=new PhieuNhapBUS();
                    KhoBUS kho=new KhoBUS();
                    cthddto.setMaSP(cmbMaSP_CT.getSelectedItem().toString());
                    cthddto.setMaPN(txtMaPN_CT.getText());
                    cthddto.setSoluong(txtSoluong.getText());
                    if(ctbus.XoaCTPN(cthddto)==true){
                        for(int j=0;j<ctbus.lsk.size();++j){
                            if(ctbus.lsk.get(j).getMaPN().equals(cthddto.getMaPN()) && ctbus.lsk.get(j).getMaSP().equals(cthddto.getMaSP()))
                                ctbus.xoavitrids(j);
                            }
                        ctbus.DocCTPN();
                        pn.DocPN();
                        kho.DocKho();

                        CapNhatTruSoLuongSanPhamTrongKho(txtSoluong.getText());
                        txtMaPN_CT.setText("");
                        txtDonGia.setText("");
                        txtSoluong.setText("");
                        txtThanhTien.setText("");
                        cmbMaSP_CT.setSelectedIndex(0);
                    }
                    model1.removeRow(i);
                } catch (Exception ex) {
                    Logger.getLogger(CTPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !!!");
            }
        }
    }//GEN-LAST:event_btnXoaCTActionPerformed

    private void btnSuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTActionPerformed
         int i=tblCTPhieuNhap.getSelectedRow();
        if(i<0){
            JOptionPane.showMessageDialog(null, "Chọn dòng để xóa");
            return;
        }
        else{
            CTPhieuNhap s =new CTPhieuNhap();
            PhieuNhapBUS pn=new PhieuNhapBUS();
            KhoBUS kho=new KhoBUS();
            pn.DocPN();
            
            boolean check=true;
            String mapn=txtMaPN_CT.getText();
            if(pn.KiemTraTrungMaPN(mapn)==true){
                check=false;
                JOptionPane.showMessageDialog(rootPane, "Mã PN ko tồn tại");
                txtMaPN_CT.requestFocus();
            }
            s.setMaPN(mapn);
            s.setMaSP(cmbMaSP_CT.getSelectedItem().toString());
            s.setDongia(txtDonGia.getText());
            s.setSoluong(txtSoluong.getText());
            s.setThanhtien(txtThanhTien.getText());
            
            String sl=ctbus.TimTheoMa(s);
            if(check==true){
                try {
                    if(ctbus.SuaCTPN(s)==true){
                        CapNhatSuaSoLuongSanPhamTrongKho(sl,s.getSoluong());
                        ctbus.DocCTPN();
                        pn.DocPN();
                        kho.DocKho();
                        model1.setRowCount(0);
                        ctbus.showTable(model1);
                        txtMaPN_CT.setText("");
                        txtDonGia.setText("");
                        txtSoluong.setText("");
                        txtThanhTien.setText("");
                        cmbMaSP_CT.setSelectedIndex(0);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PHIEUNHAPHANG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }//GEN-LAST:event_btnSuaCTActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed

    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnLoadDLCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDLCTActionPerformed
        model1.setRowCount(0);
        bus.showTable(model1);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLoadDLCTActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        txtMaPN.setText("");
        cmbMaNCC.setSelectedIndex(0);
        cmbMaNV.setSelectedIndex(0);
        txtNgay.setText("");
        txtMaPN.setEnabled(true);
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtSoluongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoluongKeyPressed
        int tong;
        String gia=txtDonGia.getText();
        String sl=txtSoluong.getText();
        
        try {
            tong=Integer.parseInt(gia) * Integer.parseInt(sl);
        
            if (evt.getKeyCode()==KeyEvent.VK_ENTER){
                txtThanhTien.setText(Integer.toString(tong));
            }
        } catch (java.lang.NumberFormatException ex){
            
        }
    }//GEN-LAST:event_txtSoluongKeyPressed

    private void cmbMaSP_CTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbMaSP_CTFocusLost
        KhoBUS khob=new KhoBUS();
        khob.DocKho();
        for(Kho dto: khob.lsk){
            if(dto.getMaSP().equals(cmbMaSP_CT.getSelectedItem().toString()))
            {
                txtDonGia.setText(dto.getDongia().toString());
                txtSoluong.requestFocus();
                break;
            }
        }   
    }//GEN-LAST:event_cmbMaSP_CTFocusLost

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
                PHIEUNHAPHANG dialog = new PHIEUNHAPHANG(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLoadDLCT;
    private javax.swing.JButton btnLoadDSPN;
    private javax.swing.JButton btnSuaCT;
    private javax.swing.JButton btnSuaPN;
    private javax.swing.JButton btnThemCTPhieuNhap;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnTimKiemDSPN;
    private javax.swing.JButton btnXoaCT;
    private javax.swing.JButton btnXoaPN;
    private javax.swing.JComboBox<String> cmbMaNCC;
    private javax.swing.JComboBox<String> cmbMaNV;
    private javax.swing.JComboBox<String> cmbMaSP_CT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTPhieuNhap;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaPN_CT;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
