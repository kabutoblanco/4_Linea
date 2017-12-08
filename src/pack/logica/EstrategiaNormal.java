/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import pack.framework.Estrategia;

/**
 *
 * @author daniel
 */
public class EstrategiaNormal implements Estrategia {

    @Override
    public int[][] posicionarFicha(int[][] grillas, int x, int y, int turno) {
        for (int i = grillas.length - 1; i > -1; i--) {
            if (grillas[i][x] == 0) {
                grillas[i][x] = turno;
                break;
            }
        }
        return grillas;
    }
    
}
