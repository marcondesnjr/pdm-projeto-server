/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.webapp.httpcall;

import io.github.marcondesnjr.pdm.projeto.server.entity.Alert;
import io.github.marcondesnjr.pdm.projeto.server.entity.Fissure;
import io.github.marcondesnjr.pdm.projeto.server.entity.Invasion;
import io.github.marcondesnjr.pdm.projeto.server.entity.Sortie;
import io.github.marcondesnjr.pdm.projeto.server.http.OnlineWorldStatus;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONAlert;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONFissure;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONInvasion;
import io.github.marcondesnjr.pdm.projeto.server.json.JSONSortie;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class EventManager extends Thread {

    private static List<Alert> alerts;
    private static List<Invasion> invasions;
    private static List<Fissure> fissures;
    private static List<Sortie> sortie;
    
    private final int DELAY = 1000*60*1;

    @Override
    public void run() {

        while (true) {

            try {
                OnlineWorldStatus ws = new OnlineWorldStatus();
                JSONObject root = ws.getRootJson();
                
                this.alerts = JSONAlert.getAlerts(root);
                this.invasions = JSONInvasion.getInvasions(root);
                this.fissures = JSONFissure.getFissures(root);
                this.sortie = JSONSortie.getSortie(root);
                
                sleep(DELAY);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static List<Alert> getAlerts() {
        return alerts;
    }

    public static List<Invasion> getInvasions() {
        return invasions;
    }

    public static List<Fissure> getFissures() {
        return fissures;
    }

    public static List<Sortie> getSortie() {
        return sortie;
    }
    
    

}
