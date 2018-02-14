import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class CalClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
        
        String operation = args[0] + " " + args[1];
        operation= operation.toUpperCase();

        // Create a new socket object and names it socket
        // the constructor requires the name of the computer and the port number to which you want to connect
        //Socket socket = new Socket("localhost", CalServer.PORT_NO);
        String ope= operation.substring(0,3);


         if(ope.equals("ADD")) { Socket socket = new Socket("localhost", CalServer.PORT_NO);
        Socket addsocket = new Socket("localhost", AddServer.PORT_NO);
         // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(operation);
        pw.flush();
        System.out.println("Request sent to MAIN SERVER");
        

        if (!"quit".equals(operation.trim())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(addsocket.getInputStream()));
            String line = reader.readLine();
            reader.close();
            System.out.println("Result sent from ADDITION SERVER: " + line);
            }
        socket.close();
        addsocket.close(); }
         
   
        else if(ope.equals("SUB")) { Socket socket = new Socket("localhost", CalServer.PORT_NO);
        Socket subsocket = new Socket("localhost", SubServer.PORT_NO);


        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(operation);
        pw.flush();
        System.out.println("Request sent to MAIN SERVER");
        

        if (!"quit".equals(operation.trim())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(subsocket.getInputStream()));
            String line = reader.readLine();
            reader.close();
            System.out.println("Result sent from SUBTRACTION SERVER: " + line);
            
        }
        socket.close();
        subsocket.close();
       }//sub if

      else if(ope.equals("MUL")) { Socket socket = new Socket("localhost", CalServer.PORT_NO);
        Socket mulsocket = new Socket("localhost", MulServer.PORT_NO);


        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(operation);
        pw.flush();
        System.out.println("Request sent to MAIN SERVER");
        

        if (!"quit".equals(operation.trim())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(mulsocket.getInputStream()));
            String line = reader.readLine();
            reader.close();
            System.out.println("Result sent from MULTIPLICATION SERVER: " + line);
            
        }
        socket.close();
        mulsocket.close();
       }//MUL if

      else if(ope.equals("DIV")) { Socket socket = new Socket("localhost", CalServer.PORT_NO);
        Socket divsocket = new Socket("localhost", DivServer.PORT_NO);


        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(operation);
        pw.flush();
        System.out.println("Request sent to MAIN SERVER");
        

        if (!"quit".equals(operation.trim())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(divsocket.getInputStream()));
            String line = reader.readLine();
            reader.close();
            System.out.println("Result sent from DIVISION SERVER: " + line);
            
        }
        socket.close();
        divsocket.close();
       }//DIV if


      else if(ope.equals("MOD")) { Socket socket = new Socket("localhost", CalServer.PORT_NO);
        Socket modsocket = new Socket("localhost", ModServer.PORT_NO);


        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(operation);
        pw.flush();
        System.out.println("Request sent to MAIN SERVER");
        

        if (!"quit".equals(operation.trim())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(modsocket.getInputStream()));
            String line = reader.readLine();
            reader.close();
            System.out.println("Result sent from MODULUS SERVER: " + line);
            
        }
        socket.close();
        modsocket.close();
       }//MOD if
      else if( (operation.length()!=7) || (!ope.equals("ADD")) || (!ope.equals("SUB")) || (!ope.equals("MUL")) || (!ope.equals("DIV")) || (!ope.equals("MOD")) || ("quit".equals(operation.trim())) )
       { System.out.println("Enter a valid request"); } 
    }
}