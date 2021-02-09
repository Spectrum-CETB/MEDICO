package com.example.coderspot;

public class prescriptionstorage {
    String phone , patientsname , disease , medicines;

    public prescriptionstorage(String phone, String name, String disease, String medicines) {
        this.phone = phone;
        this.patientsname = name;
        this.disease = disease;
        this.medicines = medicines;
    }
public prescriptionstorage(){

}
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatientsname() {
        return patientsname;
    }

    public void setPatientsname(String patientsname) {
        this.patientsname = patientsname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
}
