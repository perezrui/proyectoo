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
public class ProyectoNenRaya{
   Scanner leer = new Scanner(System.in);
   private boolean terminado;
   private tablero tablero;
   private jugadores[] jugador; 
   
   public void jugar(){
        while(!terminado){
            tablero.introducirFicha(jugadorQueEstaAhora());
            tablero.mostrarTablero();
            tablero.verificarGanador(jugadorQueEstaAhora());
            cambioDeTurno();
        }
    }
    
    
    
    public void empezarJuegoNEnRaya(){
        this.terminado = false;
        this.jugador = new jugadores[2];
        crearJugadores();
        seleccionarJugador();
        tablero = new tablero();
        
        
    }
    
    public void cambioDeTurno(){
        if(jugador[0].getTurno()){
            jugador[0].setTurno(true);
            jugador[1].setTurno(false);
        }else{
            jugador[0].setTurno(false);
            jugador[1].setTurno(true);
        }
    }
    
    private jugadores jugadorQueEstaAhora(){
        if(jugador[1].getTurno()){
            return jugador[1];
        }else{
            return jugador[0];
        }
    }
    
    public void seleccionarJugador(){
        String JugadorApodo = null ;
        
       while (JugadorApodo != jugador[0].getNombre() && JugadorApodo != jugador [1].getNombre()){
           System.out.println("¿Cual es el nombre del jugador?");
           System.out.println("El primer jugador" + jugador[0].getNombre() + " o el jugador segundo " + jugador[1].getNombre());
          JugadorApodo = leer.nextLine();
          if(JugadorApodo.equals(jugador[0].getNombre())){
              jugador[0].setTurno(true);
              jugador[1].setTurno(false);
          }else{
              jugador[0].setTurno(false);
              jugador[1].setTurno(true);
          }
          
           System.out.println("El jugador que va a empezar es " + jugadorQueEstaAhora().getNombre());
       }
       
    }
    
    public void crearJugadores (){
        String nombre;
        char ficha;
        for(int i = 0; i< jugador.length; i++){
            System.out.println("Introduce el nombre del primer jugador");
            nombre = leer.nextLine();
            System.out.println("Introduce la ficha con la que vas a jugar");
            ficha= leer.next().charAt(0);
            jugador[i] = new jugadores(nombre);
            jugador [i]. setFicha(ficha);
            System.out.println("El jugador " + jugador[i].getNombre() + " va a jugar con la ficha" + jugador[i].getFicha());
            if(i< jugador.length-1){
                System.out.println("Siguiente jugador");
            }
        }
        
    }
    
    
    
    
}
