/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.modelo;

import pack.framework.Estado;
import pack.framework.Estrategia;

/**
 *
 * @author daniel
 */
public abstract class Tablero {
    protected Estrategia _estrategia;
    protected int[][] grilla;

    public Tablero(Estrategia _estrategia, int[][] grilla) {
        this._estrategia = _estrategia;
        this.grilla = grilla;
    }
    
    public void posicionarFicha(int x, int y, int turno) {
        _estrategia.posicionarFicha(grilla, x, y, turno);
    }

    public Estrategia getEstrategia() {
        return _estrategia;
    }

    public void setEstrategia(Estrategia _estrategia) {
        this._estrategia = _estrategia;
    }

    public int[][] getGrilla() {
        return grilla;
    }

    public void setGrilla(int[][] grilla) {
        this.grilla = grilla;
    }
}
