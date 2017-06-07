
def binary_search(nums, x):

    bottom, top = 0, len(nums) - 1

    while bottom <= top:

        middle = (top + bottom) // 2

        if nums[middle] == x:
            return middle

        elif nums[middle] < x:
            bottom = middle + 1

        else:
            top = middle - 1

    return -1

def binary_search2(nums, x, bottom=None, top=None):

    if bottom == None or top == None:
        return binary_search2(nums, x, 0, len(nums) - 1)

    elif top >= bottom:

        middle = (top + bottom) // 2

        if nums[middle] == x:
            return middle

        elif nums[middle] < x:
            return binary_search2(nums, x, middle + 1, top)

        return binary_search2(nums, x, bottom, middle - 1)

    return -1

nums = sorted([3, 5, 657, 23, 5, 9, 2, 54, 22, 10, 14, 20, 42, 32, 15, 11])
print(binary_search(nums, 10))
print("------")
print(binary_search2(nums, 10))
