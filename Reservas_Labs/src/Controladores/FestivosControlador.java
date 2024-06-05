/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Block;
import Modelos.Festivo;
import Modelos.FestivosDB;
import Modelos.Lab;
import Vista.Festivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
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

    public FestivosControlador(Festivos vista) {
        this.vista = vista;
        this.modelo = new Festivo();
        this.dto = new FestivosDB();
        this.table = new DefaultTableModel(new String[]{"ID", "DESCRIPCION", "FECHA INICIO", "FECHA FIN"}, 0);
        this.vista.spinDias.setModel(new SpinnerNumberModel(1, 0, 5, 1));
        this.vista.setVisible(true);
        fillTable();
        eventos();
    }

    private void eventos() {

        vista.btnAdd.addActionListener(this);
        vista.btnDelete.addActionListener(this);
        vista.btnClean.addActionListener(this);
        vista.btnRegresar.addActionListener(this);
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
                //cleanFields();
                fillTable();
            } else {
                JOptionPane.showMessageDialog(vista, "No se guardo");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Campos Incompletos");
        }
    }

    private String obtenerFechaInicio(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }

    private String obtenerFechaFin(Date fecha) {
        int dias = (int) vista.spinDias.getValue()-1;
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate nuevaFecha = localDate.plusDays(dias);
        Date newDate = Date.from(nuevaFecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(newDate);
    }

    private void cleanFields() {
        vista.txtFechaInicio.setDate(null);
        vista.jTextArea1.setText("");
        vista.spinDias.setValue(1);
    }

    public static void main(String[] args) throws ParseException {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha = dateFormat.parse("2023-06-04");
//        int diasASumar = 5;
//        String nuevaFechaStr = obtenerFechaFin(fecha, diasASumar);
//        System.out.println("Nueva fecha: " + nuevaFechaStr);
        Festivos l = new Festivos();
        FestivosControlador v = new FestivosControlador(l);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAdd) {
            insertarDiasFestivos();
        }
    }

}
