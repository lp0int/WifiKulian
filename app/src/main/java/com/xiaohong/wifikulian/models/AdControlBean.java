package com.xiaohong.wifikulian.models;

import java.util.List;

/**
 * Created by Lpoint on 2017/3/13 14:51.
 */

public class AdControlBean {

    /**
     * Control : [{"class_name":"cycleList","enable":1,"show_time":"600"},{"class_name":"AppList","enable":1,"show_time":"3"}]
     * State : success
     * Content : 成功
     * StatusCode : 300
     */

    private String State;
    private String Content;
    private int StatusCode;
    private List<ControlBean> Control;

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

    public List<ControlBean> getControl() {
        return Control;
    }

    public void setControl(List<ControlBean> Control) {
        this.Control = Control;
    }

    public static class ControlBean {
        /**
         * class_name : cycleList
         * enable : 1
         * show_time : 600
         */

        private String class_name;
        private int enable;
        private String show_time;

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }
    }
}
