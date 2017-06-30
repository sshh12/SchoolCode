
def count_subset_sums(nums, sum_, index=None):

    if index == None:
        return count_subset_sums(nums, sum_, len(nums) - 1)

    elif sum_ == 0:
        return 1

    elif index < 0 and sum_ != 0:
        return 0

    elif nums[index] > sum_:
        return count_subset_sums(nums, sum_, index - 1)

    else:
        return (count_subset_sums(nums, sum_, index - 1) +
                count_subset_sums(nums, sum_ - nums[index], index - 1))

def count_subset_sums2(nums, sum_):

    db = [ 1 ] + [ 0 ] * sum_

    for n in nums:

        for i in reversed(range(sum_ - n + 1)):

            if db[i]:

                db[i + n] += db[i]

    return db[-1]

def main():

    nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    print(count_subset_sums(nums, 17))
    print("------")
    print(count_subset_sums2(nums, 17))

if __name__ == '__main__':
    main()
