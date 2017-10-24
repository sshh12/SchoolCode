
def get_edit_distance(a, b, index_a=None, index_b=None):

    if index_a == None or index_b == None:

        return get_edit_distance(a, b, len(a), len(b))

    elif index_a == 0:

        return index_b

    elif index_b == 0:

        return index_a

    elif a[index_a - 1] == b[index_b - 1]:

        return get_edit_distance(a, b, index_a - 1, index_b - 1)

    else:

        return 1 + min(get_edit_distance(a, b, index_a - 1, index_b),
                       get_edit_distance(a, b, index_a, index_b - 1),
                       get_edit_distance(a, b, index_a - 1, index_b - 1))

def get_edit_distance2(a, b):

    alen, blen = len(a), len(b)

    db = [ [ 0 for _ in range(blen + 1) ] for _ in range(alen + 1) ]

    for i in range(alen + 1):

        for j in range(blen + 1):

            if i == 0:

                db[i][j] = j

            elif j == 0:

                db[i][j] = i

            elif a[i - 1] == b[j - 1]:

                db[i][j] = db[i - 1][j - 1]

            else:

                db[i][j] = 1 + min(db[i - 1][j],
                                   db[i][j - 1],
                                   db[i - 1][j - 1])

    return db[-1][-1]

def main():

    a = "i like pie".split(" ")
    b = "he like much potato".split(" ")

    print(get_edit_distance(a, b))
    print("------")
    print(get_edit_distance2(a, b))

if __name__ == '__main__':
    main()
