/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package doan;
package GUI;
import GUI.LoginForm;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 6khan
 */
public class HomeForm extends javax.swing.JFrame {

    /**
     * Creates new form Management
     */

    public HomeForm() {
        setUndecorated(true);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        //System.out.println("chạy dô đây lần:"+ i++);
    }

    public HomeForm(String user){
        setUndecorated(true);
        initComponents();
        
        if(user.equals("admin")){
            lblName.setText(user);
            lblBieuTuong.setIcon(new ImageIcon("D:/DoAn/src/img/Boss.png"));
        }
        else {
            lblName.setText(user);
            lblBieuTuong.setIcon(new ImageIcon("D:/DoAn/src/img/Person.png"));
            lblNhanVien.setVisible(false);      
            lblTaiKhoan.setVisible(false);
            lblPhanQuyen.setVisible(false);
            lblSanPham.setVisible(false);
            lblNCC.setVisible(false);
            jLabel6.setVisible(false);
            jLabel5.setVisible(false);
            jLabel10.setVisible(false);
            jLabel12.setVisible(false);
            jLabel4.setVisible(false);
        }
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        lbGreeting = new javax.swing.JLabel();
        lbKho = new javax.swing.JLabel();
        lbNhapKho = new javax.swing.JLabel();
        lbXuatKho = new javax.swing.JLabel();
        lblPhanQuyen = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblLoai = new javax.swing.JLabel();
        lblNCC = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblBieuTuong = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbGreeting.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbGreeting.setForeground(new java.awt.Color(255, 255, 255));
        lbGreeting.setText("Welcome");
        pnMain.add(lbGreeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 90, 30));

        lbKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Kho.png"))); // NOI18N
        lbKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbKhoMouseClicked(evt);
            }
        });
        pnMain.add(lbKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 80, 80));

        lbNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Phieu nhap.png"))); // NOI18N
        lbNhapKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNhapKhoMouseClicked(evt);
            }
        });
        pnMain.add(lbNhapKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 80, 80));

        lbXuatKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Phieu xuat.png"))); // NOI18N
        lbXuatKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbXuatKhoMouseClicked(evt);
            }
        });
        pnMain.add(lbXuatKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 80, 90));

        lblPhanQuyen.setForeground(new java.awt.Color(255, 255, 255));
        lblPhanQuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quyen.png"))); // NOI18N
        lblPhanQuyen.setText("jLabel11");
        lblPhanQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhanQuyenMouseClicked(evt);
            }
        });
        pnMain.add(lblPhanQuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 80, 80));

        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tai khoan.png"))); // NOI18N
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
        });
        pnMain.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 80, 80));

        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Log out.png"))); // NOI18N
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
        });
        pnMain.add(lbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 40, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KHO");
        pnMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PHIẾU NHẬP");
        pnMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PHIẾU XUẤT");
        pnMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PHÂN QUYỀN");
        pnMain.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TÀI KHOẢN");
        pnMain.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LOẠI");
        pnMain.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        lblLoai.setForeground(new java.awt.Color(255, 255, 255));
        lblLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loaiSP.png"))); // NOI18N
        lblLoai.setText("jLabel8");
        lblLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoaiMouseClicked(evt);
            }
        });
        pnMain.add(lblLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 80, 90));

        lblNCC.setForeground(new java.awt.Color(255, 255, 255));
        lblNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ncc.png"))); // NOI18N
        lblNCC.setText("jLabel9");
        lblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNCCMouseClicked(evt);
            }
        });
        pnMain.add(lblNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 80, 80));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NHÀ CUNG CẤP");
        pnMain.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, -1, -1));

        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nhanvien.png"))); // NOI18N
        lblNhanVien.setText("jLabel10");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });
        pnMain.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 80, 80));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NHÂN VIÊN");
        pnMain.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, -1, -1));

        lblBieuTuong.setForeground(new java.awt.Color(255, 255, 255));
        pnMain.add(lblBieuTuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 30, 30));

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("jLabel13");
        pnMain.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 50, 30));

        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/khachhang.png"))); // NOI18N
        lblKhachHang.setText("jLabel6");
        lblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKhachHangMouseClicked(evt);
            }
        });
        pnMain.add(lblKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 80, 90));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("KHÁCH HÀNG");
        pnMain.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, -1));

        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sanpham.png"))); // NOI18N
        lblSanPham.setText("jLabel6");
        lblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSanPhamMouseClicked(evt);
            }
        });
        pnMain.add(lblSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 80, 80));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SẢN PHẨM");
        pnMain.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 70, -1));

        lbMain.setForeground(new java.awt.Color(240, 240, 240));
        lbMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.jpg"))); // NOI18N
        pnMain.add(lbMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbKhoMouseClicked
        KhoForm f=new KhoForm(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_lbKhoMouseClicked

    private void lbNhapKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNhapKhoMouseClicked
        PHIEUNHAPHANG pn=new PHIEUNHAPHANG(this, rootPaneCheckingEnabled);
        pn.setVisible(true);
    }//GEN-LAST:event_lbNhapKhoMouseClicked

    private void lbXuatKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbXuatKhoMouseClicked
        PHIEUXUATHANG abc=new PHIEUXUATHANG(this, rootPaneCheckingEnabled);
        abc.setVisible(true);
    }//GEN-LAST:event_lbXuatKhoMouseClicked

    private void lblPhanQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhanQuyenMouseClicked
        PhanQuyenForm f=new PhanQuyenForm(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_lblPhanQuyenMouseClicked

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        TKForm tk=new TKForm(this,rootPaneCheckingEnabled);
        tk.setVisible(true);
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        int comfirmed=JOptionPane.showConfirmDialog(null,
        "Are you want to log out?","Log out account message box",
        JOptionPane.YES_OPTION);
        if(comfirmed==JOptionPane.YES_OPTION)
        {
            this.setVisible(false);
            LoginForm l=new LoginForm();
            l.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Lần sau nghĩ kỹ r hãy ấn nha mạy !");
        }
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void lblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoaiMouseClicked
        LoaiSPForm lsp=new LoaiSPForm(this, rootPaneCheckingEnabled);
        lsp.setVisible(true);
    }//GEN-LAST:event_lblLoaiMouseClicked

    private void lblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseClicked
        NCCForm ncc=new NCCForm(this, rootPaneCheckingEnabled);
        ncc.setVisible(true);
    }//GEN-LAST:event_lblNCCMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
       NhanVienForm f=new NhanVienForm(this, rootPaneCheckingEnabled);     
       f.setVisible(true);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhachHangMouseClicked
        KhachHangForm f=new KhachHangForm(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_lblKhachHangMouseClicked

    private void lblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSanPhamMouseClicked
        SanPhamForm f=new SanPhamForm(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_lblSanPhamMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeForm mn=new HomeForm();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbGreeting;
    private javax.swing.JLabel lbKho;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbMain;
    private javax.swing.JLabel lbNhapKho;
    private javax.swing.JLabel lbXuatKho;
    private javax.swing.JLabel lblBieuTuong;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblNCC;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhanQuyen;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables
}
