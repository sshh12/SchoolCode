
def _find_index(nums, value, left_index, right_index):

    if right_index <= left_index:

        return left_index + 1 if value > nums[left_index] else left_index

    middle_index = (left_index + right_index) // 2

    if value == nums[middle_index]:

        return middle_index + 1

    elif value > nums[middle_index]:

        return _find_index(nums, value, middle_index + 1, right_index)

    else:

        return _find_index(nums, value, left_index, middle_index - 1)

def binary_insertion_sort(nums):

    for i in range(1, len(nums)):

        n, j = nums[i], i - 1

        correct_index = _find_index(nums, n, 0, j)

        while j >= correct_index:

            nums[j + 1] = nums[j]

            j -= 1

        nums[j + 1] = n

def main():

    nums = [1, 2, 0, 8, 22, 189, 221, 10, 88, 67, 45, 34]

    print(nums)
    binary_insertion_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
