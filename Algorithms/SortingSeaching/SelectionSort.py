
def selection_sort(nums):

    for i in range(len(nums)):

        min_index = i

        for j in range(i, len(nums)):

            if nums[j] < nums[min_index]:

                min_index = j

        nums[i], nums[min_index] = nums[min_index], nums[i]

def main():

    nums = [12, 45, 1, 76, 23, 25, 33, 99, 65, 46]

    print(nums)
    selection_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
