from heapq import heappush, heappop
from collections import Counter

class Node(object):

    def __init__(self, value):

        self.value = value
        self.left = None
        self.right = None

    def __eq__(self, other): # Ignore Heap comparisons past freq

        return True

def _add_codes(node, codes, prefix=""):

    if node:

        if node.value != '*':

            codes.update({node.value: prefix})

        _add_codes(node.left, codes, prefix + "0")
        _add_codes(node.right, codes, prefix + "1")

def get_huffman_codes(msg):

    freqs = Counter(msg)

    heap = []

    for char, freq in freqs.items():

        heappush(heap, (freq, Node(char)))

    while len(heap) > 1:

        left, right = heappop(heap), heappop(heap)

        combined = Node('*')

        combined.left = left[1]
        combined.right = right[1]

        heappush(heap, (left[0] + right[0], combined))

    codes = {}

    _add_codes(heap[0][1], codes)

    return codes


def encode(msg, codes):

    compressed = ""

    for c in msg:

        compressed += codes[c]

    return compressed

def main():

    msg = "This is a test of huffman encoding............"

    print(msg)

    codes = get_huffman_codes(msg)

    for char, code in codes.items():

        print(f'{char} {code}')

    print(encode(msg, codes))

if __name__ == '__main__':
    main()
