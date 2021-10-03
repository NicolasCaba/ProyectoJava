package manejo_archivos;

import utilidades.MiObjectOutputStream;


import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * @author Nicolás
 */
public class Archivo {
    public static void guardarEnArchivo(Object objeto, String rutaArchivo){
        File archivo = new File(rutaArchivo);
        FileOutputStream fichero = null;  
        
        boolean existe = archivo.exists();
        
        try {
            fichero = new FileOutputStream(archivo, true);
            
            if(existe){
                MiObjectOutputStream mioos = new MiObjectOutputStream(fichero);
                mioos.writeObject(objeto);
            }else {
                ObjectOutputStream oos = new ObjectOutputStream(fichero);
                oos.writeObject(objeto);
            }  
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static ArrayList<Object> leerArchivo(String rutaArchivo){
        //File archivo = new File(nombreArchivo);
        FileInputStream ficheroEntrada;
        ObjectInputStream ois = null;
        ArrayList<Object> arrlist = null;
        
        try {
            ficheroEntrada = new FileInputStream(rutaArchivo);
            ois = new ObjectInputStream(ficheroEntrada);
            Object aux = ois.readObject();
            arrlist = new ArrayList<Object>();
            
            while(aux != null){  
                    System.out.println(aux);
                    arrlist.add(aux);
                aux = ois.readObject();
            }
            
            return arrlist;
        } catch (EOFException e) {
            System.out.println("Fin del archivo");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        return arrlist;
    }
}
