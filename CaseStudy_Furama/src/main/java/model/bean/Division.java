package model.bean;

public class Division {
    private int division_id;
    private String division;

    public Division() {
    }

    public Division(int division_id, String division) {
        this.division_id = division_id;
        this.division = division;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
