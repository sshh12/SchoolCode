
def get_num_coins(values, amt):

    coins = 0

    for v in values:

        while amt >= v:

            amt -= v
            coins += 1

    return coins

def main():

    values = [10, 5, 1]

    print(get_num_coins(values, 28))

if __name__ == '__main__':
    main()
