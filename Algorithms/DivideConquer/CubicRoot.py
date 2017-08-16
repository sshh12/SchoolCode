
def _calc_error(n, guess):

    return guess ** 3 - n

def cubic_root(n, prec=1e-7):

    start, end = 0, n

    while True:

        guess = (start + end) / 2
        error = _calc_error(n, guess)

        if abs(error) <= prec:

            return guess

        elif error > 0:

            end = guess

        else:

            start = guess

def main():

    print(cubic_root(3))

if __name__ == '__main__':
    main()
