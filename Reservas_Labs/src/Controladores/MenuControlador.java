package Controladores;

import Modelos.Horario;
import Modelos.LabDB;
import Modelos.Usuario;
import Utilidades.Recurso;
import Modelos.UsuarioSesion;
import Vista.Festivos;
import Vista.Horarios;
import Vista.Laboratorios;
import Vista.Login;
import Vista.Menu;
import Vista.Usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class MenuControlador implements MouseListener {

    private Menu menu;
    private Recurso rec = new Recurso();
    private final Color rojoOscuro = new Color(212,215,224);//[188,192,203][147,10,13
    private final Color rojoClaro = new Color(188,192,203);//[212,215,224]
    private final Font BOLD_FONT = new Font("Times New Roman", Font.BOLD, 16);
    private final Font PLAIN_FONT = new Font("Times New Roman", Font.PLAIN, 16);

    public MenuControlador() {
        String rol = UsuarioSesion.getRol();
        menu = new Menu();
        ImageIcon fondo = new ImageIcon("src\\imagenes\\FondoN.png");
        int ancho=menu.lblFondo.getWidth(), largo = menu.lblFondo.getHeight();
         Image imagenEscalada = fondo.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
         ImageIcon imagenFinal = new ImageIcon(imagenEscalada);
         menu.lblFondo.setIcon(imagenFinal);
        if (rol.equals("ADMIN")) {
            this.menu.lblLAgregarUsuario.addMouseListener(this);
            this.menu.lblLaboratorios.addMouseListener(this);
            this.menu.lblLDiaFeriado.addMouseListener(this);
            this.menu.lblHorarios.addMouseListener(this);
            this.menu.lblSalir.addMouseListener(this);
        } else {
            this.menu.lblLDiaFeriado.addMouseListener(this);
            this.menu.lblLAgregarUsuario.setVisible(false);
            this.menu.panItemDiasFestivos.setVisible(false);
            this.menu.lblLaboratorios.addMouseListener(this);
            this.menu.lblHorarios.addMouseListener(this);
            this.menu.lblSalir.addMouseListener(this);
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
             LocalDate fechaActual = LocalDate.now();
            try {
                Cont_Horarios ctrl_horario = new Cont_Horarios(vista_horarios, horario, new LabDB().labList(),fechaActual,0,0,false);
            } catch (SQLException ex) {
                Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.menu.dispose();
            vista_horarios.setVisible(true);
        }
        if (e.getSource()==menu.lblLDiaFeriado) {
            Festivos vista_DiaFestivo = new Festivos();
            FestivosControlador  ctrl_festivo = new FestivosControlador(vista_DiaFestivo);
            this.menu.dispose();
            vista_DiaFestivo.setVisible(true);
        }

        if (e.getSource() == this.menu.lblSalir) {
            boolean conf =this.rec.ConfirmarAccion("Está seguro que quiere salir?");
            if ( conf) {
                Login log = new Login();
                Usuario user = new Usuario();
                try {
                    Cont_login controlador = new Cont_login(log, user);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                log.setVisible(true);
                this.menu.dispose();
            }
        }

        if (e.getSource() == this.menu.lblLAgregarUsuario) {
            Usuarios user = new Usuarios();
            user.setVisible(true);
             this.menu.dispose();
            
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
        cambiarColorMenuItems(menu.lblLDiaFeriado, menu.panItemDiasFestivos, me);
        cambiarColorMenuItems(menu.lblLAgregarUsuario, menu.panItemAgregarUsuarios, me);


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
        cambiarColorMenuItems(menu.lblLAgregarUsuario, menu.panItemAgregarUsuarios, me);
        cambiarColorMenuItems(menu.lblLDiaFeriado, menu.panItemDiasFestivos, me);
    }

}
