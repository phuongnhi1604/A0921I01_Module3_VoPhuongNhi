package model.bean;

public class Customer extends Person{
    private int customer_type_id;
    private String customer_address;

    public Customer() {
        super();
    }

    public Customer(int id, String name, String birthday, String id_card, String phone, String email, int customer_type_id, String customer_address) {
        super(id, name, birthday, id_card, phone, email);
        this.customer_type_id = customer_type_id;
        this.customer_address = customer_address;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
