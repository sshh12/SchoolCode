"use strict";

class Job {

    constructor(n, d, p) {

        this.name = n;
        this.deadline = d;
        this.profit = p;

    }

    toString() {

        return this.name;

    }

}

let printBestOrder = (jobs) => {

    jobs.sort((a, b) => b.profit - a.profit);

    let n = jobs.length;

    let results = new Array(n),
        times = new Array(n);

    for (let i in jobs) {

        for (let j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {

            if (!times[j]) {

                results[j] = i;
                times[j] = true;

                break;

            }

        }

    }

    for (let i in jobs) {

        if (times[i]) {

            console.log(jobs[results[i]].toString());

        }

    }

}

let jobs = [
    new Job("A", 6, 100),
    new Job("B", 2, 100),
    new Job("C", 1, 5),
    new Job("D", 1, 25),
    new Job("E", 3, 90),
    new Job("F", 2, 70)
];

printBestOrder(jobs);
