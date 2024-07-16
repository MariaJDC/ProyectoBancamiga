package com.mycompany.proyectobancamiga;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Cliente {
    String nombre,apellido;
    int edad, cedula;
    Cliente(String nom, String apell, int edad, int ced){
     this.nombre=nom;
     this.apellido=apell;
     this.edad=edad;
     this.cedula=ced;
    }

}
    