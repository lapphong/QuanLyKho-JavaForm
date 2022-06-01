/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.KhachHangBUS;
import DTO.KhachHang;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
public class KhachHangForm extends javax.swing.JDialog {
    DefaultTableModel model;
    KhachHangBUS bus;
    /**
     * Creates new form KhoForm
     */
    private HomeForm home;
    public KhachHangForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home=(HomeForm) parent;
        bus=new KhachHangBUS();
        bus.DocKH();
        model =(DefaultTableModel)tbl.getModel();
        bus.showTable(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLoadDL = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnXuatEX = new javax.swing.JButton();
        btnDocEX = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("SĐT");

        jLabel2.setText("Mã KH");

        jLabel3.setText("Tên KH");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modify.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLoadDL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo.png"))); // NOI18N
        btnLoadDL.setText("Load DL");
        btnLoadDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDLActionPerformed(evt);
            }
        });

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exiticon.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Find.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tìm kiếm ");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "Địa chỉ", "Số điện thoại"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        btnXuatEX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/List.png"))); // NOI18N
        btnXuatEX.setText("Xuất Excel");
        btnXuatEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatEXActionPerformed(evt);
            }
        });

        btnDocEX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Folder.png"))); // NOI18N
        btnDocEX.setText("Đọc Excel");
        btnDocEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocEXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenKH)
                                    .addComponent(txtDiaChi)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXuatEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDocEX, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadDL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnXuatEX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnDocEX, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadDL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang s = new KhachHang();
        KhachHangBUS bus=new KhachHangBUS();

        boolean check=true;
        String a=txtMaKH.getText();
        if(!bus.KiemTraTrungMaKH(a)){
            check=false;
            JOptionPane.showMessageDialog(rootPane, "Trùng mã kh!");
            txtMaKH.requestFocus();
        }
        
        s.setMaKH(a);
        s.setTenKH(txtTenKH.getText());
        s.setDiaChi(txtDiaChi.getText());
        if(txtSDT.getDocument().getLength()<10){
            check=false;
            JOptionPane.showMessageDialog(rootPane, "SDT phải có ít nhất 10 số!");
            txtSDT.requestFocus();
        }
        
        String p=txtSDT.getText();
        try {
            Integer.parseInt(p);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "SDT phải là số");
            check=false;
            txtSDT.requestFocus();
        }
        s.setSDT(p);

        if(check==true){
            try {
                if(bus.ThemKH(s)==true){
                    bus.showResult(model);
                    JOptionPane.showMessageDialog(rootPane, "Thêm KH thành công!");

                    txtMaKH.setText("");
                    txtTenKH.setText("");
                    txtDiaChi.setText("");
                    txtSDT.setText("");
                    txtMaKH.requestFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm không thành cong ! Chắc là sai 1 chỗ gì đó rầu");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row=tbl.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để sủa");
            check1=false;
        }
        if(check1==true){
            KhachHang std = bus.lssp.get(row);
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                bus.xoavitrids(row);
                bus.XoaKH(std);
                txtMaKH.setText("");
                txtTenKH.setText("");
                txtDiaChi.setText("");
                txtSDT.setText("");
                txtMaKH.requestFocus();
                txtMaKH.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.removeRow(row);
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !!!");
        }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        KhachHang s = new KhachHang();
        boolean check=true;

        int row=tbl.getSelectedRow();
        boolean check1=true;
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng để sủa");
            check1=false;
        }
        if(check1==true){
            s.setMaKH(txtMaKH.getText());
            s.setTenKH(txtTenKH.getText());
            s.setDiaChi(txtDiaChi.getText());
            if(txtSDT.getDocument().getLength()<10){
                check=false;
                JOptionPane.showMessageDialog(rootPane, "SDT phải có ít nhất 10 số!");
                txtSDT.requestFocus();
            }

            String p=txtSDT.getText();
            try {
                Integer.parseInt(p);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "SDT phải là số");
                check=false;
                txtSDT.requestFocus();
            }
            s.setSDT(p);
            if(check==true){
                try {
                    if(bus.SuaTTKH(s)==true){
                        model.setRowCount(0);
                        bus.DocKH();
                        bus.showTable(model);
                        txtMaKH.setText("");
                        txtTenKH.setText("");
                        txtDiaChi.setText("");
                        txtSDT.setText("");
                        txtMaKH.requestFocus();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Edit thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLoadDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDLActionPerformed
        model.setRowCount(0);
        bus.showTable(model);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnLoadDLActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String b=txtTimKiem.getText();
        boolean check=false;
        for(int i=0;i<bus.lssp.size();i++){
            if(bus.lssp.get(i).getMaKH().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lssp.get(i).getMaKH(), bus.lssp.get(i).getTenKH(),  bus.lssp.get(i).getDiaChi(),bus.lssp.get(i).getSDT()
                });
                break;
            }
            else if(bus.lssp.get(i).getTenKH().toLowerCase().equals(b.toLowerCase())){
                check=true;
                model.setRowCount(0);
                model.addRow(new Object[]{
                    bus.lssp.get(i).getMaKH(), bus.lssp.get(i).getTenKH(), bus.lssp.get(i).getDiaChi(),bus.lssp.get(i).getSDT()
                });
                break;
            }
        }
        if(check==false){
            JOptionPane.showMessageDialog(rootPane, "Không có MãSP hay TênSP trong bảng nhóe !");
            model.setRowCount(0);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtMaKH.setEnabled(true);
    }//GEN-LAST:event_txtTimKiemMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int row=tbl.getSelectedRow();
        txtMaKH.setText(tbl.getModel().getValueAt(row, 0).toString());
        txtMaKH.setEnabled(false);
        txtTenKH.setText(tbl.getModel().getValueAt(row, 1).toString());
        txtDiaChi.setText(tbl.getModel().getValueAt(row, 2).toString());
        txtSDT.setText(tbl.getModel().getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblMouseClicked

    private void btnXuatEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatEXActionPerformed
        WritableWorkbook wordbook;

        try{
            wordbook = Workbook.createWorkbook(new File("khachhang.xls"));
            WritableSheet sheet=wordbook.createSheet("khachhang", 0);

            sheet.addCell(new Label(0,0,"Mã KH"));
            sheet.addCell(new Label(1,0,"Tên KH"));
            sheet.addCell(new Label(2,0,"Địa chỉ"));
            sheet.addCell(new Label(3,0,"SĐT"));
          
            int row=1;
            for(KhachHang kh : KhachHangBUS.lssp){
                sheet.addCell(new Label(0,row,kh.getMaKH()));
                sheet.addCell(new Label(1,row,kh.getTenKH()));
                sheet.addCell(new Label(2,row,kh.getDiaChi()));
                sheet.addCell(new Label(3,row++,kh.getSDT()));
            }

            wordbook.write();
            wordbook.close();
            JOptionPane.showMessageDialog(null,"Xuất thành công");
        } catch (IOException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatEXActionPerformed

    private void btnDocEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocEXActionPerformed
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
                tbl.setModel(model);
                wordbook.close();
            }
            catch (IOException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BiffException ex) {
                Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDocEXActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachHangForm dialog = new KhachHangForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnDocEX;
    private javax.swing.JButton btnLoadDL;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatEX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
