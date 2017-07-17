"use strict";

let printPermutations = (chars, index = 0) => {

    if (index == chars.length - 1) {

        console.log(chars.join(""));

    } else {

        for (let i = index; i < chars.length; i++) {

            [chars[index], chars[i]] = [chars[i], chars[index]];

            printPermutations(chars, index + 1);

            [chars[index], chars[i]] = [chars[i], chars[index]];

        }

    }

}

printPermutations("asdf".split(''));
