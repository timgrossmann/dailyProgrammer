#! /usr/bin/env python3

"""
    Open the first several images of the given CLArgument
    
Usage:
    ./open_several_search...
        ... dogs -> opens the first several dog images in separate tabs
"""

import sys
import requests
import webbrowser
import bs4

glob_browser = webbrowser.get()

def open_searched_img (search_key):
    req_result = requests.get('https://www.ecosia.org/images?q=' + search_key)
    req_result.raise_for_status()
    
    soup = bs4.BeautifulSoup(req_result.text, 'html.parser')
    
    links = soup.select('div[class="image-result-wrapper js-result-wrapper"] > a')
    
    impo_links = links[:5]
    
    for link in impo_links:
        glob_browser.open(link.get('href'))
    

if len(sys.argv) < 2:
    print('Please enter a valid search String')
else:
    try:
        open_searched_img("+".join(sys.argv[1:]))
    except Exception as err:
        print('Please enter a valid search String' + str(err))