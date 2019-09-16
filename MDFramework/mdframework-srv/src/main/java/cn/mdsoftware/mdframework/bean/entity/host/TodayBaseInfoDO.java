package cn.mdsoftware.mdframework.bean.entity.host;

import java.util.Date;

public class TodayBaseInfoDO {
    private static final long serialVersionUID = 1L;
    private String id;                 //对应数据库id
    private String gongHao;             //对应数据库gonghao    职工号
    private String name;                //对应数据库name   姓名
    private String sex;                 //对应数据库sex   性别
    private String height;              //对应数据库heigtht   身高
    private String nation;              //对应数据库nation
    private String claezez;             //对应数据库class   身份类别
    private String cardNo;              //对应数据库card_no
    private Date birthday;              //对应数据库birthday   出生日期
    private String mianMao;             //对应数据库mianmao   政治面貌
    private String job;                 //对应数据库job    职务
    private Date jobDate;              //对应数据库job_date   职务时间
    private String shenFen;             //对应数据库shenfen   身份类别
    private String jsType;             //对应数据库js_type   结束时间
    private Date jsDate;               //对应数据库js_date  职称时间
    private String jobNo;              //对应数据库job_no
    private Date workDate;             //对应数据库work_date    参加工作时间
    private Date inDate;               //对应数据库in_date   入院时间
    private Date outDate;              //对应数据库out_date  入科时间
    private String hunYin;              //对应数据库hunyin   婚姻状况
    private String yunQing;             //对应数据库yunqing  孕情
    private String tel;                 //对应数据库tel   联系电话
    private String jiGuan;              //对应数据库jiguan   籍贯
    private String jobSx;              //对应数据库job_sx   职务属性
    private String tiJiao;              //对应数据库tijiao  提交
    private Date tiJiaoDate;            //对应数据库tijiaodate   提交时间
    private String zTiJiao;             //对应数据库ztijiao     护士长提交
    private String zGongHao;            //对应数据库zgonghao    护士长工号
    private Date zTiJiaoDate;           //对应数据库ztijiaodate    护士长提交日期
    private String Lzyy;                //对应数据库lzyy     离职原因
    private Date lzDate;                //对应数据库lzdate   离职时间
    private String zhaoPian;            //对应数据库zhaopian   照骗
    private String xueHui;              //对应数据库xuehui
    private String zhuanKe;             //对应数据库zhuanke  专科


    @Override
    public String toString() {
        return "TodayBaseInfoDO{" +
                "id='" + id + '\'' +
                ", gongHao='" + gongHao + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height='" + height + '\'' +
                ", nation='" + nation + '\'' +
                ", claezez='" + claezez + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", birthday=" + birthday +
                ", mianMao='" + mianMao + '\'' +
                ", job='" + job + '\'' +
                ", jobDate=" + jobDate +
                ", shenFen='" + shenFen + '\'' +
                ", jsType='" + jsType + '\'' +
                ", jsDate=" + jsDate +
                ", jobNo='" + jobNo + '\'' +
                ", workDate=" + workDate +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", hunYin='" + hunYin + '\'' +
                ", yunQing='" + yunQing + '\'' +
                ", tel='" + tel + '\'' +
                ", jiGuan='" + jiGuan + '\'' +
                ", jobSx='" + jobSx + '\'' +
                ", tiJiao='" + tiJiao + '\'' +
                ", tiJiaoDate=" + tiJiaoDate +
                ", zTiJiao='" + zTiJiao + '\'' +
                ", zGongHao='" + zGongHao + '\'' +
                ", zTiJiaoDate=" + zTiJiaoDate +
                ", Lzyy='" + Lzyy + '\'' +
                ", lzDate=" + lzDate +
                ", zhaoPian='" + zhaoPian + '\'' +
                ", xueHui='" + xueHui + '\'' +
                ", zhuanKe='" + zhuanKe + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGongHao() {
        return gongHao;
    }

    public void setGongHao(String gongHao) {
        this.gongHao = gongHao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String natton) {
        this.nation = natton;
    }

    public String getClaezez() {
        return claezez;
    }

    public void setClaezez(String claezez) {
        this.claezez = claezez;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMianMao() {
        return mianMao;
    }

    public void setMianMao(String mianMao) {
        this.mianMao = mianMao;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getShenFen() {
        return shenFen;
    }

    public void setShenFen(String shenFen) {
        this.shenFen = shenFen;
    }

    public String getJsType() {
        return jsType;
    }

    public void setJsType(String jsType) {
        this.jsType = jsType;
    }

    public Date getJsDate() {
        return jsDate;
    }

    public void setJsDate(Date jsDate) {
        this.jsDate = jsDate;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getHunYin() {
        return hunYin;
    }

    public void setHunYin(String hunYin) {
        this.hunYin = hunYin;
    }

    public String getYunQing() {
        return yunQing;
    }

    public void setYunQing(String yunQing) {
        this.yunQing = yunQing;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJiGuan() {
        return jiGuan;
    }

    public void setJiGuan(String jiGuan) {
        this.jiGuan = jiGuan;
    }

    public String getJobSx() {
        return jobSx;
    }

    public void setJobSx(String jobSx) {
        this.jobSx = jobSx;
    }

    public String getTiJiao() {
        return tiJiao;
    }

    public void setTiJiao(String tiJiao) {
        this.tiJiao = tiJiao;
    }

    public Date getTiJiaoDate() {
        return tiJiaoDate;
    }

    public void setTiJiaoDate(Date tiJiaoDate) {
        this.tiJiaoDate = tiJiaoDate;
    }

    public String getzTiJiao() {
        return zTiJiao;
    }

    public void setzTiJiao(String zTiJiao) {
        this.zTiJiao = zTiJiao;
    }

    public String getzGongHao() {
        return zGongHao;
    }

    public void setzGongHao(String zGongHao) {
        this.zGongHao = zGongHao;
    }

    public Date getzTiJiaoDate() {
        return zTiJiaoDate;
    }

    public void setzTiJiaoDate(Date zTiJiaoDate) {
        this.zTiJiaoDate = zTiJiaoDate;
    }

    public String getLzyy() {
        return Lzyy;
    }

    public void setLzyy(String lzyy) {
        Lzyy = lzyy;
    }

    public Date getLzDate() {
        return lzDate;
    }

    public void setLzDate(Date lzDate) {
        this.lzDate = lzDate;
    }

    public String getZhaoPian() {
        return zhaoPian;
    }

    public void setZhaoPian(String zhaoPian) {
        this.zhaoPian = zhaoPian;
    }

    public String getXueHui() {
        return xueHui;
    }

    public void setXueHui(String xueHui) {
        this.xueHui = xueHui;
    }

    public String getZhuanKe() {
        return zhuanKe;
    }

    public void setZhuanKe(String zhuanKe) {
        this.zhuanKe = zhuanKe;
    }
}
