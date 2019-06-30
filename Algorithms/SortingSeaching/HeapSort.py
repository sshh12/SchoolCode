
from heapq import heappush, heappop


def heap_sort(nums):

    heap = []

    for n in nums:
        heappush(heap, n)

    for i, _ in enumerate(nums):
        nums[i] = heappop(heap)


def main():

    nums = [24, 43, 1, 33, 3, 41, 99, 102, 6, 78, 8]

    print(nums)
    heap_sort(nums)
    print(nums)


if __name__ == '__main__':
    main()
