
from heapq import heappush, heappop
import math

def _insertion_sort(nums, left_index, right_index):

    for i in range(left_index + 1, right_index + 1):

        n, j = nums[i], i - 1

        while j >= left_index and nums[j] > n:

            nums[j + 1] = nums[j]

            j -= 1

        nums[j + 1] = n

def _heap_sort(nums, left_index, right_index):

    heap = []

    for i in range(left_index, right_index + 1):

        heappush(heap, nums[i])

    for i in range(left_index, right_index + 1):

        nums[i] = heappop(heap)

def _median(a, b, c):

    return a + b + c - min(a, b, c) - max(a, b, c)

def _partition(nums, left_index, right_index):

    pivot = nums[right_index]
    i = left_index - 1

    for j in range(left_index, right_index):

        if nums[j] <= pivot:

            i += 1

            nums[i], nums[j] = nums[j], nums[i]

    nums[i + 1], nums[right_index] = nums[right_index], nums[i + 1]

    return i + 1

def intro_util(nums, left_index, right_index, depth_limit):

    size = right_index - left_index

    if size < 16:

        _insertion_sort(nums, left_index, right_index)

    elif depth_limit == 0:

        _heap_sort(nums, left_index, right_index)

    else:

        pivot = _median(left_index, left_index + size // 2, right_index)

        nums[pivot], nums[right_index] = nums[right_index], nums[pivot]

        index = _partition(nums, left_index, right_index)

        intro_util(nums, left_index, index - 1, depth_limit - 1)
        intro_util(nums, index + 1, right_index, depth_limit - 1)

def intro_sort(nums):

    left_index, right_index = 0, len(nums) - 1

    depth_limit = int(2 * math.log(right_index - left_index))

    intro_util(nums, left_index, right_index, depth_limit)

def main():

    nums = [3, 23, 44, 143, 0, 4, 68, 9, 1, 59, 31, 32, 33, 34, 35, 9, 21, 22, 5]

    print(nums)
    intro_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
