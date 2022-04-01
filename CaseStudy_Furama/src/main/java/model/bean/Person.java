package model.bean;

public abstract class Person {
    protected int id;
    protected String name;
    protected String birthday;
    protected String id_card;
    protected String phone;
    protected String email;

    public Person() {
    }

    public Person(int id, String name, String birthday, String id_card, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
