/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nebulamusic.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 *
 * @author Usuario
 */
@WebListener
public class AppListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent e){
        ServletContext app = e.getServletContext();
        app.setAttribute("appname", "Nebula Music PRUEBA");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent e){
        
    }
}
