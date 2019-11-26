package com.merchant.bookwego.BookingReports.BookingModelClass;

public class BookingListModel {
    String id="";
    String nane="";
    String selectedVaule="";

    public BookingListModel(String id, String nane) {
        this.id = id;
        this.nane = nane;
    }

    public String getSelectedVaule() {
        return selectedVaule;
    }

    public void setSelectedVaule(String selectedVaule) {
        this.selectedVaule = selectedVaule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }
}
