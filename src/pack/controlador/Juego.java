/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import pack.framework.Estado;
import pack.framework.Observador;
import pack.framework.Sujeto;
import pack.modelo.Tablero;
import pack.vista.TableroGrafico;

/**
 *
 * @author daniel
 */
public abstract class Juego implements KeyListener, Sujeto {
    protected int turno;
    private Tablero _tablero;
    private Estado _estado;

    public Juego(Tablero _tablero) {
        this._tablero = _tablero;
    }
    
    protected boolean validarTecla(KeyEvent e) {
        return e.getKeyChar() - 48 > -1 && e.getKeyChar() - 48 < getTablero().getGrilla()[0].length;
    }
    
    public void iniciarJuego(Estado _estado) {
        setEstado(_estado);
    }
    
    protected void hacerJugada(int[] coordenada) {
        if (getEstado().getEstado()) {
            _tablero.posicionarFicha(coordenada[1], coordenada[0], turno);
            chequearGanador();
            procesarTurno();
            notificarTodos();
        }
    }
    
    
    @Override
    public void agregarObservador(Observador _observador) {
        TableroGrafico grafico = (TableroGrafico) _observador;
        grafico.addKeyListener(this);
        _observadores.add(grafico);
    }
    
    @Override
    public void removerObservador(int pos) {
        _observadores.remove(pos);
    }
    
    @Override
    public void notificarTodos() {
        for (Observador _observador : _observadores)
            _observador.actualizar(this);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    public abstract void procesarTurno();
    
    public abstract void chequearGanador();

    public Tablero getTablero() {
        return _tablero;
    }

    public void setTablero(Tablero _tablero) {
        this._tablero = _tablero;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Estado getEstado() {
        return _estado;
    }

    public void setEstado(Estado _estado) {
        this._estado = _estado;
    }
    
    public ArrayList<Observador> getObservadores() {
        return _observadores;
    }
    
}
