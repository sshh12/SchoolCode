class Job(object):

    def __init__(self, n, d, p):
        self.name = n
        self.deadline = d
        self.profit = p

    def __repr__(self):
        return self.name

def print_best_order(jobs):

    jobs.sort(key=lambda j: j.profit, reverse=True)

    n = len(jobs)

    results = [0 for _ in range(n)]
    times = [False for _ in range(n)]

    for i in range(n):

        for j in reversed(range( min(n, jobs[i].deadline) )):

            if not times[j]:

                results[j] = i
                times[j] = True
                break

    for i in range(n):
        if times[i]:
            print(jobs[results[i]])


def main():

    jobs = [
        Job("A", 6, 100),
        Job("B", 2, 100),
        Job("C", 1, 5),
        Job("D", 1, 25),
        Job("E", 3, 90),
        Job("F", 2, 70)
    ]

    print_best_order(jobs)

if __name__ == '__main__':
    main()
