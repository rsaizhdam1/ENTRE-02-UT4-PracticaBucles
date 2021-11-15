import java.util.Random;
/**
 *    
 */
public class PracticaBucles {
    private final char ESPACIO = ' ';
    private final char CARACTER = '\u0040';
    private Random generador;

    /**
     * Constructor  
     */
    public PracticaBucles()    {
        generador = new Random();
    }

    /**
     *  El método  genera  números aleatorios  entre -1000 y 5000 (inclusive)
     *  y calcula y escribe:
     *      - la media de todos los números
     *      - la suma de los impares
     *      - el máximo de los pares
     *        
     *  El proceso termina cuando sale un 0 o bien se han escrito n nºs
     *  
     *  Los números se escriben  en filas de 5 columnas 
     *  Cada nº aleatorio se muestra en un espacio de 12 posiciones en la pantalla  
     *  y al lado de cada nº se muestra otro nº con las mismas cifras y 
     *  en el mismo orden pero sin ceros (en 5 posiciones)
     *  
     *   Utiliza solo bucles while
     */
    public void generarNumeros(int n)   {
        System.out.println("Nº máximo de aleatorios a generar: " + n);
        System.out.println("o hasta que salga el 0");
        int i = 0;
        int al = 1;
        int fila = 0;
        int total = 0;
        int pares = 0;
        int impares = 0;
        String resul = "";
        while (i != n && al != 0){
            if (fila < 5){
                al = generador.nextInt(50000 - (-1000)) - 1000;
                total += al;
                if (al % 2 == 0 && al > pares) {
                    pares = al;
                }
                else if (al % 2 != 0){
                    impares += al;
                }
                i++;
                resul += String.format("%12d:%5d", al, obtenerNumeroSinCeros(al));
                fila++;
            }
            else {
                resul += "\n";
                fila = 0;
            }
        }
        System.out.println(resul);
        System.out.printf("\n\n%25s%10.2f\n%25s%10d\n%25s%10d", 
                            "Media:", (double)(total / i), 
                            "Suma impares:", impares,
                            "Máximo pares:", pares);    
       

    }

    /**
     *  Devuelve true si numero es impar, false en otro caso
     *  Hazlo sin utilizar if
     */
    public boolean esImpar(int numero)   {
        return  numero % 2 != 0;
    }

    /**
     *  Dado un nº genera y devuelve otro nuevo 
     *  con las mismas cifras y en el mismo orden pero sin 
     *  los 0
     *  Ej - si numero = 2040 devuelve  24, si numero = 1009 devuelve  19
     *  si numero = 3000 devuelve 3
     *   
     *   
     */
    public int obtenerNumeroSinCeros(int numero)   {
        int resul = 0;
        int i = 1;
        while (numero != 0) {
            if (numero % 10 != 0) {
                resul += (numero % 10) * i;
                i *= 10;
            }
            numero /= 10;
        }
        return resul;
    }

    /**
     *  Borrar la pantalla
     *
     */
    public void borrarPantalla()    {
        System.out.println('\u000C');
    }

    /**
     *  
     *  Dibuja la letra N (ver figura en el enunciado)
     *  Con bucles for
     *  
     *  Hay que usar el método escribirCaracter()
     *  
     *  
     *   
     */
    public void escribirLetraN(int altura)    {
        System.out.println("Letra N - Altura: " + altura);
        int esp1 = 0;
        int esp2 = altura - 1;
        for (int alt = 0; alt <= altura; alt++){
            System.out.print(CARACTER);
            escribirCaracter(ESPACIO, esp1);
            esp1++;
            System.out.print(CARACTER);    
            escribirCaracter(ESPACIO, esp2);  
            esp2--;
            System.out.print(CARACTER);
            System.out.println();
        }
    }

    /**
     *  escribe n veces el caracter  indicado en la misma línea
     *  con bucles for
     */
    private void escribirCaracter(char caracter, int n)    {
        for (int i = 0; i <= n; i++) {
            System.out.print(caracter);                
        }
    }

}
