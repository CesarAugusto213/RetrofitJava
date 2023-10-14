package com.prueba.retrofitjava.models;

import lombok.Data;

public class UserData {
    DataResponse data;
    Support support;

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
