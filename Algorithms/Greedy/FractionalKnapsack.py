
class Item(object):

    def __init__(self, v, w):
        self.value = v
        self.weight = w

    @property
    def ratio(self):
        return self.value / float(self.weight)

def get_max_value(items, max_weight):

    items.sort(key=lambda item: item.ratio, reverse=True)

    current_weight, current_value = 0, 0.0

    for item in items:

        if current_weight + item.weight <= max_weight:

            current_weight += item.weight
            current_value += item.value

        else:

            remaining = max_weight - current_weight

            current_value += remaining * item.ratio

            break

    return current_value

def main():

    items = [
        Item(60, 10),
        Item(100, 20),
        Item(20, 50),
        Item(120, 30),
        Item(10, 2)
    ]

    print(get_max_value(items, 75))

if __name__ == '__main__':
    main()
