/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.Festivo;
import Modelos.FestivosDB;
import Modelos.Horario;
import Modelos.LabDB;
import Vista.Festivos;
import Vista.Horarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class FestivosControlador implements ActionListener {

    private final Festivos vista;
    private final Festivo modelo;
    private final FestivosDB dto;
    private final DefaultTableModel table;
    private static int id;
    private static SimpleDateFormat dateFormat;

    public FestivosControlador(Festivos vista) {
        this.vista = vista;
        this.modelo = new Festivo();
        this.dto = new FestivosDB();
        this.table = new DefaultTableModel(new String[]{"ID", "DESCRIPCION", "FECHA INICIO", "FECHA FIN"}, 0);
        this.vista.spinDias.setModel(new SpinnerNumberModel(1, 0, 5, 1));
        this.vista.setVisible(true);
        fillTable();
        eventos();
        id = 0;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private void eventos() {

        vista.btnAdd.addActionListener(this);
        vista.btnDelete.addActionListener(this);
        vista.btnClean.addActionListener(this);
        vista.btnRegresar.addActionListener(this);
        vista.tbLabs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    fillFields(e);
                } catch (ParseException ex) {
                    System.out.println("Error de parseo" + ex);
                }
            }
        });
    }

    private void fillFields(MouseEvent e) throws ParseException {
        JTable target = (JTable) e.getSource();
        id = Integer.parseInt(getRowTable(target.getSelectedRow(), 0));
        vista.jTextArea1.setText(getRowTable(target.getSelectedRow(), 1));
        vista.txtFechaInicio.setDate(dateFormat.parse(getRowTable(target.getSelectedRow(), 2)));
    }

    private String getRowTable(int row, int column) {
        return vista.tbLabs.getModel().getValueAt(row, column).toString();
    }

    private void fillTable() {
        table.setRowCount(0);
        dto.listaFestivos().forEach(lab
                -> table.addRow(new Object[]{lab.getId(), lab.getNombre(), lab.getFechaInicio(), lab.getFechaFin()})
        );
        vista.tbLabs.setModel(table);
    }

    private boolean validateFields() {
        return !(vista.txtFechaInicio.getDate() == null
                || vista.jTextArea1.getText().equals("")
                || (int) vista.spinDias.getValue() == 0);
    }

    private void insertarDiasFestivos() {
        if (validateFields()) {
            modelo.setNombre(vista.jTextArea1.getText());
            modelo.setFechaInicio(obtenerFechaInicio(vista.txtFechaInicio.getDate()));
            modelo.setFechaFin(obtenerFechaFin(vista.txtFechaInicio.getDate()));
            if (dto.insertarDiaFestivo(modelo)) {
                JOptionPane.showMessageDialog(vista, "Se guardo");
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(vista, "No se guardo");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Campos Incompletos");
        }
    }

    private void eliminarFestivos() {
        if (id != 0) {

            if (dto.eliminarDiaFestivo(id)) {
                JOptionPane.showMessageDialog(vista, "Se Borro");
                cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(vista, "El laboratorio tiene una reserva, no se puede borrar");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila");
        }
    }

    private String obtenerFechaInicio(Date fecha) {
        return dateFormat.format(fecha);
    }

    private String obtenerFechaFin(Date fecha) {
        int dias = (int) vista.spinDias.getValue() - 1;
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nuevaFecha = localDate.plusDays(dias);
        Date newDate = Date.from(nuevaFecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return dateFormat.format(newDate);
    }

    private void cleanFields() {
        vista.txtFechaInicio.setDate(null);
        vista.jTextArea1.setText("");
        vista.spinDias.setValue(1);
    }

    public static void main(String[] args) throws ParseException {

        Festivos l = new Festivos();
        FestivosControlador v = new FestivosControlador(l);
    }
    
    public LocalDate convertirFecha(String fecha) {
       String formatoFecha = "yyyy-MM-dd";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formatoFecha);
        LocalDate fechaLocalDate = LocalDate.parse(fecha, formateador);
        return fechaLocalDate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAdd) {
            insertarDiasFestivos();
        }
        if (e.getSource() == vista.btnDelete) {
            eliminarFestivos();
        }
        if (e.getSource() == vista.btnClean) {
           cleanFields();
        }
          if (e.getSource() == vista.btnRegresar) {
            MenuControlador menu = new MenuControlador();
            menu.iniciar();
            this.vista.dispose();
        }
     
            
    }

}
