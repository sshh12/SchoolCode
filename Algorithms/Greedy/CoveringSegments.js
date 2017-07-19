"use strict";

class Segment {

    constructor(s, e) {

        this.startPos = s;
        this.endPos = e;

    }

}

let getOptimalPoints = (segments) => {

    segments.sort((a, b) => a.endPos - b.endPos);

    let current = segments[0].endPos;

    let points = [current];

    for (let i = 0; i < segments.length; i++) {

        if (current < segments[i].startPos || current > segments[i].endPos) {

            current = segments[i].endPos;

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
