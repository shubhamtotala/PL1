//Assignment No:                       Batch:


//Title:Write an IPC program using pipe. Process A accepts a character string and Process B inverses the string. Pipe is used to establish communication between A and B processes using Python or C++.


#include <iostream>
#include <cstdlib>
#include <cstring>
#include <string.h>
//#include <sys/wait.h>
#include <unistd.h>
using namespace std;
 
// global variables
const int BUFFER_SIZE = 256;
const int READ_END = 0;
const int WRITE_END = 1;



 
int main()
{
    // declare variables
    int fd[2]; // pipe file descriptor
    pid_t pid = -1;    
    char writeMsg[BUFFER_SIZE] = "";
    char readMsg[BUFFER_SIZE];
    
    // create a pipe
    if(pipe(fd) < 0)
    {
        cerr<<"\nPipe failed.\n";
        exit(1);
    }
    
    cerr<<"\nParent is forking a child.";
 
    // create a duplicate process of this current program
    pid = fork();
    
    // exit if something went wrong with the fork
    if(pid < 0)
    {
        cerr<<"\nFork failed!\n";
        exit(1);
    }
    // this code only gets executed by the child process
    else if(pid == 0)
    {
        cerr<<"\nStarting the child process..\n\n";
        // close the "write" end b/c we arent using it
        //close(fd[WRITE_END]);
        // get data from the pipe using the read() function
        read(fd[READ_END], readMsg, sizeof(readMsg));
        // close the "read" end
        //close(fd[READ_END]);

	cerr<<"Message from the parent via the pipe: "<<readMsg<<endl;

	/*Reverse a string*/
	int n=strlen(readMsg)-1;
	for(int i=0;i<strlen(readMsg);i++,n--)
		writeMsg[i]=readMsg[n];
	
	/*Send a reversed string*/
	//close(fd[READ_END]);
	write(fd[WRITE_END], writeMsg, strlen(writeMsg)+1);	
        // close the "write" end
        //close(fd[WRITE_END]);

        // use the "wait" function to wait for the parent to complete
        wait(NULL);  
        
    }
    // the parent process executes here
    else
    {
        cerr<<"\nParent is now waiting for child id #"<<pid<<" to complete..\n";
        // close the "read" end b/c we arent using it
//        close(fd[READ_END]);
	cout<<"Enter the string : ";
	cin>>writeMsg;
        // write data on pipe
        write(fd[WRITE_END], writeMsg, strlen(writeMsg)+1);
        // close the "write" end
//        close(fd[WRITE_END]);
        // use the "wait" function to wait for the child to complete
        wait(NULL);  

//	close(fd[WRITE_END]);
        // get data from the pipe using the read() function
        read(fd[READ_END], readMsg, sizeof(readMsg));
        // close the "read" end      
	cerr<<"Message from the child via the pipe: "<<readMsg<<endl;
        // close the "read" end
//        close(fd[READ_END]);
        cerr<<"\nThe child process is complete and has terminated!\n";
    }
    
    // NOTE: this message gets displayed twice - Why?!
    cerr<<"\nProgram is now exiting...\n";
    
    return 0;
}






/*OUTPUT:

admin1@admin1-OptiPlex-390:~$ cd Desktop
admin1@admin1-OptiPlex-390:~/Desktop$ g++ pipe.cpp
admin1@admin1-OptiPlex-390:~/Desktop$ ./a.out

Parent is forking a child.
Parent is now waiting for child id #5158
Starting the child process..

 to complete..
Enter the string : osd
Message from the parent via the pipe: osd

Program is now exiting...
Message from the child via the pipe: dso

The child process is complete and has terminated!

Program is now exiting...*/

