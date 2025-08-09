package models;

public class User {

    private int id;
    private String name;
    private int phoneNo ;
    private String address;



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

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User Id: " + this.id+
                "\nUser Name: " + this.name+
                "\nPhoneNo: " + this.phoneNo +
                "\nAddress: " + this.address;
    }
}
