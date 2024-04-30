/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonenraya;

/**
 *
 * @author Juan Pablo
 */
public class jugadores {
    private char ficha;
    private String Nombre;
    private Boolean turno;

    public jugadores (String nombre){
        this.Nombre = nombre;
        this.turno = turno;
    }
    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }
    
}



