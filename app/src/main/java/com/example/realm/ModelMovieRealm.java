package com.example.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ModelMovieRealm extends RealmObject {
    @PrimaryKey
    private Integer id;
    private String strTeam;
    private String strDescriptionEN;
    private String intFormedYear;
    private String strTeamBadge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getstrTeam() {
        return strTeam;
    }

    public void setstrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getstrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setstrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public String getintFormedYear() {
        return intFormedYear;
    }

    public void setintFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getstrTeamBadge() {
        return strTeamBadge;
    }

    public void setstrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }
}
