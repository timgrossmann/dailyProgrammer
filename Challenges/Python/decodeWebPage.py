import requests, os
from bs4 import BeautifulSoup

url = 'http://www.nytimes.com'

def extractArticles (url):
    data = requests.get(url)
    soup = BeautifulSoup(data.text, 'html.parser')

    articles = []

    for article in soup.find_all('article'):
        if article.find('h2') != None and article.find('h2').find('a') != None:
            heading = article.find('h2').find('a').get_text().strip()

            if heading != "":
                articles.append(heading)

    articles = sorted(list(set(articles)))

    f = open('./articles/headlines2.txt', 'w')            

    for heading in articles:
        f.write(heading)
        f.write('\n')

    f.close()
    
extractArticles(url)