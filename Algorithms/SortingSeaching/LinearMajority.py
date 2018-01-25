
def get_majority(votes):

    most_vote, counter = -1, 0

    for vote in votes:

        if most_vote == -1 or counter == 0:
            most_vote = vote
            counter = 1

        elif most_vote == vote:
            counter += 1

        else:
            counter -= 1

    return (most_vote if counter > 0 else None)


def main():

    votes = [0, 1, 0, 1, 2, 1, 1]

    print(get_majority(votes))

if __name__ == "__main__":
    main()
