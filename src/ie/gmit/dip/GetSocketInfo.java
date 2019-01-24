package ie.gmit.dip;

import java.net.*;
import java.io.*;
import java.util.*;
import java.time.*;
import java.text.*;


public class GetSocketInfo {
    
   
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public static void main(String[] args){
        
         long startTime = System.currentTimeMillis();

      long total = 0;
      for (int j = 0; j < 10000000; j++) {
         total += j;
     }
            InetAddress ip;
             Date date = new Date();
            
            
            
            
            
        
        for (int i = 0; i < args.length; i++){
            try{
                Socket theSocket = new Socket( args[i], 80);
                
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
                
                System.out.println("Connected to " + theSocket.getInetAddress() + " on port " + theSocket.getPort() + " from port " + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());
            
            
            
            
            long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      
                System.out.println("Total Execution time....." + elapsedTime + " milliseconds.");
            theSocket.close();}
            
            catch (UnknownHostException e){
                System.err.println("I cant find " + args[i]);
            }
        
        catch (IOException e){
            System.err.println (e);
        }
        
    }
  }
}