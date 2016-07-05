TITLE:Use Python for Socket Programming to connect two or more PCs to share a text file.
BATCH:
----------------------------------------------------------------
#server code
from socket import *

host = "10.65.6.246"
port = 15005
buf = 1024
addr = (host,port)


UDPSock = socket(AF_INET,SOCK_DGRAM)
UDPSock.bind(addr)

def_msg = "=== Receiving message from client ===";
print "",def_msg


while 1:
    data,addr = UDPSock.recvfrom(buf)
    if not data:
        print "Client has exited!"
        break
    else:
        print "Received message '", data,"'"
	data = raw_input('>>')
	if data == 'exit':
	        break
	else:
	        if(UDPSock.sendto(data,addr)):
	            print "Sending message '",data,"'"


UDPSock.close()
------------------------------------------------------------------

# Client program
from socket import *

# Set the socket parameters
host = "10.65.6.246"
port = 15005
buf = 1024
addr = (host,port)

# Create socket
UDPSock = socket(AF_INET,SOCK_DGRAM)

def_msg = "=== Enter message to send to server ===";
print "",def_msg

# Send messages
while (1):
    data = raw_input('>>')
    if data == 'exit':
        break
    else:
        if(UDPSock.sendto(data,addr)):
            print "Sending message '",data,"'"
	    data,addr = UDPSock.recvfrom(buf)
	    if not data:
	        print "Client has exited!"
	        break
	    else:
	        print "Received message '", data,"'"

# Close socket
UDPSock.close()
----------------------------------------------------------------
/*Output
server output:

comp-sl-19@compsl19-OptiPlex-3020:~$ cd Desktop
comp-sl-19@compsl19-OptiPlex-3020:~/Desktop$ python se.py
 === Receiving message from client ===
Received message ' Hiiiiiiiiii '
>>hello 
Sending message ' hello '
-------------------------------------------------------------
Client OUTPUT:

comp-sl-18@compsl18-OptiPlex-3020:~/Desktop$ python cl.py
 === Enter message to send to server ===
>>Hiiiiiiiiii 
Sending message ' Hiiiiiiiiii  '
Received message ' hello '
>>^Z
[2]+  Stopped                 python cl.py
comp-sl-18@compsl18-OptiPlex-3020:~/Desktop$ */



