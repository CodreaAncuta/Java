package model;

public class Client {

	private int idClient;
	private String name;
	private String identityCardNo;
	private String ssn;
	private String address;
	private String utilitiesProvider;
	
	public Client() {
		super();
	}
	
	public Client(int id, String name, String icn, String ssn, String address, String up) {
		this.idClient = id;
		this.name = name;
		this.identityCardNo = icn;
		this.ssn = ssn;
		this.address = address;
		this.utilitiesProvider = up;
	}

	public String getUtilitiesProvider() {
		return utilitiesProvider;
	}

	public void setUtilitiesProvider(String utilitiesProvider) {
		this.utilitiesProvider = utilitiesProvider;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String s) {
		ssn = s;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
