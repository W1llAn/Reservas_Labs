/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author ASUS
 */
import Modelos.bloque;
import Modelos.docente;
import Modelos.laboratorio;
import java.awt.Color;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class Reservas extends javax.swing.JInternalFrame {

    /**
     * Creates new form reservas
     */
    public Reservas() {
    initComponents();
    this.setLocation(930, 600);
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
        cbLaboratorios = new javax.swing.JComboBox<laboratorio>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaAsunto = new javax.swing.JTextArea();
        btReservas = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        JspinerHoraInicio = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbEdificios = new javax.swing.JComboBox<bloque>();
        jLabel11 = new javax.swing.JLabel();
        cbResponsables = new javax.swing.JComboBox<docente>();
        txtUsuario = new javax.swing.JTextField();
        JspinerHoraFin = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(930, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReservas.setBackground(new java.awt.Color(43, 43, 43));
        panelReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Reborn", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reservas");
        panelReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 29, -1, 78));

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Edifici0:");
        panelReservas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 284, -1, -1));

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hora inicio:");
        panelReservas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 284, -1, -1));

        jLabel5.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora fin:");
        panelReservas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 356, -1, -1));

        jLabel7.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de reserva:");
        panelReservas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Asunto:");
        panelReservas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 210, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-sitio-fisei-2020.png"))); // NOI18N
        panelReservas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, -1, -1));

        cbLaboratorios.setBackground(new java.awt.Color(147, 10, 13));
        cbLaboratorios.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbLaboratorios.setForeground(new java.awt.Color(255, 255, 255));
        cbLaboratorios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelReservas.add(cbLaboratorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 387, 220, 29));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setAlignmentX(0.3F);
        panelReservas.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 178, 843, 26));

        textAreaAsunto.setBackground(new java.awt.Color(147, 10, 13));
        textAreaAsunto.setColumns(20);
        textAreaAsunto.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        textAreaAsunto.setForeground(new java.awt.Color(255, 255, 255));
        textAreaAsunto.setLineWrap(true);
        textAreaAsunto.setRows(5);
        textAreaAsunto.setToolTipText("");
        textAreaAsunto.setWrapStyleWord(true);
        textAreaAsunto.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        textAreaAsunto.setCaretColor(new java.awt.Color(255, 255, 255));
        textAreaAsunto.setDisabledTextColor(new java.awt.Color(147, 10, 13));
        jScrollPane2.setViewportView(textAreaAsunto);

        panelReservas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 236, -1, 77));

        btReservas.setBackground(new java.awt.Color(147, 10, 13));
        btReservas.setFont(new java.awt.Font("Constantia", 1, 15)); // NOI18N
        btReservas.setForeground(new java.awt.Color(255, 255, 255));
        btReservas.setText("Reservar");
        btReservas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        panelReservas.add(btReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 508, 111, -1));

        btCancelar.setBackground(new java.awt.Color(43, 43, 43));
        btCancelar.setFont(new java.awt.Font("Constantia", 1, 15)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btCancelar.setText("Cancelar");
        btCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255)));
        panelReservas.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 508, 111, -1));

        JspinerHoraInicio.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        JspinerHoraInicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JspinerHoraInicio.setPreferredSize(new java.awt.Dimension(64, 30));
        panelReservas.add(JspinerHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 309, 141, 29));

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario:");
        panelReservas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Laboratorios:");
        panelReservas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 356, -1, -1));

        cbEdificios.setBackground(new java.awt.Color(147, 10, 13));
        cbEdificios.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbEdificios.setForeground(new java.awt.Color(255, 255, 255));
        cbEdificios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        cbEdificios.setPreferredSize(new java.awt.Dimension(72, 29));
        panelReservas.add(cbEdificios, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 309, 220, -1));

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Docente:");
        panelReservas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 210, -1, -1));

        cbResponsables.setBackground(new java.awt.Color(147, 10, 13));
        cbResponsables.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        cbResponsables.setForeground(new java.awt.Color(255, 255, 255));
        cbResponsables.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        panelReservas.add(cbResponsables, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 236, 220, 29));

        txtUsuario.setBackground(new java.awt.Color(43, 43, 43));
        txtUsuario.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("juan");
        panelReservas.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 138, -1, -1));

        JspinerHoraFin.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        JspinerHoraFin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        JspinerHoraFin.setMinimumSize(new java.awt.Dimension(64, 10));
        JspinerHoraFin.setPreferredSize(new java.awt.Dimension(64, 30));
        panelReservas.add(JspinerHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 387, 141, 29));

        getContentPane().add(panelReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -16, 928, 576));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JSpinner JspinerHoraFin;
    public javax.swing.JSpinner JspinerHoraInicio;
    public javax.swing.JButton btCancelar;
    public javax.swing.JButton btReservas;
    public javax.swing.JComboBox<bloque> cbEdificios;
    public javax.swing.JComboBox<laboratorio> cbLaboratorios;
    public javax.swing.JComboBox<docente> cbResponsables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelReservas;
    public javax.swing.JTextArea textAreaAsunto;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
