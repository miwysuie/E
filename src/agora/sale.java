/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package agora;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tano0
 */
public class sale extends javax.swing.JPanel {

    public static String barcode_e = "0";
    public static String cus_id = "0";
    
    
    
    
    
    public sale() {
        initComponents();
        
        data_load();
        com_pro.setEditable(true);
        com_cus.setEditable(true);
   
        
        
        
    }
    
    public void data_load(){
        
        //for customer
        
        try {
            
            java.sql.Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM customer");
            Vector v = new Vector();
            
            while (rs.next()) {
            v.add(rs.getString("customer_name"));
            
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            com_cus.setModel(com);
            
            
            
        }
            
        } catch (SQLException e){
            System.out.println(e);
        }
        
        //for product
        
        try {
            
            java.sql.Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM product");
            Vector v = new Vector();
            
            while (rs.next()) {
            v.add(rs.getString("Product_Name"));
            
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            com_pro.setModel(com);
            
            
            
        }
            
        } catch (SQLException e){
            System.out.println(e);
        }
        
        
        // this is to load last invoice number
        
        try {
            
            java.sql.Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM extra WHERE exid =1");
            
            if (rs.next()){
                
                
                inid.setText(rs.getString("val"));
                
                
                
            }
            
            
        } catch (Exception e){
            
        }
        
        // plus new invoice num
        int i = Integer.valueOf(inid.getText());
        i++;
        inid.setText(String.valueOf(i));
        
        
        
    }
    
    public void p_tot_cal(){
        
        try {
        String qtyText = p_qty.getText();
        String priceText = u_price.getText();

        if (!qtyText.isEmpty() && !priceText.isEmpty()) {
            Double qt = Double.valueOf(qtyText);
            Double price = Double.valueOf(priceText);
            Double tot = qt * price;

            tot_price.setText(String.valueOf(tot));
        } else {
            // Handle the case when either qty or price is empty
            // For example, display an error message or set a default value
        }
    } catch (NumberFormatException e) {
        // Handle the case when the conversion fails (e.g., invalid number format)
        // You may want to log the exception or display an error message
        System.out.println("Error converting to Double: " + e.getMessage());
    }

        
        
        
        
    }
    
    public void cart_total(){
        
        int numofrow = jTable1.getRowCount();
        
        double total = 0;
        for (int i = 0; i < numofrow; i++) {
            
            
            double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
            total += value;
        }
        b_total.setText(Double.toString(total));
        
        // total qty
        
        int numofrows = jTable1.getRowCount();
        
        double totals = 0;
        for (int i = 0; i < numofrows; i++) {
            
            
            double values = Double.valueOf(jTable1.getValueAt(i, 3).toString());
            totals += values;
        }
        tot_qty.setText(Double.toString(totals));
        
        
        
        
    }
    public void tot(){
    
    
    try {
    String paidText = p_amt.getText();
    String totalText = b_total.getText();

    Double paid = paidText.isEmpty() ? 0.0 : Double.valueOf(paidText);
    Double tot = totalText.isEmpty() ? 0.0 : Double.valueOf(totalText);

    Double due = paid - tot;
    balnc.setText(String.valueOf(due));

} catch (NumberFormatException e) {
    // Handle the exception, e.g., show an error message
    JOptionPane.showMessageDialog(null, "Invalid numeric input. Please enter valid numbers.");
    System.out.println(e);
}

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        com_cus = new javax.swing.JComboBox<>();
        com_pro = new javax.swing.JComboBox<>();
        p_qty = new javax.swing.JTextField();
        tot_price = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        br_code = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        p_amt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        b_total = new javax.swing.JLabel();
        balnc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INVOICE NO:");

        inid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inid.setText("01");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inid))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Product:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Product Price");

        u_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        u_price.setText("00.00");
        u_price.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        com_cus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_cus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        com_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_cusActionPerformed(evt);
            }
        });

        com_pro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        com_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        com_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_proActionPerformed(evt);
            }
        });

        p_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_qtyActionPerformed(evt);
            }
        });
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        tot_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tot_price.setText("00.00");
        tot_price.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Amount:");

        br_code.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        br_code.setText("00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Product Code:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(u_price, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(br_code, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(u_price)
                    .addComponent(com_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tot_price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(br_code)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice #", "Product Name", "Product Code", "Qty", "Price", "Total Price Amount", "Date of Purchase"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remove All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Paid Amount:");

        p_amt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        p_amt.setText("0");
        p_amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_amtActionPerformed(evt);
            }
        });
        p_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_amtKeyReleased(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Total Amount:");

        b_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        b_total.setText("00.00");
        b_total.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        balnc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balnc.setText("00.00");
        balnc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Balance / Due:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_total, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balnc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(b_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(balnc))
                .addGap(18, 18, 18))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Pay");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total Qty:");

        tot_qty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tot_qty.setText("00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(p_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tot_qty)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void p_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_qtyActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            int rw = jTable1.getSelectedRow();
            
            dt.removeRow(rw);
            
            
        } catch (Exception e){
            System.out.println(e);
        }
        
        cart_total();
        tot();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void p_amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_amtActionPerformed

    private void com_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_proActionPerformed
        // unit price
        
        String name = com_pro.getSelectedItem().toString();
        try{
            
            
            java.sql.Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT Bar_Code,Price FROM product WHERE Product_Name ='"+name+"'   ");
            if (rs.next()) {
                u_price.setText(rs.getString("Price"));
                br_code.setText (rs.getString("Bar_Code"));
                
            }
            
            p_tot_cal();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_com_proActionPerformed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased
        // sklawg
        p_tot_cal();
        
        
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String selectedProductName = com_pro.getSelectedItem().toString();
    String selectedProductQty = p_qty.getText();

    try {
        java.sql.Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT Qty FROM product WHERE Product_Name ='" + selectedProductName + "'");

        if (rs.next()) {
            int availableQty = Integer.parseInt(rs.getString("Qty"));

            if (Integer.parseInt(selectedProductQty) <= availableQty) {
                // Quantity is available, add to the cart
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                Vector v = new Vector();

                v.add(inid.getText()); // invoice id
                v.add(selectedProductName); // product name
                v.add(br_code.getText()); // barcode
                v.add(selectedProductQty); // product qty
                v.add(u_price.getText()); // unit price
                v.add(tot_price.getText()); // get total price
                // Get the selected date from jDateChooser2
                Date selectedDate = jDateChooser2.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(selectedDate);
                // Add the selected date to the Vector
                v.add(formattedDate);

                dt.addRow(v);
                cart_total();
                tot();
            } else {
                // Quantity is not available
                JOptionPane.showMessageDialog(null, "This item is out of stock!");
                p_qty.requestFocus();
            }
        }

    } catch (SQLException e) {
        System.out.println(e);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        cart_total();
        tot();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void p_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_amtKeyReleased
        // TODO add your handling code here:
        
        tot();
        
    }//GEN-LAST:event_p_amtKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // data send to databace
        
        try {
            
            //`cartid`, `INID`, `Product_Name`, `Bar_Code`, `Qty`, `Price`, `Total_Price`
            
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            int rc = dt.getRowCount();
            
            for (int i = 0; i < rc; i++) {
                
                String inid = dt.getValueAt(i, 0).toString(); // INID
                String P_name = dt.getValueAt(i, 1).toString(); // Pname
                String bar_code = dt.getValueAt(i, 2).toString(); // for bcode
                String qty = dt.getValueAt(i, 3).toString(); // for qty
                String un_price = dt.getValueAt(i, 4).toString(); // for unit price
                String tot_price = dt.getValueAt(i, 5).toString(); // for total price
                
                // cart DB
               java.sql.Statement s = db.mycon().createStatement();
               s.executeUpdate("INSERT INTO cart (INID, Product_Name, Bar_Code, Qty, Price, Total_Price ) VALUES ('"+inid+"', '"+P_name+"', '"+bar_code+"', '"+qty+"', '"+un_price+"', '"+tot_price+"' )");
               java.sql.Statement updateQtyStatement = db.mycon().createStatement();
               updateQtyStatement.executeUpdate("UPDATE product SET Qty = Qty - " + qty + " WHERE Bar_Code = '" + bar_code + "'");
                
            }
            
         JOptionPane.showMessageDialog(null, "Data Saved!");
            
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        
        
        try {
    String inv_id = inid.getText();
    int kagenou = 0; // Provide a default value if needed
    String cname = com_cus.getSelectedItem().toString();
    String totqty = tot_qty.getText();
    String tot_bil = b_total.getText();
    String blnc = balnc.getText();
    
    // Get the date for DateofPayment
    Date paymentDate = jDateChooser2.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String DateofPayment = null; // Default value is null
    
    Double tot = Double.valueOf(b_total.getText());
    Double pid = Double.valueOf(p_amt.getText());
    String status;

    if (pid.equals(0.0)) {
        status = "Unpaid!";
    } else if (tot > pid) {
        status = "Partial";
    } else {
        status = "Paid!";
        if (paymentDate != null) {
            DateofPayment = dateFormat.format(paymentDate);
        }
    }

    // Get the current date for formattedDate
    Date currentDate = new Date();
    String formattedDate = dateFormat.format(currentDate);

    String sql = "INSERT INTO sales (INID, kagenou, Customer_Name, Total_Qty, Total_Bill, Status, Balance, DateofPayment, formattedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    java.sql.PreparedStatement preparedStatement = db.mycon().prepareStatement(sql);
    preparedStatement.setString(1, inv_id);
    preparedStatement.setInt(2, kagenou); // Use default value or obtain from somewhere else
    preparedStatement.setString(3, cname);
    preparedStatement.setString(4, totqty);
    preparedStatement.setString(5, tot_bil);
    preparedStatement.setString(6, status);
    preparedStatement.setString(7, blnc);
    preparedStatement.setString(8, DateofPayment); // Use paymentDate for DateofPayment
    preparedStatement.setString(9, formattedDate); // Set currentDate for the formattedDate column

    int rowsAffected = preparedStatement.executeUpdate();
    
    // Handle other parts of your code
    
} catch (NumberFormatException | SQLException e) {
    System.out.println(e);
}

        
        
        
        // this is for INVOICE NO 1 also save the last number of inid 
        try {
        
            
        String id = inid.getText();
        java.sql.Statement s = db.mycon().createStatement();
        s.executeUpdate("UPDATE extra SET val='"+id+"' WHERE exid = 1");
        
        
        
        } catch (SQLException e){
            System.out.println(e);
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    private void com_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_cusActionPerformed
        // get cid
        
         
        String name =com_cus.getSelectedItem().toString();
        try {
        java.sql.Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT kagenou, customer_name FROM customer WHERE customer_name ='" + name + "'");
        if (rs.next()) {
        cus_id = rs.getString("kagenou");
        
        }
        } catch (SQLException e) {
          System.out.println(e);
    }
    }
        
        public Vector<Vector<String>> getUnpaidPartialData() {
    Vector<Vector<String>> data = new Vector<>();
    try {
        java.sql.Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery("SELECT Customer_Name, Balance, Status FROM sales WHERE Status IN ('Unpaid!', 'Partial')");
        while (rs.next()) {
            Vector<String> row = new Vector<>();
            row.add(rs.getString("Customer_Name"));
            row.add(rs.getString("Balance"));
            row.add(rs.getString("Status"));
            data.add(row);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return data;
}


    public void populateEmployeeTable(JTable jTableEmployee) {
    DefaultTableModel model = (DefaultTableModel) jTableEmployee.getModel();
    model.setRowCount(0); // Clear existing data

    sale salesInstance = new sale(); // Instantiate the sale class
    Vector<Vector<String>> unpaidPartialData = salesInstance.getUnpaidPartialData(); // Get unpaid and partial sales data

    // Add data to the table model
    for (Vector<String> row : unpaidPartialData) {
        model.addRow(row);
    }
        
    }//GEN-LAST:event_com_cusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_total;
    private javax.swing.JLabel balnc;
    private javax.swing.JLabel br_code;
    private javax.swing.JComboBox<String> com_cus;
    private javax.swing.JComboBox<String> com_pro;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField p_amt;
    private javax.swing.JTextField p_qty;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables

   
    
}
