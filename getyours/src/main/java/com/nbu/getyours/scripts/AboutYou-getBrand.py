import requests
from bs4 import BeautifulSoup


url =  "https://www.aboutyou.bg/p/nike-sportswear/prehodno-yake-8615180"
print(url)
response = requests.get(url)
soup = BeautifulSoup(response.content, "html.parser")

spans = soup.find_all("span", class_="sc-2qclq4-0")
for span in spans:
    print(span)
#     print(str(span.get_text() for span in spans))
# return [str(span.get_text() for span in spans)]
