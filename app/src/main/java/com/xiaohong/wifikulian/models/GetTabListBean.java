package com.xiaohong.wifikulian.models;

import java.util.List;

/**
 * Created by Lpoint on 2017/2/6 14:16.
 */

public class GetTabListBean {

    /**
     * StatusCode : 300
     * State : success
     * Content : [{"TabName":"彩票","Link":"https://6104.popcai.com/","Time":"1484017135","Id":297},{"TabName":"推荐","Link":"Native","Time":"1483953809","Id":291},{"TabName":"淘宝","Link":"https://kulian.exiaohong.com/index.php/mall/Index/Index","Time":"1484893871","Id":312},{"TabName":"搞笑","Link":"http://xhaz.come11.com/text174.html","Time":"1484117136","Id":305},{"TabName":"阅读","Link":"http://ubook.qq.com/?g_f=100028 ","Time":"1484117593","Id":309},{"TabName":"购买","Link":"Native","Time":"1484116594","Id":301}]
     */

    private int StatusCode;
    private String State;
    private List<ContentBean> Content;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public List<ContentBean> getContent() {
        return Content;
    }

    public void setContent(List<ContentBean> Content) {
        this.Content = Content;
    }

    public static class ContentBean {
        /**
         * TabName : 彩票
         * Link : https://6104.popcai.com/
         * Time : 1484017135
         * Id : 297
         */

        private String TabName;
        private String Link;
        private String Time;
        private int Id;

        public String getTabName() {
            return TabName;
        }

        public void setTabName(String TabName) {
            this.TabName = TabName;
        }

        public String getLink() {
            return Link;
        }

        public void setLink(String Link) {
            this.Link = Link;
        }

        public String getTime() {
            return Time;
        }

        public void setTime(String Time) {
            this.Time = Time;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }
    }
}
