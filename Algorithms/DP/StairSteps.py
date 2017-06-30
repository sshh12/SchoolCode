
def count_ways(steps):

    if steps < 1:
        return 0

    else:
        return (1 + count_ways(steps - 1) +
                    count_ways(steps - 2) +
                    count_ways(steps - 3))

def count_ways2(steps):

    db = [ 0 ] * (steps + 1)

    db[0], db[1] = 1, 1

    for i in range(2, steps + 1):

        k = 1

        while k <= 3 and k <= i:

            db[i] += db[i - k]

            k += 1

    return db[-1]

def main():

    print(count_ways(3))
    print("------")
    print(count_ways2(3))

if __name__ == '__main__':
    main()
