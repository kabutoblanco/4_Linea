/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import pack.controlador.Juego;
import pack.logica.EstadoJugar;
import pack.logica.EstrategiaGravedad;
import pack.logica.EstrategiaNormal;
import pack.logica.JuegoGravedad;
import pack.logica.JuegoNormal;
import pack.logica.TableroNormal;
import pack.modelo.Tablero;
import pack.vista.TableroGrafico;

/**
 *
 * @author daniel
 */
public class Main {
    public static JFrame _frame = new JFrame("JEA");
    public static Juego _juego;
    public static PanelMenu _menu;
    
    public static void main(String[] argv) {
        _menu = new PanelMenu();
        _menu.setPreferredSize(new Dimension(377, 85));
        _frame.getContentPane().setLayout(new BorderLayout());
        _frame.getContentPane().add(_menu, BorderLayout.PAGE_START);
        _frame.setDefaultCloseOperation(3);
        _frame.pack();
        _frame.setResizable(false);
        _frame.setVisible(true);
    }
    
}
