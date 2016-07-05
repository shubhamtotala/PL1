ASSIGNMENT No.:12(group B)
TITLE:Write a program in C++ to make USB Device Bootable by installing required system files
BATCH:


#include<iostream>
#include<stdio.h>
#include<stdlib.h>

using namespace std;

class usbboot
{
	private: string iso_file;
	public:
		void getdata();
		void bootable();

};


void usbboot::getdata()
{
	cout<<"\n Enter the name of iso file ::";
	cin>>iso_file;
	cout<<"\n please wait...";
}

void usbboot::bootable()
{
	string s1="sudo dd if=";
	string s2=iso_file;
	string s3=".iso of=/dev/sdb bs=4k";
	string cmd=s1+s2+s3;
	system(cmd.c_str());
	cout<<"\n\n Bootable device is ready...";
}

int main()
{
	usbboot b1;
	int ch;

	do
	{
		cout<<"\n MENU ";
		cout<<"\n 1.create bootable pendrive.. ";
		cout<<"\n 2.exit";
		cout<<"\n Enter choice :";
		cin>>ch;

		switch(ch)
		{
			case 1:
				b1.getdata();
				b1.bootable();
			break;

			case 2:
				return 0;
			break;
		}
	}while(ch!=3);
}


++++++++++++++OUTPUT+++++++++++++++++++
comp-sl-18@compsl18-OptiPlex-3020:~/Desktop/pp$ g++ usbboot.cpp
comp-sl-18@compsl18-OptiPlex-3020:~/Desktop/pp$ ./a.out

 MENU 
 1.create bootable pendrive.. 
 2.exit
 Enter choice :1

 Enter the name of iso file ::WIN7

586936+0 records in
586936+0 records out
2404089856 bytes (2.4 GB) copied, 0.789498 s, 3.0 GB/s
 please wait...

 Bootable device is ready...
 MENU 
 1.create bootable pendrive.. 
 2.exit
 Enter choice :2
comp-sl-18@compsl18-OptiPlex-3020:~/Desktop/pp$ 

