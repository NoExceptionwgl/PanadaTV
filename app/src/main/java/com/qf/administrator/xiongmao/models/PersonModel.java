package com.qf.administrator.xiongmao.models;

import java.util.List;

/**
 * Created by a on 2016/9/22.
 */
public class PersonModel {


    /**
     * errno : 0
     * errmsg :
     * data : {"info":{"hostinfo":{"rid":29733196,"name":"36E伊伊","avatar":"http://i2.pdim.gs/t019d8dffe8e0ca24ed.png","bamboos":"11676515"},"roominfo":{"id":"322650","name":"最强女刀妹，一生的信仰","type":"1","classification":"英雄联盟","cate":"lol","bulletin":"直播时间9.00-14.00，伊伊开黑群：384230663，新浪微博：LOL伊伊, 商务+q2711820953","person_num":"37931","fans":"123138","pictures":{"img":"http://i9.pdim.gs/45/68f33bf35d1cdf69854330815249e91a/w338/h190.jpg"},"display_type":"1","start_time":"1474509755","end_time":"1474442259","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"},"videoinfo":{"name":"dota","time":"6028","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"bf2c9ad697275da2e4e42d13d39f60a9","plflag":"5_10","status":"2","sign":"sign","ts":"ts","slaveflag":["2_4"],"watermark":"1"},"userinfo":{"rid":0}}}
     * authseq :
     */

    private int errno;
    private String errmsg;
    /**
     * info : {"hostinfo":{"rid":29733196,"name":"36E伊伊","avatar":"http://i2.pdim.gs/t019d8dffe8e0ca24ed.png","bamboos":"11676515"},"roominfo":{"id":"322650","name":"最强女刀妹，一生的信仰","type":"1","classification":"英雄联盟","cate":"lol","bulletin":"直播时间9.00-14.00，伊伊开黑群：384230663，新浪微博：LOL伊伊, 商务+q2711820953","person_num":"37931","fans":"123138","pictures":{"img":"http://i9.pdim.gs/45/68f33bf35d1cdf69854330815249e91a/w338/h190.jpg"},"display_type":"1","start_time":"1474509755","end_time":"1474442259","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"},"videoinfo":{"name":"dota","time":"6028","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"bf2c9ad697275da2e4e42d13d39f60a9","plflag":"5_10","status":"2","sign":"sign","ts":"ts","slaveflag":["2_4"],"watermark":"1"},"userinfo":{"rid":0}}
     */

    private DataBean data;
    private String authseq;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public static class DataBean {
        /**
         * hostinfo : {"rid":29733196,"name":"36E伊伊","avatar":"http://i2.pdim.gs/t019d8dffe8e0ca24ed.png","bamboos":"11676515"}
         * roominfo : {"id":"322650","name":"最强女刀妹，一生的信仰","type":"1","classification":"英雄联盟","cate":"lol","bulletin":"直播时间9.00-14.00，伊伊开黑群：384230663，新浪微博：LOL伊伊, 商务+q2711820953","person_num":"37931","fans":"123138","pictures":{"img":"http://i9.pdim.gs/45/68f33bf35d1cdf69854330815249e91a/w338/h190.jpg"},"display_type":"1","start_time":"1474509755","end_time":"1474442259","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"}
         * videoinfo : {"name":"dota","time":"6028","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"bf2c9ad697275da2e4e42d13d39f60a9","plflag":"5_10","status":"2","sign":"sign","ts":"ts","slaveflag":["2_4"],"watermark":"1"}
         * userinfo : {"rid":0}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * rid : 29733196
             * name : 36E伊伊
             * avatar : http://i2.pdim.gs/t019d8dffe8e0ca24ed.png
             * bamboos : 11676515
             */

            private HostinfoBean hostinfo;
            /**
             * id : 322650
             * name : 最强女刀妹，一生的信仰
             * type : 1
             * classification : 英雄联盟
             * cate : lol
             * bulletin : 直播时间9.00-14.00，伊伊开黑群：384230663，新浪微博：LOL伊伊, 商务+q2711820953
             * person_num : 37931
             * fans : 123138
             * pictures : {"img":"http://i9.pdim.gs/45/68f33bf35d1cdf69854330815249e91a/w338/h190.jpg"}
             * display_type : 1
             * start_time : 1474509755
             * end_time : 1474442259
             * room_type : 1
             * remind_content :
             * remind_time : 0
             * remind_status : 0
             */

            private RoominfoBean roominfo;
            /**
             * name : dota
             * time : 6028
             * stream_addr : {"HD":"1","OD":"1","SD":"1"}
             * room_key : bf2c9ad697275da2e4e42d13d39f60a9
             * plflag : 5_10
             * status : 2
             * sign : sign
             * ts : ts
             * slaveflag : ["2_4"]
             * watermark : 1
             */

            private VideoinfoBean videoinfo;
            /**
             * rid : 0
             */

            private UserinfoBean userinfo;

            public HostinfoBean getHostinfo() {
                return hostinfo;
            }

            public void setHostinfo(HostinfoBean hostinfo) {
                this.hostinfo = hostinfo;
            }

            public RoominfoBean getRoominfo() {
                return roominfo;
            }

            public void setRoominfo(RoominfoBean roominfo) {
                this.roominfo = roominfo;
            }

            public VideoinfoBean getVideoinfo() {
                return videoinfo;
            }

            public void setVideoinfo(VideoinfoBean videoinfo) {
                this.videoinfo = videoinfo;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public static class HostinfoBean {
                private int rid;
                private String name;
                private String avatar;
                private String bamboos;

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getBamboos() {
                    return bamboos;
                }

                public void setBamboos(String bamboos) {
                    this.bamboos = bamboos;
                }
            }

            public static class RoominfoBean {
                private String id;
                private String name;
                private String type;
                private String classification;
                private String cate;
                private String bulletin;
                private String person_num;
                private String fans;
                /**
                 * img : http://i9.pdim.gs/45/68f33bf35d1cdf69854330815249e91a/w338/h190.jpg
                 */

                private PicturesBean pictures;
                private String display_type;
                private String start_time;
                private String end_time;
                private String room_type;
                private String remind_content;
                private String remind_time;
                private String remind_status;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getClassification() {
                    return classification;
                }

                public void setClassification(String classification) {
                    this.classification = classification;
                }

                public String getCate() {
                    return cate;
                }

                public void setCate(String cate) {
                    this.cate = cate;
                }

                public String getBulletin() {
                    return bulletin;
                }

                public void setBulletin(String bulletin) {
                    this.bulletin = bulletin;
                }

                public String getPerson_num() {
                    return person_num;
                }

                public void setPerson_num(String person_num) {
                    this.person_num = person_num;
                }

                public String getFans() {
                    return fans;
                }

                public void setFans(String fans) {
                    this.fans = fans;
                }

                public PicturesBean getPictures() {
                    return pictures;
                }

                public void setPictures(PicturesBean pictures) {
                    this.pictures = pictures;
                }

                public String getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(String display_type) {
                    this.display_type = display_type;
                }

                public String getStart_time() {
                    return start_time;
                }

                public void setStart_time(String start_time) {
                    this.start_time = start_time;
                }

                public String getEnd_time() {
                    return end_time;
                }

                public void setEnd_time(String end_time) {
                    this.end_time = end_time;
                }

                public String getRoom_type() {
                    return room_type;
                }

                public void setRoom_type(String room_type) {
                    this.room_type = room_type;
                }

                public String getRemind_content() {
                    return remind_content;
                }

                public void setRemind_content(String remind_content) {
                    this.remind_content = remind_content;
                }

                public String getRemind_time() {
                    return remind_time;
                }

                public void setRemind_time(String remind_time) {
                    this.remind_time = remind_time;
                }

                public String getRemind_status() {
                    return remind_status;
                }

                public void setRemind_status(String remind_status) {
                    this.remind_status = remind_status;
                }

                public static class PicturesBean {
                    private String img;

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }
            }

            public static class VideoinfoBean {
                private String name;
                private String time;
                /**
                 * HD : 1
                 * OD : 1
                 * SD : 1
                 */

                private StreamAddrBean stream_addr;
                private String room_key;
                private String plflag;
                private String status;
                private String sign;
                private String ts;
                private String watermark;
                private List<String> slaveflag;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public StreamAddrBean getStream_addr() {
                    return stream_addr;
                }

                public void setStream_addr(StreamAddrBean stream_addr) {
                    this.stream_addr = stream_addr;
                }

                public String getRoom_key() {
                    return room_key;
                }

                public void setRoom_key(String room_key) {
                    this.room_key = room_key;
                }

                public String getPlflag() {
                    return plflag;
                }

                public void setPlflag(String plflag) {
                    this.plflag = plflag;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getTs() {
                    return ts;
                }

                public void setTs(String ts) {
                    this.ts = ts;
                }

                public String getWatermark() {
                    return watermark;
                }

                public void setWatermark(String watermark) {
                    this.watermark = watermark;
                }

                public List<String> getSlaveflag() {
                    return slaveflag;
                }

                public void setSlaveflag(List<String> slaveflag) {
                    this.slaveflag = slaveflag;
                }

                public static class StreamAddrBean {
                    private String HD;
                    private String OD;
                    private String SD;

                    public String getHD() {
                        return HD;
                    }

                    public void setHD(String HD) {
                        this.HD = HD;
                    }

                    public String getOD() {
                        return OD;
                    }

                    public void setOD(String OD) {
                        this.OD = OD;
                    }

                    public String getSD() {
                        return SD;
                    }

                    public void setSD(String SD) {
                        this.SD = SD;
                    }
                }
            }

            public static class UserinfoBean {
                private int rid;

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }
            }
        }
    }
}
