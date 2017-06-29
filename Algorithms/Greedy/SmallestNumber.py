
def get_smallest_num(digit_sum, n_digits):

    if digit_sum <= 0 or digit_sum > 9 * n_digits: return -1

    result = [ 0 ] * n_digits

    digit_sum -= 1

    for i in reversed(range(1, n_digits)):

        if digit_sum > 9:

            result[i] = 9
            digit_sum -= 9

        else:

            result[i] = digit_sum
            digit_sum = 0

    result[0] = digit_sum + 1

    n, power = 0, 1

    for i in reversed(range(n_digits)):

        n += power * result[i]

        power *= 10

    return n

def main():

    print(get_smallest_num(10, 3))

if __name__ == '__main__':
    main()
