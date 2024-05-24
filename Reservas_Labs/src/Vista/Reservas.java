/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author ASUS
 */
import Modelos.Block;
import Modelos.Lab;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class Reservas extends javax.swing.JFrame  {

    /**
     * Creates new form reservas
     */
    public Reservas() {
    initComponents();
    this.setLocationRelativeTo(null);
    //FORMATO PARA EL HORARIO DE INICIO SPINNER
    Date date = new Date(); // Fecha y hora actual
    SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
    JspinerHoraInicio.setModel(sm);
    JSpinner.DateEditor de = new JSpinner.DateEditor(JspinerHoraInicio, "HH:mm");
    JspinerHoraInicio.setEditor(de); 
    
    //FORMATO PARA EL HORARIO DE FIN SPINNER
    SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
    JspinerHoraFin.setModel(sm2);
    JSpinner.DateEditor de2 = new JSpinner.DateEditor(JspinerHoraFin, "HH:mm");
    JspinerHoraFin.setEditor(de2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReservas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbLaboratorios = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaAsunto = new javax.swing.JTextArea();
        btReservas = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        JspinerHoraInicio = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbEdificios = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        JspinerHoraFin = new javax.swing.JSpinner();
        jFecha = new com.toedter.calendar.JDateChooser();
        txtCedulaResponsable = new javax.swing.JTextField();
        txtNombreResponsable = new javax.swing.JTextField();
        txtCargoResponsable = new javax.swing.JTextField();
        txtApellidoResponsable = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        cbCarreras = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(930, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReservas.setBackground(new java.awt.Color(43, 43, 43));
        panelReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Reborn", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reservas");
        panelReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 29, -1, 78));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edifici0:");
        panelReservas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 224, 64, -1));

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora inicio:");
        panelReservas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 272, -1, -1));

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora fin:");
        panelReservas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de reserva:");
        panelReservas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 224, -1, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Asunto:");
        panelReservas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 368, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-sitio-fisei-2020.png"))); // NOI18N
        panelReservas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, -1, -1));

        cbLaboratorios.setBackground(new java.awt.Color(147, 10, 13));
        cbLaboratorios.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        cbLaboratorios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelReservas.add(cbLaboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 336, 192, 25));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAlignmentX(0.3F);
        panelReservas.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(888, 161, 16, 385));

        textAreaAsunto.setBackground(new java.awt.Color(147, 10, 13));
        textAreaAsunto.setColumns(20);
        textAreaAsunto.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        textAreaAsunto.setForeground(new java.awt.Color(255, 255, 255));
        textAreaAsunto.setLineWrap(true);
        textAreaAsunto.setRows(5);
        textAreaAsunto.setToolTipText("");
        textAreaAsunto.setWrapStyleWord(true);
        textAreaAsunto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        textAreaAsunto.setCaretColor(new java.awt.Color(255, 255, 255));
        textAreaAsunto.setDisabledTextColor(new java.awt.Color(147, 10, 13));
        textAreaAsunto.setPreferredSize(new java.awt.Dimension(302, 117));
        jScrollPane2.setViewportView(textAreaAsunto);

        panelReservas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 384, 176, 64));

        btReservas.setBackground(new java.awt.Color(147, 10, 13));
        btReservas.setFont(new java.awt.Font("Constantia", 1, 15)); // NOI18N
        btReservas.setForeground(new java.awt.Color(255, 255, 255));
        btReservas.setText("Reservar");
        btReservas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        panelReservas.add(btReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 496, 111, -1));

        btCancelar.setBackground(new java.awt.Color(43, 43, 43));
        btCancelar.setFont(new java.awt.Font("Constantia", 1, 15)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btCancelar.setText("Cancelar");
        btCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        panelReservas.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 496, 111, -1));

        JspinerHoraInicio.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        JspinerHoraInicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JspinerHoraInicio.setPreferredSize(new java.awt.Dimension(64, 30));
        panelReservas.add(JspinerHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 288, 176, 25));

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario:");
        panelReservas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 128, -1, -1));

        jLabel10.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Laboratorios:");
        panelReservas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 112, -1));

        cbEdificios.setBackground(new java.awt.Color(147, 10, 13));
        cbEdificios.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbEdificios.setForeground(new java.awt.Color(255, 255, 255));
        cbEdificios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        cbEdificios.setPreferredSize(new java.awt.Dimension(72, 29));
        panelReservas.add(cbEdificios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 192, 25));

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cargo:");
        panelReservas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 416, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(43, 43, 43));
        txtUsuario.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("JUAN");
        txtUsuario.setCaretColor(new java.awt.Color(43, 43, 43));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelReservas.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 125, -1, -1));

        JspinerHoraFin.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        JspinerHoraFin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JspinerHoraFin.setMinimumSize(new java.awt.Dimension(64, 10));
        JspinerHoraFin.setPreferredSize(new java.awt.Dimension(64, 30));
        panelReservas.add(JspinerHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 336, 176, 25));

        jFecha.setBackground(new java.awt.Color(43, 43, 43));
        jFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jFecha.setFont(new java.awt.Font("Constantia", 0, 16)); // NOI18N
        panelReservas.add(jFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 176, 25));

        txtCedulaResponsable.setBackground(new java.awt.Color(147, 10, 13));
        txtCedulaResponsable.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        txtCedulaResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtCedulaResponsable.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCedulaResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelReservas.add(txtCedulaResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 336, 128, 25));

        txtNombreResponsable.setBackground(new java.awt.Color(147, 10, 13));
        txtNombreResponsable.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        txtNombreResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreResponsable.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtNombreResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreResponsableActionPerformed(evt);
            }
        });
        panelReservas.add(txtNombreResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 240, 128, 25));

        txtCargoResponsable.setBackground(new java.awt.Color(147, 10, 13));
        txtCargoResponsable.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        txtCargoResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtCargoResponsable.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCargoResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtCargoResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoResponsableActionPerformed(evt);
            }
        });
        panelReservas.add(txtCargoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 432, 128, 25));

        txtApellidoResponsable.setBackground(new java.awt.Color(147, 10, 13));
        txtApellidoResponsable.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        txtApellidoResponsable.setForeground(new java.awt.Color(255, 255, 255));
        txtApellidoResponsable.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidoResponsable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtApellidoResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoResponsableActionPerformed(evt);
            }
        });
        panelReservas.add(txtApellidoResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 288, 128, 25));

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("LUGAR");
        panelReservas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 176, 288, -1));

        jLabel13.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Apellido");
        panelReservas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 272, -1, -1));

        jLabel14.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cédula:");
        panelReservas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 320, -1, -1));

        jLabel15.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Carrera:");
        panelReservas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 368, -1, -1));

        jLabel16.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Nombre:");
        panelReservas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 224, -1, -1));

        jLabel17.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("RESPONSABLE");
        panelReservas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 176, 208, -1));

        jLabel18.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("HORARIO");
        panelReservas.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 176, 336, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setAlignmentX(0.3F);
        panelReservas.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 160, 843, 16));

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setAlignmentX(0.3F);
        panelReservas.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 544, 843, 16));

        jSeparator5.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setAlignmentX(0.3F);
        panelReservas.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 160, 16, 385));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setAlignmentX(0.3F);
        panelReservas.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 160, 16, 384));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setAlignmentX(0.3F);
        panelReservas.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 16, 385));

        cbCarreras.setBackground(new java.awt.Color(147, 10, 13));
        cbCarreras.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbCarreras.setForeground(new java.awt.Color(255, 255, 255));
        cbCarreras.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        cbCarreras.setPreferredSize(new java.awt.Dimension(72, 29));
        panelReservas.add(cbCarreras, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 384, 128, 25));

        getContentPane().add(panelReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -16, 928, 576));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreResponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreResponsableActionPerformed

    private void txtApellidoResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoResponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoResponsableActionPerformed

    private void txtCargoResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoResponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoResponsableActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JSpinner JspinerHoraFin;
    public javax.swing.JSpinner JspinerHoraInicio;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btReservas;
    public javax.swing.JComboBox<Modelos.Carrera> cbCarreras;
    public javax.swing.JComboBox<Modelos.Block> cbEdificios;
    public javax.swing.JComboBox<Modelos.Lab> cbLaboratorios;
    public com.toedter.calendar.JDateChooser jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel panelReservas;
    public javax.swing.JTextArea textAreaAsunto;
    public javax.swing.JTextField txtApellidoResponsable;
    public javax.swing.JTextField txtCargoResponsable;
    public javax.swing.JTextField txtCedulaResponsable;
    public javax.swing.JTextField txtNombreResponsable;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
