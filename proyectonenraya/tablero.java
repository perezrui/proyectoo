/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonenraya;

import java.util.Scanner;

/**
 *
 * @author Juan Pablo
 */
public class tablero {
    char [][] tablero;
    char fichasColocadas;
    
public void CrearTablero(){
    Scanner leer = new Scanner(System.in);
        int tamaño;
        System.out.println("Introduce como de grande es el tablero");
        tamaño = leer.nextInt();
        while (tamaño<3){
            System.out.println("has introducido el tamaño a " + tamaño);
            tablero = new char[tamaño][tamaño];
            completarTablero();
        }
        
}

private void completarTablero (){
    for (int i = 0; i< tablero.length; i++){
        for (int x = 0; x< tablero[i].length; x++){
            tablero[i][x] = 'x';
            
        }
        
    }
}
    


public void introducirFicha(jugadores jugador){
    int queFila = 0;
    int queColumna = 0;
    System.out.println("Es el turno del jugador" + jugador.getNombre());
    while(tablero[queFila][queColumna]!= 'x'){
        tablero[queFila][queColumna] = jugador.getFicha();
        fichasColocadas ++;
    }
    
}

public void mostrarTablero(){
    
   for (int i = 0; i < tablero.length; i++) {
            for (int x = 0; x < tablero[i].length; x++) {
                if (x<tablero.length-1) {
                    System.out.print("|"+(char)tablero[i][x]);
                }else{
                    System.out.print("|"+(char)tablero[i][x]+"|");
                }
            }
            System.out.println("");
   }
}

private int introducirlugar(String string){
        Scanner leer = new Scanner(System.in);
        int lugar;
        do{
            System.out.println("Introduce el lugar de la "+string);
            lugar=leer.nextInt();
        }while(lugar<1||lugar>tablero.length);
        return lugar-1;
    }
    

private boolean comprobarFilas(jugadores jugador) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int x = 0; x < tablero.length; x++) {
                if (tablero[i][x]==jugador.getFicha()) {
                    contador++;
                }
            }
            if (contador==tablero.length) {
                return true;
            }else{
                contador=0;
            }
        }
        return false;
    }

 private boolean comprobarColumnas(jugadores jugador) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int x = 0; x < tablero.length; x++) {
                if (tablero[x][i]==jugador.getFicha()) {
                    contador++;
                }
            }
            if (contador==tablero.length) {
                return true;
            }else{
                contador=0;
            }
        }
        return false;
    }
private boolean comprobarDiagonal(jugadores jugador) {
        int contadorD=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i]==jugador.getFicha()) {
                contadorD++;
            }
        }

         if(contadorD == tablero.length){
            return true;
        }else{
             return false;
         }
    }

private boolean comprobarDiagonalInversa(jugadores jugador) {
        int contadorDInversa=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][tablero.length-1-i]==jugador.getFicha()) {
                contadorDInversa++;
            }
        }

        if(contadorDInversa == tablero.length){
            return true;
        }else{
             return false;
         }
    }
public boolean verificarGanador(jugadores jugador) {
        if (comprobarFilas(jugador) || comprobarColumnas(jugador) || comprobarDiagonal(jugador) ||comprobarDiagonalInversa(jugador)) {
            System.out.println("Has ganado " + jugador.getNombre());
            return true;
        } else {
            if (fichasColocadas == (tablero.length * tablero.length)) {
                System.out.println(" ha quedado empate");
                return true;
            }else{
                return false;
            }
        }
    }

}


