package Controladores;

import Modelos.Horario;
import Modelos.LabDB;
import Modelos.UsuarioSesion;
import Vista.Horarios;
import Vista.Laboratorios;
import Vista.Menu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class MenuControlador implements MouseListener {

    private Menu menu;
    private final Color rojoOscuro = new Color(147, 10, 13);
    private final Color rojoClaro = new Color(216, 17, 45);
    private final Font BOLD_FONT = new Font("Times New Roman", Font.BOLD, 16);
    private final Font PLAIN_FONT = new Font("Times New Roman", Font.PLAIN, 16);
    private JPanel panItemLaboratorios;
    private JLabel lblLaboratorios;

    public MenuControlador() {
        menu = new Menu();
        this.menu.lblLaboratorios.addMouseListener(this);
        this.menu.lblHorarios.addMouseListener(this);
        this.menu.lblSalir.addMouseListener(this);
        String rol = UsuarioSesion.getRol();
        if (rol.equals("ADMIN")) {
            initComponets();
        }

    }

    public void iniciar() {
        this.menu.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == menu.lblHorarios) {
            Horarios vista_horarios = new Horarios();
            Horario horario = new Horario();
            try {
                Cont_Horarios ctrl_horario = new Cont_Horarios(vista_horarios, horario, new LabDB().labList());
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.menu.dispose();
            vista_horarios.setVisible(true);
        }
        if (e.getSource() == this.menu.lblSalir) {
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == menu.lblLaboratorios) {
            Laboratorios vistaLabs = new Laboratorios();
            ControllerPanelLabs ctrl_labs = new ControllerPanelLabs(vistaLabs);
            menu.dispose();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {

        cambiarColorMenuItems(menu.lblHorarios, menu.panItemHorarios, me);
        cambiarColorMenuItems(menu.lblLaboratorios, menu.panItemLaboratorios, me);
        cambiarColorMenuItems(menu.lblSalir, menu.panItemSalir, me);

    }

    private void cambiarColorMenuItems(JLabel etiqueta, JPanel panel, MouseEvent me) {

        if (me.getID() == MouseEvent.MOUSE_ENTERED) {
            if (me.getSource() == etiqueta) {
                panel.setBackground(rojoClaro);
                etiqueta.setFont(BOLD_FONT);
            }
        } else if (me.getID() == MouseEvent.MOUSE_EXITED) {
            if (me.getSource() == etiqueta) {
                panel.setBackground(rojoOscuro);
                etiqueta.setFont(PLAIN_FONT);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
        cambiarColorMenuItems(menu.lblHorarios, menu.panItemHorarios, me);
        cambiarColorMenuItems(menu.lblLaboratorios, menu.panItemLaboratorios, me);
        cambiarColorMenuItems(menu.lblSalir, menu.panItemSalir, me);
    }

    private void initComponets() {
        
        panItemLaboratorios = new JPanel();
        lblLaboratorios = new JLabel("Agregar usuarios");

        // Establecer el color de fondo del panel
        panItemLaboratorios.setBackground(new Color(147, 10, 13));
        panItemLaboratorios.setPreferredSize(new Dimension(200, 50));
        panItemLaboratorios.setBorder(new LineBorder(Color.WHITE, 2));
        // Establecer el color del texto y otras propiedades
        lblLaboratorios.setForeground(Color.WHITE);

        lblLaboratorios.setHorizontalAlignment(SwingConstants.CENTER);
        lblLaboratorios.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        panItemLaboratorios.setLayout(new BorderLayout());
        panItemLaboratorios.add(lblLaboratorios, BorderLayout.CENTER);

        // Añadir un MouseListener para que el panel funcione como un botón
        panItemLaboratorios.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseEntered(MouseEvent e) {
                panItemLaboratorios.setBackground(new Color(170, 30, 30)); // Cambiar color al pasar el mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panItemLaboratorios.setBackground(new Color(147, 10, 13)); // Restaurar color al salir del mouse
            }
        });
       

        // Establecer la posición y el tamaño del panel manualmente
        panItemLaboratorios.setBounds(16, 208, 260, 50);

       
    }

}
