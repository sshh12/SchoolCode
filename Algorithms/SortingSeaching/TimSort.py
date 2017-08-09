
RUN = 4

def _insertion_sort(nums, left_index, rightIndex):

    for i in range(left_index + 1, rightIndex + 1):

        n, j = nums[i], i - 1

        while j >= left_index and nums[j] > n:

            nums[j + 1] = nums[j]

            j -= 1

        nums[j + 1] = n

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

def tim_sort(nums):

    n = len(nums)

    for i in range(0, n, RUN):

        _insertion_sort(nums, i, min(i + RUN - 1, n - 1))

    size = RUN

    while size < n:

        for left_index in range(0, n, 2 * size):

            right_index = min(left_index + 2 * size - 1, n - 1)
            middle_index = min(left_index + size - 1, right_index)

            _merge(nums, left_index, middle_index, right_index)

        size *= 2

def main():

    nums = [1, 3, 88, 12, 3432, 32, 10, 5, 99, 111, 85, 939, 4, 0, 8, 101]

    print(nums)
    tim_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
