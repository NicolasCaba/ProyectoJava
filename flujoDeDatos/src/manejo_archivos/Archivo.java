package manejo_archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Nicolás
 */
public class Archivo {
    public void guardarEnArchivo(Object objeto, String rutaArchivo){
        try {
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
        }
    }
}
