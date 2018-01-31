
offsets = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4]

def get_day_of_week(year, month, day):

    if month < 3:
        year -= 1

    return (year + year // 4 - year // 100 + year // 400 + offsets[month - 1] + day) % 7

def main():

    print(get_day_of_week(2000, 1, 1))

if __name__ == '__main__':
    main()
