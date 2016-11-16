package vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author jelly
 */
public class Card {

    private String cardSerial;//卡片序列号
    private String type;//卡片类型
    private String version;//卡片初始化版本号
    private String network;//卡片所用路段
    private Date fmtDate;//卡片初始化日期（YMD）
    private Date validDate;//卡片有效期（YMD）（储值卡）
    private String id;//卡箱标签卡对应标签卡卡号，员工卡对应员工号，公务卡对应卡号
    private String status;//卡状态
    private Timestamp dhm;//卡片上一次使用的时间（YMD DHM）
    private String roadid;//上一次使用时的路段号
    private String stationid;//上一次使用时的收费站号
    private String laneId;//上一次使用时的车道号
    private String staffId;//上一次使用时的员工号（通行卡，卡箱标签卡，公务卡，储值卡）
    private String writingNum;//写卡次数
    private String cartId;//所属卡箱标签卡卡号（通行卡）
    private String cartCycleNum;//卡箱循环次数（通行卡，卡箱标签卡）
    private String cscNum;//卡箱内的第几张卡（通行卡）或卡箱内的卡数量（卡箱标签卡）
    private String vehClass;//车型(通行卡)
    private String keySet;//保留字段
    private String vehPlateNum;//上一次使用时收费员确认车牌后三位(通行卡，公务卡)
    private String lprPlateNum;//上一次使用时车牌识别车牌后三位(通行卡)
    private String fullVehPlateNum;//上一次使用时收费员确认全车牌(通行卡)
    private String plateColor;//车牌颜色
    private String observationCode = "0";//卡观察码 0正常 1 通行卡状态异常 2 超时 3 车型差异 4 车牌差异  5 车型车牌不符 6 U型车两小时之内 7 U型车两小时之外 8 无卡 9 不可读卡 10更改车型 11 更改车种 12残卡 13小于最小行程时间
    private StringBuilder section_04_info;
    private StringBuilder section_05_info;
    private StringBuilder section_06_info;
    private StringBuilder section_08_info;

    public Card() {
    }

    public Card(Card card) {
        cardSerial = card.getCardSerial();
        cartCycleNum = card.getCartCycleNum();
        cartId = card.getCartId();
        cscNum = card.getCscNum();
        dhm = card.getDhm();
        fmtDate = card.getFmtDate();
        fullVehPlateNum = card.getFullVehPlateNum();
        id = card.getId();
        keySet = card.getKeySet();
        laneId = card.getLaneId();
        lprPlateNum = card.getLprPlateNum();
        network = card.getNetwork();
        observationCode = card.getObservationCode();
        plateColor = card.getPlateColor();
        roadid = card.getRoadid();
        staffId = card.getStaffId();
        stationid = card.getStationid();
        status = card.getStatus();
        type = card.getType();
        validDate = card.getValidDate();
        vehClass = card.getVehClass();
        vehPlateNum = card.getVehPlateNum();
        version = card.getVersion();
        writingNum = card.getWritingNum();
        section_04_info = card.getSection_04_info();
        section_05_info = card.getSection_05_info();
        section_06_info = card.getSection_06_info();
        section_08_info = card.getSection_08_info();
    }

    public StringBuilder getSection_04_info() {
        return section_04_info;
    }

    public void setSection_04_info(StringBuilder section_04_info) {
        this.section_04_info = section_04_info;
    }

    public StringBuilder getSection_05_info() {
        return section_05_info;
    }

    public void setSection_05_info(StringBuilder section_05_info) {
        this.section_05_info = section_05_info;
    }

    public StringBuilder getSection_06_info() {
        return section_06_info;
    }

    public void setSection_06_info(StringBuilder section_06_info) {
        this.section_06_info = section_06_info;
    }

    public StringBuilder getSection_08_info() {
        return section_08_info;
    }

    public void setSection_08_info(StringBuilder section_07_info) {
        this.section_08_info = section_07_info;
    }

    public String getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor;
    }

    public String getObservationCode() {
        return observationCode;
    }

    public void setObservationCode(String observationCode) {
        this.observationCode = observationCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Date getFmtDate() {
        return fmtDate;
    }

    public void setFmtDate(Date fmtDate) {
        this.fmtDate = fmtDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDhm() {
        return dhm;
    }

    public void setDhm(Timestamp dhm) {
        this.dhm = dhm;
    }

    public String getRoadid() {
        return roadid;
    }

    public void setRoadid(String roadid) {
        this.roadid = roadid;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid;
    }

    public String getLaneId() {
        return laneId;
    }

    public void setLaneId(String laneId) {
        this.laneId = laneId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getWritingNum() {
        return writingNum;
    }

    public void setWritingNum(String writingNum) {
        this.writingNum = writingNum;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCartCycleNum() {
        return cartCycleNum;
    }

    public void setCartCycleNum(String cartCycleNum) {
        this.cartCycleNum = cartCycleNum;
    }

    public String getCscNum() {
        return cscNum;
    }

    public void setCscNum(String cscNum) {
        this.cscNum = cscNum;
    }

    public String getVehClass() {
        return vehClass;
    }

    public void setVehClass(String vehClass) {
        this.vehClass = vehClass;
    }

    public String getKeySet() {
        return keySet;
    }

    public void setKeySet(String keySet) {
        this.keySet = keySet;
    }

    public String getVehPlateNum() {
        return vehPlateNum;
    }

    public void setVehPlateNum(String vehPlateNum) {
        this.vehPlateNum = vehPlateNum;
    }

    public String getLprPlateNum() {
        return lprPlateNum;
    }

    public void setLprPlateNum(String lprPlateNum) {
        this.lprPlateNum = lprPlateNum;
    }

    public String getFullVehPlateNum() {
        return fullVehPlateNum;
    }

    public void setFullVehPlateNum(String fullVehPlateNum) {
        this.fullVehPlateNum = fullVehPlateNum;
    }

    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    public void setLane(Lane lane) {
        setRoadid(lane.getRoadId());
        setStationid(lane.getStationId());
        setLaneId(lane.getLaneId());
    }

    public void setCartInfo(CartInfo cartInfo) {
        this.cartId = cartInfo.getCartId();
        this.cartCycleNum = cartInfo.getCartCycleNum();
        this.cscNum = cartInfo.getCardOrderNum();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cardSerial);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.version);
        hash = 53 * hash + Objects.hashCode(this.network);
        hash = 53 * hash + Objects.hashCode(this.fmtDate);
        hash = 53 * hash + Objects.hashCode(this.validDate);
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.status);
        hash = 53 * hash + Objects.hashCode(this.dhm);
        hash = 53 * hash + Objects.hashCode(this.roadid);
        hash = 53 * hash + Objects.hashCode(this.stationid);
        hash = 53 * hash + Objects.hashCode(this.laneId);
        hash = 53 * hash + Objects.hashCode(this.staffId);
        hash = 53 * hash + Objects.hashCode(this.writingNum);
        hash = 53 * hash + Objects.hashCode(this.cartId);
        hash = 53 * hash + Objects.hashCode(this.cartCycleNum);
        hash = 53 * hash + Objects.hashCode(this.cscNum);
        hash = 53 * hash + Objects.hashCode(this.vehClass);
        hash = 53 * hash + Objects.hashCode(this.keySet);
        hash = 53 * hash + Objects.hashCode(this.vehPlateNum);
        hash = 53 * hash + Objects.hashCode(this.lprPlateNum);
        hash = 53 * hash + Objects.hashCode(this.fullVehPlateNum);
        hash = 53 * hash + Objects.hashCode(this.plateColor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.cardSerial, other.cardSerial)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.network, other.network)) {
            return false;
        }
        if (!Objects.equals(this.fmtDate, other.fmtDate)) {
            return false;
        }
        if (!Objects.equals(this.validDate, other.validDate)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.dhm, other.dhm)) {
            return false;
        }
        if (!Objects.equals(this.roadid, other.roadid)) {
            return false;
        }
        if (!Objects.equals(this.stationid, other.stationid)) {
            return false;
        }
        if (!Objects.equals(this.laneId, other.laneId)) {
            return false;
        }
        if (!Objects.equals(this.staffId, other.staffId)) {
            return false;
        }
        if (!Objects.equals(this.writingNum, other.writingNum)) {
            return false;
        }
        if (!Objects.equals(this.cartId, other.cartId)) {
            return false;
        }
        if (!Objects.equals(this.cartCycleNum, other.cartCycleNum)) {
            return false;
        }
        if (!Objects.equals(this.cscNum, other.cscNum)) {
            return false;
        }
        if (!Objects.equals(this.vehClass, other.vehClass)) {
            return false;
        }
        if (!Objects.equals(this.keySet, other.keySet)) {
            return false;
        }
        if (!Objects.equals(this.vehPlateNum, other.vehPlateNum)) {
            return false;
        }
        if (!Objects.equals(this.lprPlateNum, other.lprPlateNum)) {
            return false;
        }
        if (!Objects.equals(this.fullVehPlateNum, other.fullVehPlateNum)) {
            return false;
        }
        if (!Objects.equals(this.plateColor, other.plateColor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Card{" + "cardSerial=" + cardSerial + ", type=" + type + ", version=" + version + ", network=" + network + ", fmtDate=" + fmtDate + ", validDate=" + validDate + ", id=" + id + ", status=" + status + ", dhm=" + dhm + ", roadid=" + roadid + ", stationid=" + stationid + ", laneId=" + laneId + ", staffId=" + staffId + ", writingNum=" + writingNum + ", cartId=" + cartId + ", cartCycleNum=" + cartCycleNum + ", cscNum=" + cscNum + ", vehClass=" + vehClass + ", keySet=" + keySet + ", vehPlateNum=" + vehPlateNum + ", lprPlateNum=" + lprPlateNum + ", fullVehPlateNum=" + fullVehPlateNum + ", plateColor=" + plateColor + ", observationCode=" + observationCode + '}';
    }
}
