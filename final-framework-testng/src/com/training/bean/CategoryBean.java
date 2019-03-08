
package com.training.bean;

public class CategoryBean {
	private String CATEGORYNAME;
	private String CATEGORYDESC;
	private String METATAGTITLE;
	private String METATAGDESC;
	

	public CategoryBean() {
	}

	public CategoryBean(String CATEGORYNAME, String CATEGORYDESC, String METATAGTITLE, String METATAGDESC, String ADDRESS1,
			String ADDRESS2, String CITY, String POSTCODE, String COUNTRY, String STATE, String PASSWORD,
			String CONFIRMPASSWORD) {
		super();
		this.CATEGORYNAME = CATEGORYNAME;
		this.CATEGORYDESC = CATEGORYDESC;
		this.METATAGTITLE = METATAGTITLE;
		this.METATAGDESC = METATAGDESC;
		
	}

	public String getCATEGORYNAME() {
		return CATEGORYNAME;
	}

	public void setCATEGORYNAME(String CATEGORYNAME) {
		this.CATEGORYNAME = CATEGORYNAME;
	}

	public String getCATEGORYDESC() {
		return CATEGORYDESC;
	}

	public void setCATEGORYDESC(String CATEGORYDESC) {
		this.CATEGORYDESC = CATEGORYDESC;
	}

	public String getMETATAGTITLE() {
		return METATAGTITLE;
	}

	public void setMETATAGTITLE(String METATAGTITLE) {
		this.METATAGTITLE = METATAGTITLE;
	}

	public String getMETATAGDESC() {
		return METATAGDESC;
	}

	public void setMETATAGDESC(String METATAGDESC) {
		this.METATAGDESC = METATAGDESC;
	}



	@Override
	public String toString() {
		return "LoginBean [CATEGORYNAME=" + CATEGORYNAME + ", CATEGORYDESC=" + CATEGORYDESC + ", METATAGTITLE=" + METATAGTITLE + ", METATAGDESC="
				+ METATAGDESC + "]";
	}

}
