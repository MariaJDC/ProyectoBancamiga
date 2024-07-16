package com.mycompany.proyectobancamiga;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class transaccion {
    String nombre;
    String apellido;
    int edad;
    int cedula;
    String transaccion;
    transaccion down;
    
    transaccion(String nom, String apell, int ed, int ced, String transaccion){
        this.nombre=nom;
        this.apellido=apell;
        this.cedula=ced;
        this.edad=ed;
        this.transaccion=transaccion;
    }
    
    transaccion(String nom, String apell, int ed, int ced, String transaccion, transaccion down){
        this.nombre=nom;
        this.apellido=apell;
        this.cedula=ced;
        this.edad=ed;
        this.down=down;
    }
    
    transaccion(transaccion tran){
        this.nombre=tran.nombre;
        this.apellido=tran.apellido;
        this.cedula=tran.cedula;
        this.edad=tran.edad;
        this.down=tran.down;
    }
}
