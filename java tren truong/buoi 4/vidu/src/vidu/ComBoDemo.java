package ControlCoBan;


import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ComBoDemo extends javax.swing.JFrame {
//    Vector<SinhVien> dsVector=new Vector<SinhVien>();
    ArrayList<SinhVien> dsList=new ArrayList<SinhVien>();
    public ComBoDemo() {
        initComponents();
//        c1 tạo xâu chứa dữ liệu và làm nguồn cho combo
//        String dsSV[]={"hoa", "ha","Hung"};
//        cboSinhVien.setModel(new DefaultComboBoxModel(dsSV));
        //c2- nguồn là arraylist
        dsList.add(new SinhVien(1,"Lan"));
        dsList.add(new SinhVien(2,"Hà"));
        dsList.add(new SinhVien(3,"Thuong")); 
        cboSinhVien.setModel(
                new DefaultComboBoxModel(dsList.toArray()));
        jTable1.setModel(new TableConbo(dsList));
        
        dsList.add(new SinhVien(4,"thêm mới")); 
        jTable1.repaint();
        //c3 nguồn là dữ liệu thông thường addItem
        cboSinhVien.addItem(" them moi");
        
//        c4 tạo dữ liệu là 1 vector chứa thành phàn đối tượng
//        dsVector.add(new SinhVien(1,"Lan"));
//        dsVector.add(new SinhVien(2,"Hà"));
//        dsVector.add(new SinhVien(3,"Thuong"));                        
//        cboSinhVien.setModel(
//                new DefaultComboBoxModel(dsVector));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboSinhVien = new javax.swing.JComboBox();
        txtKQq = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboSinhVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Graduate", "postGraduate", "ví dụ", "abcdf", "fsfsfsf" }));
        cboSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSinhVienActionPerformed(evt);
            }
        });

        txtKQq.setText("kq");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtKQq, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(cboSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cboSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKQq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSinhVienActionPerformed
        int viTri=cboSinhVien.getSelectedIndex();
        //c2,4- gán dữ liệu qua arraylist và vector
//        txtKQq.setText(dsList.get(viTri).getMa()+"-"+dsList.get(viTri).getName());   
//        txtKQq.setText(dsVector.get(viTri).getMa()+" - "+dsVector.get(viTri).getName());
       //c1,3
        txtKQq.setText(cboSinhVien.getSelectedItem()+"");   
    }//GEN-LAST:event_cboSinhVienActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     int viTri=jTable1.getSelectedRow();
     cboSinhVien.setSelectedIndex(viTri);
    }//GEN-LAST:event_jTable1MouseClicked
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
            java.util.logging.Logger.getLogger(ComBoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComBoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComBoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComBoDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComBoDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboSinhVien;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtKQq;
    // End of variables declaration//GEN-END:variables
}
