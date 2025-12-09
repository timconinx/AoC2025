package day08;

public class Coordinate3D {
	private int x;
	
	private int y;
	
	private int z;
	
	private Island island;
	
	public int X() {
		return x;
	}
	
	public int Y() {
		return y;
	}
	
	public int Z() {
		return z;
	}
	
	public Island getIsland() {
		return island;
	}
	
	public void setIsland(Island i) {
		island = i;
	}
	
	public Coordinate3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Coordinate3D(String s) {
		String[] p = s.split(",");
		x = Integer.parseInt(p[0]);
		y = Integer.parseInt(p[1]);
		z = Integer.parseInt(p[2]);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Coordinate3D && ((Coordinate3D)obj).X() == x && ((Coordinate3D)obj).Y() == y && ((Coordinate3D)obj).Z() == z;
	}
	
	@Override
	public int hashCode() {
		return 31*x + 17*y + 7*z;
	}
	
	public int mDistanceTo(Coordinate3D c) {
		return Math.abs(x - c.X()) + Math.abs(y - c.Y()) + Math.abs(z - c.Z());
	}
}
