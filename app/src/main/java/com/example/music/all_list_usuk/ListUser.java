package com.example.music.all_list_usuk;

import java.io.Serializable;

public class ListUser implements Serializable {
    private int resourceId;
    private String tenbaihat;
    private String tencasy;

    public ListUser(int resourceId, String tenbaihat, String tencasy) {
        this.resourceId = resourceId;
        this.tenbaihat = tenbaihat;
        this.tencasy = tencasy;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getTencasy() {
        return tencasy;
    }

    public void setTencasy(String tencasy) {
        this.tencasy = tencasy;
    }
}


