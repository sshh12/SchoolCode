words = open("words.txt", 'r').read().split("\n")

length = int(raw_input("Word Length? "))
guesses = int(raw_input("Max Guesses? "))


def get_pattern(word, char):
    pat = ""
    for i in range(length):
        if word[i] == char:
            pat += char
        else:
            pat += pattern[i]
    return pat

words = filter(lambda w: len(w) == length and w.isalpha(), words)
guessed = []
pattern = "-" * length

while True:
    print "\n\n\n"
    print "Guessed: ", ", ".join(guessed)
    print "Guesses Left: ", guesses
    print "Current: ", pattern

    g = raw_input("Guess? ")[0]
    if g not in guessed and g.isalpha():

        patterns = {}
        for word in words:
            patrn = get_pattern(word, g)
            if patrn not in patterns.keys():
                patterns.update({patrn: [word]})
            else:
                patterns[patrn].append(word)

        most = max(patterns.keys(), key=lambda p: len(patterns[p]))

        words = patterns[most]

        if pattern == most:
            guesses -= 1
        else:
            pattern = most

        guessed.append(g)

        if pattern in words:
            print "You Win!", pattern
            break

        elif guesses < 0:
            print "You Lose!", words[0]
            break
