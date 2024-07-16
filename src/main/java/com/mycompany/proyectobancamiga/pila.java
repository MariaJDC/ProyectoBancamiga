/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectobancamiga;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class pila {
    List<transaccion> elementos = new LinkedList<>();
    
    void push(String nom, String apell, int ed, int ced, String transaccion){ // 1
        this.elementos.add(new transaccion(nom, apell, ed, ced, transaccion));
    }
    
    transaccion pop(){
        transaccion ultimo = this.elementos.get(this.elementos.size() - 1);
        this.elementos.remove(this.elementos.size() -1);
        return ultimo;
    }
    
    public void guardarArchivoTransacciones(){
        while(this.isEmpty() == false){
            transaccion tran = this.pop();
            
            var texto = "Nombre: " + tran.nombre + " Apellido: " + tran.apellido + " Cedula: " + tran.cedula + " Edad: " + tran.edad + " Transaccion: " + tran.transaccion + "\n";
            try {
                Files.write(Paths.get("Transacciones.out"), texto.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                Logger.getLogger(cola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean isEmpty() {
        return this.elementos.size() == 0;
    }
}
