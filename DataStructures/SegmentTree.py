import math

class SegmentTree1(object):

    def __init__(self, nums):

        self.nums = nums

        levels = math.ceil( math.log(len(nums)) / math.log(2) )
        max_size = 2 * int(2 ** levels) - 1

        self.tree = [ None ] * max_size

        self._construct(0, len(nums) - 1, 0)

    def _get_middle_index(self, start_index, end_index):

        return start_index + (end_index - start_index) // 2

    def _construct(self, start_index, end_index, cur_index):

        if start_index == end_index:

            self.tree[cur_index] = self.nums[start_index]

            return self.nums[start_index]

        middle_index = self._get_middle_index(start_index, end_index)

        self.tree[cur_index] = (self._construct(start_index, middle_index, cur_index * 2 + 1) +
                                self._construct(middle_index + 1, end_index, cur_index * 2 + 2))

        return self.tree[cur_index]

    def sum(self, range_start, range_end, start_index=-1, end_index=-1, cur_index=-1):

        if start_index < 0 or end_index < 0 or cur_index < 0:

            return self.sum(range_start, range_end, 0, len(self.nums) - 1, 0)

        elif range_start <= start_index and range_end >= end_index:

            return self.tree[cur_index]

        elif end_index < range_start or start_index > range_end:

            return 0

        else:

            middle_index = self._get_middle_index(start_index, end_index)

            return (self.sum(range_start, range_end, start_index, middle_index, cur_index * 2 + 1) +
                    self.sum(range_start, range_end, middle_index + 1, end_index, cur_index * 2 + 2))

    def __getitem__(self, index):

        return self.nums[index]

    def __setitem__(self, index, value, start_index=-1, end_index=-1, cur_index=-1, diff=None):

        if value:

            diff = value - self.nums[index]

            self.nums[index] = value

            self.__setitem__(index, None, 0, len(self.nums) - 1, 0, diff)

        elif start_index <= index <= end_index:

            self.tree[cur_index] += diff

            if start_index != end_index:

                middle_index = self._get_middle_index(start_index, end_index)

                self.__setitem__(index, None, start_index, middle_index, cur_index * 2 + 1, diff)
                self.__setitem__(index, None, middle_index + 1, end_index, cur_index * 2 + 2, diff)

def main():

    nums = [1, 2, 4, 6, 10, 20, 22]

    for segtree_class in [SegmentTree1]:

        segtree = segtree_class(nums)

        print(segtree.sum(2, 5))

        segtree[3] = 10

        print(segtree.sum(2, 5))

        print("------")

if __name__ == '__main__':
    main()
