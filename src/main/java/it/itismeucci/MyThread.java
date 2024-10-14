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
            String scelta;
    
            do{
            
           scelta = in.readLine();
            stringaRicevuta = in.readLine();

            switch(scelta){
                case "1":
                  String stringaMaiuscola = stringaRicevuta.toUpperCase();
                  out.writeBytes(stringaMaiuscola + "\n");
                  break;
                
                case "2":
                   String stringaMinuscola = stringaRicevuta.toLowerCase();
                   out.writeBytes(stringaMinuscola + "\n");
                   break;
                
                case "3":
                StringBuilder s = new StringBuilder(stringaRicevuta);
                s = s.reverse();
                out.writeBytes(s + "\n");
                break;

                case "4":
                int caratteri = stringaRicevuta.length();
                out.writeBytes(caratteri + "\n");
                break;

                case "5":
                out.writeBytes("esecuzione finita!!!");

            }

    
            }while(!scelta.equals("5"));
    
            s.close();

            } catch (Exception e) {
               e.printStackTrace();
            }
        }
}
