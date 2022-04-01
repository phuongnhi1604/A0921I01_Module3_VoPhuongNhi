package model.bean;

public class Attach_Service {
    private int id;
    private String attach_service_name;
    private String attach_service_unit;
    private String attach_service_cost;

    public Attach_Service() {
    }

    public Attach_Service(int id, String attach_service_name, String attach_service_unit, String attach_service_cost) {
        this.id = id;
        this.attach_service_name = attach_service_name;
        this.attach_service_unit = attach_service_unit;
        this.attach_service_cost = attach_service_cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public String getAttach_service_unit() {
        return attach_service_unit;
    }

    public void setAttach_service_unit(String attach_service_unit) {
        this.attach_service_unit = attach_service_unit;
    }

    public String getAttach_service_cost() {
        return attach_service_cost;
    }

    public void setAttach_service_cost(String attach_service_cost) {
        this.attach_service_cost = attach_service_cost;
    }
}
