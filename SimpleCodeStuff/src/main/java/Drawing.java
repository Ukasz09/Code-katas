package main.java;

public class Drawing {

    public static void drawHalfTriangleRightSlope(int height) {
        for (int i = 0; i < height; i++) {
            printSignsInLine((i + 1), '*');
            System.out.println();
        }
    }

    public static void drawHalfTriangleLeftSlope(int height) {
        for (int i = 0; i < height; i++) {
            printSignsInLine((height - (i + 1)), ' ');
            printSignsInLine((i + 1), '*');
            System.out.println();
        }
    }

    private static void printSignsInLine(int amount, char sign) {
        for (int j = 0; j < amount; j++)
            System.out.print(sign);
    }

    public static void drawFullTriangle(int height) {
        drawFullTriangle(height, 0, 0);
    }

    public static void drawRotatedFullTriangle(int height) {
        for (int i = height - 1; i >= 0; i--) {
            printSignsInLine((height - (i + 1)), ' ');
            printSignsInLine((i + 1), '*');
            printSignsInLine(i, '*');
            System.out.println();
        }
    }

    private static void drawFullTriangle(int height, int extraAsterisksAtTopQty, int translatedFromMiddleBy) {
        for (int i = 0; i < height; i++) {
            printSignsInLine(translatedFromMiddleBy, ' ');
            printSignsInLine((height - (i + 1)), ' ');
            printSignsInLine((i + 1), '*');
            printSignsInLine(i + extraAsterisksAtTopQty, '*');
            System.out.println();
        }
    }


    public static void drawTree(int subtreeQty, int smallestTreeSize) {
        if (subtreeQty > 0)
            drawFullTriangle(smallestTreeSize, 0, subtreeQty + smallestTreeSize - 2);

        for (int i = 1; i < subtreeQty; i++) {
            drawFullTriangle(i + smallestTreeSize, i + smallestTreeSize - 2, subtreeQty - i);
        }
    }

}
