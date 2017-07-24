
def count_ways(steps):

    if steps <= 1:
        return steps

    else:

        sum_, i = 0, 1

        for i in range(1, min(steps, 3) + 1):

            sum_ += count_ways(steps - i)

        return sum_

def count_ways2(steps):

    if steps == 1:
        return 1

    else:

        db = [0, 1, 2, 4] + [ 0 ] * (steps - 3)

        for i in range(4, steps + 1):

            db[i] = db[i - 1] + db[i - 2] + db[i - 3]

        return db[-1]

def main():

    print(count_ways(22 + 1))
    print("------")
    print(count_ways2(22))

if __name__ == '__main__':
    main()
