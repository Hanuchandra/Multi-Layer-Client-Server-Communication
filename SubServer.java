import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SubServer {
    enum OPERATOR { SUB };

    public static final int PORT_NO = 8889;

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(PORT_NO);
        System.out.println("SERVER started, ready to accept requests...");

        while (true) {
            Socket subsocket = serverSocket.accept(); 
            Socket socket = serverSocket.accept();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            socket.close();

            System.out.println("Request received from the Main Server request: " + line);
            System.out.println("Rrequest is processing....");

            if (line.trim().startsWith("quit")) {
                //System.out.println("... server shutting down ...");
                socket.close();
                break;
            } else {
                processRequest(subsocket, line);
            }
        }

        System.out.println("... closing server socket ...");
        serverSocket.close();
    }
    
    private static void processRequest(Socket subsocket, String line) throws IOException, InterruptedException {
        PrintWriter pw = new PrintWriter(subsocket.getOutputStream());

        String[] tokens = line.split(" ");

        if (tokens.length != 2) {
            pw.println("invalid command: " + line);
            subsocket.close();
            return;
        } 

        String[] operands = tokens[1].split(",");

        if (operands.length != 2) {
            pw.println("invalid command: " + line);
            subsocket.close();
            return;
        } 

        String operator = tokens[0].trim();

        try {
            Double operand1 = Double.valueOf(operands[0].trim());
            Double operand2 = Double.valueOf(operands[1].trim());
            System.out.println("Operand 1:"+operand1);System.out.println("Operand 2:"+operand2);

            double result = 0;
            OPERATOR  op = OPERATOR.valueOf(operator.toUpperCase());
            switch (op) {
            case SUB:
                result = operand1 - operand2;
                break;
            default:
                pw.println("invalid operand: " + line);
                pw.flush();
                subsocket.close();
                return;
            }
            System.out.println("Result sent to the client ");
            System.out.println("Sent result: " + result );
            pw.println(result);
            pw.flush();
        } catch (NumberFormatException nfe) {
            pw.println("invalid operand: " + line);
        }

        
        
        subsocket.close();
    }

}