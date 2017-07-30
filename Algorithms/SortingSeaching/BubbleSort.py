
def bubble_sort(nums):

    n = len(nums)

    for i in range(n - 1):

        for j in range(n - i - 1):

            if nums[j] > nums[j + 1]:

                nums[j], nums[j + 1] = nums[j + 1], nums[j]

def main():

    nums = [1, 43, 12, 3, 4, 99, 65, 66, 32, 8]

    print(nums)
    bubble_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
