
def insertion_sort(nums):

    for i in range(1, len(nums)):

        n, j = nums[i], i - 1

        while j >= 0 and nums[j] > n:

            nums[j + 1] = nums[j]

            j -= 1

        nums[j + 1] = n

def main():

    nums = [12, 45, 1, 76, 23, 25, 33, 99, 65, 46]

    print(nums)
    insertion_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
