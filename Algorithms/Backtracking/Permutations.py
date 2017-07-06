
from itertools import permutations


def print_permutations(string):

    for perm in permutations(string):

        print("".join(perm))

def main():

    print_permutations("asdf")

if __name__ == '__main__':
    main()
