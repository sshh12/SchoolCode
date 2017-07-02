
best_overall = 1

def get_length_LIS(nums, index=None):

    global best_overall

    if index == None:

        best_overall = 1

        get_length_LIS(nums, len(nums) - 1)

        return best_overall

    elif index == 0:

        return 1

    else:

        best = 1

        for i in range(index):

            sub_length = get_length_LIS(nums, i)

            if nums[i] < nums[index] and sub_length + 1 > best:

                best = sub_length + 1

        best_overall = max(best_overall, best)

        return best

def get_length_LIS2(nums):

    n = len(nums)

    db = [ 1 ] * n

    for i in range(n):

        for j in range(i):

            if nums[i] > nums[j] and db[j] + 1 > db[i]:

                db[i] = db[j] + 1

    return max(db)


def main():

    nums = [10, 22, 9, 33, 21, 50, 41, 60]

    print(get_length_LIS(nums))
    print("------")
    print(get_length_LIS2(nums))

if __name__ == '__main__':
    main()
