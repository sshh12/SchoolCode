
from functools import cmp_to_key

def get_largest_number(nums):

    values = list(map(str, nums))

    values.sort(key=cmp_to_key( lambda a, b: 1 if (b + a) > (a + b) else -1 ))

    return int("".join(values))

def main():

    nums = [22, 225, 53, 19, 100]

    print(get_largest_number(nums))

if __name__ == '__main__':
    main()
