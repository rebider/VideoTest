package vo;

import java.util.Objects;

/**
 *ETC卡类
 * @author 王国栋 2014-9-6
 */
public class CpuCard extends Card{
    private String issuer;//发行方
    private double balance;//余额
    private String cardType;//卡类型 22储值卡 23记账卡
    private String laneStatus;//车道状态 01-封闭式MTC入口 02-封闭式MTC出口 03-封闭式ETC入口 04-封闭式ETC出口 05-MTC开放式 06-ETC开放式
    private String userType;//用户类型
    private String psamNum;//PSAM卡号码
    private String tacCode;//TAC校验码
    private String termCode;//终端序列号
    private String termTradNo;//终端交易序列号
    private String tradeNo;//交易序列号
    private Double discount;//折扣率
    private String cpuNum;  //cpu号
    private long ibalance1;     //卡片消费前余额
    private long ibalance2;     //卡片消费后余额
    private String info19 ;       //19文件的内容  
    private String info15 ;     //15文件的内容
    private String cardVersion; //卡片版本号
    private String startDate;    //卡片生效时间
    private String endDate;      //卡片有效截止时间
    private String plateInCard15;   //卡片发行时写入15文件的全车牌
    private String plateInCard19;   //卡片中19文件的全车牌
    private int bindFlag;        //绑定标识   0为绑定OBU车牌，1为不绑定
    private String enJobNum;        //入口工班
    private int money;              //消费额（以分为单位）

    public CpuCard() {
    }

    public CpuCard(CpuCard cpuCard) {
        this.balance = cpuCard.getBalance();
        this.cardType = cpuCard.getCardType();
        this.issuer = cpuCard.getIssuer();
        this.laneStatus = cpuCard.getLaneStatus();
        this.psamNum = cpuCard.getPsamNum();
        this.tacCode = cpuCard.getTacCode();
        this.termCode = cpuCard.getTermCode();
        this.termTradNo = cpuCard.getTermTradNo();
        this.tradeNo = cpuCard.getTradeNo();
        this.userType = cpuCard.getUserType();
        this.discount = cpuCard.getDiscount();
        this.plateInCard15 = cpuCard.getPlateInCard15();
        this.plateInCard19 = cpuCard.getPlateInCard19();
        this.info15 = cpuCard.getInfo15();
        this.info19 = cpuCard.getInfo19();
        this.cpuNum = cpuCard.getCpuNum();
        this.ibalance1 = cpuCard.getIbalance1();
        this.ibalance2 = cpuCard.getIbalance2();
        this.cardVersion = cpuCard.getCardVersion();
        this.startDate = cpuCard.getStartDate();
        this.endDate = cpuCard.getEndDate();
        this.bindFlag = cpuCard.getBindFlag();
        this.enJobNum = cpuCard.getEnJobNum();
        this.money = cpuCard.getMoney();
        setCardSerial(cpuCard.getCardSerial());
        setCartCycleNum(cpuCard.getCartCycleNum());
        setCartId(cpuCard.getCartId());
        setCscNum(cpuCard.getCscNum());
        setDhm(cpuCard.getDhm());
        setFmtDate(cpuCard.getFmtDate());
        setFullVehPlateNum(cpuCard.getFullVehPlateNum());
        setId(cpuCard.getId());
        setKeySet(cpuCard.getKeySet());
        setLaneId(cpuCard.getLaneId());
        setLprPlateNum(cpuCard.getLprPlateNum());
        setNetwork(cpuCard.getNetwork());
        setObservationCode(cpuCard.getObservationCode());
        setPlateColor(cpuCard.getPlateColor());
        setRoadid(cpuCard.getRoadid());
        setStaffId(cpuCard.getStaffId());
        setStationid(cpuCard.getStationid());
        setStatus(cpuCard.getStatus());
        setType(cpuCard.getType());
        setValidDate(cpuCard.getValidDate());
        setVehClass(cpuCard.getVehClass());
        setVehPlateNum(cpuCard.getVehPlateNum());
        setVersion(cpuCard.getVersion());
        setWritingNum(cpuCard.getWritingNum());
    }

    public long getIbalance1() {
        return ibalance1;
    }

    public void setIbalance1(long ibalance1) {
        this.ibalance1 = ibalance1;
    }

    public long getIbalance2() {
        return ibalance2;
    }

    public void setIbalance2(long ibalance2) {
        this.ibalance2 = ibalance2;
    }



    public String getInfo19() {
        return info19;
    }

    public void setInfo19(String info19) {
        this.info19 = info19;
    }

    public String getInfo15() {
        return info15;
    }

    public void setInfo15(String info15) {
        this.info15 = info15;
    }

    public String getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(String cpuNum) {
        this.cpuNum = cpuNum;
    }

    public String getCardVersion() {
        return cardVersion;
    }

    public void setCardVersion(String cardVersion) {
        this.cardVersion = cardVersion;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPlateInCard15() {
        return plateInCard15;
    }

    public void setPlateInCard15(String plateInCard15) {
        this.plateInCard15 = plateInCard15;
    }

    public String getPlateInCard19() {
        return plateInCard19;
    }

    public void setPlateInCard19(String plateInCard19) {
        this.plateInCard19 = plateInCard19;
    }


    public int getBindFlag() {
        return bindFlag;
    }

    public void setBindFlag(int bindFlag) {
        this.bindFlag = bindFlag;
    }

    public String getEnJobNum() {
        return enJobNum;
    }

    public void setEnJobNum(String enJobNum) {
        this.enJobNum = enJobNum;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermTradNo() {
        return termTradNo;
    }

    public void setTermTradNo(String termTradNo) {
        this.termTradNo = termTradNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    
    
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getLaneStatus() {
        return laneStatus;
    }

    public void setLaneStatus(String laneStatus) {
        this.laneStatus = laneStatus;
    }

    
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPsamNum() {
        return psamNum;
    }

    public void setPsamNum(String psamNum) {
        this.psamNum = psamNum;
    }

    public String getTacCode() {
        return tacCode;
    }

    public void setTacCode(String tacCode) {
        this.tacCode = tacCode;
    }
    
    @Override
    public void setLane(Lane lane){
        setRoadid(lane.getRoadId());
        setStationid(lane.getStationId());
        setLaneId(lane.getLaneId());
        setLaneStatus(lane.getLaneType()+"");
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CpuCard other = (CpuCard) obj;
        if (!Objects.equals(this.issuer, other.issuer)) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if (!Objects.equals(this.cardType, other.cardType)) {
            return false;
        }
        if (!Objects.equals(this.laneStatus, other.laneStatus)) {
            return false;
        }
        if (!Objects.equals(this.userType, other.userType)) {
            return false;
        }
        if (!Objects.equals(this.psamNum, other.psamNum)) {
            return false;
        }
        if (!Objects.equals(this.tacCode, other.tacCode)) {
            return false;
        }
        if (!Objects.equals(this.termCode, other.termCode)) {
            return false;
        }
        if (!Objects.equals(this.termTradNo, other.termTradNo)) {
            return false;
        }
        if (!Objects.equals(this.discount, other.discount)) {
            return false;
        }
        if (!Objects.equals(this.cpuNum, other.cpuNum)) {
            return false;
        }
        if (this.ibalance1 != other.ibalance1) {
            return false;
        }
        if (this.ibalance2 != other.ibalance2) {
            return false;
        }
        if (!Objects.equals(this.cardVersion, other.cardVersion)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.plateInCard15, other.plateInCard15)) {
            return false;
        }
        if (this.bindFlag != other.bindFlag) {
            return false;
        }
        if (!Objects.equals(this.enJobNum, other.enJobNum)) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.issuer);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.cardType);
        hash = 53 * hash + Objects.hashCode(this.laneStatus);
        hash = 53 * hash + Objects.hashCode(this.userType);
        hash = 53 * hash + Objects.hashCode(this.psamNum);
        hash = 53 * hash + Objects.hashCode(this.tacCode);
        hash = 53 * hash + Objects.hashCode(this.termCode);
        hash = 53 * hash + Objects.hashCode(this.termTradNo);
        hash = 53 * hash + Objects.hashCode(this.discount);
        hash = 53 * hash + Objects.hashCode(this.cpuNum);
        hash = 53 * hash + (int) (this.ibalance1 ^ (this.ibalance1 >>> 32));
        hash = 53 * hash + (int) (this.ibalance2 ^ (this.ibalance2 >>> 32));
        hash = 53 * hash + Objects.hashCode(this.cardVersion);
        hash = 53 * hash + Objects.hashCode(this.startDate);
        hash = 53 * hash + Objects.hashCode(this.endDate);
        hash = 53 * hash + Objects.hashCode(this.plateInCard15);
        hash = 53 * hash + this.bindFlag;
        hash = 53 * hash + Objects.hashCode(this.enJobNum);
        hash = 53 * hash + this.money;
        return hash;
    }

    @Override
    public String toString() {
        return "CpuCard{" +super.toString()+ "issuer=" + issuer + ", balance=" + balance + ", cardType=" + cardType + ", laneStatus=" + laneStatus + ", userType=" + userType + ", psamNum=" + psamNum + ", tacCode=" + tacCode + ", termCode=" + termCode + ", termTradNo=" + termTradNo + ", tradeNo=" + tradeNo + ", discount=" + discount + ", cpuNum=" + cpuNum + ", ibalance1=" + ibalance1 + ", ibalance2=" + ibalance2 + ", info19=" + info19 + ", info15=" + info15 + ", cardVersion=" + cardVersion + ", startDate=" + startDate + ", endDate=" + endDate + ", plateInCard15=" + plateInCard15 + ", plateInCard19=" + plateInCard19 + ", bindFlag=" + bindFlag + ", enJobNum=" + enJobNum + ", money=" + money + '}';
    }

    
}
