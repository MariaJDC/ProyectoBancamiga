package com.mycompany.proyectobancamiga;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class nodo {
    String nombre;
    String apellido;
    int edad;
    int cedula;
    String transaccion;
    nodo siguiente;
    nodo(String nom, String apell, int ed, int ced, String transaccion){
        this.nombre=nom;
        this.apellido=apell;
        this.cedula=ced;
        this.edad=ed;
        this.transaccion=transaccion;
    }
    
    public static String Transaccion(){
        Scanner sc=new Scanner (System.in);
        String TipoTransaccion;
        System.out.println("Indicar transaccion a realizar");
        System.out.println(" 1 Retirar \n 2 Deposito \n 3 Consulta de movimientos \n 4 Actualizacion de Libretas \n 5 Pago de Servicios");
        int numTransaccion= sc.nextInt();

        switch (numTransaccion){
            case 1: TipoTransaccion="Retiro";
            break;
            case 2: TipoTransaccion="Deposito";
            break;
            case 3: TipoTransaccion="Consulta de movimientos";
            break;
            case 4: TipoTransaccion="Actualizacion de Libretas";
            break;
            case 5: TipoTransaccion="Pago de Servicios";
            break;
            default: TipoTransaccion="Debe seleccinar alguna de las opciones indicadas";
            break; 
        }
        System.out.println("Selecciono"+ TipoTransaccion);
        
        return TipoTransaccion;
    }
}
