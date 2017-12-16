
def _merge(nums, left_index, middle_index, right_index):

    inversions = 0

    left_size = middle_index - left_index + 1
    right_size = right_index - middle_index

    left_elements = nums[left_index:left_index + left_size]
    right_elements = nums[middle_index + 1:middle_index + right_size + 1]

    left, right, index = 0, 0, left_index

    while left < left_size and right < right_size:

        if left_elements[left] <= right_elements[right]:

            nums[index] = left_elements[left]
            left += 1

        else:

            nums[index] = right_elements[right]
            right += 1

            inversions += (left_size - left)

        index += 1

    while left < left_size:

        nums[index] = left_elements[left]

        index += 1; left += 1

    while right < right_size:

        nums[index] = right_elements[right]

        index += 1; right += 1

    return inversions

def get_num_inversions(nums, left_index=None, right_index=None):

    count = 0

    if left_index == None or right_index == None:

        return get_num_inversions(nums, 0, len(nums) - 1)

    elif left_index < right_index:

        middle_index = (left_index + right_index) // 2

        count += get_num_inversions(nums, left_index, middle_index)
        count += get_num_inversions(nums, middle_index + 1, right_index)

        count += _merge(nums, left_index, middle_index, right_index)

    return count

def main():

    nums = [3, 15, 61, 11, 7, 9, 2]

    print(get_num_inversions(nums))

if __name__ == '__main__':
    main()
