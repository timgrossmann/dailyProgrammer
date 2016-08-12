#! /usr/bin/env python3

"""
    Search entered location in google maps

Usage:
    ./mapit.py
"""

import sys
import webbrowser
import pyperclip


glob_browser = webbrowser.get('safari')

def open_google_maps (location):
    glob_browser.open('https://www.google.com/maps/place/' + location)
        
        
if len(sys.argv) > 1:
    location = sys.argv[1:]
else:
    location = pyperclip.paste().split(' ')
    
open_google_maps('+'.join(location))
