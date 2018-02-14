import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalServer {
    

    public static final int PORT_NO = 8888;

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(PORT_NO);
        
        System.out.println("SERVER started, ready to accept requests...");

        while (true) {
            //Socket addsocket = new Socket("localhost", AddServer.PORT_NO);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            socket.close();
            String ope= line.substring(0,3);
         if(ope.equals("ADD"))  {
            Socket addsocket = new Socket("localhost", AddServer.PORT_NO);
           System.out.println("Request received from the client: " + line);
            
            if (line.trim().startsWith("quit")) {
                System.out.println("... server shutting down ...");
                socket.close();
                break;
            }// if

        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(addsocket.getOutputStream());
        pw.println(line);
        System.out.println("REQUEST sent to ADDITION SERVER");
        pw.flush();
        addsocket.close(); }
         

        if(ope.equals("SUB")){
            Socket subsocket = new Socket("localhost", SubServer.PORT_NO);
            System.out.println("Request received from the client: " + line);
            
            if (line.trim().startsWith("quit")) {
                System.out.println("... server shutting down ...");
                socket.close();
                break;
            }// if

        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(subsocket.getOutputStream());
        pw.println(line);
        System.out.println("REQUEST sent to SUBTRACTION SERVER");
        pw.flush();
        subsocket.close();
        }
       if(ope.equals("MUL")){
            Socket mulsocket = new Socket("localhost", MulServer.PORT_NO);
            System.out.println("Request received from the client: " + line);
            
            if (line.trim().startsWith("quit")) {
                System.out.println("... server shutting down ...");
                socket.close();
                break;
            }// if

        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(mulsocket.getOutputStream());
        pw.println(line);
        System.out.println("REQUEST sent to MULTIPLICATION SERVER");
        pw.flush();
        mulsocket.close();
        }

if(ope.equals("DIV")){
            Socket divsocket = new Socket("localhost", DivServer.PORT_NO);
            System.out.println("Request received from the client: " + line);
            
            if (line.trim().startsWith("quit")) {
                System.out.println("... server shutting down ...");
                socket.close();
                break;
            }// if

        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(divsocket.getOutputStream());
        pw.println(line);
        System.out.println("REQUEST sent to DIVISION SERVER");
        pw.flush();
        divsocket.close();
        }

if(ope.equals("MOD")){
            Socket modsocket = new Socket("localhost", ModServer.PORT_NO);
            System.out.println("Request received from the client: " + line);
            
            if (line.trim().startsWith("quit")) {
                System.out.println("... server shutting down ...");
                socket.close();
                break;
            }// if

        // gets the socket's output stream and opens a PrintWriter on it
        PrintWriter pw = new PrintWriter(modsocket.getOutputStream());
        pw.println(line);
        System.out.println("REQUEST sent to MODULUS SERVER");
        pw.flush();
        modsocket.close();
        }
        
        
       }//while
        
        
        
       
    }
  

}