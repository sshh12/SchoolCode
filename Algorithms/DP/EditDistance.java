
public class EditDistance {

    public static int getEditDistance(String[] a, String[] b, int indexA, int indexB) {
        if (indexA == 0) {
            return indexB;
        } else if (indexB == 0) {
            return indexA;
        } else if (a[indexA - 1].equals(b[indexB - 1])) {
            return getEditDistance(a, b, indexA - 1, indexB - 1);
        } else {
            return 1 + Math.min(Math.min(
                                    getEditDistance(a, b, indexA - 1, indexB),
                                    getEditDistance(a, b, indexA, indexB - 1)),
                                    getEditDistance(a, b, indexA - 1, indexB - 1));
        }
    }

    public static int getEditDistance2(String[] a, String[] b) {

        int alen = a.length, blen = b.length;

        int[][] db = new int[alen + 1][blen + 1];

        for (int i = 0; i <= alen; i++) {
            for (int j = 0; j <= blen; j++) {
                if (i == 0) {
                    db[i][j] = j;
                } else if (j == 0) {
                    db[i][j] = i;
                } else if (a[i - 1].equals(b[j - 1])) {
                    db[i][j] = db[i - 1][j - 1];
                } else {
                    db[i][j] = 1 + Math.min(Math.min(
                                                db[i - 1][j],
                                                db[i][j - 1]),
                                                db[i - 1][j - 1]);
                }
            }
        }

        return db[alen][blen];

    }

    public static void main(String[] args) {

        String[] a = "i like pie".split(" ");
        String[] b = "he like much potato".split(" ");

        System.out.println(getEditDistance(a, b, a.length, b.length));

        System.out.println("------");

        System.out.println(getEditDistance2(a, b));

    }

}
