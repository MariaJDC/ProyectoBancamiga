/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectobancamiga;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer
 */
public class ProyectoBancamiga {

    public static void main(String[] args) {
        cola ColaClientes=new cola();
        pila pilaTransacciones=new pila();

        try{ 
            FileReader FilasPendientes;
            BufferedReader leerPendientes;
            FilasPendientes=new FileReader("ClientesPendientes.in");
            leerPendientes=new BufferedReader(FilasPendientes);
            String LineaPendiente;
        
            if (FilasPendientes.ready()){
                while((LineaPendiente=leerPendientes.readLine())!=null){
                    String[] Columnas=LineaPendiente.split("\t");

                    if (Columnas.length==4){
                        String nombre=Columnas[0];
                        String apellido=(Columnas[1]);
                        int edad=Integer.parseInt(Columnas[2]);
                        int cedula=Integer.parseInt(Columnas[3]);
                        
                        System.out.println("Atendiendo a cliente pendiente: "+ nombre);
                        ColaClientes.Ingresar(nombre, apellido, edad, cedula);
                    }
                }
                
                limpiararchivo("ClientesPendientes.in");
            }
        
            FileReader Filas;
            BufferedReader leer;
            Filas=new FileReader("Clientes.in");
            leer=new BufferedReader(Filas);
            String Linea;
            
            int cantClientes = 0;
            if (Filas.ready()){
                while((Linea=leer.readLine())!=null){
                    cantClientes++;
                    String[] Columnas=Linea.split("\t");

                    if (Columnas.length==4){
                        String nombre=Columnas[0];
                        String apellido=(Columnas[1]);
                        int edad=Integer.parseInt(Columnas[2]);
                        int cedula=Integer.parseInt(Columnas[3]);
                        
                        if(cantClientes >= 10){
                            escribirpendiente(nombre, apellido, edad, cedula);
                        }else{
                            System.out.println("Atendiendo a: "+ nombre);
                            ColaClientes.Ingresar(nombre, apellido, edad, cedula);
                        }
                    }
                }
                
                limpiararchivo("Clientes.in");
            }
            
            ColaClientes.GuardarTransacciones(pilaTransacciones);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
//        for ( int i=1; i<=4; i++){
//          ColaClientes.Pasar();
//        }
//        ColaClientes.PasarPrioritarios();

    }
    
    public static void escribirpendiente(String nom, String apell, int ed, int ced){
        var texto = nom + "\t" + apell + "\t" + ed + "\t" + ced + "\n";
            try {
                Files.write(Paths.get("ClientesPendientes.in"), texto.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                Logger.getLogger(cola.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void limpiararchivo(String ruta) throws IOException {
        FileWriter writer = new FileWriter(new File(ruta));
        writer.close();
    }
}
