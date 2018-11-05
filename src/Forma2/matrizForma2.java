package Forma2;

import Forma1.NodoDoble;
import Tripleta.Tripleta;

//@author BreakerMoob
 
public class matrizForma2 {
    
    private NodoDoble mat;

    public matrizForma2(int m, int n)
    {
        Tripleta t = new Tripleta(m, n, null);
        mat = new NodoDoble(t);
        Tripleta tx = new Tripleta(0,0,null);
        NodoDoble x = new NodoDoble(tx); 
        x.setLigaIzq(x);
        x.setLigaDer(x);
        mat.setLigaDer(x);
    }
   
    public NodoDoble primerNodo()
    {
        return mat;
    }
    
    public NodoDoble nodoCabeza()
    {
        return mat.getLigaDer();
    }
    
    public boolean esVacia()
    {
        NodoDoble p = mat.getLigaDer();
        return (p.getLigaIzq() == p && p.getLigaDer() == p);
    }
    
    public boolean finDeRecorrido(NodoDoble p)
    {
        return p == nodoCabeza();
    }
    
    public void muestraMatriz()
    {
        int qf, qc, qv;
        NodoDoble q;
        Tripleta tq;
        q = nodoCabeza().getLigaDer();
        while(!finDeRecorrido(q))
        {
            tq = q.getDato();
            qf = tq.getFila();
            qc = tq.getColumna();
            qv = (int) tq.getDato();
            System.out.println(qf+" "+qc+" "+qv);
            q = q.getLigaDer();
        }
    }
    
    public void conectaPorFilasForma2(NodoDoble x)
    {
        NodoDoble p, q, anterior;
        Tripleta tq,tx;
        int i;
        tx = x.getDato();
        p = nodoCabeza();
        anterior = p;
        q = p.getLigaDer();
        tq = q.getDato();
        while((q != p) && (tq.getFila() < tx.getFila()))
        {
            anterior = q;
            q = q.getLigaDer();
            tq = q.getDato(); 
        }
        while((q != p) && (tq.getFila() == tx.getFila()) && (tq.getColumna() < tx.getColumna()))
        {
            anterior = q;
            q = q.getLigaDer();
            tq = q.getDato();
        }
        anterior.setLigaDer(x);
        x.setLigaDer(q);
    }
    
    public void  conectaPorColumnasForma2(NodoDoble x)
    {
        NodoDoble p, q, anterior;
        Tripleta tq, tx;
        int i;
        tx = x.getDato();
        p = nodoCabeza();
        anterior = p;
        q = p.getLigaIzq();
        tq = q.getDato();
        while((q != p) && (tq.getColumna() < tx.getColumna()))
        {
            anterior = q;
            q = q.getLigaIzq();
            tq = q.getDato();
        }
        while((q != p) && (tq.getColumna() == tx.getColumna()) && (tq.getFila() < tx.getFila()))
        {
            anterior = q;
            q = q.getLigaIzq();
            tq = q.getDato();
        }
        anterior.setLigaIzq(x);
        x.setLigaIzq(q);
    }
    
    
}
