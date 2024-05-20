import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TimeGUI extends JFrame {
    private JDateChooser dateChooserInicio;
    private JSpinner timeSpinnerInicio;
    private JDateChooser dateChooserFin;
    private JSpinner timeSpinnerFin;
    private JButton btnGuardar;

    public TimeGUI() {
        setTitle("Reserva de Laboratorio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        dateChooserInicio = new JDateChooser();
        timeSpinnerInicio = createTimeSpinner();

        dateChooserFin = new JDateChooser();
        timeSpinnerFin = createTimeSpinner();

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarReserva());

        add(new JLabel("Fecha y Hora de Inicio:"));
        add(dateChooserInicio);
        add(timeSpinnerInicio);
        add(new JLabel("Fecha y Hora de Fin:"));
        add(dateChooserFin);
        add(timeSpinnerFin);
        add(btnGuardar);
    }

    private JSpinner createTimeSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(editor);
        return spinner;
    }

    private void guardarReserva() {
        Date fechaInicio = dateChooserInicio.getDate();
        Date horaInicio = (Date) timeSpinnerInicio.getValue();
        Date fechaFin = dateChooserFin.getDate();
        Date horaFin = (Date) timeSpinnerFin.getValue();

        // Combina las fechas y horas según sea necesario
        System.out.println("Reserva guardada: " +
                "Fecha Inicio: " + fechaInicio + " Hora Inicio: " + horaInicio +
                ", Fecha Fin: " + fechaFin + " Hora Fin: " + horaFin);
    }

    // Método main para probar la clase TimeGUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimeGUI().setVisible(true);
            }
        });
    }
}
