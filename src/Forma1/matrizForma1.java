package Forma1;

import Tripleta.Tripleta;

//@author BreakerMoob
 
public class matrizForma1 {
    private final NodoDoble mat;

    
    public matrizForma1(int m, int n)
    {
        Tripleta t;
        t = new Tripleta(m,n,null);
        mat = new NodoDoble(t);
        t.setDato(mat); 
        mat.getDato(); 
    }
    
    public NodoDoble nodoCabeza()
    {
        return mat;
    }
    
    public NodoDoble primerNodo()
    {
        Tripleta tp = mat.getDato(); 
        NodoDoble p = (NodoDoble) tp.getDato();
        return p;
    }
    
    public boolean esVacia()
    {
        NodoDoble p = primerNodo();
        return p == mat;
    }
    
    public boolean finDeRecorrido(NodoDoble p)
    {
        return p == mat;
    }
    
    public void muestraMatriz()
    {
        int qf, qc, qv;
        NodoDoble p, q;
        Tripleta tq, tp;
        p = primerNodo();
        while(!(finDeRecorrido(p)))
        {
            q = p.getLigaDer();
            while(q != p)
            {
                tq = q.getDato();
                qf = tq.getFila();
                qc = tq.getColumna();
                qv = (int) tq.getDato(); 
                System.out.println(qf+" "+qc+" "+qv);
                q = q.getLigaDer();
            }
            tp = p.getDato();
            p = (NodoDoble) tp.getDato();
        }
    }
    
    public void construyeNodosCabeza()
    {   
        int mayor,i,m,n;
        NodoDoble x,ultimo;
        Tripleta t;
        ultimo = nodoCabeza();
        t = ultimo.getDato(); 
        m = t.getFila();
        n = t.getColumna();
        mayor = m;
        if(n > m)
        {
            mayor = n;
        } 
        for(i = 1; i <= mayor; i++)
        {
            t = new Tripleta(i,i,nodoCabeza());
            x = new NodoDoble(t);
            x.setLigaDer(x);
            x.setLigaIzq(x);
            t = ultimo.getDato();
            t.setDato(x);
            ultimo.setDato(t); 
            ultimo = x;
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void conectaPorFilas(NodoDoble x)
    {
        NodoDoble p, q, anterior;
        Tripleta tp, tq, tx;
        int i;
        tx = x.getDato();
        p = primerNodo();
        for(i = 1;i < tx.getFila(); i++)
        {
            tp = p.getDato();
            p = (NodoDoble) tp.getDato();
        }
        anterior = p;
        q = p.getLigaDer();
        tq = q.getDato();
        while((q != p) && (tq.getColumna() < tx.getColumna()));
        {
            anterior = q;
            q = q.getLigaDer();
            tq = q.getDato();
        }
        anterior.setLigaDer(x);
        x.setLigaDer(q);
    }
    
    public void conectarPorColumnas(NodoDoble x)
    {
        NodoDoble p, q, anterior;
        Tripleta tp, tq , tx;
        int i;
        tx = x.getDato();
        p = primerNodo();
        for(i = 1;i < tx.getColumna(); i++)
        {
            tp = p.getDato();
            p = (NodoDoble) tp.getDato();
        }
        anterior = p;
        q= p.getLigaIzq();
        tq = q.getDato();
        while((q != p) && (tq.getColumna() < tx.getColumna()))
        {
            anterior = q;
            q = q.getLigaIzq();
            tq = q.getDato();
        }
        anterior.setLigaIzq(x);
        x.setLigaIzq(q);
    }
    
     public int comparar(int x,int y)
    { 
      int valor = 0;
      if(x < y){ valor = -1; }
      if(x>y){ valor = +1; }
      if(x == y){ valor = 0; }
      return valor;  
    }
     
    public matrizForma1 suma(matrizForma1 b)
    {
        int ma,na,mb,nb,ss;
        NodoDoble p,q,r,s,x;
        Tripleta tp,tq,tr,ts,tx = null;
        matrizForma1 c;
        p = this.nodoCabeza();
        q = b.nodoCabeza();
        tp = p.getDato();
        tq = q.getDato();
        ma = tp.getFila();
        na = tp.getColumna();
        mb = tq.getFila();
        nb = tq.getColumna();
        if(ma != mb && na != nb)
        {
            System.out.println("No se pueden sumar, dimensiones diferentes");
            return null;
        }
        c = new matrizForma1(ma,na);
        c.construyeNodosCabeza();
        p = this.primerNodo();
        q = b.primerNodo();
        
        while(!(finDeRecorrido(p)))
        {
            r = p.getLigaDer();
            s = q.getLigaDer();
            
            while((r != p) && (s != q))
            {
                tr = r.getDato();
                ts = s.getDato();
                
                switch(comparar(tr.getFila(),ts.getFila()))
                {
                    case -1: 
                        x = new NodoDoble(tr);
                        c.conectaPorFilas(x);
                        c.conectarPorColumnas(x);
                        r = r.getLigaDer();
                        break;
                    
                    case +1: 
                        x = new NodoDoble(ts);
                        c.conectaPorFilas(x);
                        c.conectarPorColumnas(x);
                        s = s.getLigaDer();
                        break;
                    
                    case 0:
                        switch(comparar(tr.getColumna(),ts.getColumna()))
                        {
                            case -1:
                                x = new NodoDoble(tr);
                                c.conectaPorFilas(x);
                                c.conectarPorColumnas(x);
                                r = r.getLigaDer();
                                
                            case +1:
                                x = new NodoDoble(ts);
                                c.conectaPorFilas(x);
                                c.conectarPorColumnas(x);
                                s = s.getLigaDer();
                            
                            case 0:
                                int i = (int) tr.getDato();
                                int j = (int) ts.getDato();
                                ss = i + j;
                                if(ss != 0)
                                {
                                    tx = new Tripleta(tr.getFila(),tr.getColumna(),ss);
                                    x = new NodoDoble(tx);
                                    c.conectaPorFilas(x);
                                    c.conectarPorColumnas(x);
                                }
                                r = r.getLigaDer();
                                s = s.getLigaDer();                            
                        }                                
                }
            }
            while(s != q)
            {
                ts = s.getDato();
                x = new NodoDoble(ts);
                c.conectaPorFilas(x);
                c.conectarPorColumnas(x);
                s = s.getLigaDer();
            }
            while(r != p)
            {
                tr = r.getDato();
                x = new NodoDoble(tr);
                c.conectaPorFilas(x);
                c.conectarPorColumnas(x);
                r = r.getLigaDer();
            }
            
            tp = p.getDato();
            p = (NodoDoble) tp.getDato();
            tq = q.getDato();
            q = (NodoDoble) tq.getDato();
        }
        return c;
    }
    
    public matrizForma1 multiplica(matrizForma1 b)
    {
        NodoDoble p,q,r,s,x;
        Tripleta tq, tp, tr, ts, tx;
        int ss, fila, columna;
        matrizForma1 c;
        p = this.nodoCabeza();
        q = b.nodoCabeza();
        tp =  p.getDato();
        tq = q.getDato();
        
        if(tp.getColumna() != tq.getFila())
        {
            System.out.println("Diferente dimensión, no se pueden multiplicar");
            return null;
        }
        
        c = new matrizForma1(tp.getFila(),tq.getColumna());
        c.construyeNodosCabeza();
        p = this.primerNodo();
        while(!(this.finDeRecorrido(p)))
        {
            q = b.primerNodo();
            while(!(b.finDeRecorrido(q)))
            {
                ss = 0;
                r = p.getLigaDer();
                s = q.getLigaIzq();
                tr = r.getDato();
                ts = s.getDato();
                fila = tr.getFila();
                columna = ts.getColumna();
                while((r != p) && (s != q))
                {
                    tr = r.getDato();
                    ts = s.getDato();
                    switch(comparar(tr.getColumna(),ts.getFila()))
                    {
                        case -1: r = r.getLigaDer();
                                 break;
                        case +1: s = s.getLigaIzq();
                                 break;
                        case 0: ss = ss + (int) tr.getDato() * (int) ts.getDato();
                                r = r.getLigaDer();
                                s = s.getLigaIzq();
                                break;                        
                    }
                }
                if(ss != 0)
                {
                    tx = new Tripleta(fila, columna ,ss);
                    x = new NodoDoble(tx);
                    c.conectaPorFilas(x);
                    c.conectarPorColumnas(x);
                }
                tp = q.getDato();
                q = (NodoDoble) tq .getDato();
            }
            tp = p.getDato();
            p = (NodoDoble) tq.getDato();
        }
        return c;
    }
    
    public matrizForma1 transpuesta()
    {
        NodoDoble p,q,x;
        Tripleta tp,tq,tx;
        
        p = this.nodoCabeza();
        tp = p.getDato();
        matrizForma1 c = new matrizForma1(tp.getColumna(),tp.getFila());
        c.construyeNodosCabeza();
        p = this.primerNodo();
        while(!(this.finDeRecorrido(p)))
        {
            q = p.getLigaDer();
            tq = q.getDato();
            while(q != p)
            {
                tx = new Tripleta(tq.getColumna(),tq.getFila(),tq.getDato());
                x = new NodoDoble(tx);
                c.conectaPorFilas(x);
                c.conectarPorColumnas(x);
                q = q.getLigaDer();
                tq = q.getDato();
            }
            tp = p.getDato();
            p = (NodoDoble) tp.getDato();
        }
        return c;        
    }
    
    
}
