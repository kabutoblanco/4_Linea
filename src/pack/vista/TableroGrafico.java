/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pack.controlador.Juego;
import pack.modelo.Tablero;
import pack.framework.Observador;
import pack.framework.Sujeto;

/**
 *
 * @author daniel
 */
public abstract class TableroGrafico extends JPanel implements Observador {
    private final JLabel estadoJuego;
    private Tablero _tablero;

    public TableroGrafico(Tablero _tablero) {
        estadoJuego = new JLabel("Estado: -");
        this._tablero = _tablero;
        crear();
    }
    
    @Override
    public void actualizar(Sujeto _sujeto) {
       Juego _juego = (Juego) _sujeto;
       estadoJuego.setText("Estado: " + _juego.getEstado().notificar());
       _tablero = _juego.getTablero();
       mostrarJugada();
    }
    
    private void crear() {
        add(estadoJuego);
        setFocusable(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < _tablero.getGrilla().length; i++) {
            for (int j = 0; j < _tablero.getGrilla()[i].length; j++) {
                if (_tablero.getGrilla()[i][j] != 0) {
                    if (_tablero.getGrilla()[i][j] == 1)
                        g.setColor(Color.red);
                    else if (_tablero.getGrilla()[i][j] == 2)
                        g.setColor(Color.blue);
                    g.fillRect(j * 60 + 8, i * 60 + 30, 60, 60);
                }
                g.setColor(Color.black);
                g.drawRect(j * 60 + 8, i * 60 + 30, 60, 60);
            }
        }
    }
    
    public void mostrarGanador(int turno) {
        JOptionPane.showMessageDialog(this, "Ganador: " + turno, "OJO", JOptionPane.OK_OPTION);
    }
    
    public void mostrarPerdedor(int turno) {
        JOptionPane.showMessageDialog(this, "Perdedor: " + turno, "OJO", JOptionPane.OK_OPTION);
    }
    
    public void mostrarJugada() {
        repaint();
    }

    public Tablero getTablero() {
        return _tablero;
    }

    public void setTablero(Tablero _tablero) {
        this._tablero = _tablero;
    }
}
