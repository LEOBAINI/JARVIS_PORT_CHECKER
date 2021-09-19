package portchecker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HostController {
	
	public static ArrayList<Host> hosts=new ArrayList<Host>();
	
	public static int nodosVivos=0;
	
	public static void getResumedInfo() {
		int ok=0;
		int fail=0;
		for(int i=0;hosts.size()>i;i++) {
			if(hosts.get(i).isOpen()) {
				ok++;
			}else {
				fail++;
				System.out.println(hosts.get(i).getIp()+"|"+hosts.get(i).getPort()+"|"+hosts.get(i).isOpen());
			}
			
		}
		System.out.println("Total equipos -> "+hosts.size()+"| En falla -> "+fail+"| ok -> "+ok);
	}
	
public static void destruirHostMemoria(Host host) {
	nodosVivos--;
	host=null;
	System.gc();
	
}

}
