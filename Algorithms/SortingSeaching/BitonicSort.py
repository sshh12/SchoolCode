
def _merge(nums, index, length, increasing):

    if length > 1:

        half = length // 2

        for i in range(index, index + half):

            if ((nums[i] > nums[i + half] and increasing) or
                (nums[i] < nums[i + half] and not increasing)):

               nums[i], nums[i + half] = nums[i + half], nums[i]

        _merge(nums, index, half, increasing)
        _merge(nums, index + half, half, increasing)

def bitonic_sort(nums, index=None, length=None, increasing=None):

    if index == None or length == None or increasing == None:

        bitonic_sort(nums, 0, len(nums), True)

    else:

        if length > 1:

            half = length // 2

            bitonic_sort(nums, index, half, True)
            bitonic_sort(nums, index + half, half, False)

            _merge(nums, index, length, increasing)

def main():

    nums = [1, 5, 77, 34, 2, 18, 19, 20, 21, 10, 43, 99, 101, 77, 75, 71] # Must be pow of 2

    print(nums)
    bitonic_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
