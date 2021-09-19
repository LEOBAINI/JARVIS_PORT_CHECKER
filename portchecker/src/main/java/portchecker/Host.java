package portchecker;

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Host {
	String ip;
	int port;
	boolean isOpen;
	int pruebasExitosas=0;
	int pruebasExitosasSuficientes=1;
	int maximoNroIntentos=1;
	
	
	
	
	
	public Host(final String ip, final int port) {
		super();
		
		this.ip = ip;
		this.port = port;
		final Timer timer;
	    timer = new Timer();
	   

	    TimerTask task = new TimerTask() {
	       

	        @Override
	        public void run()
	        {
	        	//isOpen();
	        	setOpen(serverListening(ip,port));
	        	if(isOpen()) {
	        		pruebasExitosas++;
	        	}else {
	        		maximoNroIntentos--;
	        	}
	        	if(pruebasExitosas>=pruebasExitosasSuficientes) {
	        		new FileUtils().escribirArchivo("C:\\Users\\AR00122207\\Desktop\\Jarvis\\hostsOK.log", getIp()+"|"+getPort()+"|"+ isOpen()+" pruebas ok:"+pruebasExitosas+"| intentos restantes permitidos:"+maximoNroIntentos);
	        		
	        		timer.cancel();
	        		autodestry();
	        	}if(maximoNroIntentos==0) {
	        		new FileUtils().escribirArchivo("C:\\Users\\AR00122207\\Desktop\\Jarvis\\hostsError.log", getIp()+"|"+getPort()+"|"+ isOpen()+" pruebas ok:"+pruebasExitosas+"| intentos restantes permitidos:"+maximoNroIntentos);
	        		
	        		timer.cancel();
	        		autodestry();
	        		
	        		
	        	}
	        	System.out.println(getIp()+"|"+getPort()+"|"+ isOpen()+" pruebas ok:"+pruebasExitosas+"| intentos restantes permitidos:"+maximoNroIntentos);
	       
	        }
	        };
	        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
	    timer.schedule(task, 10, 3000);
	  //  HostController.hosts.add(this);
	    
	}




	
	private void autodestry() {
		HostController.destruirHostMemoria(this);
	}

	public static boolean serverListening(String host, int port)
	{
	    Socket s = null;
	    try
	    {
	        s = new Socket(host, port);
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
	    finally
	    {
	        if(s != null)
	            try {s.close();}
	            catch(Exception e){}
	    }
	}





	public String getIp() {
		return ip;
	}





	public void setIp(String ip) {
		this.ip = ip;
	}





	public int getPort() {
		return port;
	}





	public void setPort(int port) {
		this.port = port;
	}





	public boolean isOpen() {
		
		return isOpen;
	}





	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	

}
