package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Horloge implements PropertyChangeListener {

    private String name;
    private TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
        System.out.println("Horloge " + name + " initialized!");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("seconde")) afficherHeure();
    }

    public void afficherHeure() {
        System.out.println(name + " -> " +
                timerService.getHeures() + ":" +
                timerService.getMinutes() + ":" +
                timerService.getSecondes());
    }
}
