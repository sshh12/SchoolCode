
def shell_sort(nums):

    gap = len(nums) // 2

    while gap > 0:

        for i in range(gap, len(nums)):

            j, temp = i, nums[i]

            while j >= gap and nums[j - gap] > temp:

                nums[j] = nums[j - gap]

                j -= gap

            nums[j] = temp

        gap //= 2

def main():

    nums = [1, 52, 2, 25, 6, 10, 25, 200, 15, 12, 8, 2]

    print(nums)
    shell_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
