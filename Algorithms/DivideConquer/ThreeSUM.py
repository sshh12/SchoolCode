
def get_triplet_sum_zero(nums):

    triplets = []

    nums.sort()

    for i in range(len(nums) - 3):

        a, start, end = nums[i], i + 1, len(nums) - 1

        while start < end:

            b, c = nums[start], nums[end]

            if a + b + c >= 0:

                if a + b + c == 0:

                    triplets.append((a, b, c))

                end -= 1

            else:

                start += 1

    return triplets

def main():

    nums = [-25, -10, -7, -3, 2, 4, 8, 10]

    for triplet in get_triplet_sum_zero(nums):

        print(triplet)

if __name__ == '__main__':
    main()
