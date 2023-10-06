import requests
from bs4 import BeautifulSoup

def get_price(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.content, "html.parser")

    spans = soup.find_all("span", class_="sc-2qclq4-0 sc-18q4lz4-0 eMbUfc bRLqIC")

    return [str(span.get_text() for span in spans]
