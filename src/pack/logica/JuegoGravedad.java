/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import java.awt.event.KeyEvent;
import pack.controlador.Juego;
import pack.modelo.Tablero;

/**
 *
 * @author daniel
 */
public class JuegoGravedad extends Juego {
    private boolean pulso = false;
    private final int[] coordenada = new int[2];
    
    public JuegoGravedad(Tablero _tablero) {
        super(_tablero);
        super.setTurno(1);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (!pulso && validarTecla(e)) {
            pulso = true;
            coordenada[1] = e.getKeyChar() - 48;
        }
        else if (validarTecla(e)) {
            pulso = false;
            coordenada[0] = e.getKeyChar() - 48;
            hacerJugada(coordenada);
        }
    }

    @Override
    public void procesarTurno() {
        if (getTurno() == 1)
            setTurno(2);
        else if (getTurno() == 2)
            setTurno(1);
    }

    @Override
    public void chequearGanador() {
        int cont;
        int filas = getTablero().getGrilla().length;
        int columnas = getTablero().getGrilla()[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cont = 0;
                for (int k = i, l = j; k < filas && l < columnas; k++, l++) {
                    if (getTablero().getGrilla()[k][l] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k > -1 && l < columnas; k--, l++) {
                    if (getTablero().getGrilla()[k][l] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k > -1 && l > - 1; k--, l--) {    
                    if (getTablero().getGrilla()[k][l] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = i, l = j; k < filas && l > -1; k++, l--) {
                    if (getTablero().getGrilla()[k][l] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = j; k < columnas; k++) {
                    if (getTablero().getGrilla()[i][k] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = j; k > -1; k--) {
                    if (getTablero().getGrilla()[i][k] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = i; k < filas; k++) {
                    if (getTablero().getGrilla()[k][j] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
                cont = 0;
                for (int k = i; k > -1; k--) {
                    if (getTablero().getGrilla()[k][j] == turno) {
                        cont++;
                        if (cont == 4) {
                            setEstado(new EstadoGanado(turno));
                            return;
                        }
                    } else break;
                }
            }
        }
    }
    
}
