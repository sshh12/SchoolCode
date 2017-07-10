
public class LCS {

    public static int getLengthLCS(String a, String b, int indexA, int indexB) {

        if (indexA < 0 || indexB < 0) {

            return 0;

        } else if (a.charAt(indexA) == b.charAt(indexB)) {

            return 1 + getLengthLCS(a, b, indexA - 1, indexB - 1);

        } else {

            return Math.max(
                    getLengthLCS(a, b, indexA - 1, indexB),
                    getLengthLCS(a, b, indexA, indexB - 1));

        }

    }

    public static int getLengthLCS2(String a, String b) {

        int alen = a.length(), blen = b.length();

        int db[][] = new int[alen + 1][blen + 1];

        for (int i = 0; i <= alen; i++) {

            for (int j = 0; j <= blen; j++) {

                if (i == 0 || j == 0) {

                    db[i][j] = 0;

                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    db[i][j] = 1 + db[i - 1][j - 1];

                } else {

                    db[i][j] = Math.max(db[i - 1][j], db[i][j - 1]);

                }

            }

        }

        return db[alen][blen];

    }

    public static void main(String[] args) {

        String a = "ilikepie", b = "helikepotato";

        System.out.println(getLengthLCS(a, b, a.length() - 1, b.length() - 1));

        System.out.println("------");

        System.out.println(getLengthLCS2(a, b));

    }

}
