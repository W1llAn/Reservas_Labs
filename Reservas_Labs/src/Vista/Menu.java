/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author PC
 */
public class Menu extends javax.swing.JFrame {

    
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        panItemHorarios = new javax.swing.JPanel();
        lblHorarios = new javax.swing.JLabel();
        panItemSalir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        lblSalir1 = new javax.swing.JLabel();
        lblSalir2 = new javax.swing.JLabel();
        lblSalir3 = new javax.swing.JLabel();
        panItemAgregarUsuarios = new javax.swing.JPanel();
        lblLAgregarUsuario = new javax.swing.JLabel();
        panItemLaboratorios = new javax.swing.JPanel();
        lblLaboratorios = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(212, 215, 224));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MENÚ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 41, -1, -1));

        panItemHorarios.setBackground(new java.awt.Color(212, 215, 224));
        panItemHorarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHorarios.setBackground(new java.awt.Color(43, 43, 43));
        lblHorarios.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblHorarios.setForeground(new java.awt.Color(0, 0, 0));
        lblHorarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHorarios.setText("Horarios");

        javax.swing.GroupLayout panItemHorariosLayout = new javax.swing.GroupLayout(panItemHorarios);
        panItemHorarios.setLayout(panItemHorariosLayout);
        panItemHorariosLayout.setHorizontalGroup(
            panItemHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panItemHorariosLayout.setVerticalGroup(
            panItemHorariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panItemHorariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(panItemHorarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 80, 250, 50));

        panItemSalir.setBackground(new java.awt.Color(212, 215, 224));
        panItemSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panItemSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSalir.setBackground(new java.awt.Color(43, 43, 43));
        lblSalir.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(0, 0, 0));
        lblSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir.setText("Salir");
        panItemSalir.add(lblSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 250, 50));

        lblSalir1.setBackground(new java.awt.Color(43, 43, 43));
        lblSalir1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSalir1.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir1.setText("Salir");
        panItemSalir.add(lblSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 1, 246, 40));

        lblSalir2.setBackground(new java.awt.Color(43, 43, 43));
        lblSalir2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSalir2.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir2.setText("Salir");
        panItemSalir.add(lblSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 1, 246, 40));

        lblSalir3.setBackground(new java.awt.Color(43, 43, 43));
        lblSalir3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblSalir3.setForeground(new java.awt.Color(255, 255, 255));
        lblSalir3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSalir3.setText("Salir");
        panItemSalir.add(lblSalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 1, 246, 40));

        jPanel2.add(panItemSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 336, 250, 50));

        panItemAgregarUsuarios.setBackground(new java.awt.Color(212, 215, 224));
        panItemAgregarUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panItemAgregarUsuarios.setPreferredSize(new java.awt.Dimension(250, 50));

        lblLAgregarUsuario.setBackground(new java.awt.Color(43, 43, 43));
        lblLAgregarUsuario.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblLAgregarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblLAgregarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLAgregarUsuario.setText("Agregar Usuarios");

        javax.swing.GroupLayout panItemAgregarUsuariosLayout = new javax.swing.GroupLayout(panItemAgregarUsuarios);
        panItemAgregarUsuarios.setLayout(panItemAgregarUsuariosLayout);
        panItemAgregarUsuariosLayout.setHorizontalGroup(
            panItemAgregarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLAgregarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panItemAgregarUsuariosLayout.setVerticalGroup(
            panItemAgregarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panItemAgregarUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(panItemAgregarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 208, 250, 50));

        panItemLaboratorios.setBackground(new java.awt.Color(212, 215, 224));
        panItemLaboratorios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panItemLaboratorios.setPreferredSize(new java.awt.Dimension(250, 50));

        lblLaboratorios.setBackground(new java.awt.Color(43, 43, 43));
        lblLaboratorios.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblLaboratorios.setForeground(new java.awt.Color(0, 0, 0));
        lblLaboratorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaboratorios.setText("Laboratorios");

        javax.swing.GroupLayout panItemLaboratoriosLayout = new javax.swing.GroupLayout(panItemLaboratorios);
        panItemLaboratorios.setLayout(panItemLaboratoriosLayout);
        panItemLaboratoriosLayout.setHorizontalGroup(
            panItemLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLaboratorios, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        panItemLaboratoriosLayout.setVerticalGroup(
            panItemLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLaboratorios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel2.add(panItemLaboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 144, 250, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 112, 300, 400));

        jPanel3.setBackground(new java.awt.Color(35, 33, 33));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));

        jPanel4.setBackground(new java.awt.Color(35, 33, 33));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 544, 930, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoFisei_pequenio.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 117, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reservas_LogoMenu.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 272, -1, 45));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("UNIVERSIDAD TÉCNICA DE ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, 50));

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("AMBATO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblHorarios;
    public javax.swing.JLabel lblLAgregarUsuario;
    public javax.swing.JLabel lblLaboratorios;
    public javax.swing.JLabel lblSalir;
    public javax.swing.JLabel lblSalir1;
    public javax.swing.JLabel lblSalir2;
    public javax.swing.JLabel lblSalir3;
    public javax.swing.JPanel panItemAgregarUsuarios;
    public javax.swing.JPanel panItemHorarios;
    public javax.swing.JPanel panItemLaboratorios;
    public javax.swing.JPanel panItemSalir;
    // End of variables declaration//GEN-END:variables
}
