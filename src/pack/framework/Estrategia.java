/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.framework;

/**
 *
 * @author daniel
 */
public interface Estrategia {
    public int[][] posicionarFicha(int[][] grilla, int x, int y, int turno);
}
