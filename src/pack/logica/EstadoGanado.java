/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.logica;

import pack.framework.Estado;

/**
 *
 * @author daniel
 */
public class EstadoGanado implements Estado {    
    private final int turno;

    public EstadoGanado(int turno) {
        this.turno = turno;
    }
    
    @Override
    public String notificar() {
        return "ganador " + turno;
    }

    @Override
    public boolean getEstado() {
        return false;
    }
    
}
