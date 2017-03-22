package com.xiaohong.wifikulian.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lpoint on 2017/2/8 14:50.
 */

public class RecommendListBean implements Serializable{

    private String State;
    private String Content;
    private int StatusCode;
    private List<AppListBean> AppList;

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

    public List<AppListBean> getAppList() {
        return AppList;
    }

    public void setAppList(List<AppListBean> AppList) {
        this.AppList = AppList;
    }

    public static class AppListBean {
        /**
         * id : 1
         * pic1 : http://cms.jinkechen.com:8080//uploads/images/20170207/91977556b73014f58a7e4d56d8e9aa75.jpg
         * pic2 : http://cms.jinkechen.com:8080//uploads/images/20170207/e40ab5e15cfb000c819d0d1d59e4ce9a.jpg
         * pic3 : http://cms.jinkechen.com:8080//uploads/images/20170207/488342fa81735b8803bade3e6639cab7.jpg
         * url : https://kulian.exiaohong.com/html5/PALYtaskDetails006/index.html
         * file : http://91chaxun.cn/2016/Y_wcly/?utm_source=gugong&mi_source=WYYWA06-03
         * exposure_url : http://www.mobdsp.com/cb/v?k=1&m1=[M_MAC]&m2=[M_IDFA]&m3=[M_IMEI]&phone=[PHONE]&o=
         * click_url : http://www.mobdsp.com/cb/c?k=1&m1=[M_MAC]&m2=[M_IDFA]&m3=[M_IMEI]&phone=[PHONE]&o=
         * h5_zip : http://cms.jinkechen.com:8080//uploads/zip/PALYtaskDetails006.zip
         * is_title : 0
         * h5_zip_md5 : 4683d716c41082004f991486a87ffe3e
         * apk_md5 : null
         * h5_name : PALYtaskDetails006
         * appId : 1
         * name : 平安旅游险
         * logo : http://cms.jinkechen.com:8080//uploads/images/20170118/73944c5985a9b55fe2dc7f08f840e84b.png
         * summary : 参与活动免费领平安100万元畅行天下意外险，还有海量金币赠送！！！
         * description : 参与活动免费领平安100万元畅行天下意外险，还有海量金币赠送！！！ 外出旅游，安全至上!中国平安100万元畅行天下险为您保驾护航！ 参与活动，即可免费领取中国平安畅行天下险，最高保额达100万元。
         * size : 0MB
         * version : 1.0
         * package_name : null
         * gold : 300
         * is_vertical : 1
         * star : 5
         * open_enable : 1
         * is_red : 0
         * status : 0
         */

        private int id;
        private String pic1;
        private String pic2;
        private String pic3;
        private String url;
        private String file;
        private String exposure_url;
        private String click_url;
        private String h5_zip;
        private int is_title;
        private String h5_zip_md5;
        private Object apk_md5;
        private String h5_name;
        private int appId;
        private String name;
        private String logo;
        private String summary;
        private String description;
        private String size;
        private String version;
        private Object package_name;
        private int gold;
        private int is_vertical;
        private int star;
        private int open_enable;
        private int is_red;
        private int status;

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

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getExposure_url() {
            return exposure_url;
        }

        public void setExposure_url(String exposure_url) {
            this.exposure_url = exposure_url;
        }

        public String getClick_url() {
            return click_url;
        }

        public void setClick_url(String click_url) {
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

        public String getH5_zip_md5() {
            return h5_zip_md5;
        }

        public void setH5_zip_md5(String h5_zip_md5) {
            this.h5_zip_md5 = h5_zip_md5;
        }

        public Object getApk_md5() {
            return apk_md5;
        }

        public void setApk_md5(Object apk_md5) {
            this.apk_md5 = apk_md5;
        }

        public String getH5_name() {
            return h5_name;
        }

        public void setH5_name(String h5_name) {
            this.h5_name = h5_name;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Object getPackage_name() {
            return package_name;
        }

        public void setPackage_name(Object package_name) {
            this.package_name = package_name;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getIs_vertical() {
            return is_vertical;
        }

        public void setIs_vertical(int is_vertical) {
            this.is_vertical = is_vertical;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public int getOpen_enable() {
            return open_enable;
        }

        public void setOpen_enable(int open_enable) {
            this.open_enable = open_enable;
        }

        public int getIs_red() {
            return is_red;
        }

        public void setIs_red(int is_red) {
            this.is_red = is_red;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
