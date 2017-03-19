//Modified Client program
import java.io.*; 
import java.net.*; 

class ClientConn { 

	public static void main(String args[]) throws Exception 
    { 
        String modifiedSentence; 
        ///client --server <server ip> --user <username> --password <password> --exec <program to execute>
        String ip= args[0];
        String username=args[1];
        String password=args[2];
        String program=args[3];
        Socket clientSocket = new Socket(ip, 15007); 

        DataOutputStream outToServer = 
          new DataOutputStream(clientSocket.getOutputStream()); 
        
        BufferedReader inFromServer = 
          new BufferedReader(new
          InputStreamReader(clientSocket.getInputStream()));
      /* Sending command-line parameters to server for processing
        */
        outToServer.writeBytes(username+" "+password+" "+program+ '\n'); 
        modifiedSentence = inFromServer.readLine(); 
        System.out.println("FROM SERVER: " + modifiedSentence); 
        clientSocket.close();                 
    } 
} 
