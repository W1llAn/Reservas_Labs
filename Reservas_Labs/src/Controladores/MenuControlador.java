package Controladores;

import Modelos.Reserva;
import Vista.Horarios;
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
    }

    public void iniciar() {
        this.menu.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.menu.lblReservas) {
            Reserva res = new Reserva();
            Reservas vistReser = new Reservas();
            try {
                ControlReserva contr= new ControlReserva(vistReser, res);// Mostrar la ventana de reserva cuando se hace clic en lblReservas
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
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

        cambiarColorMenuItems(menu.lblReservas, menu.panItemReservas, me);
        cambiarColorMenuItems(menu.lblHorarios, menu.panItemHorarios, me);
        cambiarColorMenuItems(menu.lblLaboratorios, menu.panItemLaboratorios, me);
        cambiarColorMenuItems(menu.lblCerrar, menu.panItemCerrar, me);
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
        cambiarColorMenuItems(menu.lblCerrar, menu.panItemCerrar, me);
        cambiarColorMenuItems(menu.lblSalir, menu.panItemSalir, me);
    }

}
