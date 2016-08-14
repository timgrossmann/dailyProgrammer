#! usr/env/bin python3.5

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from time import sleep


browser = webdriver.Chrome('/Users/TG/Applications/Chrome Apps.localized/chromedriver')

browser.get('https://gabrielecirulli.github.io/2048/')

try:
    htmlElem = browser.find_element_by_tag_name('body')

    while True:
        htmlElem.send_keys(Keys.UP)
        sleep(0.05)
        htmlElem.send_keys(Keys.RIGHT)
        sleep(0.05)
        htmlElem.send_keys(Keys.DOWN)
        sleep(0.05)
        htmlElem.send_keys(Keys.LEFT)
        sleep(0.05)
        
except Exception as err:
    print(str(err))

