"""
    Rename files that have spaces or dashes to camelCase files
    
    
Usage:
    python3.5 rnFilesToCamelCase.py...
    ... (empty) -> uses the current directory
    ... /Users/TG/Dropbox/FreeBooks -> using an absolute Path checks all the files in that folder
    ... . ".py .exe" -> using current directory and ignoring the files with endings .py and .exe
"""

import os, sys, re, shutil

def renameFiles ():
    ignoreEndings = []
    
    if len(sys.argv) == 3:
        ignoreEndings = sys.argv[2].split(" ")
        
    if len(sys.argv) >= 2:
        filesPath = sys.argv[1]
        os.chdir(filesPath)
    else:
        filesPath = "."
    
    files = os.listdir(filesPath)
    
    for item in files:
        wrongFile = False
        
        for ending in ignoreEndings:
            if item.endswith(ending):
                wrongFile = True
        
        if not item.startswith(".") and not wrongFile:
            oldItem = item
            
            for char in "[](){}'#*_-–?:;!%|,— `´<>^°§¡“¶¢≠¿'":
                if char in item:
                    item = item.replace(char, " ")

            item = oldItem if oldItem == item else item.title()
            
            if item[0].islower():
                item = item.capitalize()

            item = re.sub(" +", "", item)
            
            shutil.move(oldItem, item)
    
renameFiles()