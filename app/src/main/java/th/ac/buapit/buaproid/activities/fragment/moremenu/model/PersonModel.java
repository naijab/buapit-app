package th.ac.buapit.buaproid.activities.fragment.moremenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonModel {

    @SerializedName("person_name")
    @Expose
    private String namePerson;

    @SerializedName("person_position")
    @Expose
    private String positionPerson;

    @SerializedName("person_tel")
    @Expose
    private String telPerson;

    @SerializedName("person_faction")
    @Expose
    private String factionPerson;

    public PersonModel(String namePerson, String positionPerson, String telPerson, String factionPerson) {
        this.namePerson = namePerson;
        this.positionPerson = positionPerson;
        this.telPerson = telPerson;
        this.factionPerson = factionPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getPositionPerson() {
        return positionPerson;
    }

    public void setPositionPerson(String positionPerson) {
        this.positionPerson = positionPerson;
    }

    public String getTelPerson() {
        return telPerson;
    }

    public void setTelPerson(String telPerson) {
        this.telPerson = telPerson;
    }

    public String getFactionPerson() {
        return factionPerson;
    }

    public void setFactionPerson(String factionPerson) {
        this.factionPerson = factionPerson;
    }
}
