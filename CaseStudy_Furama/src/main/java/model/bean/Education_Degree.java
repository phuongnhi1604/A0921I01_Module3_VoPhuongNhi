package model.bean;

public class Education_Degree {
    private int education_degree_id;
    private String education_degree;

    public Education_Degree() {
    }

    public Education_Degree(int education_degree_id, String education_degree) {
        this.education_degree_id = education_degree_id;
        this.education_degree = education_degree;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public String getEducation_degree() {
        return education_degree;
    }

    public void setEducation_degree(String education_degree) {
        this.education_degree = education_degree;
    }
}
