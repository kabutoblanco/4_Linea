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
public class EstadoJugar implements Estado {
    
    @Override
    public String notificar() {
        return "jugando";
    }

    @Override
    public boolean getEstado() {
        return true;
    }
    
}
