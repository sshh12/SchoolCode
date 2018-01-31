"use strict";

let offsets = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4];

let getDayOfWeek = (year, month, day) => {

  if(month < 3) {
    year--;
  }

  return (year + Math.floor(year / 4) - Math.floor(year / 100) + Math.floor(year / 400) + offsets[month - 1] + day) % 7;

}

console.log(getDayOfWeek(2000, 1, 1))
