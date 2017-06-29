
def interpolation_search(nums, x):

    bottom, top = 0, len(nums) - 1

    while bottom <= top and x >= nums[bottom] and x <= nums[top]:

        position = bottom + (top - bottom) // (nums[top] - nums[bottom]) * (x - nums[bottom])

        if nums[position] == x:

            return position

        elif nums[position] < x:

            bottom = position + 1

        else:

            top = position - 1

    return -1

def main():

    nums = [2, 15, 28, 34, 44, 51, 67, 79, 87, 93, 105]

    print(nums)
    print(interpolation_search(nums, 15))

if __name__ == '__main__':
    main()
