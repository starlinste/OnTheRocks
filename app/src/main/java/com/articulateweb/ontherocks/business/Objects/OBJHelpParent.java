package com.articulateweb.ontherocks.business.Objects;

import java.util.*;

public class OBJHelpParent {
    private ArrayList<OBJHelp> records;

    public OBJHelpParent(){
        records = new ArrayList<>();
    }

    public ArrayList<OBJHelp> getRecords() { return records; }
    public void setRecords(ArrayList<OBJHelp> value) { this.records = value; }
}