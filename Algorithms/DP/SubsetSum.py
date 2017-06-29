
def contains_sum_subset(nums, sum_, index=None):

    if index == None:
        return contains_sum_subset(nums, sum_, len(nums) - 1)

    elif sum_ == 0:
        return True

    elif index < 0 and sum_ != 0:
        return False

    elif nums[index] > sum_:
        return contains_sum_subset(nums, sum_, index - 1)

    else:
        return (contains_sum_subset(nums, sum_, index - 1) or
                contains_sum_subset(nums, sum_ - nums[index], index - 1))

def contains_sum_subset2(nums, sum_):

    db = [ [ (row == 0) for _ in range(len(nums) + 1) ] for row in range(sum_ + 1) ]

    for i in range(sum_ + 1):

        for j in range(1, len(nums) + 1):

            db[i][j] = db[i][j - 1]

            if not db[i][j] and i >= nums[j - 1]:

                db[i][j] = db[i - nums[j - 1]][j - 1]

    return db[-1][-1]

def main():

    nums = [2, 5, 4, 10]

    print(contains_sum_subset(nums, 19))
    print("------")
    print(contains_sum_subset2(nums, 19))

if __name__ == '__main__':
    main()
