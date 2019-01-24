package ie.gmit.dip;
import java.net.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.text.*;

public class LookForPorts {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   
   public static void main(String[] args){
        
        long startTime = System.currentTimeMillis();

      long total = 0;
      for (int i = 0; i < 10000000; i++) {
         total += i;
      }
        
        Socket theSocket;
        String host = "localhost";
        InetAddress ip;
         Date date = new Date();
         
        
        if (args.length > 0){
            host = args[0];
        }
        for (int i = 10; i < 150; i++){
            try {
                theSocket = new Socket(host, i);
                System.out.println("IP Address is....." + InetAddress.getLocalHost().getHostAddress());
                
                
                 ip = InetAddress.getLocalHost();
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] mac = network.getHardwareAddress(); 
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <mac.length; j++){
                    sb.append(String.format("%02X%s", mac[j],(j < mac.length - 1) ? "-" : ""));    
                }
                System.out.println("MAC Address is....." + sb.toString());
                
                
                System.out.println("Target IP address is....." + theSocket.getInetAddress());
                
                
                
                
                System.out.println("Date and Time....." + sdf.format(date));
                
                
                System.out.println("There is a server on port " + i + " of " + host);
                
                long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      
                System.out.println("Total Execution time....." + elapsedTime + " milliseconds.");
                 theSocket.close();
            }
            catch (UnknownHostException e){
                System.err.println(e);
                break;
            }
            catch (IOException e){
                System.err.println("Handshake not accepted, no server listening on port... " + i);
               
            }
        }
    }
}
