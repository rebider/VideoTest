package vo;

import java.util.Date;

/**
 * 卡箱信息类
 *
 * @author 王国栋
 */
public class CartInfo {

    private String cardSerial;//标签卡序列号
    private String cartId;//标签卡编号
    private String totalCardQty;//卡箱容量
    private String cardOrderNum;//卡箱内卡顺序号（即当前卡箱内卡数量）
    /**
     * 出口装入卡箱时卡箱循环号+1，取出卡箱时卡箱循环号不变 入口装入卡箱时卡箱循环号不变，取出卡箱时卡箱循环号+1
     */
    private String cartCycleNum;//卡箱循环号
    private String cartStaffId;//卡箱传递员
    private short status;//卡箱状态 1车道内使用 2库存（站或分中心或中心）3站间或站与分中心间流动 4站内流通 8.分中心间或分中心和中心
    private Date curOpTime;//最近一次接发时间
    private short curOpRoadid;//最近一次接发路段
    private short curOpStationid;//最近一次接发站
    private String curOpLaneNo;//最近一次接发车道
    private String spare;//备用

    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCurOpTime() {
        return curOpTime;
    }

    public void setCurOpTime(Date curOpTime) {
        this.curOpTime = curOpTime;
    }

    public short getCurOpRoadid() {
        return curOpRoadid;
    }

    public void setCurOpRoadid(short curOpRaodid) {
        this.curOpRoadid = curOpRaodid;
    }

    public short getCurOpStationid() {
        return curOpStationid;
    }

    public void setCurOpStationid(short curOpStationid) {
        this.curOpStationid = curOpStationid;
    }

    public String getCurOpLaneNo() {
        return curOpLaneNo;
    }

    public void setCurOpLaneNo(String curOpLaneNo) {
        this.curOpLaneNo = curOpLaneNo;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public String getCartStaffId() {
        return cartStaffId;
    }

    public void setCartStaffId(String cartStaffId) {
        this.cartStaffId = cartStaffId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getTotalCardQty() {
        return totalCardQty;
    }

    public void setTotalCardQty(String totalCardQty) {
        this.totalCardQty = totalCardQty;
    }

    public String getCardOrderNum() {
        return cardOrderNum;
    }

    public void setCardOrderNum(String cardOrderNum) {
        this.cardOrderNum = cardOrderNum;
    }

    public String getCartCycleNum() {
        return cartCycleNum;
    }

    public void setCartCycleNum(String cartCycleNum) {
        this.cartCycleNum = cartCycleNum;
    }

    @Override
    public String toString() {
        return "CartInfo{" + "cartId=" + cartId + ", totalCardQty=" + totalCardQty + ", cardOrderNum=" + cardOrderNum + ", cartCycleNum=" + cartCycleNum + ", cartStaffId=" + cartStaffId + '}';
    }
}
