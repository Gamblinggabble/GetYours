import requests
from bs4 import BeautifulSoup

def get_price(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.content, "html.parser")

    spans = soup.find_all("span", class_="sc-2qcyw4-0 sc-18q89z4-0 eMbUfc bRLyIC")

    return [str(span.get_text() for span in spans]
