#include<iostream>
#include<list>
#include<array>


// template<typename E>
// class BinaryTreeDataStructure {
//   public:
//     virtual void add(E item);
//     virtual void remove(E item);
//     virtual bool contains(E item);
//     virtual std::list<E>* getPreOrder();
//     virtual std::list<E>* getInOrder();
//     virtual std::list<E>* getPostOrder();
// };


template<typename E>
class Node {
  public:
    Node(E val) {
      data = val;
    }
    E data;
    Node<E>* left = 0;
    Node<E>* right = 0;
};


template<typename E>
class BinaryTree1 {

  public:

    void add(E item) {
      if(!root) {
        root = new Node<E>(item);
      } else {
        add(root, item);
      }
    }

    void remove(E item) {
      root = remove(root, item);
    }

    bool contains(E item) const {
      return contains(root, item);
    }

    std::list<E> getPreOrder() const {
      std::list<E> items;
      getPreOrder(root, items);
      return items;
    }

    std::list<E> getInOrder() const {
      std::list<E> items;
      getInOrder(root, items);
      return items;
    }

    std::list<E> getPostOrder() const {
      std::list<E> items;
      getPostOrder(root, items);
      return items;
    }

  private:

    void add(Node<E>* node, E item) {
      if(item < node->data) {
        if(node->left) {
          add(node->left, item);
        } else {
          node->left = new Node<E>(item);
        }
      } else {
        if(node->right) {
          add(node->right, item);
        } else {
          node->right = new Node<E>(item);
        }
      }
    }

    Node<E>* minNode(Node<E>* node) const {
      while(node->left) {
        node = node->left;
      }
      return node;
    }

    Node<E>* remove(Node<E>* node, E item) {
      if(node) {
        if(item < node->data) {
          node->left = remove(node->left, item);
        } else if(item > node->data) {
          node->right = remove(node->right, item);
        } else {
          if(!node->left) {
            Node<E>* newNode = node->right;
            delete node;
            return newNode;
          } else if(!node->right) {
            Node<E>* newNode = node->left;
            delete node;
            return newNode;
          } else {
            Node<E>* min_node = minNode(node->right);
            node->data = min_node->data;
            node->right = remove(node->right, min_node->data);
            delete min_node;
          }
        }
      }
      return node;
    }

    bool contains(Node<E>* node, E item) const {
      if(!node) {
        return false;
      } else if(item == node->data) {
        return true;
      } else if(item < node->data) {
        return contains(node->left, item);
      } else {
        return contains(node->right, item);
      }
    }

    void getPreOrder(Node<E>* node, std::list<E>& items) const {
      if(!node) {
        return;
      }
      items.push_back(node->data);
      getPreOrder(node->left, items);
      getPreOrder(node->right, items);
    }

    void getInOrder(Node<E>* node, std::list<E>& items) const {
      if(!node) {
        return;
      }
      getInOrder(node->left, items);
      items.push_back(node->data);
      getInOrder(node->right, items);
    }

    void getPostOrder(Node<E>* node, std::list<E>& items) const {
      if(!node) {
        return;
      }
      getPostOrder(node->left, items);
      getPostOrder(node->right, items);
      items.push_back(node->data);
    }

  protected:
    Node<E>* root = 0;
};


template<typename E>
void print_list(std::list<E> items) {
  if(items.size() == 0) {
    std::cout << "[]" << std::endl;
  } else {
    std::cout << "[ ";
    for(auto it = items.begin(); it != items.end(); it++) {
      std::cout << (int)(*it) << ' ';
    }
    std::cout << "]" << std::endl;
  }
}


int main() {

  std::array<BinaryTree1<int>*, 1> binTreeClasses {
    new BinaryTree1<int>()
  };

  for(int i = 0; i < binTreeClasses.size(); i++) {
    BinaryTree1<int> binTree = *binTreeClasses[i];
    binTree.add(1);
    binTree.add(0);
    binTree.add(2);
    std::cout << binTree.contains(2) << std::endl;
    print_list(binTree.getInOrder());
    print_list(binTree.getPreOrder());
    print_list(binTree.getPostOrder());
    binTree.remove(2);
    binTree.add(3);
    binTree.add(-1);
    binTree.add(-3);
    binTree.add(-2);
    std::cout << binTree.contains(1) << std::endl;
    print_list(binTree.getInOrder());
    std::cout << "------" << std::endl;
  }

  return 0;

}
