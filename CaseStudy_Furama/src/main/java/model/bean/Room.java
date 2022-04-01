package model.bean;

public class Room extends Service{
    private String accompanied_service;

    public Room() {
        super();
    }

    public Room(int id, String service_name, double service_area, double service_cost, int service_max_people, int rent_type_id, String accompanied_service) {
        super(id, service_name, service_area, service_cost, service_max_people, rent_type_id);
        this.accompanied_service = accompanied_service;
    }

    public String getAccompanied_service() {
        return accompanied_service;
    }

    public void setAccompanied_service(String accompanied_service) {
        this.accompanied_service = accompanied_service;
    }
}
