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
public class EstrategiaGravedad implements Estrategia {

    @Override
    public int[][] posicionarFicha(int[][] grilla, int x, int y, int turno) {
        if (grilla[y][x] == 0) {
            grilla[y][x] = turno;
            int cont; boolean ficha;
            int filas = grilla.length;
            int columnas = grilla[0].length;
            int x1 = x;
            int x2 = grilla[0].length - x1 - 1;
            int y1 = y;
            int y2 = grilla.length - y1 - 1;
            System.out.println("x1: " + x1);
            System.out.println("y1: " + y1);
            System.out.println("x2: " + x2);
            System.out.println("y2: " + y2);
            boolean izq = false, der = false, hor = false, arr = false, aba = false, ver = false;
            if (x1 - x2 < x2 - x1)
                izq = true;
            if (x1 - x2 > x2 - x1)
                der = true;
            if (x1 - x2 == x2 - x1)
                hor = true;
            if (y1 - y2 < y2 - y1)
                arr = true;
            if (y1 - y2 > y2 - y1)
                aba = true;
            if (y1 - y2 == y2 - y1)
                ver = true;
            System.out.println("Izq: " + Boolean.toString(izq) + " | " + (x1 - x2) + " < " + (x2 - x1));
            System.out.println("Der: " + Boolean.toString(der) + " | " + (x1 - x2) + " > " + (x2 - x1));
            System.out.println("Hor: " + Boolean.toString(hor) + " | " + (x1 - x2) + " = " + (x2 - x1));
            System.out.println("Arr: " + Boolean.toString(arr) + " | " + (y1 - y2) + " < " + (y2 - y1));
            System.out.println("Aba: " + Boolean.toString(aba) + " | " + (y1 - y2) + " > " + (y2 - y1));
            System.out.println("Ver: " + Boolean.toString(ver) + " | " + (y1 - y2) + " = " + (y2 - y1));
            if (arr && izq && Math.abs(x1) == Math.abs(y1)) {
                System.out.println("diagonal arr izq");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i > -1 && j > -1; i--, j--, cont++) {
                    if (i - 1 > -1 && j - 1 > -1) {
                        if (grilla[i - 1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i + 1][j + 1] = 0;
                    if (grilla[i][j] == 0 && ficha || i == 0 || j == 0)
                        grilla[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (arr && der && Math.abs(x2) == Math.abs(y1)) {
                System.out.println("diagonal arr der");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i > -1 && j < columnas; i--, j++, cont++) {
                    if (i - 1 > -1 && j + 1 < columnas) {
                        if (grilla[i - 1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i + 1][j - 1] = 0;
                    if (grilla[i][j] == 0 && ficha || i == 0 || j == columnas - 1)
                        grilla[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (aba && izq && Math.abs(x1) == Math.abs(y2)) {
                System.out.println("diagonal abj izq");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i < filas && j > -1; i++, j--, cont++) {
                    if (i + 1 < filas && j - 1 > -1) {
                        if (grilla[i + 1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i - 1][j + 1] = 0;
                    if (grilla[i][j] == 0 || i == filas - 1 || j == 0)
                        grilla[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (aba && der && Math.abs(x2) == Math.abs(y2)) {
                System.out.println("diagonal abj der");
                cont = 0; ficha = false;
                for (int i = y1, j = x1; i < filas && j < columnas; i++, j++, cont++) {
                    if (i + 1 < filas && j + 1 < columnas) {
                        if (grilla[i + 1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i - 1][j - 1] = 0;
                    if (grilla[i][j] == 0 || i == filas - 1 || j == columnas - 1)
                        grilla[i][j] = turno;
                    if (ficha) break;
                }
            }
            else if (arr && hor || (arr && !hor && (x1 - x2 > y1 - y2 || x1 - x2 > y1 - y2))) {
                System.out.println("arr");
                cont = 0; ficha = false;
                for (int i = y1; i > -1; i--, cont++) {
                    if (i - 1 > -1) {
                        if (grilla[i - 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i + 1][x1] = 0;
                    if (grilla[i][x1] == 0 || i == 0)
                        grilla[i][x1] = turno;
                    if (ficha) break;
                }
            }
            else if (aba && hor || (aba && !hor && (x1 - x2 > y2 - y1 || x1 - x2 > y2 - y1))) {
                System.out.println("aba");
                cont = 0; ficha = false;
                for (int i = y1; i < filas; i++, cont++) {
                    if (i + 1 < filas) {
                        if (grilla[i + 1][x1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[i - 1][x1] = 0;
                    if (grilla[i][x1] == 0 || i == filas - 1)
                        grilla[i][x1] = turno;
                    if (ficha) break;
                }
            }
            else if (izq && ver || (izq && !ver && (x1 - x2 < y1 - y2 || x1 - x2 < y2 - y1))) {
                System.out.println("izq");
                cont = 0; ficha = false;
                for (int j = x1; j > -1; j--, cont++) {
                    if (j - 1 > -1) {
                        if (grilla[y1][j - 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[y1][j + 1] = 0;
                    if (grilla[y1][j] == 0 || j == 0)
                        grilla[y1][j] = turno;
                    if (ficha) break;
                }
            }
            else if (der && ver || (der && !ver && (x2 - x1 < y1 - y2 || x2 - x1 < y2 - y1))) {
                System.out.println("der");
                cont = 0; ficha = false;
                for (int j = x1; j < columnas; j++, cont++) {
                    if (j + 1 < columnas) {
                        if (grilla[y1][j + 1] != 0)
                            ficha = true;
                    }
                    if (cont > 0)
                        grilla[y1][j - 1] = 0;
                    if (grilla[y1][j] == 0 || j == columnas - 1)
                        grilla[y1][j] = turno;
                    if (ficha) break;
                }
            }
        }
        return grilla;
    }
    
}
