package com.mycompany.proyectobancamiga;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class cola {
    nodo front;
    nodo tail;
    int EdadPreferencial=60;
    int CantRegulares=4;
    boolean isEmpty(){
        if (front==null){
            return true;
        }else{
         return false;
        }
}
    void Ingresar(String nom, String apell, int ed, int ced){
        nodo nuevo = new nodo(nom, apell, ed, ced, nodo.Transaccion());
        
        if (isEmpty()){
            front=nuevo;
            tail=front;
        }else{
            tail.siguiente = nuevo;
            tail = nuevo;
        }
    }
    
    void GuardarTransacciones(pila pilatransacciones){
        int i = 0;
        nodo aux = null;
        while(this.front != null){
            i++;
            if(i == 4){
                aux = this.PasarPrioritarios();
                if(aux == null){
                    aux = this.Pasar();
                }
                i=0;
            }else{
                aux = this.Pasar();
            }
            
            pilatransacciones.push(aux.nombre, aux.apellido, aux.edad, aux.cedula, aux.transaccion);
        }
        
        pilatransacciones.guardarArchivoTransacciones();
    }
        
    void Ingresar(nodo nuevo){
        if (isEmpty()){
            front=nuevo;
            front=tail;
        }else{
            tail.siguiente=nuevo;
            tail=tail.siguiente;
        }
    }
    
    nodo Pasar(){
        nodo atendido=null;
        if (!isEmpty()){
            atendido=front;
            front=front.siguiente;
        }else{
            System.out.println("Aun no hay nadie en la cola");
        }
        return atendido;
    }
    
    nodo PasarPrioritarios(){
        nodo Preferencialaux=front;
        nodo Anterioraux=null;
        
        if(isEmpty() == false){
            while(front!=null && Preferencialaux!=null){
                if (Preferencialaux.edad >= EdadPreferencial){
                    if(Anterioraux == null){
                        return this.Pasar();
                    }
                    Anterioraux.siguiente = Preferencialaux.siguiente;
                    return Preferencialaux;
                }else{
                    Anterioraux = Preferencialaux;
                    Preferencialaux = Preferencialaux.siguiente;
                }
            }
        }
        
        return null;
        
       /*     cola ColAux=new cola();
        if (!isEmpty()){
            while(front!=null || front.edad>=EdadPreferencial){
                ColAux.Ingresar(this.Pasar());
            }
            if (front==null){
                this.front=ColAux.front;
                this.tail=ColAux.tail;
                return this.Pasar();
            }else{
                Atendidoaux=this.Pasar();
                ColAux.tail.siguiente=this.front;
                this.front=ColAux.front;
                return Atendidoaux;
            }
        }
        return null;*/
    }
}
