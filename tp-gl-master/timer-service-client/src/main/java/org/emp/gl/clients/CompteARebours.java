package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CompteARebours implements PropertyChangeListener {

    private int tempsRestant;
    private TimerService timerService;

    public CompteARebours(int initial, TimerService timerService) {
        this.tempsRestant = initial;
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours initialized: " + initial + " sec");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("seconde")) {
            tempsRestant--;
            System.out.println("Compte à rebours: " + tempsRestant);
            if (tempsRestant <= 0) timerService.removeTimeChangeListener(this);
        }
    }
}
