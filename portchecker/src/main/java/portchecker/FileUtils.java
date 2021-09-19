package portchecker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
	

	
	public FileUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  String LeeArchivoParametrosYCrearHosts(String archivo)  {
	  	 
		System.out.println("Intentando leer archivo "+archivo);
	  	  String resultado=null;    
	  	  String strLinea=null;
	  	  InputStream fstream = this.getClass().getResourceAsStream(archivo);
	        // Creamos el objeto de entrada
	        DataInputStream entrada = new DataInputStream(fstream);
	        // Creamos el Buffer de Lectura
	        BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada)); 
	        
	        // Leer el archivo linea por linea
	        try {
				while ((strLinea = buffer.readLine()) != null)   {
				      // Imprimimos la línea por pantalla
					  if(resultado==null){
				    	  resultado=strLinea;
				         }else{
				        	 resultado=resultado+" "+strLinea;
				         }
				  
				   
				      System.out.println(strLinea);
				      if(!strLinea.contains("NULL") && getPortFromLine(strLinea)!=-1) {
				    	  new Host(getIpFromLine(strLinea),getPortFromLine(strLinea));
				      }
				      
					 
				  }
				 System.out.println(archivo+" leído correctamente.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				 System.out.println("Error : " +e.getMessage());
			}
	        // Cerramos el archivo
	        try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				 System.out.println("Error : " +e.getMessage());
			}    			
	        return resultado;
	 	}   	
	
	private String getIpFromLine(String linea) {
		
		
		return linea.substring(0, linea.indexOf(","));
	}
	private int getPortFromLine(String linea) {
		int port=0;
		try {
			port=Integer.parseInt(linea.substring(linea.indexOf(",")+1));
		}catch(Exception e) {
			return -1;
		}
		return  port;
	}
public void escribirArchivo(String archivo,String dataLog) {
	BufferedWriter bw = null;
    FileWriter fw = null;

    try {
        String data = dataLog;
        File file = new File(archivo);
        // Si el archivo no existe, se crea!
        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        System.out.println("información agregada!");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
                        //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
}
