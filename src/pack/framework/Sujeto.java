/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.framework;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public interface Sujeto {
    public ArrayList<Observador> _observadores = new ArrayList<>();
    
    public void agregarObservador(Observador _observador);
    public void removerObservador(int pos);
    public void notificarTodos();
}
