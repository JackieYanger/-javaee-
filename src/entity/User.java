package entity;

 
public class User {
    private int id;
    private String name;
    private String password;
    private String secure_code;
    private String address;
    private String phone;
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getSecure_code() {
		return secure_code;
	}
	public void setSecure_code(String secure_code) {
		this.secure_code = secure_code;
	}
}