import java.util.*;
import java.beans.*;

public class Hello
{
	public static void main(String... args) {
		Point p1 = new Point(1,2); //p1.x = 1; p1.y = 2;
		Point p2 = new Point(1,2); //p2.x = 1; p2.y = 2;
		Point p3 = new Point(2,1); //p3.x = 2; p3.y = 1;
		Point p4 = new Point(-5,12);// p4.x = -5; p4.y = 12;

		ArrayList<Point> points = new ArrayList<Point>(50);
		points.add(p1); points.add(p2); points.add(p3); points.add(p4);
		System.out.println(points);

		Collections.sort(points);
		System.out.println(points);

		Collections.sort(points, new Point.YComparator());
		System.out.println(points);

		 int foo = 12;
		p2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				foo = 24;
				System.out.println("Object " + evt.getSource() + " says that " +
					evt.getPropertyName() + " is now " + evt.getNewValue() + foo);
			}
		} );
		p2.addPropertyChangeListener((evt) -> {
			foo = 24;
			System.out.println("Object " + evt.getSource() + " says that " +
				evt.getPropertyName() + " is now " + evt.getNewValue() + foo);
		} );

		p2.setX(24);

	}
}
