package Tripleta;
import Forma1.NodoDoble;
import Forma1.matrizForma1;
import Forma2.matrizForma2;
import java.util.Scanner;
// @author BreakerMoob

public class Main {

    public static void main(String[] args) 
    {   
        Scanner read = new Scanner(System.in);       
        
        //pruba Tripletas
        /*int m=3,n=3;
        Tripleta t,t1,t2,t3;
        Tripleta b,b1,b2,b3; 
        MatrizEnTripletas x,y,z;      
        System.out.println("Ingrese las dimensiones de la matriz");
            System.out.println("Filas");
            m = read.nextInt();
            System.out.println("Columnas");
            n = read.nextInt();


        t = new Tripleta(m,m,0);
        b = new Tripleta(m,n,0);
        x = new MatrizEnTripletas(t);
        y = new MatrizEnTripletas(b);
        t1 = new Tripleta(1,1,1);
        t2 = new Tripleta(2,2,1);
        t3 = new Tripleta(3,3,1);
        b1 = new Tripleta(1,1,2);
        b2 = new Tripleta(2,2,2);
        b3 = new Tripleta(3,3,2);

        x.insertarTripleta(t1);
        x.insertarTripleta(t2);
        x.insertarTripleta(t3);
        x.muestraMatrizEnTripletas();
        y.insertarTripleta(b1);
        y.insertarTripleta(b2);
        y.insertarTripleta(b3);
        y.muestraMatrizEnTripletas();
        z = x.Suma(y);
        z.muestraMatrizEnTripletas();;  */
        
        //Prueba Forma 1
        
        int fila=1,columna=1,dato=1;
        Tripleta t;
        NodoDoble x;

        matrizForma1 a,b;
        a= new matrizForma1(2,2);
        a.construyeNodosCabeza();
        
            t = new Tripleta(fila, columna, dato);
            x = new NodoDoble(t);
            a.conectaPorFilas(x);
            a.conectarPorColumnas(x);
            
            fila=2;
            columna=1;
            dato = 87;
            t = new Tripleta(fila, columna, dato);
            x = new NodoDoble(t);
            a.conectaPorFilas(x);
            a.conectarPorColumnas(x);
       
        a.muestraMatriz();
        b = a.transpuesta();
        b.muestraMatriz();

        
        /*int fila1,columna1,dato1;
        int j1 = 1;
        Tripleta t1;
        NodoDoble x1;
        System.out.println("Cuantas Filas: ");
        fila1 = read.nextInt();
        System.out.println("Cuentas Columnas: ");
        columna1 = read.nextInt();

        matrizForma1 a1 = new matrizForma1(fila1,columna1);
        a1.construyeNodosCabeza();
        while(j1 == 1)
        {
            System.out.println("Ingrese fila: ");
            fila1 = read.nextInt();
            System.out.println("Ingrese Columna: ");
            columna1 = read.nextInt();
            System.out.println("Ingrese Dato: ");
            dato1 = read.nextInt();
            
            t1 = new Tripleta(fila1, columna1, dato1);
            x1 = new NodoDoble(t1);
            a1.conectaPorFilas(x1);
            a1.conectarPorColumnas(x1);
            
            System.out.println("Si quiere ingresar otro dato marque 1 de lo contrario marque 0");
            j1 = read.nextInt();
        }
        a1.muestraMatriz();
        
        matrizForma1 xd = a.suma(a1);
        xd.muestraMatriz();*/
        
        
        
        
        
        
        
        
        
        
        
        
        
         
       /* int fila,columna,dato,j = 1, valor;
        System.out.println("Cuantas Filas: ");
        fila = read.nextInt();
        System.out.println("Cuentas Columnas: ");
        columna = read.nextInt();
        
        matrizForma2 a = new matrizForma2(fila,columna);
        while(j == 1)
        {
        System.out.println("Fila: ");
        fila = read.nextInt();
        System.out.println("Columna: ");
        columna = read.nextInt();
        System.out.println("Valor: ");
        valor = read.nextInt();
        
        Tripleta t = new Tripleta(fila, columna, valor);
        NodoDoble x = new NodoDoble(t);
        a.conectaPorFilasForma2(x);
        a.conectaPorColumnasForma2(x);
        
        System.out.println("Si quiere ingresar otro dato marque 1 de lo contrario marque 0");
            j = read.nextInt();
        }
        a.muestraMatriz();*/
        
    }
}
