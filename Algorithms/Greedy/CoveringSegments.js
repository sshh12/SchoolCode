"use strict";

class Segment {

    constructor(s, e) {

        this.start = s;
        this.end = e;

    }

}

let getOptimalPoints = (segments) => {

    segments.sort((a, b) => a.end - b.end);

    let current = segments[0].end;

    let points = [current];

    for (let i = 0; i < segments.length; i++) {

        if (current < segments[i].start || current > segments[i].end) {

            current = segments[i].end;

            points.push(current);

        }

    }

    return points;

}

let segments = [
    new Segment(4, 7),
    new Segment(1, 3),
    new Segment(2, 5),
    new Segment(5, 6)
];

for (let point of getOptimalPoints(segments)) {

    console.log(point);

}
