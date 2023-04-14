/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp2dpbo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author binta
 */
public class addGundam extends javax.swing.JFrame {
    private Menu gundam;
    private dbConnection db;
    private Boolean isUpdate = false;
    private int selectedID;
    private File fileImage;
    private String filePath;
    private String fileName;
    /**
     * Creates new form addGundam
     */
    public addGundam(Menu gundam) {
        initComponents();
        db = new dbConnection();
        this.gundam=gundam;
        creator.setSelectedItem(null);
        String sql = "SELECT * FROM creator";
        java.sql.ResultSet res = db.selectQuery(sql);
        try {
            while(res.next())
            {
                creator.addItem(res.getString("nama_creator"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public addGundam(Menu gundam,int id, String  name, String image, String Creator, String size, String type)
     {
        initComponents();
        db = new dbConnection();
        this.gundam=gundam;
        creator.setSelectedItem(null);
         String sql = "SELECT * FROM creator";
        java.sql.ResultSet res = db.selectQuery(sql);
        try {
            while(res.next())
            {
                creator.addItem(res.getString("nama_creator"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gundam=gundam;
        this.selectedID = id;
        this.isUpdate=true;
        this.fileName=image;
        btnAdd.setText("Update");
        nameField.setText(name);
        typeField.setText(type);
        sizeField.setText(size);
        creator.setSelectedItem(Creator);
        gambarField.setText(image);
        titleLabel.setText("Update Gundam");
    }
      public void resetForm() {
        // Set All Value Form to Empty
        nameField.setText("");
        typeField.setText("");
        sizeField.setText("");
        gambarField.setText("");
        
    }
      public void insertData() throws IOException
    {        
        String name = nameField.getText();
        String size = sizeField.getText();
        String type = typeField.getText();
        int idCreator = 0;
        String Creator = creator.getSelectedItem().toString();
        
        String sqlc = "SELECT * FROM creator WHERE nama_creator = '"+Creator+"'";
        
        java.sql.ResultSet res = db.selectQuery(sqlc);
        try {
            if(res.next())
            {
                idCreator = res.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            copyImage(this.fileName);
            String sqlg = "INSERT INTO gundam VALUES (NULL, '"+name+"', '"+idCreator+"', '"+type+"', '"+size+"', '"+fileName+"')";       
            db.updateQuery(sqlg);
            resetForm();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            this.gundam.setPanelGundam();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to add data!");
        }
        
       
    }
    public void updateData() throws IOException
    {        
        String name = nameField.getText();
        String size = sizeField.getText();
        String type = typeField.getText();
        int idCreator = 0;
        String Creator = creator.getSelectedItem().toString();
        String sqlc = "SELECT * FROM creator WHERE nama_creator = '"+Creator+"'";
        java.sql.ResultSet res = db.selectQuery(sqlc);
        try {
            if(res.next())
            {
                idCreator = res.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(this.fileImage!= null)
        {
            copyImage(this.fileName);
        }
        String sqlg = "UPDATE gundam SET nama_gundam='"+name+"', gambar_gundam='" + fileName + "', jenis_gundam='" + type + "', ukuran_gundam='" + size +"', creator_gundam='" + idCreator +"' WHERE id=" + selectedID ;
        int affectedRow = db.updateQuery(sqlg);
        
        if (affectedRow > 0) {
            // Show Information
            this.gundam.setPanelGundam();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Data gagal diubah!");
        }
    }
     public void copyImage(String img)
    {
        try
        {
            String newPath = "src/tp2dpbo/img/";
            File directory = new File(newPath);
            if(!directory.exists())
            {
                directory.mkdir();
            }
            
            Path copy = Paths.get(newPath + img);
            Path originalPath = Paths.get(this.filePath);
            Files.copy(originalPath, copy, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to upload file!");
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

        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        typeField = new javax.swing.JTextField();
        sizeField = new javax.swing.JTextField();
        gambarField = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        creator = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        titleLabel.setText("Add Gundam");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Nama Gundam : ");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Jenis Gundam : ");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Ukuran Gundam : ");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Creator Gundam : ");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Gambar Gundam : ");

        btnAdd.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        sizeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeFieldActionPerformed(evt);
            }
        });

        btnUpload.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(typeField)
                            .addComponent(sizeField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gambarField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(creator, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(creator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gambarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jButton3))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(isUpdate == false)
            try {
                insertData();
        } catch (IOException ex) {
            Logger.getLogger(addGundam.class.getName()).log(Level.SEVERE, null, ex);
        }
        else {
            try {
                updateData();
            } catch (IOException ex) {
                Logger.getLogger(addCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         this.dispose();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void sizeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        try
        {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            this.fileImage = chooser.getSelectedFile();
            this.fileName = this.fileImage.getName();
            this.filePath = this.fileImage.getAbsolutePath();
            gambarField.setText(this.filePath);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed to browse file!");
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> creator;
    private javax.swing.JTextField gambarField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField sizeField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField typeField;
    // End of variables declaration//GEN-END:variables
}
