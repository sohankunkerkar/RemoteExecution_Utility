# RemoteExecution_Utility
A client and server program that allows selected users to remotely execute selected programs on a server

On Server Machine use following code when prompted(in this case config):

    Server machine: <config-file name> 
        
On Client Machine please enter a command in following manner:

    Client machine: ./client --server <server ip> --user <username> --password <password> --exec <program to execute>
    
Following assumptions are made while buiding this code:
1. This code is executable for single client 
2. Basically a socket connection is established beween client & server and server handles the request
3. To handle the requirements for validation of the data from config file,HashMap is used
4. Please use localhost in place of server IP address while providing inputs to client machine 
   for e.g <br>
     127.0.0.1 ClientConn (username) (passoword) (programutility)
5. UserCredential class is created to handle multple scenarios of fail attempts. Since Hashmap handles only two values at a time so I'm passing object of class UserCredential as a value and keeping key as a username.
6. There is an assumption where only string matching is done for program to execute input instead of actually restricting the exexution of the program.
    
    
