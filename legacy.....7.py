Assignment No:                                Batch:
TitleWrite a program in Python/C++ to test that computer is booted with Legacy Boot ROM-
BIOS or UEFI.


import os

print 'UEFI detected.' if os.path.exists('/sys/firmware/efi') else 'Legacy BIOS detected.'


OUTPUT:


admin1@admin1-OptiPlex-390:~$ cd Desktop
admin1@admin1-OptiPlex-390:~/Desktop$ python legacy.py
Legacy BIOS detected.

