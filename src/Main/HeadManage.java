/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Libra.XDate;
import Libra.XFile;
import Model.Headphone;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class HeadManage extends javax.swing.JFrame {

    DefaultTableModel tbModel;
    DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        String filePath = "";
        ArrayList<Headphone> HeadList;
        int currentRow = -1;
          JFrame frontScreen;  
    public HeadManage(String name,Login.Login aThis){
        initComponents();
        frontScreen = aThis;
         this.setLocationRelativeTo(null);
    initTable();
        LoadCb();
        TBHead.setDefaultEditor(Object.class, null);
        HeadList = new ArrayList<>();
        // nó phân biet hoa thường
        filePath = "./src/Libra/HeadPhone.dat";
        this.setTitle("Head phone.APP");
        this.setLocationRelativeTo(null);
        TBHead.setDefaultEditor(Object.class,null);//
         boolean file = loadFile();
        if(file){
            filltotable();
            
        }else{
//            showmess("nothing to show");
        }
        this.setLocationRelativeTo(null);
    }

    
    /**
     * Creates new form Main
     */
    public HeadManage() {
        initComponents();
      
    }
    /*
    hàm nào em dùng đê tăng id
    đáng lẽ em nên để d là biến cục bộ trong hàm, vì khi em chạy nó
    rất nhiều lần, thì d là biến toàn cục nó sẽ nhớ mà tăng theo
    Hoặc, em có thể lấy HeadList.size() coi như là max id sẽ nhanh hơn
    */
     private void addcan(){
            
//    String id = TXT.getText(); id auto grow
         if (TXTname.getText().equals(""))  {
             showmess("you haven't input name yet");
         }else if(TXTprice.getText().equals("")){
             showmess("you haven't input price yet");
         }else if(TXTDate.getDate()==null){
             showmess("you haven't choose import date yet");
         }else if(CBbrand.getSelectedIndex() == 0){
             showmess("you haven't choose brand of the headphone yet");
         }else if (grBTN1.getSelection() == null) {
                 showmess("you haven't choose type of item yet!!");
         }else
{
    
    checkint();
    String name = TXTname.getText();
    Double Price = Double.parseDouble(TXTprice.getText());
    boolean Type = Boolean.parseBoolean(grBTN1.getSelection().getActionCommand());
    String brand = CBbrand.getSelectedItem().toString();
     Date IMP = TXTDate.getDate();
    String date = XDate.DateToString(IMP);
//    String date = "2000/11/01";
//int d
    
        
    int d = HeadList.size()+1;
    
//    int iid = (int)TBHead.getValueAt(d +1, 1);
        
//    Headphone x = HeadList.get(d);
//    int a = x.getID();
    Headphone c = new Headphone(d, name, Price, date, Type, brand);
    HeadList.add(c);}
}
    private void checkint(){
        double x;
        try {
            x = Double.parseDouble(TXTprice.getText());
        } catch (NumberFormatException e) {
            showmess("you are input a character into price pls try again");
        }
    } 
     
    private void filltotable(){
        tbModel.setRowCount(0);
        for(Headphone c : HeadList){
            Object[] row = new Object[]{c.getID(),c.getName(),c.getPrice(),c.getIday(),c.getBrand(),c.getType(filePath)};
            tbModel.addRow(row);
        }
    }
    private void initTable(){
        String[] columnNames = {"ID","Name","Price","Import Date","Brand","type"};
        tbModel = new DefaultTableModel(columnNames,0);
        TBHead.setModel(tbModel);
    }
    
     private void showmess(String mess){
        JOptionPane.showMessageDialog(this, mess);
    }
     private boolean loadFile(){
        if(XFile.readObject(filePath)==null){
            showmess("nothing to show");
            return false;
        }
        HeadList = (ArrayList<Headphone>) XFile.readObject(filePath);
        return true; 
    }
     private void saveFile(){
        XFile.writeObject(filePath, HeadList);
    }
    private void LoadCb(){
         String[] BrandList = {"choose your Brand","Soni","apples","Samsong"};
        for(String string:BrandList){
            cbModel.addElement(string);
        }
        CBbrand.setModel(cbModel);
    }
    
    private void updateCan(){
        Headphone c = HeadList.get(currentRow);
   
        c.setName(TXTname.getText());
        c.setPrice(Double.parseDouble(TXTprice.getText()));
        c.setType(Boolean.parseBoolean(grBTN1.getSelection()
                .getActionCommand()));
        c.setBrand(CBbrand.getSelectedItem().toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grBTN1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBHead = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TXTname = new javax.swing.JTextField();
        TXTprice = new javax.swing.JTextField();
        TXTDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CBbrand = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 102));

        jScrollPane1.setBackground(new java.awt.Color(255, 0, 51));

        TBHead.setBackground(new java.awt.Color(204, 255, 255));
        TBHead.setFont(new java.awt.Font("Snap ITC", 0, 12)); // NOI18N
        TBHead.setModel(new javax.swing.table.DefaultTableModel(
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
        TBHead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBHeadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBHead);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 3, 30)); // NOI18N
        jLabel1.setText("Manage headphone store");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/2437962-middle.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        TXTname.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N

        TXTprice.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel2.setText("Headphone name");

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel4.setText("Import date");

        jLabel5.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel5.setText("Type");

        grBTN1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jRadioButton1.setText("new");
        jRadioButton1.setActionCommand("true");

        grBTN1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jRadioButton2.setText("99%");
        jRadioButton2.setActionCommand("false");

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setFont(new java.awt.Font("Viner Hand ITC", 0, 14)); // NOI18N
        jButton5.setText("sort by Price");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Viner Hand ITC", 0, 18)); // NOI18N
        jLabel7.setText("brand");

        CBbrand.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        CBbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(306, 306, 306))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXTprice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXTDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBbrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TXTname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTprice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          addcan();
        filltotable();
        saveFile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(currentRow == -1){
            showmess("you haven't choose any row to update yet!!!");
        }else{
        updateCan();
        filltotable();
        saveFile();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(currentRow == -1){
            showmess("you haven't choose any row to Delete yet!!!");
        }else{
        deleteCan();
        filltotable();
        saveFile();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TBHeadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBHeadMouseClicked
        // TODO add your handling code here:
              currentRow = TBHead.getSelectedRow();
        showDetail(currentRow); 
        
    }//GEN-LAST:event_TBHeadMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sortbyprice();
        filltotable();
    }//GEN-LAST:event_jButton5ActionPerformed
   private void sortbyprice(){
        Collections.sort(HeadList,new Comparator<Headphone>(){
        @Override
        public int compare(Headphone o1, Headphone o2){
            return o1.getPrice()>o2.getPrice()?-1:1;
        }
        
    });
        showmess("sort success");
   }
    
    
    private void showDetail(int r){
        
        
        String name = (String)TBHead.getValueAt(r, 1);
        TXTname.setText( name);
        
         Double price = (Double) TBHead.getValueAt(r, 2);
        TXTprice.setText(price.toString());
        
        String brand = (String) TBHead.getValueAt(r, 4);
        CBbrand.setSelectedItem(brand);
        
        Headphone c = HeadList.get(r);
        Date birth = (Date) XDate.stringToDate(c.getIday());
        TXTDate.setDate(birth);
            
        String type = (String) TBHead.getValueAt(r, 5);
        String value = "";
        if (type.equals("new")) {
            value = "true";
        }
        else{
             value = "false";
        }
        setBtnGroup(value);
        
    }
     private void setBtnGroup(String value){
        for(Component c : jPanel2.getComponents()){
            if( c instanceof JRadioButton btn){
                if(btn.getActionCommand().equals(value)){
                    btn.setSelected(true);
                }
            }
        }
    }
    
     private void deleteCan(){
        int result = JOptionPane.showConfirmDialog(this,
                "Do you wanna delete","delete?"
                ,JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            HeadList.remove(currentRow);
            resetform();
            // all id -1 from delete position; 
//            int i = currentRow;
//            for (i = currentRow; i < HeadList.size(); i++) {
//                Headphone c = HeadList.get(i);
//              Headphone c = headList.get(headlist.size())
                   //c.setID(d +1);
//                c.setID(i-1);        
//            }
           
        }
    }
    private void resetform(){
        CBbrand.setSelectedIndex(0);
    }
     
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
            java.util.logging.Logger.getLogger(HeadManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HeadManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HeadManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HeadManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HeadManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBbrand;
    private javax.swing.JTable TBHead;
    private com.toedter.calendar.JDateChooser TXTDate;
    private javax.swing.JTextField TXTname;
    private javax.swing.JTextField TXTprice;
    private javax.swing.ButtonGroup grBTN1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
