//Modified server program
import java.io.*; 
import java.net.*; 
import java.util.*;
class ServerConn { 

	@SuppressWarnings("resource")
	public static void main(String args[]) throws Exception 
    { 
      String clientInput; 
      String[]elements=new String[3]; //to store command line arguments provided by user

      ServerSocket welcomeSocket = new ServerSocket(15005); 
      //Creating HashMap to store data from the file
      HashMap<String, UserCredentials> mapUsers=new HashMap<>();
      while(true) { 
            Socket connectionSocket = welcomeSocket.accept(); 
           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream())); 
           DataOutputStream  outToClient = 
             new DataOutputStream(connectionSocket.getOutputStream()); 
      try
       {
    	  //Creating an object of Usercredentials class
           UserCredentials u=new UserCredentials();
           //Reading the file input
           File config=new File("/Users/Sohank/Documents/workspace/RemoteExec/src/config.txt");
           Scanner sc=new Scanner(config);
           while(sc.hasNext())
           {
           String nl=sc.nextLine();
           //Split the data data in the file  to store it in Map
           String []credentials=nl.split(";");
           String user=credentials[0];
           String pass=credentials[1];
           String prog=credentials[2];
           String[] progAccess=prog.split(",");
           // changing the username to lowercase in order to avoid confusion
           u.setUsername(user.toLowerCase());
           u.setPassword(pass);
           u.setProgram(progAccess);
           mapUsers.put(user.toLowerCase(), u);
           
           } 
           
          //reading the input from client 
           clientInput = inFromClient.readLine(); 
           //split the data to compare it with the on which is store in map
           elements=clientInput.split("\\s+");
           //comparing user name
           if(!mapUsers.containsKey(elements[0]))
           {
        	   //System.out.println(" Given username/password is not valid!");
        	   outToClient.writeBytes("Given username/password is not valid! \n");
           }
           else {
        	   UserCredentials existingUser=(UserCredentials)mapUsers.get(elements[0]);
        	   // boolean variable is intialize in case program utility is not accessible
        	   boolean access=false;
        	   //Checking the password
        	   if( existingUser.getPassword().equals(elements[1].toLowerCase()) ){
        		   for(String progAccessToUser: existingUser.program){
        			   if( elements[2].equals(progAccessToUser) ){
        				   access=true;
        				   //System.out.println("Successful in execution");
        				   outToClient.writeBytes("Successful in execution  \n");
        				   break;
        			   }
        		   }
        		   
        		   if(!access){
        			   //System.out.println("Given user doesn't have access to mentioned utility program");
        			   outToClient.writeBytes("Given user doesn't have access to mentioned utility program \n");
        		   }
        	   }
        	   else{
        		   //System.out.println("Given username/password is not valid!");
        		   outToClient.writeBytes("Given username/password is not valid! \n");
        	   }
           }
           
     }    
           catch(FileNotFoundException ex)
           {
        	   System.out.println("Exception is"+ex);
           }
        } 
    } 
} 
 
