
public class MinSquares {

    public static int getMinSquares(int length, int width) {

        int result = 0;

        int largeSide = Math.max(length, width),
            smallSide = Math.min(length, width);

        while (smallSide > 0) {

            result += largeSide / smallSide;

            int temp = largeSide % smallSide;

            largeSide = smallSide;
            smallSide = temp;

        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(getMinSquares(13, 29));

    }

}
