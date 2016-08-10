#! python3.5

"""
    Copies all files with the given endings into the specified directory
    
Usage:
    python3.5 copySelective.py...
        ... /Users/TG/Desktop/Test ".pdf .jpg" -> walks the Test Folder and copies all the files ending with .pdf or .jpg to the current directory
        ... /Users/TG/Desktop/Test ".pdf .jpg" /Users/TG/Desktop/CopiedFiles -> copies all the files with specified endings into CopiedFiles Folder
"""

import os
import shutil
import sys
import time

def copySelective ():
    start = time.time()
    
    if len(sys.argv) == 4:
        destinationFolder = sys.argv[3] if os.path.isabs(sys.argv[3]) else os.path.abspath(sys.argv[3])
    else:
        destinationFolder = '.'
    
    if len(sys.argv) >= 3:
        fileExtensions = sys.argv[2].split(' ')
        targetFolder = sys.argv[1] if os.path.isabs(sys.argv[1]) else os.path.abspath(sys.argv[1])
    else:
        raise Exception('Please Enter valid arguments')
    
    for foldername, subfolders, filenames in os.walk(targetFolder):
        for currFile in filenames:
            for extension in fileExtensions:
                if currFile.endswith(extension):
                    shutil.copy(os.path.join(foldername, currFile), destinationFolder )
                    break
    
    print('Copying all files took %s seconds' % (round((time.time() - start) * 100) / 100) + '\n')
    
    
try:
    copySelective()
except Exception as err:
    print(str(err))