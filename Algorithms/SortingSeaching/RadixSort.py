def _sort_count(nums, mask):

    counts = [ 0 for _ in range(10) ]
    out = [ 0 for _ in nums ]

    for n in nums:
        counts[(n // mask) % 10] += 1

    for i in range(1, 10):
        counts[i] += counts[i - 1]

    for n in reversed(nums):
        out[counts[(n // mask) % 10] - 1] = n
        counts[(n // mask) % 10] -= 1

    nums[:] = out

def radix_sort(nums):

    m = max(nums)

    mask = 1

    while m / mask > 0:

        _sort_count(nums, mask)

        mask *= 10

def main():

    nums = [1, 52, 2, 25, 6, 10, 25, 200, 15, 12, 8, 2]

    print(nums)
    radix_sort(nums)
    print(nums)


if __name__ == '__main__':
    main()
