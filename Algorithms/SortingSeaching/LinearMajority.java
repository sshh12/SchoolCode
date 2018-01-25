
public class LinearMajority {

    public static Object getMajority(Object[] votes) {

        Object mostVote = null;
        int counter = 0;

        for(Object vote : votes) {

            if(mostVote == null || counter == 0) {

                mostVote = vote;
                counter = 1;

            } else if(mostVote == vote) {

                counter++;

            } else {

                counter--;

            }

        }

        return counter > 0 ? mostVote : null;

    }

    public static void main(String[] args) {

        Object[] nums = new Object[]{0, 1, 0, 1, 2, 1, 1};

        System.out.println(getMajority(nums));

    }

}
