/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forma1;

import Tripleta.Tripleta;

/**
 *
 * @author Familia
 */
public class NodoDoble {
    
    private NodoDoble ligaDer;
    private NodoDoble ligaIzq;
    private Tripleta t;
    
    public NodoDoble(Tripleta t)
    {
        ligaDer = null;
        ligaIzq = null;
        this.t = t;
    }

    public NodoDoble getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoDoble ligaDer) {
        this.ligaDer = ligaDer;
    }

    public NodoDoble getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(NodoDoble ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    public Tripleta getDato() { 
        return t;
    }

    public void setDato(Tripleta t) {
        this.t = t;
    }
   
    
}
