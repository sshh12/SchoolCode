#include<iostream>
#include<vector>
#include<cstring>


int getEditDistance(std::vector<std::string> a, std::vector<std::string> b, int indexA, int indexB) {
  if(indexA == 0) {
    return indexB;
  } else if(indexB == 0) {
    return indexA;
  } else if(a[indexA] == b[indexB]) {
    return getEditDistance(a, b, indexA - 1, indexB - 1);
  } else {
    return 1 + std::min(std::min(getEditDistance(a, b, indexA - 1, indexB),
                                 getEditDistance(a, b, indexA, indexB - 1)),
                                 getEditDistance(a, b, indexA - 1, indexB - 1));
  }
}


int getEditDistance2(std::vector<std::string> a, std::vector<std::string> b) {

  int alen = a.size();
  int blen = b.size();

  int db[alen + 1][blen + 1];
  memset(db, 0, sizeof(int) * (alen + 1) * (blen + 1));

  for(int i = 0; i <= alen; i++) {
    for(int j = 0; j <= blen; j++) {
      if(i == 0) {
        db[i][j] = j;
      } else if(j == 0) {
        db[i][j] = i;
      } else if(a[i - 1] == b[j - 1]) {
        db[i][j] = db[i - 1][j - 1];
      } else {
        db[i][j] =  1 + std::min(std::min(db[i - 1][j],
                                          db[i][j - 1]),
                                          db[i - 1][j - 1]);
      }
    }
  }

  return db[alen][blen];

}


int main() {

  std::vector<std::string> a {"i", "like", "pie"};
  std::vector<std::string> b {"he", "like", "much", "potato"};

  std::cout << getEditDistance(a, b, a.size(), b.size()) << std::endl;
  std::cout << "------\n";
  std::cout << getEditDistance2(a, b) << std::endl;

}
