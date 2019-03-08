package com.training.bean;

public class LoginBean {
	private String FIRSTNAME;
	private String LASTNAME;
	private String EMAIL;
	private String TELEPHONE;
	private String ADDRESS1;
	private String ADDRESS2;
	private String CITY;
	private String POSTCODE;
	private String COUNTRY;
	private String STATE;
	private String PASSWORD;
	private String CONFIRMPASSWORD;

	public LoginBean() {
	}

	public LoginBean(String FIRSTNAME, String LASTNAME, String EMAIL, String TELEPHONE, String ADDRESS1,
			String ADDRESS2, String CITY, String POSTCODE, String COUNTRY, String STATE, String PASSWORD,
			String CONFIRMPASSWORD) {
		super();
		this.FIRSTNAME = FIRSTNAME;
		this.LASTNAME = LASTNAME;
		this.EMAIL = EMAIL;
		this.TELEPHONE = TELEPHONE;
		this.ADDRESS1 = ADDRESS1;
		this.ADDRESS2 = ADDRESS2;
		this.CITY = CITY;
		this.POSTCODE = POSTCODE;
		this.COUNTRY = COUNTRY;
		this.STATE = STATE;
		this.PASSWORD = PASSWORD;
		this.CONFIRMPASSWORD = CONFIRMPASSWORD;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String FIRSTNAME) {
		this.FIRSTNAME = FIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String LASTNAME) {
		this.LASTNAME = LASTNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String TELEPHONE) {
		this.TELEPHONE = TELEPHONE;
	}

	public String getADDRESS1() {
		return ADDRESS1;
	}

	public void setADDRESS1(String ADDRESS1) {
		this.ADDRESS1 = ADDRESS1;
	}

	public String getADDRESS2() {
		return ADDRESS2;
	}

	public void setADDRESS2(String ADDRESS2) {
		this.ADDRESS2 = ADDRESS2;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String CITY) {
		this.CITY = CITY;
	}

	public String getPOSTCODE() {
		return POSTCODE;
	}

	public void setPOSTCODE(String POSTCODE) {
		this.POSTCODE = POSTCODE;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String COUNTRY) {
		this.COUNTRY = COUNTRY;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String STATE) {
		this.STATE = STATE;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}

	public String getCONFIRMPASSWORD() {
		return CONFIRMPASSWORD;
	}

	public void setCONFIRMPASSWORD(String CONFIRMPASSWORD) {
		this.CONFIRMPASSWORD = CONFIRMPASSWORD;
	}

	@Override
	public String toString() {
		return "LoginBean [FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", EMAIL=" + EMAIL + ", TELEPHONE=" + TELEPHONE + ", ADDRESS1=" + ADDRESS1 + ", ADDRESS2=" + ADDRESS2 + ", CITY=" + CITY + ", POSTCODE=" + POSTCODE + ", COUNTRY=" + COUNTRY + ", STATE=" + STATE + ", PASSWORD=" + PASSWORD + ", CONFIRMPASSWORD=" + CONFIRMPASSWORD + "]";
	}

}
