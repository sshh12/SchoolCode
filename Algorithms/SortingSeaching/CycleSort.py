
def cycle_sort(nums):

    n = len(nums)

    for cycle_index in range(n - 1):

        item, index = nums[cycle_index], cycle_index

        for i in range(cycle_index + 1, n):

            if nums[i] < item:

                index += 1

        if index == cycle_index:

            continue

        while item == nums[index]:

            index += 1

        nums[index], item = item, nums[index]

        while index != cycle_index:

            index = cycle_index

            for i in range(cycle_index + 1, n):

                if nums[i] < item:

                    index += 1

            while item == nums[index]:

                index += 1

            nums[index], item = item, nums[index]

def main():

    nums = [3, 654, 3, 33, 10, 8, 2, 99, 101, 94, 60]

    print(nums)
    cycle_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
