/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Modelos.Block;
import Modelos.Lab;
import java.awt.Font;
import javax.swing.JMenuItem;
/**
 *
 * @author PC
 */
public class Horarios extends javax.swing.JFrame {
public JMenuItem jitmReserva = new JMenuItem("Reservar");
    /**
     * Creates new form Laboratorios_
     */
    public Horarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        Font font = new Font("Lucida fax", Font.PLAIN, 16); // Por ejemplo, Arial, negrita, tamaño 16
        this.jitmReserva.setFont(font);
        this.menuClick.add(jitmReserva);
        this.tablaHorarios.setComponentPopupMenu(menuClick);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClick = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBloque = new javax.swing.JComboBox<>();
        comboLaboratorio = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        txt_semana = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        tablaHorarios = new Utilidades.horario();
        fechaDia = new com.toedter.calendar.JDateChooser();
        txt_fechas = new java.awt.Label();
        btnSiguienteS = new javax.swing.JButton();
        btnAnteriorS = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(43, 43, 43));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(147, 10, 13));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Reborn", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Horarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seleccione un Laboratorio: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        comboBloque.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jPanel1.add(comboBloque, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 240, -1));

        comboLaboratorio.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jPanel1.add(comboLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 240, -1));

        btnRegresar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegresar.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 40));

        txt_semana.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        txt_semana.setForeground(new java.awt.Color(0, 0, 0));
        txt_semana.setText("Semana");
        jPanel1.add(txt_semana, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));

        Scroll.setViewportView(tablaHorarios);

        jPanel1.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 890, 420));

        fechaDia.setBackground(new java.awt.Color(43, 43, 43));
        fechaDia.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        fechaDia.setDoubleBuffered(false);
        fechaDia.setFocusable(false);
        fechaDia.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        jPanel1.add(fechaDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 180, 30));

        txt_fechas.setBackground(new java.awt.Color(255, 255, 255));
        txt_fechas.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jPanel1.add(txt_fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 180, 30));

        btnSiguienteS.setBackground(new java.awt.Color(204, 204, 204));
        btnSiguienteS.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        btnSiguienteS.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(btnSiguienteS, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 40, 30));

        btnAnteriorS.setBackground(new java.awt.Color(204, 204, 204));
        btnAnteriorS.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        btnAnteriorS.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(btnAnteriorS, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 40, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Seleccione un Bloque: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane Scroll;
    public javax.swing.JButton btnAnteriorS;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JButton btnSiguienteS;
    public javax.swing.JComboBox<Block> comboBloque;
    public javax.swing.JComboBox<Lab> comboLaboratorio;
    public com.toedter.calendar.JDateChooser fechaDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblFondo;
    public javax.swing.JPopupMenu menuClick;
    public Utilidades.horario tablaHorarios;
    public java.awt.Label txt_fechas;
    public javax.swing.JLabel txt_semana;
    // End of variables declaration//GEN-END:variables
}
