package com.example.thinkpad.kh4b;

/**
 * Created by thinkpad on 2018/1/4.
 */

public class item {
    private String title;
    private String date;
    private String file_size;
    private boolean aBoolean;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public item(String title, String date, String file_size, boolean aBoolean){
        super();
        this.title=title;
        this.date=date;
        this.file_size=file_size;
        this.aBoolean=aBoolean;
    }
    public item(){
        super();
    }


}
