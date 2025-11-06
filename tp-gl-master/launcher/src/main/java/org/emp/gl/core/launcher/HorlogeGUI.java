package org.emp.gl.core.launcher;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;

public class HorlogeGUI implements TimerChangeListener {

    private JFrame frame;
    private JLabel label;
    private TimerService timerService;

    public HorlogeGUI(String name, TimerService timerService) {
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);

        frame = new JFrame(name);
        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));

        frame.add(label);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        updateLabel();
    }

    private void updateLabel() {
        String timeText = String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes());
        label.setText(timeText);
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            SwingUtilities.invokeLater(this::updateLabel);
        }
    }
}
