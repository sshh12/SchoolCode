
def get_unique_summands(num):

    summands = []

    if num <= 2:

        summands.append(num)

    else:

        k = 1

        while num > 2 * k:

            num -= k

            summands.append(k)

            k += 1

        summands.append(num)

    return summands

def main():

    for n in get_unique_summands(8):

        print(n)

if __name__ == '__main__':
    main()
