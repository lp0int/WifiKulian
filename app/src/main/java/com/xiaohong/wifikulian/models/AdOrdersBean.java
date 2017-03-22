package com.xiaohong.wifikulian.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lpoint on 2017/3/13 11:10.
 */

public class AdOrdersBean implements Serializable {

    /**
     * AdOrder : [{"name":"滚动消息-Android","id":54,"pic1":"http://cms.jinkechen.com:8080/","pic2":"http://cms.jinkechen.com:8080/","pic3":"http://cms.jinkechen.com:8080/","url":"","file":null,"exposure_url":"http://www.mobdsp.com/cb/v?k=54&m1=[M_MAC]&m2=[M_IDFA]&m3=[M_IMEI]&phone=[PHONE]&o=","click_url":null,"h5_zip":"http://cms.jinkechen.com:8080/","is_title":1,"h5_zip_md5":null,"content":"签到有惊喜","apk_md5":null,"app_id":0}]
     * State : success
     * Content : 成功
     * StatusCode : 300
     */

    private String State;
    private String Content;
    private int StatusCode;
    private List<AdOrderBean> AdOrder;

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public List<AdOrderBean> getAdOrder() {
        return AdOrder;
    }

    public void setAdOrder(List<AdOrderBean> AdOrder) {
        this.AdOrder = AdOrder;
    }

    public static class AdOrderBean {
        /**
         * name : 滚动消息-Android
         * id : 54
         * pic1 : http://cms.jinkechen.com:8080/
         * pic2 : http://cms.jinkechen.com:8080/
         * pic3 : http://cms.jinkechen.com:8080/
         * url :
         * file : null
         * exposure_url : http://www.mobdsp.com/cb/v?k=54&m1=[M_MAC]&m2=[M_IDFA]&m3=[M_IMEI]&phone=[PHONE]&o=
         * click_url : null
         * h5_zip : http://cms.jinkechen.com:8080/
         * is_title : 1
         * h5_zip_md5 : null
         * content : 签到有惊喜
         * apk_md5 : null
         * app_id : 0
         */

        private String name;
        private int id;
        private String pic1;
        private String pic2;
        private String pic3;
        private String url;
        private Object file;
        private String exposure_url;
        private Object click_url;
        private String h5_zip;
        private int is_title;
        private Object h5_zip_md5;
        private String content;
        private Object apk_md5;
        private int app_id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic1() {
            return pic1;
        }

        public void setPic1(String pic1) {
            this.pic1 = pic1;
        }

        public String getPic2() {
            return pic2;
        }

        public void setPic2(String pic2) {
            this.pic2 = pic2;
        }

        public String getPic3() {
            return pic3;
        }

        public void setPic3(String pic3) {
            this.pic3 = pic3;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getFile() {
            return file;
        }

        public void setFile(Object file) {
            this.file = file;
        }

        public String getExposure_url() {
            return exposure_url;
        }

        public void setExposure_url(String exposure_url) {
            this.exposure_url = exposure_url;
        }

        public Object getClick_url() {
            return click_url;
        }

        public void setClick_url(Object click_url) {
            this.click_url = click_url;
        }

        public String getH5_zip() {
            return h5_zip;
        }

        public void setH5_zip(String h5_zip) {
            this.h5_zip = h5_zip;
        }

        public int getIs_title() {
            return is_title;
        }

        public void setIs_title(int is_title) {
            this.is_title = is_title;
        }

        public Object getH5_zip_md5() {
            return h5_zip_md5;
        }

        public void setH5_zip_md5(Object h5_zip_md5) {
            this.h5_zip_md5 = h5_zip_md5;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getApk_md5() {
            return apk_md5;
        }

        public void setApk_md5(Object apk_md5) {
            this.apk_md5 = apk_md5;
        }

        public int getApp_id() {
            return app_id;
        }

        public void setApp_id(int app_id) {
            this.app_id = app_id;
        }
    }
}
