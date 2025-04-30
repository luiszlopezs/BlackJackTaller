/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author hailen
 */
public class SerializacionCrupier {
    
        //Canal de salida para escribir en el archivo de serializacion
    private FileOutputStream fileOut;
    private ObjectOutputStream salida;

    //Canal de salida para escribir en el archivo de serializacion
    private FileInputStream fileIn;
    private ObjectInputStream entrada;

    //Metodo Cosntructor que prepara los canales para leer / escribir 
    //en el archivo de serializacion
    public SerializacionCrupier(FileOutputStream fileOut,ObjectOutputStream salida, FileInputStream fileIn, ObjectInputStream entrada) {
        try {
            //Para escribir
            fileOut = new FileOutputStream("crupier.bin");
            salida = new ObjectOutputStream(fileOut);

            //Para leer
            fileIn = new FileInputStream("crupier.bin");
            entrada = new ObjectInputStream(fileIn);
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
        }
    }

    
    
    public void cerrarArchivoSerializadoOut() throws IOException {
        salida.close();
               
            
    }

    public void cerrarArchivoSerializadoIn() throws IOException {
        entrada.close();
 
        }
    

    public void escribirArchivoSerializado(Persona persona) throws IOException {
   
        salida.writeObject(persona);
    
        
    }

        //Metodos para escribir en el archivo de serializacion
    //Para recosntruir los objetos desde los bytes del archivo
    public Crupier leerArchivoSerializado() throws IOException, ClassNotFoundException {
        Crupier crupier = null;
                crupier = (Crupier) entrada.readObject();
   
        
        return crupier;
    }
}
