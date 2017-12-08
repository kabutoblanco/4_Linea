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
public class EstrategiaComplica implements Estrategia {

    @Override
    public int[][] posicionarFicha(int[][] grilla, int x, int y, int turno) {
        System.err.println(x + " - " + y);
        for (int i = grilla.length - 1; i > -1; i--) {
            if (grilla[i][x] == 0) {
                grilla[i][x] = turno;
                break;
            }
            else if (i == 0 && grilla[i][x] != 0) {
                System.out.println("tope");
                for (int j = grilla.length - 1; j > 0; j--)
                    grilla[j][x] = grilla[j - 1][x];
                grilla[i][x] = turno;
                return grilla;
            }
        }
        return grilla;
    }
    
}
