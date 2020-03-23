package main.java;

public class Main {
    public static void main(String[] args) {
        System.out.println();
    }

    private void drawingFunctionalityPresentation() {
        Drawing.drawHalfTriangleLeftSlope(6);
        System.out.println("___________________________________________________________________________________________");
        Drawing.drawHalfTriangleRightSlope(6);
        System.out.println("___________________________________________________________________________________________");
        Drawing.drawFullTriangle(4);
        System.out.println("___________________________________________________________________________________________");
        Drawing.drawFullTriangle(6);
        System.out.println("___________________________________________________________________________________________");
        Drawing.drawTree(5, 3);
        System.out.println("___________________________________________________________________________________________");
        Drawing.drawRotatedFullTriangle(6);
    }

}
