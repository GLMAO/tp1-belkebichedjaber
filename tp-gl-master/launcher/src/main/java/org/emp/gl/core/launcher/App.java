package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        TimerService timerService = new DummyTimeServiceImpl();

        // Horloges console
        Horloge h1 = new Horloge("Horloge 1", timerService);
        Horloge h2 = new Horloge("Horloge 2", timerService);

        // Compte à rebours
        CompteARebours c1 = new CompteARebours(5, timerService);

        // Plusieurs compte à rebours aléatoires
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            new CompteARebours(10 + rand.nextInt(11), timerService);
        }

        // Horloge GUI
        new HorlogeGUI("Horloge Graphique", timerService);
    }
}
