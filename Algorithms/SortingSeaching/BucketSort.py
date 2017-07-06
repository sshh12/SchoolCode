
def bucket_sort(nums, num_buckets=4):

    buckets = [ [] for _ in range(num_buckets) ]

    mx = max(nums) + 1

    for n in nums:

        index = int(n / mx * num_buckets)

        buckets[index].append(n)

    for bucket in buckets:

        bucket.sort()

    index = 0

    for bucket in buckets:

        for num in bucket:

            nums[index] = num

            index += 1

def main():

    nums = [12, 32, 43, 11, 58, 60, 68, 90, 80, 99, 22]

    print(nums)
    bucket_sort(nums)
    print(nums)

if __name__ == '__main__':
    main()
