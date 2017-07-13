
def _merge(nums, left_index, middle_index, right_index):

    left_size = middle_index - left_index + 1
    right_size = right_index - middle_index

    left_elements = nums[left_index:left_index + left_size]
    right_elements = nums[middle_index + 1:middle_index + right_size + 1]

    left, right, index = 0, 0, left_index

    while left < left_size and right < right_size:

        if left_elements[left] <= right_elements[right]:

            nums[index] = left_elements[left]
            left += 1

        else:

            nums[index] = right_elements[right]
            right += 1

        index += 1

    while left < left_size:

        nums[index] = left_elements[left]

        index += 1; left += 1

    while right < right_size:

        nums[index] = right_elements[right]

        index += 1; right += 1

def merge_sort(nums, left_index=None, right_index=None):

    if left_index == None or right_index == None:

        merge_sort(nums, 0, len(nums) - 1)

    elif left_index < right_index:

        middle_index = (left_index + right_index) // 2

        merge_sort(nums, left_index, middle_index)
        merge_sort(nums, middle_index + 1, right_index)

        _merge(nums, left_index, middle_index, right_index)

def main():

    nums = [1, 32, 33, 5, 99, 23, 12, 4, 100, 26, 24]

    print(nums)
    merge_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
