package model.bean;

public class Service {
    private int id;
    private String service_name;
    private double service_area;
    private int service_max_people;
    private int rent_type_id;
    private int service_type_id;
    private String standard_room;
    private String description_other_convenience;
    private double pool_area;
    private int number_of_floors;


    public Service() {
    }

    public Service(String service_name, double service_area, int service_max_people, int rent_type_id, int service_type_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floors) {
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public Service(int id, String service_name, double service_area, int service_max_people, int rent_type_id, int service_type_id, String standard_room, String description_other_convenience, double pool_area, int number_of_floors) {
        this.id = id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public double getService_area() {
        return service_area;
    }

    public void setService_area(double service_area) {
        this.service_area = service_area;
    }

    public int getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(int service_max_people) {
        this.service_max_people = service_max_people;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public double getPool_area() {
        return pool_area;
    }

    public void setPool_area(double pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }
}
