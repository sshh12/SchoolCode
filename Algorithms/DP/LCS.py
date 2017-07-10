
def get_length_LCS(a, b, index_a=None, index_b=None):

    if index_a == None or index_b == None:

        return get_length_LCS(a, b, len(a) - 1, len(b) - 1)

    elif index_a < 0 or index_b < 0:

        return 0

    elif a[index_a] == b[index_b]:

        return 1 + get_length_LCS(a, b, index_a - 1, index_b - 1)

    else:

        return max(get_length_LCS(a, b, index_a - 1, index_b),
                   get_length_LCS(a, b, index_a, index_b - 1))

def get_length_LCS2(a, b):

    alen, blen = len(a), len(b)

    db = [ [ 0 for _ in range(blen + 1) ] for _ in range(alen + 1) ]

    for i in range(alen + 1):

        for j in range(blen + 1):

            if i == 0 or j == 0:

                db[i][j] = 0

            elif a[i - 1] == b[j - 1]:

                db[i][j] = 1 + db[i - 1][j - 1]

            else:

                db[i][j] = max(db[i - 1][j], db[i][j - 1])

    return db[-1][-1]

def main():

    a, b = "ilikepie", "helikepotato"

    print(get_length_LCS(a, b))
    print("------")
    print(get_length_LCS2(a, b))

if __name__ == '__main__':
    main()
