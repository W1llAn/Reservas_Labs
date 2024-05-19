package Controladores;

import Vista.Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        cambiarColorMenuItems(menu.lblReservas, menu.panItemReservas, me);

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
    public void mouseExited(MouseEvent e
    ) {
        cambiarColorMenuItems(menu.lblReservas, menu.panItemReservas, e);
    }

}
