public class Triangle extends Shape {
    private Point edgeOne;
    private Point edgeTwo;
    private Point edgeThree;

    public Triangle(Point x, Point y, Point z) {
        edgeOne = x;
        edgeTwo = y;
        edgeThree = z;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        edgeOne = new Point(x1, y1);
        edgeTwo = new Point(x2, y2);
        edgeThree = new Point(x3, y3);
    }

    private double distanceBetweenPoints(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX()- b.getX(), 2) + Math.pow(a.getY() - b.getY(),2));
    }


    @Override
    public double square() {
        return  0.5 * ((edgeOne.getX() * edgeTwo.getY() + edgeTwo.getX() * edgeThree.getY() + edgeThree.getX() * edgeOne.getY()) - (edgeOne.getY() * edgeTwo.getX() + edgeTwo.getY() * edgeThree.getX() + edgeThree.getY() * edgeOne.getX()));
    }

    @Override
    public double perimeter() {
        return distanceBetweenPoints(edgeOne,edgeTwo) + distanceBetweenPoints(edgeTwo,edgeThree) + distanceBetweenPoints(edgeOne, edgeThree);
    }

    @Override
    public void move(double dx, double dy) {
        edgeOne.setX(edgeOne.getX() + dx);
        edgeOne.setY(edgeOne.getY() + dy);
        edgeTwo.setX(edgeTwo.getX() + dx);
        edgeTwo.setY(edgeTwo.getY() + dy);
        edgeThree.setX(edgeThree.getX() + dx);
        edgeThree.setY(edgeThree.getY() + dy);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "edgeOne=" + edgeOne +
                ", edgeTwo=" + edgeTwo +
                ", edgeThree=" + edgeThree +
                '}' + super.toString();
    }
}
