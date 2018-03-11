"use strict";

/*
 * Based on: https://articles.leetcode.com/longest-palindromic-substring-part-ii/
 */

let process = (s) => {

    let altChars = ['$', '#'];

    for (let char of s) {
        altChars.push(char);
        altChars.push('#');
    }

    altChars.push('@');

    return altChars;

}

let runManacher = (altChars) => {

    let palinTable = new Array(altChars.length);
    palinTable.fill(0);

    let center = 0,
        right = 0;

    for (let i = 1; i < altChars.length - 1; i++) {

        let opposite = center * 2 - i;

        if (right > i) {
            palinTable[i] = Math.min(right - i, palinTable[opposite])
        }

        while (altChars[i + (1 + palinTable[i])] == altChars[i - (1 + palinTable[i])]) {
            palinTable[i]++;
        }

        if (1 + palinTable[i] > right) {
            center = i;
            right = i + palinTable[i];
        }

    }

    return palinTable;

}

let longestPalindrome = (s) => {

    let altChars = process(s);
    let palinTable = runManacher(altChars);

    let longest = 0,
        center = 0;

    for (let i = 0; i < palinTable.length - 1; i++) {

        if (palinTable[i] > longest) {
            longest = palinTable[i];
            center = i;
        }

    }

    return s.substring((center - 1 - longest) / 2, (center - 1 + longest) / 2);

}

console.log(longestPalindrome("blahblahblahracecarblah"));
