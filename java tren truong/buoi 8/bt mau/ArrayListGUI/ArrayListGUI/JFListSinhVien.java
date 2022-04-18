package ArrayListGUI;

import java.awt.HeadlessException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFListSinhVien extends javax.swing.JFrame {

    ListSinhVien dssv = new ListSinhVien();
    SinhVien sv;
    private int selectIndex = -1;
    private DefaultTableModel dtmSV;
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
    ReadWriteObject rw = new ReadWriteObject();
    String fileName = "dssv.bin";

    public JFListSinhVien() {
        initComponents();
        myInit();
    }

    private void myInit() {
        try {
            dssv = (ListSinhVien) rw.ReadObject(fileName);
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "danh sach hien tai rong");
        }
        SetJListLop();
        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Classroom", "ID Student", "Full Name", "Birthday", "Address"
                }
        ));
        String[] lop = {"KTPM1", "KTPM2", "KTPM3",};
        cbbClassroom.setModel(new javax.swing.DefaultComboBoxModel(lop));
        dtmSV = (DefaultTableModel) tableStudents.getModel();
        tableStudents.setModel(dtmSV);
        setLocationRelativeTo(null);
    }
    String[] sumListLop = {"", "", "", ""};

    private void SetJListLop() {
        String listName[] = {"KTPM1", "KTPM2", "KTPM3", "ALL  "};
        sumListLop = dssv.ThongKeSV(listName);
        for (int i = 0; i < 4; i++) {
            listName[i] = listName[i] + " (" + sumListLop[i] + ")";
        }
        jListClass.setListData(listName);
    }

    private void luuFile() {
        try {
            rw.WriteObject(fileName, dssv);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void loadDataIntoTableModel() {
        XoaDLTrenBang();
        deleteTxtField();
        luuFile();
        dssv.inDS(dtmSV);
    }

    private void XoaDLTrenBang() {
        int rowCount = dtmSV.getRowCount();
        for (int i = rowCount; i > 0; i--) {
            dtmSV.removeRow(i - 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        txDAddress = new javax.swing.JTextField();
        cbbClassroom = new javax.swing.JComboBox();
        btnClearTextField = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        panelList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListClass = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Classroom");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setText("ID Student");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("Full Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setText("Birthday");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel5.setText("Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 162, -1));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 162, -1));

        txtBirthday.setText("01/01/1992");
        txtBirthday.setToolTipText("Nhap kieu thang ngay nam");
        jPanel1.add(txtBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 162, -1));
        jPanel1.add(txDAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 162, -1));

        jPanel1.add(cbbClassroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 162, -1));

        btnClearTextField.setText("Clear TextField");
        btnClearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(btnClearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 30));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 80, 30));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 80, 30));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 30));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 80, 30));

        tableStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStudents);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );

        jListClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListClassMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListClass);

        javax.swing.GroupLayout panelListLayout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(panelListLayout);
        panelListLayout.setHorizontalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        panelListLayout.setVerticalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteTxtField() {
        //cbbLop.setSelectedIndex(0);
        txtID.setText("");
        txtName.setText("");
        txtBirthday.setText("01/01/1992");
        txDAddress.setText("");
        txtID.requestFocus();//dua con tro ve day
    }
    private void btnClearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTextFieldActionPerformed
        // TODO add your handling code here:
        deleteTxtField();
    }//GEN-LAST:event_btnClearTextFieldActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        try {
            sv = new SinhVien(cbbClassroom.getSelectedItem().toString(), txtID.getText(), txtName.getText(), format.parse(txtBirthday.getText()), txDAddress.getText());
            if (txtID.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ma SV khong duoc de trong", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (cbbClassroom.getSelectedItem().toString().equalsIgnoreCase("ALL")) {
                JOptionPane.showMessageDialog(null, "Hãy chọn lớp!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else if (dssv.ThemSV(sv)) {
                SetJListLop();
                XoaDLTrenBang();
                dssv.inDS(dtmSV);
                //dssv.inDSTheoLop(dtmSV, cbbLop.getSelectedItem().toString());
                deleteTxtField();
            } else {
                JOptionPane.showMessageDialog(null, "Ma sv da ton tai", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (ParseException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra dữ liệu, định dạng ngày sinh kiểu MM/dd/yyyy\n" + ex, "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            selectIndex = tableStudents.getSelectedRow();
            if (selectIndex != -1) {
                try {
                    dssv.xoaDS(selectIndex);
                    SetJListLop();
                    selectIndex = -1;
                    loadDataIntoTableModel();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex, "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ban hay chon sinh vien can xoa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        selectIndex = tableStudents.getSelectedRow();
        if (selectIndex != -1) {
            try {
                if (dssv.checkID(txtID.getText(), selectIndex)) {
                    sv = dssv.sinhVien(selectIndex);
                    sv.setLop(cbbClassroom.getSelectedItem().toString());
                    sv.setMaSV(txtID.getText());
                    sv.setHoTen(txtName.getText());
                    sv.setNgaySinh(format.parse(txtBirthday.getText()));
                    sv.setDiaChi(txDAddress.getText().trim());
                    selectIndex = -1;
                    loadDataIntoTableModel();
                    SetJListLop();
                } else {
                    JOptionPane.showMessageDialog(null, "Ma da ton tai");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Hãy kiểm tra dữ liệu, định dạng ngày sinh kiểu MM/dd/yyyy\n" + ex, "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ban hay chon sinh vien can sua", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        luuFile();
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tableStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentsMouseClicked
        selectIndex = tableStudents.getSelectedRow();
        if (selectIndex != -1) {
            //cach 1
            /*sv = dssv.sinhVien(selectIndex);
             cbbLop.setSelectedItem(sv.getLop());
             txtMaSV.setText(sv.getMaSV());
             txtHoTen.setText(sv.getHoTen());
             txtNgaySinh.setText(sv.getNgaySinh());
             txtDiaChi.setText(sv.getDiaChi());*/
            //cach 2
            cbbClassroom.setSelectedItem(dtmSV.getValueAt(selectIndex, 0).toString());
            txtID.setText(dtmSV.getValueAt(selectIndex, 1).toString());
            txtName.setText(dtmSV.getValueAt(selectIndex, 2).toString());
            txtBirthday.setText(dtmSV.getValueAt(selectIndex, 3).toString());
            txDAddress.setText(dtmSV.getValueAt(selectIndex, 4).toString());

        }
    }//GEN-LAST:event_tableStudentsMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            XoaDLTrenBang();
            dssv.inDS(dtmSV);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowActivated

    private void jListClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListClassMouseClicked
        if (jListClass.getSelectedValue().toString().substring(0, 5).equals("ALL  ")) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
            btnDelete.setEnabled(false);
        }
        cbbClassroom.setSelectedItem(jListClass.getSelectedValue().toString().substring(0, 5));
        XoaDLTrenBang();
        dssv.inDSTheoLop(dtmSV, jListClass.getSelectedValue().toString().substring(0, 5));
    }//GEN-LAST:event_jListClassMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        luuFile();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFListSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearTextField;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbbClassroom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListClass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelList;
    private javax.swing.JTable tableStudents;
    private javax.swing.JTextField txDAddress;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
