package org.emp.gl.time.service.impl;

import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;


public class DummyTimeServiceImpl implements TimerService {

    private int dixiemeDeSeconde;
    private int secondes;
    private int minutes;
    private int heures;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DummyTimeServiceImpl() {
        setTimeValues();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setTimeValues();
            }
        }, 100, 100);
    }

    private void setTimeValues() {
        LocalTime localTime = LocalTime.now();
        setHeures(localTime.getHour());
        setMinutes(localTime.getMinute());
        setSecondes(localTime.getSecond());
        setDixiemeDeSeconde(localTime.getNano() / 100_000_000);
    }

    private void setDixiemeDeSeconde(int newVal) {
        int old = this.dixiemeDeSeconde;
        this.dixiemeDeSeconde = newVal;
        support.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, old, newVal);
    }

    private void setSecondes(int newVal) {
        int old = this.secondes;
        this.secondes = newVal;
        support.firePropertyChange(TimerChangeListener.SECONDE_PROP, old, newVal);
    }

    private void setMinutes(int newVal) {
        int old = this.minutes;
        this.minutes = newVal;
        support.firePropertyChange(TimerChangeListener.MINUTE_PROP, old, newVal);
    }

    private void setHeures(int newVal) {
        int old = this.heures;
        this.heures = newVal;
        support.firePropertyChange(TimerChangeListener.HEURE_PROP, old, newVal);
    }

    @Override
    public int getDixiemeDeSeconde() { return dixiemeDeSeconde; }

    @Override
    public int getSecondes() { return secondes; }

    @Override
    public int getMinutes() { return minutes; }

    @Override
    public int getHeures() { return heures; }

    @Override
    public void addTimeChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removeTimeChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
