package com.articulateweb.ontherocks.business.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OBJHelp {
    @SerializedName("ID")
    private Integer id = 0;
    @SerializedName("Header")
    private String header = "";
    @SerializedName("Text")
    private String text = "";

    public Integer getID() { return id; }
    public void setID(Integer value) { this.id = value; }
    public String getHeader() { return header; }
    public void setHeader(String value) { this.header = value; }
    public String getText() { return text; }
    public void setText(String value) { this.text = value; }
}
