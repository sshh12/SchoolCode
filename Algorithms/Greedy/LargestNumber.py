
def sort(values, compare):

    for i in range(len(values)):

        min_index = i

        for j in range(i, len(values)):

            if compare(values[j], values[min_index]) < 0:

                min_index = j

        values[i], values[min_index] = values[min_index], values[i]

def get_largest_number(nums):

    values = list(map(str, nums))

    sort(values, lambda a, b: (b + a) > (a + b))

    return int("".join(values))

def main():

    nums = [22, 225, 53, 19, 100]

    print(get_largest_number(nums))

if __name__ == '__main__':
    main()
