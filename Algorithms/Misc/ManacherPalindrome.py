# Based on: https://articles.leetcode.com/longest-palindromic-substring-part-ii/

def _process(s):

    alt_chars = ['$', '#']

    for char in s:
        alt_chars.extend([char, '#'])

    alt_chars += ['@']

    return alt_chars

def _run_manacher(alt_chars):

    palin_table = [0] * len(alt_chars)

    center, right = 0, 0

    for i in range(len(alt_chars) - 1):

        opposite = center * 2 - i

        if right > i:
            palin_table[i] = min(right - i, palin_table[opposite])

        while alt_chars[i + (1 + palin_table[i])] == alt_chars[i - (1 + palin_table[i])]:
            palin_table[i] += 1

        if i + palin_table[i] > right:
            center, right = i, i + palin_table[i]

    return palin_table

def longest_palindrome(s):

    alt_chars = _process(s)
    palin_table = _run_manacher(alt_chars)

    longest, center = 0, 0

    for i in range(len(palin_table) - 1):

        if palin_table[i] > longest:
            longest, center = palin_table[i], i

    return s[(center - 1 - longest) // 2:(center - 1 + longest) // 2]

def main():

    print(longest_palindrome("blahblahblahracecarblah"))

if __name__ == '__main__':
    main()
