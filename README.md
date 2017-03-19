# RemoteExecution_Utility
A client and server program that allows selected users to remotely execute selected programs on a server

In a programming language of your choice, write 
a client and server program that allows selected 
users to remotely execute selected programs on 
a server:

    Server machine: ./server config-file
        
config-file allows an Admin to specify users, 
their passwords, and the programs they are allowed 
to execute.

    Client machine: ./client --server <server ip> --user <username> --password <password> --exec <program to execute>
