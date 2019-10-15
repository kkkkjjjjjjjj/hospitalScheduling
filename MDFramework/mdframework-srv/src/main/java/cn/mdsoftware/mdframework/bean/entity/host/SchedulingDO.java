package cn.mdsoftware.mdframework.bean.entity.host;
//HR_PAIBAN_DICT_HLB
public class SchedulingDO {
    private Integer xh;             //对应数据库xh   序号
    private String jc;              //对应数据库jc    简称
    private String xx;              //对应数据库xx  详细描述
    private String startTime;       //对应数据库starttime   开始时间
    private String endtime;         //对应数据库endTime       结束时间
    private String shijian;         //对应数据库shiJian      时间


    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }



    @Override
    public String toString() {
        return "PaibanDicthlbDO{" +
                "xh=" + xh +
                ", jc='" + jc + '\'' +
                ", xx='" + xx + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", shijian='" + shijian + '\'' +
                '}';
    }
}
