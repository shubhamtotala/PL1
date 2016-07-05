/*Assignment no:
Batch:T1
Title:Write a program in C++ to create a RAMDRIVE and associate an acyclic directory structure to it. Use this RAMDRIVE to store input, out files to run a calculator program.
*/
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<fstream>
using namespace std;

class RamDisk {
	private:int no1,no2;

	public:	void create_mount();
		void umount_remove();
		void getdata();
		int calci();
		
};
void RamDisk::create_mount() {
	system("sudo mkdir /mnt/ramdisk");
	system("sudo mount -t tmpfs -o size=4G tmpfs /mnt/ramdisk");
	system("mount");
	cout<<"\n\nDirectory has been successfully mounted as temporary storage (RAM).";
	cout<<"\n\nDetails-\n";
	system("stat /mnt/ramdisk");
}
void RamDisk::umount_remove()
{
	system("sudo umount /mnt/ramdisk");
	system("sudo rmdir /mnt/ramdisk");
	cout<<"\n\nDirectory has been successfully unmounted and removed.\n\n";
}
void RamDisk::getdata() {
	cout<<"\nEnter the first no. : ";
	cin>>no1;
	cout<<"\nEnter the second no. : ";
	cin>>no2;
}

int RamDisk::calci()
{
	fstream write("results.txt",ios::out);	//write() is used to write block of data

	if(write.is_open()) {					//is_open() checks if the file is open
		cout<<"\n\nFile 'results.txt' has been created successfully.\n\n";
	}
	



else {
		cout<<"\n\nSorry..! Failed to create file 'results.txt'";
	}

	RamDisk c;
	int ch,ans;
	   do {
		cout<<"\n\n\t\t*** MENU ***";
		cout<<"\n\n1. Addition";
		cout<<"\n2. Subtraction";
		cout<<"\n3. Multiplication";
		cout<<"\n4. Division";
		cout<<"\n5. Exit";
		cout<<"\nEnter your choice: ";
		cin>>ch;
		switch(ch) {
			case 1:	c.getdata();
				ans=c.no1+c.no2;
				
				cout<<"\n NUMBER 1  	 :   "<<c.no1;
				cout<<"\n	     	   +";
				cout<<"\n NUMBER 2  	 :   "<<c.no2;
				cout<<"\n ====================================";
				cout<<"\n ADDITION  	 :   "<<ans;

				//writing to file
				write<<"\n NUMBER 1  	 :   "<<c.no1;
				write<<"\n	     	   +";
				write<<"\n NUMBER 2  	 :   "<<c.no2;
				write<<"\n ====================================";
				write<<"\n ADDITION  	 :   "<<ans;
								
				cout<<"\n\n";
				break;

			case 2:	c.getdata();
				ans=c.no1-c.no2;
				
				cout<<"\n NUMBER 1  	 :   "<<c.no1;
				cout<<"\n	     	   -";
				cout<<"\n NUMBER 2  	 :   "<<c.no2;
				cout<<"\n ====================================";
				cout<<"\n SUBTRACTION  	 :   "<<ans;
				
				//writing to file
				write<<"\n NUMBER 1  	 :   "<<c.no1;
				write<<"\n	     	   -";
				write<<"\n NUMBER 2  	 :   "<<c.no2;
				write<<"\n ====================================";
				write<<"\n SUBTRACTION  	 :   "<<ans;
				cout<<"\n\n";		
				break;

			

				case 3:	c.getdata();
				ans=c.no1*c.no2;

				cout<<"\n NUMBER 1  	 :   "<<c.no1;
				cout<<"\n	     	   *";
				cout<<"\n NUMBER 2  	 :   "<<c.no2;
				cout<<"\n ====================================";
				cout<<"\n MULTIPLICATION  :   "<<ans;
		
				//writing to file
				write<<"\n NUMBER 1  	 :   "<<c.no1;
				write<<"\n	     	   *";
				write<<"\n NUMBER 2  	 :   "<<c.no2;
				write<<"\n ====================================";
				write<<"\n MULTIPLICATION  :   "<<ans;		

				cout<<"\n\n";
				break;

			case 4:	c.getdata();
				ans=c.no1/c.no2;
				
				cout<<"\n NUMBER 1  	 :   "<<c.no1;
				cout<<"\n	     	   /";
				cout<<"\n NUMBER 2  	 :   "<<c.no2;
				cout<<"\n ====================================";
				cout<<"\n DIVISION  	 :   "<<ans;
				
				//writing to file
				write<<"\n NUMBER 1  	 :   "<<c.no1;
				write<<"\n	     	   /";
				write<<"\n NUMBER 2  	 :   "<<c.no2;
				write<<"\n ====================================";
				write<<"\n DIVISION  	 :   "<<ans;
				
				cout<<"\n\n";		
				break;

			case 5:	return 0;
		}
	}while(1);
	write.close();
}

int main() {
	RamDisk r;
	
	r.create_mount();
	r.calci();
	cout<<"\n\nResults have been stored in results.txt file.";
	r.umount_remove();
	return 0;
}



/*
Output:

admin1@admin1-OptiPlex-390:~$ cd Desktop
admin1@admin1-OptiPlex-390:~/Desktop$ g++ ramdisk.cpp
admin1@admin1-OptiPlex-390:~/Desktop$ ./a.out
[sudo] password for admin1: 
/dev/sda6 on / type ext4 (rw,errors=remount-ro)
proc on /proc type proc (rw,noexec,nosuid,nodev)
sysfs on /sys type sysfs (rw,noexec,nosuid,nodev)
none on /sys/fs/cgroup type tmpfs (rw)
none on /sys/fs/fuse/connections type fusectl (rw)
none on /sys/kernel/debug type debugfs (rw)
none on /sys/kernel/security type securityfs (rw)
udev on /dev type devtmpfs (rw,mode=0755)
devpts on /dev/pts type devpts (rw,noexec,nosuid,gid=5,mode=0620)
tmpfs on /run type tmpfs (rw,noexec,nosuid,size=10%,mode=0755)
none on /run/lock type tmpfs (rw,noexec,nosuid,nodev,size=5242880)
none on /run/shm type tmpfs (rw,nosuid,nodev)
none on /run/user type tmpfs (rw,noexec,nosuid,nodev,size=104857600,mode=0755)
none on /sys/fs/pstore type pstore (rw)
/dev/sda8 on /home type ext4 (rw)
/dev/sda7 on /boot type ext4 (rw)
binfmt_misc on /proc/sys/fs/binfmt_misc type binfmt_misc (rw,noexec,nosuid,nodev)
systemd on /sys/fs/cgroup/systemd type cgroup (rw,noexec,nosuid,nodev,none,name=systemd)
gvfsd-fuse on /run/user/1000/gvfs type fuse.gvfsd-fuse (rw,nosuid,nodev,user=admin1)
/dev/sdb1 on /media/admin1/SAI type vfat (rw,nosuid,nodev,uid=1000,gid=1000,shortname=mixed,dmask=0077,utf8=1,showexec,flush,uhelper=udisks2)
/dev/sdc1 on /media/admin1/COMPUTER SH type vfat (rw,nosuid,nodev,uid=1000,gid=1000,shortname=mixed,dmask=0077,utf8=1,showexec,flush,uhelper=udisks2)
tmpfs on /mnt/ramdisk type tmpfs (rw,size=4G)


Directory has been successfully mounted as temporary storage (RAM).

Details-
  File: ‘/mnt/ramdisk’
  Size: 40        	Blocks: 0          IO Block: 4096   directory
Device: 1ah/26d	Inode: 21069       Links: 2
Access: (1777/drwxrwxrwt)  Uid: (    0/    root)   Gid: (    0/    root)
Access: 2014-09-17 12:59:57.289996903 +0530
Modify: 2014-09-17 12:59:57.289996903 +0530
Change: 2014-09-17 12:59:57.289996903 +0530
 Birth: -


File 'results.txt' has been created successfully.



		
		*** MENU ***

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice: 1

Enter the first no. : 10

Enter the second no. : 20

 NUMBER 1  	 :   10
	     	   +
 NUMBER 2  	 :   20
 ====================================
 ADDITION  	 :   30



		*** MENU ***

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice: 2

Enter the first no. : 20

Enter the second no. : 10

 NUMBER 1  	 :   20
	     	   -
 NUMBER 2  	 :   10
 ====================================
 SUBTRACTION  	 :   10



		*** MENU ***

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice: 3




Enter the first no. : 30

Enter the second no. : 2

 NUMBER 1  	 :   30
	     	   *
 NUMBER 2  	 :   2
 ====================================
 MULTIPLICATION  :   60



		*** MENU ***

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice: 4

Enter the first no. : 50

Enter the second no. : 5

 NUMBER 1  	 :   50
	     	   /
 NUMBER 2  	 :   5
 ====================================
 DIVISION  	 :   10



		*** MENU ***

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit
Enter your choice: 5


Results have been stored in results.txt file.

Directory has been successfully unmounted and removed.

admin1@admin1-OptiPlex-390:~/Desktop$ */

