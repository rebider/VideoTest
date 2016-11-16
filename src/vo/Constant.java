package vo;

/**
 * 常量类,用于加载编码中所需要的常量
 *
 * @author Wang Guodong
 */
public class Constant {

    /**
     * 软件版本
     */
    public static final String SOFT_VERSION = "1.0.1600.1";
    /**
     * 软件名称
     */
    public static final String SOFT_NAME = "视频及字符叠加测试";
    
    
    /**
     * 收费类型 0 按最小费额收费 1 按实际路径收费
     */
    public static final Integer CHARGE_TYPE = 0;
    /**
     * 普通车
     */
    public static final Integer NORMAL_VEHICLE = 0;
    /**
     * 内部车(白名单)
     */
    public static final Integer INSIDE_VEH = 1;
    /**
     * 军警车
     */
    public static final Integer MILITARY_VEHICLE = 2;
    /**
     * 紧急车或车队
     */
    public static final Integer EMERGENCY_VEH = 3;
    /**
     * 绿通车
     */
    public static final Integer GREEN_VEH = 4;
    /**
     * 一型车
     */
    public static final int VEHICLE_CLASS_ONE = 1;
    /**
     * 二型车
     */
    public static final int VEHICLE_CLASS_TWO = 2;
    /**
     * 三型车
     */
    public static final int VEHICLE_CLASS_THREE = 3;
    /**
     * 四型车
     */
    public static final int VEHICLE_CLASS_FOUR = 4;
    /**
     * 五型车
     */
    public static final int VEHICLE_CLASS_FIVE = 5;
    /**
     * 六型车
     */
    public static final int VEHICLE_CLASS_SIX = 6;
    /**
     * 七型车
     */
    public static final int VEHICLE_CLASS_SEVEN = 7;
    /**
     * 八型车
     */
    public static final int VEHICLE_CLASS_EIGHT = 8;
    /**
     * 九型车
     */
    public static final int VEHICLE_CLASS_NINE = 9;
    /**
     * 普通路段计重收费标准的基本费率
     */
    public static final double FARE_RATE_ONE = 0.08;
    /**
     * 特殊路段计重收费标准的基本费率
     */
    public static final double FARE_RATE_TWO = 0.09;
    /**
     * 随岳路段计重收费标准的基本费率
     */
    public static final double FARE_RATE_THREE = 0.1;
    
    /**
     * Issued卡已发放
     */
    public static final String TRANSIT_CSC_STATUS_01 = "01";
    /**
     * Issued & precoded 已发放预编码卡
     */
    public static final String TRANSIT_CSC_STATUS_02 = "02";
    /**
     * Issued & maintenance 已发放维修卡 *
     */
    public static final String TRANSIT_CSC_STATUS_03 = "03";
    /**
     * not Issued & in cartidge卡箱内未发放
     */
    public static final String TRANSIT_CSC_STATUS_04 = "04";
    /**
     * not issued & not in cartidge *
     */
    public static final String TRANSIT_CSC_STATUS_05 = "05";
    /**
     * not issued & not in cartidge & precoded
     */
    public static final String TRANSIT_CSC_STATUS_06 = "06";
    /**
     * MiFare Pro卡
     */
    public static final String CARD_TYPE_1 = "1";
    /**
     * Transic CSC通行卡
     */
    public static final String CARD_TYPE_01 = "01";
    /**
     * Identity CSC员工卡
     */
    public static final String CARD_TYPE_03 = "03";
    /**
     * Cartridge CSC 卡箱标签卡
     */
    public static final String CARD_TYPE_04 = "04";
    /**
     * Service CSC
     */
    public static final String CARD_TYPE_05 = "05";
    /**
     * SVC
     */
    public static final String CARD_TYPE_06 = "06";
    /**
     * 出口写卡是默认的卡箱编号
     */
    public static final String DEFAULT_CART_ID = "请装卡箱";
    /**
     * 出口写卡时默认的卡箱循环号
     */
    public static final String DEFAULT_CART_CYCLE_NUMBER = "333333";
    /**
     * 年月日时分秒时间格式
     */
    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";
    /**
     * 年月日时间格式
     */
    public static final String SHORT_TIME_PATTERN = "yyMMdd";
    /**
     * 主机向串口发送数据后的等待时间
     */
    public static final Integer SLEEP_TIME = 10;
    /**
     * ASCII功能符STX(16进制),表示文本开始
     */
    public static final String STX = "02";
    /**
     * ASCII功能符DLE(16进制),表示数据链路转义
     */
    public static final String DLE = "10";
    /**
     * ASCII功能符ETX(16进制),表示文本结束
     */
    public static final String ETS = "03";
    /**
     * 表示数字的正则表达式
     */
    public static final String REGIX_NUM = "\\d+";

    /**
     * 打印机测试指令
     */
    public static final String FEE = "1B 41 01 1B32 1B 4A 0A 1B 4A 0E"
            + "14 1B 4A 1B "
            + "20202020202020202020202020203020202020202020202020202020202020203020202020"
            + "14 1B 4A 1B "
            + "20 20 20 20 2020202020202020 583034 20 20 20 20 20 "//车道  X04
            + "20202020202020202020 30 30 30 30 31 38 20 20 20 20 "//收费员 000018
            + "14 1B 4A 1B"
            + "20 20 20 2020 20 20 20202020202030 31"
            + "202020202020202020 20 20 20 20 20203230303030"
            + "14 1B 4A 1B "//回车换行
            + "20202020202020 202020 "
            + "20202020D4C2D0CEC9BD 20 20 20 20 20 2020 20202020 b1 b1 be a9 b3 c7 "//月形山          //雨花
            + "14 1B 4A 1B "
            + "202020202020202030 30"//某某城市 
            + "1B 4A 0E"
            + "202020202020202020202020202020202020202020202020202020203220202020"//2日有效
            + "14 1B 4A 1B"
            + "2020202020202020202020202020202020 32 30 31 32 2F 31 31 2F 32 30 20 31 30 3A 30 32 1B 4A 0E"//票据打印日期
            + "14 1B 4A 1B "
            + "1B 4A 0E"
            + "1B 4A 0E"
            + "14 1B 4A 1B ";
    /**
     * 串口3初始化指令
     */
    public static final String com3InitiallizeOrder = "\nC151015101510151099109910101010101010101010101010101010101010101010101010101010101010101010101010\r";
    /**
     * 车型1-7的正则表达式
     */
    public static final String REGIX_CLASS = "[1-7]";
    /**
     * 车牌颜色对应数字的正则表达式
     */
    public static String PLATE_COL_OPTION = "^[0-6]$";

    public static final int RESULT = -1;
}
