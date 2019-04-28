package entity;
 
public class Product {
 
    private int id;
    private String name;
    private float price;
    private String infor;
    public int getId() {
        return id;
    }
    public String getInfor() {
		return infor;
	}
	public void setInfor(String infor) {
		this.infor = infor;
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
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
     
}