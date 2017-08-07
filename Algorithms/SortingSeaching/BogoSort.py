
from random import shuffle

def _is_sorted(nums):

    return all([ nums[i - 1] <= nums[i] for i in range(1, len(nums)) ])

def bogo_sort(nums):

    while not _is_sorted(nums):

        shuffle(nums)

def main():

    nums = [7, 3, 1, 10, 5, 2, 9, 4, 6, 8]

    print(nums)
    bogo_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
