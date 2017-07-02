
def get_min_squares(length, width):

    result = 0

    large_side, small_side = max(length, width), min(length, width)

    while small_side > 0:

        result += large_side // small_side

        temp = large_side % small_side

        large_side = small_side
        small_side = temp

    return result

def main():

    print(get_min_squares(13, 29))

if __name__ == '__main__':
    main()
