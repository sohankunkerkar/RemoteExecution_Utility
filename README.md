# RemoteExecution_Utility
A client and server program that allows selected users to remotely execute selected programs on a server

On Server Machine use following code when prompt(in this case config):

    Server machine: <config-file name> 
        
On Client Machine please enter a command in following manner

    Client machine: ./client --server <server ip> --user <username> --password <password> --exec <program to execute>
    
Following assumptions are made while buiding this code:
1. This code can handle only single client 
2. To handle the requirements for validation of the data from config file,HashMap is used
3. Please use localhost in place of server IP address while providing inputs to client machine 
   for e.g
     127.0.0.1 ClientConn <username> <passoword> <programutility>
    
    
