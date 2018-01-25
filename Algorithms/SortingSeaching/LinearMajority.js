"use strict";

let getMajority = (votes) => {

    let mostVote = null,
        counter = 0;

    for (let vote of votes) {

        if (mostVote == -1 || counter == 0) {

            mostVote = vote;
            counter = 1;

        } else if (mostVote == vote) {

            counter--;

        } else {

            counter--;

        }

    }

    return counter > 0 ? mostVote : null;

}

let votes = [0, 1, 0, 1, 2, 1, 1];

console.log(getMajority(votes));
