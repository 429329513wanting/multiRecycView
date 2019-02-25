package com.sendinfo.mymulity;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 *     author : ghwang
 *     e-mail : 429329513@qq.com
 *     time   : 2018/05/04
 *     desc   :
 * </pre>
 */

public class HomeData implements Serializable {


    private List<CarouselBean> carousel;
    private List<HouseBean> house;
    private List<ReservationBean> reservation;
    private List<NewsBean> news;

    public List<CarouselBean> getCarousel() {
        return carousel;
    }

    public void setCarousel(List<CarouselBean> carousel) {
        this.carousel = carousel;
    }

    public List<HouseBean> getHouse() {
        return house;
    }

    public void setHouse(List<HouseBean> house) {
        this.house = house;
    }

    public List<ReservationBean> getReservation() {
        return reservation;
    }

    public void setReservation(List<ReservationBean> reservation) {
        this.reservation = reservation;
    }

    public List<NewsBean> getNews() {
        return news;
    }

    public void setNews(List<NewsBean> news) {
        this.news = news;
    }

    public static class CarouselBean {
        /**
         * id : 14
         * car_img : /Uploads/img/20180503/5aea72b0d1ba2.jpg
         * cityid : 0
         * type : 1
         * sort : 0
         * url :
         * remark :
         * status : 1
         * createtime : 1525314227
         * updatetime : 1525314227
         */

        private String id;
        private String car_img;
        private String cityid;
        private String type;
        private String sort;
        private String url;
        private String remark;
        private String status;
        private String createtime;
        private String updatetime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCar_img() {
            return car_img;
        }

        public void setCar_img(String car_img) {
            this.car_img = car_img;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }

    public static class HouseBean {
        /**
         * id : 516
         * title : 富元雅苑西门·33栋2单元2404室SZ-00168
         * browse : 83
         * houseid : 373
         * price : 880.00
         * roombg : /Uploads/img/20171123/5a167f3aae11a.jpg
         * typeid : 2
         * cityid : 178
         * areaid : 181
         * labelid : 2,3,4
         * label : [{"name":"精装白领专享"},{"name":"真房源"},{"name":"家具家电齐全"}]
         * typename : 合租
         * area : 苏州市相城区
         */

        private String id;
        private String title;
        private String browse;
        private String houseid;
        private String price;
        private String roombg;
        private String typeid;
        private String cityid;
        private String areaid;
        private String labelid;
        private String typename;
        private String area;
        private List<LabelBean> label;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrowse() {
            return browse;
        }

        public void setBrowse(String browse) {
            this.browse = browse;
        }

        public String getHouseid() {
            return houseid;
        }

        public void setHouseid(String houseid) {
            this.houseid = houseid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRoombg() {
            return roombg;
        }

        public void setRoombg(String roombg) {
            this.roombg = roombg;
        }

        public String getTypeid() {
            return typeid;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getAreaid() {
            return areaid;
        }

        public void setAreaid(String areaid) {
            this.areaid = areaid;
        }

        public String getLabelid() {
            return labelid;
        }

        public void setLabelid(String labelid) {
            this.labelid = labelid;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public List<LabelBean> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBean> label) {
            this.label = label;
        }

        public static class LabelBean {
            /**
             * name : 精装白领专享
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class ReservationBean {
        /**
         * id : 581
         * title : 鑫苑湖居世家51栋101室SZ-00025
         * browse : 255
         * houseid : 340
         * price : 940.00
         * roombg : /Uploads/img/20171215/5a333ecdec86b.jpg
         * direction : 南
         * acreage : 22.0
         * is_loan : 1
         * is_self : 1
         * labelid : 1,2,4,5
         * housekeeperid : 13
         * housetypeid : 14
         * label : [{"name":"精装白领专享"},{"name":"地铁轻轨房"},{"name":"精装单间"},{"name":"真房源"}]
         * housetype :  四室二厅二卫
         * roompic : [{"pic":"/Uploads/img/20171215/5a333eda0b758.jpg","type":"1"},{"pic":"/Uploads/img/20171215/5a333edbc6611.jpg","type":"1"},{"pic":"/Uploads/img/20171215/5a333ed8356bb.jpg","type":"1"}]
         */

        private String id;
        private String title;
        private String browse;
        private String houseid;
        private String price;
        private String roombg;
        private String direction;
        private String acreage;
        private String is_loan;
        private String is_self;
        private String labelid;
        private String housekeeperid;
        private String housetypeid;
        private String housetype;
        private List<LabelBeanX> label;
        private List<RoompicBean> roompic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrowse() {
            return browse;
        }

        public void setBrowse(String browse) {
            this.browse = browse;
        }

        public String getHouseid() {
            return houseid;
        }

        public void setHouseid(String houseid) {
            this.houseid = houseid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRoombg() {
            return roombg;
        }

        public void setRoombg(String roombg) {
            this.roombg = roombg;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getAcreage() {
            return acreage;
        }

        public void setAcreage(String acreage) {
            this.acreage = acreage;
        }

        public String getIs_loan() {
            return is_loan;
        }

        public void setIs_loan(String is_loan) {
            this.is_loan = is_loan;
        }

        public String getIs_self() {
            return is_self;
        }

        public void setIs_self(String is_self) {
            this.is_self = is_self;
        }

        public String getLabelid() {
            return labelid;
        }

        public void setLabelid(String labelid) {
            this.labelid = labelid;
        }

        public String getHousekeeperid() {
            return housekeeperid;
        }

        public void setHousekeeperid(String housekeeperid) {
            this.housekeeperid = housekeeperid;
        }

        public String getHousetypeid() {
            return housetypeid;
        }

        public void setHousetypeid(String housetypeid) {
            this.housetypeid = housetypeid;
        }

        public String getHousetype() {
            return housetype;
        }

        public void setHousetype(String housetype) {
            this.housetype = housetype;
        }

        public List<LabelBeanX> getLabel() {
            return label;
        }

        public void setLabel(List<LabelBeanX> label) {
            this.label = label;
        }

        public List<RoompicBean> getRoompic() {
            return roompic;
        }

        public void setRoompic(List<RoompicBean> roompic) {
            this.roompic = roompic;
        }

        public static class LabelBeanX {
            /**
             * name : 精装白领专享
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class RoompicBean {
            /**
             * pic : /Uploads/img/20171215/5a333eda0b758.jpg
             * type : 1
             */

            private String pic;
            private String type;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class NewsBean {
        /**
         * id : 1189
         * new_img : /Uploads/img/20180503/5aeab98f41058.jpg
         * title : 我们需要怎样的五四青年节
         * summary : 只有当每个青年人都能够认识到这样的基本价值，都清楚看到自己的本职工作的意义，才能够不断奉献，不断呈现出一个新的天地。
         */

        private String id;
        private String new_img;
        private String title;
        private String summary;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNew_img() {
            return new_img;
        }

        public void setNew_img(String new_img) {
            this.new_img = new_img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
