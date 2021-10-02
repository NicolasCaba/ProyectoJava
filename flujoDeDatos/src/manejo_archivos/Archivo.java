package manejo_archivos;

import utilidades.MiObjectOutputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nicolás
 */
public class Archivo {
    public void guardarEnArchivo(Object objeto, String rutaArchivo){
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
        
        
        /*try {
            File archivo = new File(rutaArchivo);
            FileWriter fw;
            BufferedWriter bw;
        
        boolean existe = archivo.exists();
            
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            
            if(!existe){
                String objStr = objeto.toString();
                bw.write(objStr);
            }else {
                String objStr = objeto.toString();
                bw.newLine();
                bw.write(objStr);
            }
            
            bw.close();
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }*/
    }
    
    
    public void leerArchivo(String rutaArchivo){
        //File archivo = new File(nombreArchivo);
        FileInputStream ficheroEntrada;
        ObjectInputStream ois = null;
        
        try {
            ficheroEntrada = new FileInputStream(rutaArchivo);
            ois = new ObjectInputStream(ficheroEntrada);
            Object aux = ois.readObject();
            
            while(aux != null){  
                    System.out.println(aux);
                aux = ois.readObject();
            }
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
        
        
        /*try {
            File archivo = new File(rutaArchivo);
            FileReader fr;
            BufferedReader br;
            
            boolean existe = archivo.exists();
            
            if(existe){
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                
                String linea;
                
                while((linea = br.readLine()) != null){
                    
                }
            }else {
                System.out.println("Arvchivo no existenete");
            }
        } catch (Exception e) {
        }*/
    }
}
