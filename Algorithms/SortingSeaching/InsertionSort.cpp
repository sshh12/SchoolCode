#include <iostream>
#include <array>

template<typename E, std::size_t SIZE>
void print_array(std::array<E, SIZE> nums) {
  for(int i(0); i < SIZE; i++) {
    std::cout << nums[i] << " ";
  }
  std::cout << std::endl;
}

template<typename E, std::size_t SIZE>
void insertion_sort(std::array<E, SIZE>& nums) {

  int n, j;

  for(int i(1); i < SIZE; i++) {
    n = nums[i];
    j = i - 1;
    while(j >= 0 && nums[j] > n) {
      nums[j + 1] = nums[j];
      j--;
    }
    nums[j + 1] = n;
  }

}

int main() {

  std::array<int, 10> nums {12, 45, 1, 76, 23, 25, 33, 99, 65, 46};

  print_array(nums);
  insertion_sort(nums);
  print_array(nums);

  return 0;

}
