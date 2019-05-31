#include <iostream>
#include <queue>
#include <array>


template<typename E, std::size_t SIZE>
void print_array(std::array<E, SIZE> nums) {
  for(int i(0); i < SIZE; i++) {
    std::cout << nums[i] << " ";
  }
  std::cout << std::endl;
}


template<typename E, size_t SIZE>
void heapSort(std::array<E, SIZE>& nums) {

  std::priority_queue<E, std::vector<E>, std::greater<E>> pq;

  for(int i = 0; i < SIZE; i++) {
    pq.push(nums[i]);
  }

  for(int i = 0; i < SIZE; i++) {
    nums[i] = pq.top();
    pq.pop();
  }

}


int main() {

  std::array<int, 11> nums {24, 43, 1, 33, 3, 41, 99, 102, 6, 78, 8};

  print_array(nums);
  heapSort(nums);
  print_array(nums);

}
