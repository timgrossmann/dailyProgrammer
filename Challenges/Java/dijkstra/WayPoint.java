
public class WayPoint {
	
	int id;
	int currValue = Integer.MAX_VALUE;
	WayPoint prePoint;
	boolean removed = false;
	
	public WayPoint(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WayPoint [id=" + id + ", currValue=" + currValue + ", prePoint=" + prePoint.id + ", removed=" + removed
				+ "]";
	}	

}
