package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Document {
    private String name;
    private String date;

    public Document(String docName){
        name = docName;
        Date currentDate = new Date();
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy/mm/dd");
        date = formatForDate.format(currentDate);
    }

    public Document(String docName, String date){
        name = docName;
        this.date = date;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
