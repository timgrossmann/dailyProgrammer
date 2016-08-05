"""
!---MultiClipboard---!

Usage:
    python3.5 mcb.pyw... 
        ... save name -> saves clipboard content to name
        ... name -> copies content of name to the clipboard
        ... list -> copies a list of all saved names to the clipboard
        ... delete name -> deletes name with it's content
        ... delete -> deletes all name keys
        ... print name filename -> prints the content of the name key to the file
"""

import shelve, pyperclip, sys, os

def handleCase (mcbShelve):
    numOfArgs = len(sys.argv)
    args = []
    
    for arg in range(numOfArgs):
        args.append(sys.argv[arg])
    
    if len(sys.argv) == 4:
        if args[1].lower() == 'print' and args[2] in mcbShelve:
            with open(args[3], 'a') as f:
                f.write(mcbShelve[args[2]])
                f.write('\n')
                
        else:
            print('Sorry invalid Statement')
    
    elif len(sys.argv) == 3:
        if args[1].lower() == 'save':
            mcbShelve[args[2]] = pyperclip.paste()

        elif args[1].lower() == 'delete':
            del mcbShelve[args[2]]
            
        else:
            print('Sorry invalid Statement')
        
    elif len(sys.argv) == 2:
        if args[1].lower() == 'list':
            pyperclip.copy(str(list(mcbShelve.keys())))

        elif args[1].lower() == 'delete':
            for key in mcbShelve.keys():
                del mcbShelve[key]

        elif args[1] in mcbShelve:
            pyperclip.copy(mcbShelve[args[1]])
            
        else:
            print('Sorry invalid Statement')
    

mcbShelve = shelve.open('./db/mcb')

handleCase(mcbShelve)

mcbShelve.close()
