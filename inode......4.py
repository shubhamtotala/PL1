Assignment No:                                Batch:
Title:Write a program in Python/C++ to read display the i-node information for a given text file,
image file.

import os, sys

fd=os.open("example.jpg",os.O_RDWR|os.O_CREAT)

info=os.fstat(fd)

print" File information is as follows"

print"File inode number",info.st_ino

print"Devince number",info.st_dev

print"Number of link",info.st_nlink

print"UID of the file:%d"% info.st_uid

print"GID of the file :%d" %info.st_gid

print"Size",info.st_size

print"access time",info.st_atime

print"Modify time",info.st_mtime

print"Change time",info.st_ctime

print"Protections",info.st_mode

print"Number of blocks allocated",info.st_blocks

os.close(fd)

OUTPUT:

admin1@admin1-OptiPlex-390:~$ cd Desktop
admin1@admin1-OptiPlex-390:~/Desktop$ python link.py
 File information is as follows
File inode number 2887272
Devince number 2055
Number of link 1
UID of the file:1000
GID of the file :1000
Size 0
access time 1410519702.76
Modify time 1410519702.76
Change time 1410519702.76
Protections 33277
Number of blocks allocated 0

