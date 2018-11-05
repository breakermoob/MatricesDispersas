package Tripleta;


// @author BreakerMoob

public class Tripleta {
    private int fila,columna;
    private Object dato;
    public Tripleta(int fila, int columna,Object dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
 
    public Object getDato() {
        return dato;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    
}
