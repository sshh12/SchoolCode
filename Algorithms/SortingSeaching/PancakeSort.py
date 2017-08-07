
def _flip(nums, end_index):

    nums[:end_index+1] = nums[end_index::-1]

def _max_index(nums, endIndex):

    return nums.index(max(nums[:endIndex]))

def pancake_sort(nums):

    for size in reversed(range(2, len(nums) + 1)):

        max_index = _max_index(nums, size)

        if max_index != size - 1:

            _flip(nums, max_index)
            _flip(nums, size - 1)

def main():

    nums = [12, 3, 33, 1, 88, 100, 50, 40, 60, 25, 2, 4, 6, 22]

    print(nums)
    pancake_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
