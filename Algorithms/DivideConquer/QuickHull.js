"use strict";

let getLineDist = (a, b, x) => {
    return (x.y - a.y) * (b.x - a.x) - (b.y - a.y) * (x.x - a.x);
}

let findHull = (points, hull, a, b, side) => {

    let maxIndex = -1,
        maxDist = 0;

    for (let [index, point] of points.entries()) {

        let dist = getLineDist(a, b, point);

        let curDist = Math.abs(dist);
        let curSide = Math.sign(dist);

        if (curSide == side && curDist > maxDist) {

            maxIndex = index;
            maxDist = curDist;

        }

    }

    if (maxIndex == -1) {

        hull.add(a);
        hull.add(b);

    } else {

        findHull(points, hull, points[maxIndex], a, -Math.sign(getLineDist(points[maxIndex], a, b)));
        findHull(points, hull, points[maxIndex], b, -Math.sign(getLineDist(points[maxIndex], b, a)));

    }

}

let getHull = (points) => {

    let hull = new Set();

    let minX = 0,
        maxX = 0;

    for (let [index, point] of points.entries()) {

        if (point.x < points[minX].x) {
            minX = index;
        }

        if (point.x > points[maxX].x) {
            maxX = index;
        }

    }

    findHull(points, hull, points[minX], points[maxX], 1);
    findHull(points, hull, points[minX], points[maxX], -1);

    return hull;

}

let points = [
  {x: 0, y: 3},
  {x: 1, y: 1},
  {x: 2, y: 2},
  {x: 4, y: 4},
  {x: 0, y: 0},
  {x: 1, y: 2},
  {x: 3, y: 1},
  {x: 3, y: 3}
]

for(let p of getHull(points)) {
  console.log(p);
}
