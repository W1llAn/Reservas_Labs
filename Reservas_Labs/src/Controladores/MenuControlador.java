package Controladores;

import Modelos.Horario;
import Vista.Horarios;
import Vista.Laboratorios;
import Vista.Menu;
import Vista.Reservas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuControlador implements MouseListener {

    private Menu menu;
    private final Color rojoOscuro = new Color(147, 10, 13);
    private final Color rojoClaro = new Color(216, 17, 45);
    private final Font BOLD_FONT = new Font("Times New Roman", Font.BOLD, 16);
    private final Font PLAIN_FONT = new Font("Times New Roman", Font.PLAIN, 16);

    public MenuControlador() {
        menu = new Menu();
        this.menu.panItemReservas.addMouseListener(this);
        this.menu.lblReservas.addMouseListener(this);
        this.menu.lblLaboratorios.addMouseListener(this);
        this.menu.lblHorarios.addMouseListener(this);
        this.menu.lblSalir.addMouseListener(this);
    }

    public void iniciar() {
        this.menu.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.menu.lblReservas) {
            Horario horario = new Horario();
            Reservas vistReser = new Reservas();
            try {
                ControlReserva contr= new ControlReserva(vistReser, 
                        horario,"Edificio1","Laboratorio 2",
                        "2024-06-21","9:00","11:00",3);// Mostrar la ventana de reserva cuando se hace clic en lblReservas
                vistReser.setVisible(true);
                this.menu.dispose();
            } catch (SQLException ex) {
                System.out.println("es en inicar reserva");
            } catch (ClassNotFoundException ex) {
                System.out.println("es en inicar reserva");
            }
            this.menu.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==menu.lblHorarios) {
            Horarios vista_horarios = new Horarios();
            Horario horario = new Horario();
            Cont_Horarios contH = new Cont_Horarios(vista_horarios, horario);
            this.menu.dispose();
            vista_horarios.setVisible(true);
        }
        if (e.getSource()==this.menu.lblSalir) {
           System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource()== menu.lblLaboratorios) {
            Laboratorios vistaLabs = new Laboratorios();
            ControllerPanelLabs ctrl_labs = new ControllerPanelLabs(vistaLabs);
            menu.dispose();
        }
    }
    

    @Override
    public void mouseEntered(MouseEvent me) {

        cambiarColorMenuItems(menu.lblReservas, menu.panItemReservas, me);
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
        cambiarColorMenuItems(menu.lblReservas, menu.panItemReservas, me);
        cambiarColorMenuItems(menu.lblHorarios, menu.panItemHorarios, me);
        cambiarColorMenuItems(menu.lblLaboratorios, menu.panItemLaboratorios, me);
        cambiarColorMenuItems(menu.lblSalir, menu.panItemSalir, me);
    }

}
