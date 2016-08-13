#! /usr/bin/env python3

"""
    Crawls all the images on the xkcd Blog
"""

import os
import requests
import bs4

os.makedirs('xkcd_comics', exist_ok = True)
curr_url = 'http://xkcd.com'

while not curr_url.endswith('#'):
    req_result = requests.get(curr_url)
    req_result.raise_for_status()

    soup = bs4.BeautifulSoup(req_result.text, 'html.parser')

    try:
        image = soup.select('div[id="comic"] img')[0]
        img_src = ('http:' + image.get('src'))

        comic_res = requests.get(img_src)

        if not os.path.isfile(os.path.join('xkcd_comics', os.path.basename(img_src))):
            img_file = open(os.path.join('xkcd_comics', os.path.basename(img_src)), 'wb')
            print('Downloading File: ' + os.path.basename(img_src))

            for chunk in comic_res.iter_content(100000):
                img_file.write(chunk)

            img_file.close()
        else:
            print(os.path.basename(img_src) + ' already downloaded')
            
    except Exception as err:
        print('No file found on: ' + curr_url)
        
    prev_url = soup.select('a[rel="prev"]')[0].get('href')
    curr_url = 'http://xkcd.com' + prev_url