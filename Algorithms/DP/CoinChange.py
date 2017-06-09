
def get_num_coins(coins, i, balance):

    if balance == 0:
        return 1

    elif (balance < 0) or (i <= 0 and balance >= 1):
        return 0

    return (get_num_coins(coins, i - 1, balance) +
            get_num_coins(coins, i, balance - coins[i - 1]))

def get_num_coins2(coins, i, balance):

    db = [0 for _ in range(balance + 1)]

    db[0] = 1

    for k in range(i):

        for j in range(coins[k], balance + 1):

            db[j] += db[j - coins[k]]

    return db[balance]

def main():

    coins = [1, 2, 8, 12]

    print(get_num_coins(coins, len(coins), 25))
    print("------")
    print(get_num_coins2(coins, len(coins), 25))
    
if __name__ == '__main__':
    main()
