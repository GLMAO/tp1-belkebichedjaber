package org.emp.gl.timer.service;

import java.beans.PropertyChangeListener;

public interface TimeChangeProvider {
    void addTimeChangeListener(PropertyChangeListener listener);
    void removeTimeChangeListener(PropertyChangeListener listener);
}
