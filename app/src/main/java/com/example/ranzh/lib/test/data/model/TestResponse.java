package com.example.ranzh.lib.test.data.model;

/**
 * Created by ranzh on 1/9/2017.
 */

public class TestResponse {

    private int status;
    private Object message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private String api_base_url;
        private String cdn_base_url;

        public String getApi_base_url() {
            return api_base_url;
        }

        public void setApi_base_url(String api_base_url) {
            this.api_base_url = api_base_url;
        }

        public String getCdn_base_url() {
            return cdn_base_url;
        }

        public void setCdn_base_url(String cdn_base_url) {
            this.cdn_base_url = cdn_base_url;
        }
    }
}
