
class Item:

    def __init__(self, v, w):
        self.value = v
        self.weight = w

def get_max_value(capacity, items, n=None):

    if n == None:
        return get_max_value(capacity, items, len(items))

    elif capacity == 0 or n == 0:

        return 0

    elif items[n - 1].weight > capacity:

        return get_max_value(capacity, items, n - 1)

    else:

        return max(items[n - 1].value + get_max_value(capacity - items[n - 1].weight, items, n - 1),
                                        get_max_value(capacity, items, n - 1))

def get_max_value2(capacity, items):

    n = len(items)

    db = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    for i in range(n + 1):

        for weight in range(capacity + 1):

            if i == 0 or weight == 0:

                db[i][weight] = 0

            elif items[i - 1].weight <= weight:

                db[i][weight] = max(items[i - 1].value + db[i - 1][weight - items[i - 1].weight],
                                                         db[i - 1][weight])

            else:

                db[i][weight] = db[i - 1][weight]

    return db[-1][-1]

def main():

    items = [
        Item(60, 10),
        Item(100, 20),
        Item(120, 30)
    ]

    print(get_max_value(50, items))
    print("------")
    print(get_max_value2(50, items))

if __name__ == '__main__':
    main()
