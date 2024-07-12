package Form;

import Config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Penjualan extends javax.swing.JFrame {

    private final Connection conn;

    public Penjualan() {
        initComponents();
        conn = Koneksi.getConnection();
        getData();
        populateComboBox();
    }

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) data_tbl_ahmadfauzanabd.getModel();
        model.setRowCount(0);

        try {
            String sql = "SELECT payments.idPayment, items.codeItem, items.itemName, items.itemPrice, payments.quantity, payments.total, payments.discount, payments.finalTotal "
                    + "FROM payments "
                    + "JOIN items ON payments.codeItem = items.codeItem";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int idPayment = rs.getInt("idPayment");
                String codeItem = rs.getString("codeItem");
                String itemName = rs.getString("itemName");
                int itemPrice = rs.getInt("itemPrice");
                int quantity = rs.getInt("quantity");
                int total = rs.getInt("total");
                String discount = rs.getString("discount");
                String finalTotal = rs.getString("finalTotal");

                Object[] rowData = {idPayment, codeItem, itemName, itemPrice, quantity, total, discount, finalTotal};
                model.addRow(rowData);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void populateComboBox() {
        try {
            String sql = "SELECT codeItem FROM items";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            while (rs.next()) {
                String codeItem = rs.getString("codeItem");
                comboBoxModel.addElement(codeItem);
            }

            jComboBox_KdBrg_ahmadfauzanabd.setModel(comboBoxModel);

            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void fetchItemDetails(String codeItem) {
        try {
            String sql = "SELECT itemName, itemPrice FROM items WHERE codeItem = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, codeItem);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                String itemName = rs.getString("itemName");
                int itemPrice = rs.getInt("itemPrice");

                jTextField_NmBrg_ahmadfauzanabd.setText(itemName);
                jTextField_HrgBrg_ahmadfauzanabd.setText(String.valueOf(itemPrice));
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox_KdBrg_ahmadfauzanabd = new javax.swing.JComboBox<>();
        KdBrg_ahmadfauzanabd = new javax.swing.JLabel();
        NmBrg_ahmadfauzanabd = new javax.swing.JLabel();
        HrgBrg_ahmadfauzanabd = new javax.swing.JLabel();
        JmlhBeli_ahmadfauzanabd = new javax.swing.JLabel();
        JmlhByr_ahmadfauzanabd = new javax.swing.JLabel();
        Diskon_ahmadfauzanabd = new javax.swing.JLabel();
        TtlByr_ahmadfauzanabd = new javax.swing.JLabel();
        jTextField_NmBrg_ahmadfauzanabd = new javax.swing.JTextField();
        jTextField_HrgBrg_ahmadfauzanabd = new javax.swing.JTextField();
        jTextField_JmlhBeli_ahmadfauzanabd = new javax.swing.JTextField();
        jTextField_JmlhByr_ahmadfauzanabd = new javax.swing.JTextField();
        jTextField_Diskon_ahmadfauzanabd = new javax.swing.JTextField();
        jTextField_TtlByr_ahmadfauzanabd = new javax.swing.JTextField();
        btn_keluar_ahmadfauzanabd = new javax.swing.JButton();
        btn_DtBr_ahmadfauzanabd = new javax.swing.JButton();
        btn_Tmbh_ahmadfauzanabd = new javax.swing.JButton();
        btn_Simpan_ahmadfauzanabd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        data_tbl_ahmadfauzanabd = new javax.swing.JTable();
        Hero_ahmadfauzanabd = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jComboBox_KdBrg_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_KdBrg_ahmadfauzanabdActionPerformed(evt);
            }
        });

        KdBrg_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        KdBrg_ahmadfauzanabd.setText("Kode Barang");

        NmBrg_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        NmBrg_ahmadfauzanabd.setText("Nama Barang");

        HrgBrg_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        HrgBrg_ahmadfauzanabd.setText("Harga Barang");

        JmlhBeli_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        JmlhBeli_ahmadfauzanabd.setText("Jumlah Beli");

        JmlhByr_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        JmlhByr_ahmadfauzanabd.setText("Jumlah Bayar");

        Diskon_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        Diskon_ahmadfauzanabd.setText("Diskon");

        TtlByr_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        TtlByr_ahmadfauzanabd.setText("Total Bayar");

        jTextField_NmBrg_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_NmBrg_ahmadfauzanabdActionPerformed(evt);
            }
        });

        jTextField_HrgBrg_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_HrgBrg_ahmadfauzanabdActionPerformed(evt);
            }
        });

        jTextField_JmlhBeli_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_JmlhBeli_ahmadfauzanabdActionPerformed(evt);
            }
        });

        jTextField_JmlhByr_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_JmlhByr_ahmadfauzanabdActionPerformed(evt);
            }
        });

        jTextField_Diskon_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Diskon_ahmadfauzanabdActionPerformed(evt);
            }
        });

        jTextField_TtlByr_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TtlByr_ahmadfauzanabdActionPerformed(evt);
            }
        });

        btn_keluar_ahmadfauzanabd.setText("Keluar");
        btn_keluar_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluar_ahmadfauzanabdActionPerformed(evt);
            }
        });

        btn_DtBr_ahmadfauzanabd.setText("Data Baru");
        btn_DtBr_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DtBr_ahmadfauzanabdActionPerformed(evt);
            }
        });

        btn_Tmbh_ahmadfauzanabd.setText("Tambah");
        btn_Tmbh_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tmbh_ahmadfauzanabdActionPerformed(evt);
            }
        });

        btn_Simpan_ahmadfauzanabd.setText("Simpan");
        btn_Simpan_ahmadfauzanabd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Simpan_ahmadfauzanabdActionPerformed(evt);
            }
        });

        data_tbl_ahmadfauzanabd.setBackground(new java.awt.Color(51, 51, 255));
        data_tbl_ahmadfauzanabd.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        data_tbl_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        data_tbl_ahmadfauzanabd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Kode Barang", "Nama Barang", "Harga barang", "Jumlah Beli", "Jumlah Bayar", "Diskon", "Total Bayar"
            }
        ));
        jScrollPane1.setViewportView(data_tbl_ahmadfauzanabd);

        Hero_ahmadfauzanabd.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        Hero_ahmadfauzanabd.setForeground(new java.awt.Color(255, 255, 255));
        Hero_ahmadfauzanabd.setText("F22110007 KASIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(HrgBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(117, 117, 117)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_JmlhBeli_ahmadfauzanabd, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                            .addComponent(jTextField_JmlhByr_ahmadfauzanabd)
                                            .addComponent(jTextField_Diskon_ahmadfauzanabd)
                                            .addComponent(jTextField_TtlByr_ahmadfauzanabd))
                                        .addComponent(jTextField_HrgBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(KdBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NmBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(117, 117, 117)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox_KdBrg_ahmadfauzanabd, 0, 252, Short.MAX_VALUE)
                                        .addComponent(jTextField_NmBrg_ahmadfauzanabd))))
                            .addComponent(Diskon_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JmlhByr_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JmlhBeli_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TtlByr_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_DtBr_ahmadfauzanabd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Tmbh_ahmadfauzanabd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Simpan_ahmadfauzanabd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_keluar_ahmadfauzanabd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(Hero_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Hero_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_KdBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KdBrg_ahmadfauzanabd)
                    .addComponent(btn_DtBr_ahmadfauzanabd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NmBrg_ahmadfauzanabd)
                    .addComponent(jTextField_NmBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tmbh_ahmadfauzanabd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HrgBrg_ahmadfauzanabd)
                    .addComponent(jTextField_HrgBrg_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Simpan_ahmadfauzanabd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlhBeli_ahmadfauzanabd)
                    .addComponent(jTextField_JmlhBeli_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar_ahmadfauzanabd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JmlhByr_ahmadfauzanabd)
                    .addComponent(jTextField_JmlhByr_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Diskon_ahmadfauzanabd)
                    .addComponent(jTextField_Diskon_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TtlByr_ahmadfauzanabd)
                    .addComponent(jTextField_TtlByr_ahmadfauzanabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_KdBrg_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_KdBrg_ahmadfauzanabdActionPerformed
         String selectedItem = (String) jComboBox_KdBrg_ahmadfauzanabd.getSelectedItem();
        fetchItemDetails(selectedItem);
    }//GEN-LAST:event_jComboBox_KdBrg_ahmadfauzanabdActionPerformed

    private void btn_Tmbh_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tmbh_ahmadfauzanabdActionPerformed
        try {
            int harga = Integer.parseInt(jTextField_HrgBrg_ahmadfauzanabd.getText());
            int jumlahBeli = Integer.parseInt(jTextField_JmlhBeli_ahmadfauzanabd.getText());
            int jumlahBayar = harga * jumlahBeli;

            double diskon;
            if (jumlahBayar >= 200000) {
                diskon = jumlahBayar * 0.3;
            } else if (jumlahBayar >= 100000) {
                diskon = jumlahBayar * 0.2;
            } else {
                diskon = 0;
            }

            double totalBayar = jumlahBayar - diskon;

            jTextField_JmlhByr_ahmadfauzanabd.setText(String.valueOf(jumlahBayar));
            jTextField_Diskon_ahmadfauzanabd.setText(String.valueOf(diskon));
            jTextField_TtlByr_ahmadfauzanabd.setText(String.valueOf(totalBayar));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for price and quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_Tmbh_ahmadfauzanabdActionPerformed

    private void jTextField_Diskon_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Diskon_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Diskon_ahmadfauzanabdActionPerformed

    private void jTextField_TtlByr_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TtlByr_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TtlByr_ahmadfauzanabdActionPerformed

    private void jTextField_NmBrg_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_NmBrg_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_NmBrg_ahmadfauzanabdActionPerformed

    private void jTextField_HrgBrg_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_HrgBrg_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_HrgBrg_ahmadfauzanabdActionPerformed

    private void jTextField_JmlhBeli_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_JmlhBeli_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_JmlhBeli_ahmadfauzanabdActionPerformed

    private void jTextField_JmlhByr_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_JmlhByr_ahmadfauzanabdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_JmlhByr_ahmadfauzanabdActionPerformed

    private void btn_DtBr_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DtBr_ahmadfauzanabdActionPerformed
         // Clear the current data in the table
        DefaultTableModel model = (DefaultTableModel) data_tbl_ahmadfauzanabd.getModel();
        model.setRowCount(0);

        // Fetch and add new data to the table
        getData();
    }//GEN-LAST:event_btn_DtBr_ahmadfauzanabdActionPerformed

    private void btn_Simpan_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Simpan_ahmadfauzanabdActionPerformed
           try {
            String codeItem = (String) jComboBox_KdBrg_ahmadfauzanabd.getSelectedItem();
            int quantity = Integer.parseInt(jTextField_JmlhBeli_ahmadfauzanabd.getText());
            int total = Integer.parseInt(jTextField_JmlhByr_ahmadfauzanabd.getText());
            double discount = Double.parseDouble(jTextField_Diskon_ahmadfauzanabd.getText());
            double finalTotal = Double.parseDouble(jTextField_TtlByr_ahmadfauzanabd.getText());

            String sql = "INSERT INTO payments (codeItem, quantity, total, discount, finalTotal) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, codeItem);
            st.setInt(2, quantity);
            st.setInt(3, total);
            st.setDouble(4, discount);
            st.setDouble(5, finalTotal);

            st.executeUpdate();
            st.close();

            JOptionPane.showMessageDialog(this, "Data has been saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            getData();  // Refresh the table data
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Failed to save data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_Simpan_ahmadfauzanabdActionPerformed

    private void btn_keluar_ahmadfauzanabdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluar_ahmadfauzanabdActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_keluar_ahmadfauzanabdActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Penjualan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Diskon_ahmadfauzanabd;
    private javax.swing.JLabel Hero_ahmadfauzanabd;
    private javax.swing.JLabel HrgBrg_ahmadfauzanabd;
    private javax.swing.JLabel JmlhBeli_ahmadfauzanabd;
    private javax.swing.JLabel JmlhByr_ahmadfauzanabd;
    private javax.swing.JLabel KdBrg_ahmadfauzanabd;
    private javax.swing.JLabel NmBrg_ahmadfauzanabd;
    private javax.swing.JLabel TtlByr_ahmadfauzanabd;
    private javax.swing.JButton btn_DtBr_ahmadfauzanabd;
    private javax.swing.JButton btn_Simpan_ahmadfauzanabd;
    private javax.swing.JButton btn_Tmbh_ahmadfauzanabd;
    private javax.swing.JButton btn_keluar_ahmadfauzanabd;
    private javax.swing.JTable data_tbl_ahmadfauzanabd;
    private javax.swing.JComboBox<String> jComboBox_KdBrg_ahmadfauzanabd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_Diskon_ahmadfauzanabd;
    private javax.swing.JTextField jTextField_HrgBrg_ahmadfauzanabd;
    private javax.swing.JTextField jTextField_JmlhBeli_ahmadfauzanabd;
    private javax.swing.JTextField jTextField_JmlhByr_ahmadfauzanabd;
    private javax.swing.JTextField jTextField_NmBrg_ahmadfauzanabd;
    private javax.swing.JTextField jTextField_TtlByr_ahmadfauzanabd;
    // End of variables declaration//GEN-END:variables

}
