
def get_max_dot_product(a, b):

    a.sort()
    b.sort()

    return sum( [ a[i] * b[i] for i in range(len(a)) ] )

def main():

    a = [1, 3, -5]

    b = [-2, 4, 1]

    print(get_max_dot_product(a, b))

if __name__ == '__main__':
    main()
