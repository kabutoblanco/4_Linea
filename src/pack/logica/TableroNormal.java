/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import pack.framework.Estrategia;
import pack.modelo.Tablero;

/**
 *
 * @author daniel
 */
public class TableroNormal extends Tablero {
    
    public TableroNormal(Estrategia _estrategia, int[][] grilla) {
        super(_estrategia, grilla);
    }
    
}
