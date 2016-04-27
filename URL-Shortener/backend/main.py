import csv
import hashlib
import configparser
import time
import calendar

from flask import Flask, redirect, url_for, render_template

class URLshortener():
    def __init__(self):
        config = configparser.ConfigParser()
        config.read("settings.ini")


    def shorturl(self, link):
        shorturl = hashlib.sha224(str.encode(link)).hexdigest()[0:6]
        timenow = calendar.timegm(time.gmtime())
        res = [shorturl, link, timenow]
        self.updatedatabase(res)
        return res

    def lookup(self, url):
        with open('data/data.csv') as cv:
            reader = csv.reader(cv, delimiter=' ')
            for row in reader:
                if row[0] == url:
                    return row[1]
            return '404'

    def updatedatabase(self, row):
        if self.lookup(row[0]) == '404':
            with open("data/data.csv", 'a', newline='') as cv:
                writer = csv.writer(cv, delimiter=' ')
                writer.writerow(row)

u = URLshortener()

print(u.lookup("089c3c"))

app = Flask(__name__)

@app.route('/shorten_url', methods = ['POST'])
def shorten():
    url = request.form['url']
    return render_template("index.html", newurl = "http://" + u.lookup(url))

@app.route('/r/<shorturl>')
def update(shorturl):
    lll = "http://" + u.lookup(shorturl)
    return redirect(lll, code=302)

@app.route('/a/<url>')
def addurl(url):
    res = u.shorturl(url)
    return  res[0]

if __name__ == '__main__':
    app.run()
