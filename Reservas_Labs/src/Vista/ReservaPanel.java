package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;

public class ReservaPanel extends JPanel {
    private JDateChooser dateChooser;
    private JSpinner timeSpinner;

    public ReservaPanel() {
        setLayout(new FlowLayout());
        dateChooser = new JDateChooser();
        timeSpinner = createTimeSpinner();

        add(new JLabel("Fecha y Hora de Fin:"));
        add(dateChooser);
        add(timeSpinner);
    }

    private JSpinner createTimeSpinner() {
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        spinner.setEditor(editor);
        return spinner;
    }
}
