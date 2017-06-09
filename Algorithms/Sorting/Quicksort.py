
def partition(nums, low, high):

    pivot = nums[high]
    i = low - 1

    for j in range(low, high):

        if nums[j] <= pivot:

            i += 1

            nums[i], nums[j] = nums[j], nums[i]

    nums[i + 1], nums[high] = nums[high], nums[i + 1]

    return i + 1

def quick_sort(nums, low=None, high=None):

    if low == None or high == None:

        quick_sort(nums, 0, len(nums) - 1)

    elif low < high:

        index = partition(nums, low, high)

        quick_sort(nums, low, index - 1)
        quick_sort(nums, index + 1, high)

def main():

    nums = [1, 5, 2, 6, 10, 25, 15, 12, 8]

    print(nums)
    quick_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
