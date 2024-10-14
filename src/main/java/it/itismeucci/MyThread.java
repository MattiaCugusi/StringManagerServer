package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{
    Socket s = new Socket();

    public MyThread(Socket s){
        this.s = s;
    }
    
        @Override
        public void run() {
            try {

            System.out.println("qualcuno si è collegato");
    
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
    
            String stringaRicevuta;
            int scelta;
    
            do{
            
           scelta = in.read();
            stringaRicevuta = in.readLine();

            switch(scelta){
                case 1:
                  String stringaMaiuscola = stringaRicevuta.toUpperCase();
                  out.writeBytes(stringaMaiuscola + "\n");
                  break;
                
                case 2:
                   String stringaMinuscola = stringaRicevuta.toLowerCase();
                   out.writeBytes(stringaMinuscola + "\n");


            }
            
    
            String stringaMaiuscola = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaMaiuscola + "\n");
    
            }while(!stringaRicevuta.equals("!"));
    
            s.close();

            } catch (Exception e) {
               e.printStackTrace();
            }
        }
}
