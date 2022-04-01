package model.bean;

public class RentType {
    private int rent_type_id;
    private String rentType;

    public RentType() {
    }

    public RentType(int rent_type_id, String rentType) {
        this.rent_type_id = rent_type_id;
        this.rentType = rentType;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
