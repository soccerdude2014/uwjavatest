import java.beans.*;
import java.util.*;

class Point 
	implements Comparable<Point>
{
	private int x;
	private int y;

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.addPropertyChangeListener(listener);
     }

     public void removePropertyChangeListener(PropertyChangeListener listener) {
         this.pcs.removePropertyChangeListener(listener);
     }

	public static class YComparator implements Comparator<Point>
	{
		public int compare(Point lhs, Point rhs) {
			return lhs.y - rhs.y;
		}
	}

	public Point(int xx, int yy) { this.x = xx; this.y = yy; }

	public int getX() { return x; }
	public void setX(int value) { 
		int old = x;
		x = value; 
		pcs.firePropertyChange(new PropertyChangeEvent(this, "x", old, value));
	}

	@Override
	public int compareTo(Point other) {
		return this.x - other.x;
	}

	@Override
	public String toString() {
		return "Point: (" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Point) {
			Point p = (Point)other;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
}


















