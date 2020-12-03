package com.example.realm;

public class Model {
    //https://image.tmdb.org/t/p/w500/k68nPLbIST6NP96JmTxmZijEvCA.jpg
    String strTeam;
    String intFormedYear;
    String strTeamBadge;
    String strDescriptionEN;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getstrTeam() { return strTeam;
    }

    public void setstrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getintFormedYear() { return intFormedYear; }

    public void setintFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getstrTeamBadge() {
        return strTeamBadge;
    }

    public void setstrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getstrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setstrDescriptionEN(String strDescriptionEN) { this.strDescriptionEN = strDescriptionEN; }

}
