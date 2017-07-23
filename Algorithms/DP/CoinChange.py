
def get_num_coins(coins, balance, i=None):

    if i == None:
        return get_num_coins(coins, balance, len(coins))

    elif balance == 0:
        return 1

    elif (balance < 0) or (i <= 0 and balance >= 1):
        return 0

    return (get_num_coins(coins, balance, i - 1) +
            get_num_coins(coins, balance - coins[i - 1], i))

def get_num_coins2(coins, balance):

    db = [ 0 for _ in range(balance + 1) ]

    db[0] = 1

    for k in range(len(coins)):

        for j in range(coins[k], balance + 1):

            db[j] += db[j - coins[k]]

    return db[balance]

def main():

    coins = [1, 2, 8, 12]

    print(get_num_coins(coins, 25))
    print("------")
    print(get_num_coins2(coins, 25))

if __name__ == '__main__':
    main()
