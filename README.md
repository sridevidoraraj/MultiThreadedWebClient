## MultiThreaded WebClient Program

## Client Program

### Structure

This project structured using intellij platform and maven as build system.

#### About Project

-> This project is used for multiple clients can communicate simultaneously with one server.

-> Everytime server should get start first, then only client program should start.

-> In client program, server port number is given to communicate with server.

-> DataInputStream and outputStream are used to send and receive message from server.

-> FileInputStream is used to get the file which was requested by client.

-> Response from server is given by HTTP response, which was displayed when client send request to server.

-> The output was given in console as : 

[CONNECTED]
[READ PROCESS]

buff length->140

[/READ PROCESS]

[RES]

HTTP/1.0 200 OK

[<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">]

### To Run The Program
for maven, to build the project use
```
mvn clean install
```

to run the program, in main application by clicking the run button icon where the java class file is created.

```bash
Public class Client{
```
for multiple client run simultaneously, click on the run icon everytime to run the client program.