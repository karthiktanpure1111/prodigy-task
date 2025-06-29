import requests
from bs4 import BeautifulSoup
import pandas as pd

# Base URL
BASE_URL = 'http://books.toscrape.com/catalogue/page-{}.html'

# Store product info
products = []

# Scrape first 3 pages (can increase)
for page in range(1, 4):
    print(f"Scraping page {page}...")
    url = BASE_URL.format(page)
    res = requests.get(url)
    soup = BeautifulSoup(res.text, 'html.parser')

    books = soup.find_all('article', class_='product_pod')

    for book in books:
        name = book.h3.a['title']
        price = book.find('p', class_='price_color').text
        rating = book.p['class'][1]

        products.append({
            'Name': name,
            'Price': price,
            'Rating': rating
        })

# Save to CSV
df = pd.DataFrame(products)
df.to_csv('products.csv', index=False)

print("\n✅ Done! Data saved to products.csv")
