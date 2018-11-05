package Tripleta;
import Tripleta.Tripleta;

public class MatrizEnTripletas { 
    
    private final Tripleta v[];

    public MatrizEnTripletas(Tripleta t)
    {
        int m = t.getFila();
        int n = t.getColumna();
        int p = (m*n) + 2;
        int i;
        v = new Tripleta[p];
        v[0] = t;
        for(i = 1;i<p;i++)
            {
                v[i]= null;
            }    
    } /*Construcctor llena el vector de tripletas null 
                    Y a la primera le asigna #Filas,#Columnas y #datos */
    
    public MatrizEnTripletas MatrizEnTripletas(int m, int n) 
    {
        MatrizEnTripletas a; 
        int c,d;  
        Tripleta t = new Tripleta(m,n,null);     
        a = new MatrizEnTripletas(t); 
        c = 0;
        for(int i = 1;i <= m; i++)
        {
            for(int j = 1;j <= n; j++)
            {
                /*d = Dato en matriz i,j
                if(d != 0)
                {
                    c = c+1;
                    t = new Tripleta(i,j,d)
                    a.asignaTripleta(t,c)
                }*/
            }
        }
        a.asignaNumeroTripletas(c);
        return a;       
    }/* Pasar de Matriz cuadricula a vector de tripletas
                      Nota: metodo incompleto falta crear clase matriz [z|y]*/
    
    public void asignaTripleta(Tripleta t, int i)
    {
        v[i]= t;    
    } //Inserta una tripleta en la posicion i del vector
    
    public void asignaNumeroTripletas(int n)
    {
        Tripleta t = v[0];
        t.setDato(n);
        v[0] = t;
    }// En la posicion o del vector asigna la cantidad de tripletas que hay
    
    public int getFilas()
    {
        Tripleta t = v[0];
        return t.getFila();
    }//Retorna #filas
    
    public int getColumnas()
    {
        Tripleta t = v[0];
        return t.getColumna();
    }//Retorna #Columna
    
    public int getNumeroTripletas()
    {
        Tripleta t = v[0];
        return (int) t.getDato(); 
    }//Retorna #Tripletas
    
    public Tripleta retornaTripleta(int i)
    {
        return v[i];
    }//Retorna tripleta en posicion i
    
    public void muestraMatrizEnTripletas()
    {
        int i = 1;
        Tripleta t = this.retornaTripleta(0);
        int datos = (int) t.getDato();
        while(i <= datos)
        {
            System.out.println("Tripleta en la posición: " + i);
            System.out.println("Fila     "+"Columna     "+"Dato ");
            System.out.println(v[i].getFila()+"        "+ v[i].getColumna() +"            "+  v[i].getDato());
            i++;
        }
    }//Imprime el vector de tripletas o la matriz
    
    public void insertarTripleta(Tripleta ti)
    {
        int i,j,datos;
        int existe = 0;
        Tripleta t,tx;
        tx = this.retornaTripleta(0);
        datos = (int) tx.getDato();
        i = 1;
        t = this.retornaTripleta(i);       
        while(i <= datos && t.getFila() < ti.getFila())
        {
           i= i+1;
           t = this.retornaTripleta(i); 
        }
        while((i <= datos) && (t.getFila() == ti.getFila()) && (t.getColumna() <= ti.getColumna()))
        {
            if(t.getColumna() == ti.getColumna())//Este if se va a ejecutar cuando ya exista una tripleta en dicha posición
            {
                System.out.println("Ya existe una tripleta en esta posición y sera reemplazado");
                existe = 1;
            }
            i = i+1;
            t = this.retornaTripleta(i);
        }
        datos = datos+1;
        j = datos-1;
        if(existe != 1)
        {
            while(j>=i)
            {
                j= j-1;
            }
            v[i] = ti;
            this.asignaNumeroTripletas(datos);
        }
        else
        {
            v[i-1] = ti;
        }
    }/*Inserta una tripleta
                    Nota: Si la tripleta existe la reemplaza*/ 
    public int comparar(int x,int y)
    { 
      int valor = 0;
      if(x < y){ valor = -1; }
      if(x>y){ valor = +1; }
      if(x == y){ valor = 0; }
      return valor;  
    }
    
    public MatrizEnTripletas Suma(MatrizEnTripletas b)
    {
        int ma, na, mb, nb, p, q, i, j, k, ss, fi, fj, ci, cj, vi, vj,valor;
        Tripleta ti,tj,tx;
        ma = this.getFilas();
        na = this.getColumnas();
        mb = b.getFilas();
        nb = b.getColumnas();
        p = this.getNumeroTripletas();
        q = b.getNumeroTripletas();
        if((ma != mb) && (na != nb))
        {
            System.out.println("Matrices de diferente dimension no es posible sumarlas");
            return null;
        }
        ti = new Tripleta(ma,na,null);
        MatrizEnTripletas c = new MatrizEnTripletas(ti);
        i = 1;
        j = 1;
        k = 0;
        while((i <= p) && (j <= q))
        {
            ti = this.retornaTripleta(i);
            tj = b.retornaTripleta(i);
            fi = ti.getFila();
            fj = tj.getFila();
            k = k + 1;
            valor = comparar(fi,fj);
            switch(valor)
            {
                case -1: 
                    c.asignaTripleta(ti, k);
                    i = i + 1;
                    break;
                case +1: 
                    c.asignaTripleta(tj, k);
                    j = j + 1;
                    break;
                case  0: 
                    ci = ti.getColumna();
                    cj = tj.getColumna();
                    switch(comparar(ci,cj)){
                            case -1: 
                                 c.asignaTripleta(ti, k);
                                 i = i + 1;
                                 break;
                            case +1:
                                c.asignaTripleta(tj, k);
                                j = j + 1;
                                break;
                            case  0:
                                vi = (int) ti.getDato();
                                vj = (int) tj.getDato();
                                ss = vi + vj;
                                if(ss != 0)
                                {
                                    tx = new Tripleta(fi,ci,ss);
                                    c.asignaTripleta(tx, k);
                                }
                                else
                                {
                                    k = k - 1;
                                }
                                i = i + 1;
                                j = j + 1;
                                break;
                         }
                    break;
            }
        }    
        while(i <= p)
        {
            ti = this.retornaTripleta(i);
            k = k +1;
            c.asignaTripleta(ti, k);
            i = i+1;
        }
        while(j <= p)
        {
            tj = b.retornaTripleta(i);
            k = k + 1;
            c.asignaTripleta(tj, k);
            j = j + 1;
        }
        c.asignaNumeroTripletas(k);        
        return c;
    }
    
     public void insertarTripletaSumando(Tripleta ti)
    {
        int i,j,datos;
        int existe = 0;
        Tripleta t,tx;
        tx = this.retornaTripleta(0);
        datos = (int) tx.getDato();
        i = 1;
        t = this.retornaTripleta(i);       
        while(i <= datos && t.getFila() < ti.getFila())
        {
           i= i+1;
           t = this.retornaTripleta(i);
        }
        while((i <= datos) && (t.getFila() == ti.getFila()) && (t.getColumna() <= ti.getColumna()))
        {
            if(t.getColumna() == ti.getColumna())//Este if se va a ejecutar cuando ya exista una tripleta en dicha posición
            {
                System.out.println("Ya existe una tripleta en esta posición, Se sumaran ambos valores");
                existe = 1;
            }
            i = i+1;
            t = this.retornaTripleta(i);
        }
        datos = datos+1;
        j = datos-1;
        if(existe != 1)
        {
            while(j>=i)
            {
                j= j-1;
            }
            v[i] = ti;
            this.asignaNumeroTripletas(datos);
        }
        else
        {
            int k = (int) v[i-1].getDato();
            int r = (int) ti.getDato();
            int s = k + r;
            Tripleta ta = ti;
            ta.setDato(s);
            v[i-1] = ta;
        }
    }/*Este metodo inserta una tripleta, en caso de que en esa posicion ya exista un elemnto va a 
     sumar los valores de ambos NOTA: este metodo se uso para hacer la suma de matrices con tripletas*/
    

    public MatrizEnTripletas SumaAlt(MatrizEnTripletas b)
    {
        int ma,na,mb,nb,i,valor;
        MatrizEnTripletas x = b;
        Tripleta t,ta;
        ma = this.getFilas();
        na = this.getColumnas();
        mb = b.getFilas();
        nb = b.getColumnas();
        
        if((ma != na) && (mb != nb))
        {
            System.out.println("No se pueden sumar porque tienen dimensiones diferentes");
            return null;
        }
        ta = this.retornaTripleta(0);
        valor = (int) ta.getDato();
        i = 1;
        while(i <= valor)
        {
            t = this.retornaTripleta(i);
            x.insertarTripletaSumando(t);
            i++;
        }
        
        return b;
    }// Suma de matrices usando insertar tripleta
    
    

}
   



