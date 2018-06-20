/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.marcondesnjr.pdm.projeto.webapp;

import io.github.marcondesnjr.pdm.projeto.webapp.httpcall.EventManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author José Marcondes do Nascimento Junior
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Thread t = new EventManager();
        t.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
