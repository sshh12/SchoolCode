
def get_max_price(prices, index=None):

    if index == None: index = len(prices) - 1

    elif index < 0: return 0

    mx = 0

    for i in range(index + 1):

        mx = max(mx, prices[i] + get_max_price(prices, index - i - 1))

    return mx

def get_max_price2(prices):

    db = [ 0 ] * (len(prices) + 1)

    for i in range(1, len(prices) + 1):

        mx = 0

        for j in range(i):

            mx = max(mx, prices[j] + db[i - j - 1])

        db[i] = mx

    return db[-1]

def main():

    prices = [1, 5, 8, 9, 10, 17, 17, 20]

    print(get_max_price(prices))
    print("------")
    print(get_max_price2(prices))

if __name__ == '__main__':
    main()
