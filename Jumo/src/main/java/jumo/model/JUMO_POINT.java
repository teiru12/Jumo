package jumo.model;

import java.util.Date;

public class JUMO_POINT {

	private int POINT_KEY;
	private String EMAIL;
	private int JUMO_POINT;
	private Date RULLETDATE;
	
	public int getPOINT_KEY() {
		return POINT_KEY;
	}
	public void setPOINT_KEY(int pOINT_KEY) {
		POINT_KEY = pOINT_KEY;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public int getJUMO_POINT() {
		return JUMO_POINT;
	}
	public void setJUMO_POINT(int jUMO_POINT) {
		JUMO_POINT = jUMO_POINT;
	}
	public Date getRULLETDATE() {
		return RULLETDATE;
	}
	public void setRULLETDATE(Date rULLETDATE) {
		RULLETDATE = rULLETDATE;
	}	
}