package com.xiaohong.wifikulian.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lpoint on 2017/3/13 16:25.
 */

public class QQReadBean implements Serializable {

    private boolean isLogin;
    private int stGuest;
    private String skey;
    private String lskey;
    private int qq;
    private List<HotListBean> hotList;
    private List<Adlist1Bean> adlist1;
    private List<FireListBean> fireList;
    private List<FmaleListBean> fmaleList;
    private List<PubListBean> pubList;
    private List<MaleListBean> maleList;

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public int getStGuest() {
        return stGuest;
    }

    public void setStGuest(int stGuest) {
        this.stGuest = stGuest;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getLskey() {
        return lskey;
    }

    public void setLskey(String lskey) {
        this.lskey = lskey;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public List<HotListBean> getHotList() {
        return hotList;
    }

    public void setHotList(List<HotListBean> hotList) {
        this.hotList = hotList;
    }

    public List<Adlist1Bean> getAdlist1() {
        return adlist1;
    }

    public void setAdlist1(List<Adlist1Bean> adlist1) {
        this.adlist1 = adlist1;
    }

    public List<FireListBean> getFireList() {
        return fireList;
    }

    public void setFireList(List<FireListBean> fireList) {
        this.fireList = fireList;
    }

    public List<FmaleListBean> getFmaleList() {
        return fmaleList;
    }

    public void setFmaleList(List<FmaleListBean> fmaleList) {
        this.fmaleList = fmaleList;
    }

    public List<PubListBean> getPubList() {
        return pubList;
    }

    public void setPubList(List<PubListBean> pubList) {
        this.pubList = pubList;
    }

    public List<MaleListBean> getMaleList() {
        return maleList;
    }

    public void setMaleList(List<MaleListBean> maleList) {
        this.maleList = maleList;
    }

    public static class HotListBean {
        /**
         * lpushname : 他曾是兵中王者——“凶兽”秦渊。而现在，他只是个小保镖……
         * cpushname : 美人贴身偷心贼:近身高手
         * finished : 0
         * type : 0
         * intro : 单纯靓丽的少女鲁雪晴，妖媚强势的熟女叶云曼，对一个谜一样少年主动投怀送抱，无怨无悔的跟随，为何会有这样的因缘？
         * id : 361503
         * cat3Info : 20000:小说:小说,20019:都市:都市,20027:恩怨情仇:恩仇
         * author : 月下吟
         * title : 近身高手
         * cover : http://wfqqreader.3g.qq.com/cover/503/361503/b_361503.jpg
         * categoryInfoV4Slave :
         * catName : 都市
         * totalWords : 6709809
         * pushName : 美人贴身偷心贼:近身高手
         * categoryInfoV4 : 20000:小说:小说,20019:都市:都市,20027:恩怨情仇:恩仇
         */

        private String lpushname;
        private String cpushname;
        private String finished;
        private String type;
        private String intro;
        private String id;
        private String cat3Info;
        private String author;
        private String title;
        private String cover;
        private String categoryInfoV4Slave;
        private String catName;
        private String totalWords;
        private String pushName;
        private String categoryInfoV4;

        public String getLpushname() {
            return lpushname;
        }

        public void setLpushname(String lpushname) {
            this.lpushname = lpushname;
        }

        public String getCpushname() {
            return cpushname;
        }

        public void setCpushname(String cpushname) {
            this.cpushname = cpushname;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat3Info() {
            return cat3Info;
        }

        public void setCat3Info(String cat3Info) {
            this.cat3Info = cat3Info;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCategoryInfoV4Slave() {
            return categoryInfoV4Slave;
        }

        public void setCategoryInfoV4Slave(String categoryInfoV4Slave) {
            this.categoryInfoV4Slave = categoryInfoV4Slave;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTotalWords() {
            return totalWords;
        }

        public void setTotalWords(String totalWords) {
            this.totalWords = totalWords;
        }

        public String getPushName() {
            return pushName;
        }

        public void setPushName(String pushName) {
            this.pushName = pushName;
        }

        public String getCategoryInfoV4() {
            return categoryInfoV4;
        }

        public void setCategoryInfoV4(String categoryInfoV4) {
            this.categoryInfoV4 = categoryInfoV4;
        }
    }

    public static class Adlist1Bean {
        /**
         * channel :
         * extInfo : {"position":"102118","packageType":"1","loginStatus":"0","show_limit":"0","showPosition":"0","tag":"0","cashDays":"0","data":"0","chapterLength":"0","deviceModel":"","monthDays":"0","priority":"0","ref_info":"","black":"0","dayHigh":"0","live_time":"0","publishTime":"2017-03-13 11:30:00","property":"-1","actionType":"0","closeTime":"2017-03-14 11:30:00","category":"0","bookNews":"0","red":"0","channelStatus":"0","dayLow":"0","forceLogin":"0","cash":"0","month":"0","userNew":"0"}
         * id : 70088590
         * imageUrl : http://wfqqreader.3g.qq.com/cover/topic/119201207_69895932_1488345057179.jpg
         * intro :
         * title : 最强神级兵王
         * type : 2
         * value : intro.html?bid=13585295
         * valueType : 1
         */

        private String channel;
        private ExtInfoBean extInfo;
        private int id;
        private String imageUrl;
        private String intro;
        private String title;
        private int type;
        private String value;
        private int valueType;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public ExtInfoBean getExtInfo() {
            return extInfo;
        }

        public void setExtInfo(ExtInfoBean extInfo) {
            this.extInfo = extInfo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getValueType() {
            return valueType;
        }

        public void setValueType(int valueType) {
            this.valueType = valueType;
        }

        public static class ExtInfoBean {
            /**
             * position : 102118
             * packageType : 1
             * loginStatus : 0
             * show_limit : 0
             * showPosition : 0
             * tag : 0
             * cashDays : 0
             * data : 0
             * chapterLength : 0
             * deviceModel :
             * monthDays : 0
             * priority : 0
             * ref_info :
             * black : 0
             * dayHigh : 0
             * live_time : 0
             * publishTime : 2017-03-13 11:30:00
             * property : -1
             * actionType : 0
             * closeTime : 2017-03-14 11:30:00
             * category : 0
             * bookNews : 0
             * red : 0
             * channelStatus : 0
             * dayLow : 0
             * forceLogin : 0
             * cash : 0
             * month : 0
             * userNew : 0
             */

            private String position;
            private String packageType;
            private String loginStatus;
            private String show_limit;
            private String showPosition;
            private String tag;
            private String cashDays;
            private String data;
            private String chapterLength;
            private String deviceModel;
            private String monthDays;
            private String priority;
            private String ref_info;
            private String black;
            private String dayHigh;
            private String live_time;
            private String publishTime;
            private String property;
            private String actionType;
            private String closeTime;
            private String category;
            private String bookNews;
            private String red;
            private String channelStatus;
            private String dayLow;
            private String forceLogin;
            private String cash;
            private String month;
            private String userNew;

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getPackageType() {
                return packageType;
            }

            public void setPackageType(String packageType) {
                this.packageType = packageType;
            }

            public String getLoginStatus() {
                return loginStatus;
            }

            public void setLoginStatus(String loginStatus) {
                this.loginStatus = loginStatus;
            }

            public String getShow_limit() {
                return show_limit;
            }

            public void setShow_limit(String show_limit) {
                this.show_limit = show_limit;
            }

            public String getShowPosition() {
                return showPosition;
            }

            public void setShowPosition(String showPosition) {
                this.showPosition = showPosition;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getCashDays() {
                return cashDays;
            }

            public void setCashDays(String cashDays) {
                this.cashDays = cashDays;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getChapterLength() {
                return chapterLength;
            }

            public void setChapterLength(String chapterLength) {
                this.chapterLength = chapterLength;
            }

            public String getDeviceModel() {
                return deviceModel;
            }

            public void setDeviceModel(String deviceModel) {
                this.deviceModel = deviceModel;
            }

            public String getMonthDays() {
                return monthDays;
            }

            public void setMonthDays(String monthDays) {
                this.monthDays = monthDays;
            }

            public String getPriority() {
                return priority;
            }

            public void setPriority(String priority) {
                this.priority = priority;
            }

            public String getRef_info() {
                return ref_info;
            }

            public void setRef_info(String ref_info) {
                this.ref_info = ref_info;
            }

            public String getBlack() {
                return black;
            }

            public void setBlack(String black) {
                this.black = black;
            }

            public String getDayHigh() {
                return dayHigh;
            }

            public void setDayHigh(String dayHigh) {
                this.dayHigh = dayHigh;
            }

            public String getLive_time() {
                return live_time;
            }

            public void setLive_time(String live_time) {
                this.live_time = live_time;
            }

            public String getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(String publishTime) {
                this.publishTime = publishTime;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public String getActionType() {
                return actionType;
            }

            public void setActionType(String actionType) {
                this.actionType = actionType;
            }

            public String getCloseTime() {
                return closeTime;
            }

            public void setCloseTime(String closeTime) {
                this.closeTime = closeTime;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getBookNews() {
                return bookNews;
            }

            public void setBookNews(String bookNews) {
                this.bookNews = bookNews;
            }

            public String getRed() {
                return red;
            }

            public void setRed(String red) {
                this.red = red;
            }

            public String getChannelStatus() {
                return channelStatus;
            }

            public void setChannelStatus(String channelStatus) {
                this.channelStatus = channelStatus;
            }

            public String getDayLow() {
                return dayLow;
            }

            public void setDayLow(String dayLow) {
                this.dayLow = dayLow;
            }

            public String getForceLogin() {
                return forceLogin;
            }

            public void setForceLogin(String forceLogin) {
                this.forceLogin = forceLogin;
            }

            public String getCash() {
                return cash;
            }

            public void setCash(String cash) {
                this.cash = cash;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getUserNew() {
                return userNew;
            }

            public void setUserNew(String userNew) {
                this.userNew = userNew;
            }
        }
    }

    public static class FireListBean {
        /**
         * lpushname :
         * cpushname : 垂钓诸天
         * finished : 0
         * type : 0
         * intro : 厌烦了都市的勾心斗角，北风回到乡下的老宅。养几只鸡，几只鸭，想过着采菊东篱下悠然见南山的生活。万万没想到命运给
         * id : 14893588
         * cat3Info : 20000:小说:小说,20019:都市:都市,20020:都市生活:生活
         * author : 道在不可鸣
         * title : 垂钓诸天
         * cover : 14893588
         * categoryInfoV4Slave :
         * catName : 都市
         * totalWords : 662341
         * pushName : 垂钓诸天
         * categoryInfoV4 : 20000:小说:小说,20019:都市:都市,20020:都市生活:生活
         */

        private String lpushname;
        private String cpushname;
        private String finished;
        private String type;
        private String intro;
        private String id;
        private String cat3Info;
        private String author;
        private String title;
        private String cover;
        private String categoryInfoV4Slave;
        private String catName;
        private String totalWords;
        private String pushName;
        private String categoryInfoV4;

        public String getLpushname() {
            return lpushname;
        }

        public void setLpushname(String lpushname) {
            this.lpushname = lpushname;
        }

        public String getCpushname() {
            return cpushname;
        }

        public void setCpushname(String cpushname) {
            this.cpushname = cpushname;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat3Info() {
            return cat3Info;
        }

        public void setCat3Info(String cat3Info) {
            this.cat3Info = cat3Info;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCategoryInfoV4Slave() {
            return categoryInfoV4Slave;
        }

        public void setCategoryInfoV4Slave(String categoryInfoV4Slave) {
            this.categoryInfoV4Slave = categoryInfoV4Slave;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTotalWords() {
            return totalWords;
        }

        public void setTotalWords(String totalWords) {
            this.totalWords = totalWords;
        }

        public String getPushName() {
            return pushName;
        }

        public void setPushName(String pushName) {
            this.pushName = pushName;
        }

        public String getCategoryInfoV4() {
            return categoryInfoV4;
        }

        public void setCategoryInfoV4(String categoryInfoV4) {
            this.categoryInfoV4 = categoryInfoV4;
        }
    }

    public static class FmaleListBean {
        /**
         * lpushname :
         * cpushname : 绯闻萌妻：腹黑老公，头条见
         * finished : 0
         * type : 0
         * intro : 四年，他从一无所有变身神秘财阀的继承人，荣耀归来。四年，她从豪门千金沦落成娱乐圈的小编剧，面临牢狱之灾。“夏长
         * id : 13559994
         * cat3Info : 30000:小说:小说,30020:现代言情:现言,30028:豪门世家:豪门
         * author : 浮屠妖
         * title : 绯闻萌妻：腹黑老公，头条见
         * cover : 13559994
         * categoryInfoV4Slave :
         * catName : 现言
         * totalWords : 1963958
         * pushName : 绯闻萌妻：腹黑老公，头条见
         * categoryInfoV4 : 30000:小说:小说,30020:现代言情:现言,30028:豪门世家:豪门
         */

        private String lpushname;
        private String cpushname;
        private String finished;
        private String type;
        private String intro;
        private String id;
        private String cat3Info;
        private String author;
        private String title;
        private String cover;
        private String categoryInfoV4Slave;
        private String catName;
        private String totalWords;
        private String pushName;
        private String categoryInfoV4;

        public String getLpushname() {
            return lpushname;
        }

        public void setLpushname(String lpushname) {
            this.lpushname = lpushname;
        }

        public String getCpushname() {
            return cpushname;
        }

        public void setCpushname(String cpushname) {
            this.cpushname = cpushname;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat3Info() {
            return cat3Info;
        }

        public void setCat3Info(String cat3Info) {
            this.cat3Info = cat3Info;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCategoryInfoV4Slave() {
            return categoryInfoV4Slave;
        }

        public void setCategoryInfoV4Slave(String categoryInfoV4Slave) {
            this.categoryInfoV4Slave = categoryInfoV4Slave;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTotalWords() {
            return totalWords;
        }

        public void setTotalWords(String totalWords) {
            this.totalWords = totalWords;
        }

        public String getPushName() {
            return pushName;
        }

        public void setPushName(String pushName) {
            this.pushName = pushName;
        }

        public String getCategoryInfoV4() {
            return categoryInfoV4;
        }

        public void setCategoryInfoV4(String categoryInfoV4) {
            this.categoryInfoV4 = categoryInfoV4;
        }
    }

    public static class PubListBean {
        /**
         * lpushname :
         * cpushname : 《太子妃升职记》前传：阿麦从军（全集）
         * finished : 1
         * type : 0
         * intro : 阿麦出生在麦熟时节，为此差点被爹爹取名为“麦兜”。阿麦的父母从另一个时空穿越而来，她本想跟着父母过一番清净无争
         * id : 847304
         * cat3Info : 10000:小说:小说,10011:情感小说:情感,10015:古代情缘:古言
         * author : 鲜橙
         * title : 阿麦从军（全集）（全新修订版）
         * cover : 847304
         * categoryInfoV4Slave : 10000:出版:出版,14300:青春文学:青春,14307:大陆原创:大陆原创
         * catName : 青春
         * totalWords : 548339
         * pushName : 《太子妃升职记》前传：阿麦从军（全集）
         * categoryInfoV4 : 10000:出版:出版,14300:青春文学:青春,14314:古代言情:古言
         */

        private String lpushname;
        private String cpushname;
        private String finished;
        private String type;
        private String intro;
        private String id;
        private String cat3Info;
        private String author;
        private String title;
        private String cover;
        private String categoryInfoV4Slave;
        private String catName;
        private String totalWords;
        private String pushName;
        private String categoryInfoV4;

        public String getLpushname() {
            return lpushname;
        }

        public void setLpushname(String lpushname) {
            this.lpushname = lpushname;
        }

        public String getCpushname() {
            return cpushname;
        }

        public void setCpushname(String cpushname) {
            this.cpushname = cpushname;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat3Info() {
            return cat3Info;
        }

        public void setCat3Info(String cat3Info) {
            this.cat3Info = cat3Info;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCategoryInfoV4Slave() {
            return categoryInfoV4Slave;
        }

        public void setCategoryInfoV4Slave(String categoryInfoV4Slave) {
            this.categoryInfoV4Slave = categoryInfoV4Slave;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTotalWords() {
            return totalWords;
        }

        public void setTotalWords(String totalWords) {
            this.totalWords = totalWords;
        }

        public String getPushName() {
            return pushName;
        }

        public void setPushName(String pushName) {
            this.pushName = pushName;
        }

        public String getCategoryInfoV4() {
            return categoryInfoV4;
        }

        public void setCategoryInfoV4(String categoryInfoV4) {
            this.categoryInfoV4 = categoryInfoV4;
        }
    }

    public static class MaleListBean {
        /**
         * lpushname :
         * cpushname : 逃婚千金大小姐:超品兵王
         * finished : 0
         * type : 0
         * intro : 低调小商贩，邂逅逃婚千金大小姐，无奈卷入是非中，再掀世界雇佣兵之王荣耀：颤抖吧，我来了！
         * id : 813724
         * cat3Info : 20000:小说:小说,20019:都市:都市,20026:异术超能:异能
         * author : 爆护大队长
         * title : 超品兵王
         * cover : 813724
         * categoryInfoV4Slave :
         * catName : 都市
         * totalWords : 3062522
         * pushName : 逃婚千金大小姐:超品兵王
         * categoryInfoV4 : 20000:小说:小说,20019:都市:都市,20026:异术超能:异能
         */

        private String lpushname;
        private String cpushname;
        private String finished;
        private String type;
        private String intro;
        private String id;
        private String cat3Info;
        private String author;
        private String title;
        private String cover;
        private String categoryInfoV4Slave;
        private String catName;
        private String totalWords;
        private String pushName;
        private String categoryInfoV4;

        public String getLpushname() {
            return lpushname;
        }

        public void setLpushname(String lpushname) {
            this.lpushname = lpushname;
        }

        public String getCpushname() {
            return cpushname;
        }

        public void setCpushname(String cpushname) {
            this.cpushname = cpushname;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCat3Info() {
            return cat3Info;
        }

        public void setCat3Info(String cat3Info) {
            this.cat3Info = cat3Info;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCategoryInfoV4Slave() {
            return categoryInfoV4Slave;
        }

        public void setCategoryInfoV4Slave(String categoryInfoV4Slave) {
            this.categoryInfoV4Slave = categoryInfoV4Slave;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getTotalWords() {
            return totalWords;
        }

        public void setTotalWords(String totalWords) {
            this.totalWords = totalWords;
        }

        public String getPushName() {
            return pushName;
        }

        public void setPushName(String pushName) {
            this.pushName = pushName;
        }

        public String getCategoryInfoV4() {
            return categoryInfoV4;
        }

        public void setCategoryInfoV4(String categoryInfoV4) {
            this.categoryInfoV4 = categoryInfoV4;
        }
    }
}
