package util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import vo.*;

/**
 * 主要用于解析从卡片不同区域 读取到的信息
 *
 * @author acer1
 */
public class ParseUtil {

    /**
     * 卡片04区域的信息，包含：卡类型、卡的版本号、初始化时是发往哪个路段、初始化的日期、卡的内部号等。
     */
    static String info_04;
    /**
     * 卡片05区域的信息，包含：卡的状态（标签卡和通行卡）、上一次的写入卡的时间、路段号、站代号、车道号、员工号，卡的已写次数。
     */
    static String info_05;
    /**
     * 卡片06区域的信息，包含：卡箱号（通行卡）、卡箱循环次数、通行卡在发出前在卡箱内的顺序号、
     * 卡箱的编号、车型（通行卡）、收费员确认的车牌后三位、车牌识别器识别的后三位。
     */
    static String info_06;
    /**
     * 卡片08区域的信息，包含：收费员最终确认的全车牌、车牌识别器识别的车牌颜色。
     */
    static String info_07;

    public static String getInfo_04() {
        return info_04;
    }

    public static String getInfo_05() {
        return info_05;
    }

    public static String getInfo_06() {
        return info_06;
    }

    public static String getInfo_07() {
        return info_07;
    }

    public static void parseCardInfo(Card card) throws ParseException {
        info_04 = parse04(card);
        info_05 = parse05(card);
        info_06 = parse06(card);
    }

    /**
     * 解析卡片中04块的信息
     *
     * @param card 卡片信息
     * @return 解析后的结果
     * @throws ParseException
     */
    public static String parse04(Card card) throws ParseException {
        StringBuilder sb = card.getSection_04_info();                             //获取已经接收到的04区的信息
        int i = sb.lastIndexOf("1003");
        String doc;
        //王国栋 2014-12-18注释  现场测试中发现在06区内部数据中出现1003
//        if(i>0){
//            doc = sb.substring(6, sb.lastIndexOf("1003"));  
//        }else{
//            doc = sb.toString();
//        }
        doc = sb.toString();
        card.setType(doc.substring(0, 2));                                        //获得卡的类型
        card.setVersion(doc.substring(2, 4));
        card.setNetwork(doc.substring(4, 6));
        String dateStr = StringUtil.hexToDateStr(doc.substring(6, 10));           //获取卡初始化的日期
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.SHORT_TIME_PATTERN);
        card.setFmtDate(sdf.parse(dateStr));
        String validDateStr = StringUtil.hexToDateStr(doc.substring(10, 14));     //有效期限（公务卡）
        card.setValidDate(sdf.parse(validDateStr));
        card.setId(doc.substring(14, 19));
        StringBuilder res = new StringBuilder(doc);
        res.delete(32, 34);
        res.replace(11, 14, validDateStr).replace(6, 10, dateStr);
//        card.setSection_04_info(res);
        return res.toString();
    }

    /**
     * 解析卡片中05块的信息
     *
     * @param card 卡片信息
     * @return 解析后的结果
     */
    public static String parse05(Card card) throws ParseException {
        StringBuilder sb = card.getSection_05_info();
        int i = sb.lastIndexOf("1003");
        String doc;
        //王国栋 2014-12-18注释  现场测试中发现在06区内部数据中出现1003
//        if(i>0){
//            doc = sb.substring(6, sb.lastIndexOf("1003"));  
//        }else{
//            doc = sb.toString();
//        }
        doc = sb.toString();
//        String doc = sb.substring(6, sb.lastIndexOf("1003")); //因为获取的信息前面0-5是命令的序号、命令的类型、信息的长度，末尾是1003，中间才是需要的内容
        card.setStatus(doc.substring(0, 2));                                 //通行卡或标签卡的状态
        String dateStr = StringUtil.hexToDateStr(doc.substring(2, 10));          //取出写入卡的的时间
        String laneStr = new String(HexBin.decode(doc.substring(14, 16)));       //取出车道编号的前一个字母；如‘X01’的X
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.FULL_TIME_PATTERN); //将取出的时间进行标准化”YYYYmmDDhhMMss“
        Timestamp date = new Timestamp(sdf.parse(dateStr).getTime());            //先将DateFormat时间转换成Date类型，再转成1970-1-1后到此时间的秒值
        card.setDhm(date);
        String roadId = doc.substring(10, 12);                                   //路段代号
        card.setRoadid(roadId);
        String stationId = doc.substring(12, 14);                                //站代号
        card.setStationid(stationId);
        String laneId = laneStr + doc.substring(16, 18);                         //拼接完整的车道编号
        card.setLaneId(laneId);
        String staffId = doc.substring(18, 24);                                  //员工号，例如是出口道读则是入口发卡道的员工号
        card.setStaffId(staffId);
        String writingNum = doc.substring(24, 30);
        card.setWritingNum(writingNum);
        StringBuilder res = new StringBuilder(doc);
        res.delete(32, 34);
        if (roadId == null) {
//            System.out.println("section05" + res.replace(14, 16, laneStr).replace(2, 10, dateStr).toString());
        }
        res.replace(14, 16, laneStr).replace(2, 10, dateStr);
//        card.setSection_05_info(res);
//        System.out.println("卡片解析类的数据05块============"+card.toString());
        return res.toString();
    }

    /**
     * 解析卡片中06块的信息
     *
     * @param card 卡片信息
     * @return 解析后的结果
     */
    public static String parse06(Card card) {
        StringBuilder sb = card.getSection_06_info();
        System.out.println("getSection_06_info:" + sb);
//        3248100000231003203731373731377A
        int i = sb.lastIndexOf("1003");
        String doc;
        //王国栋 2014-12-18注释  现场测试中发现在06区内部数据中出现1003
//        if(i>0){
//            doc = sb.substring(6, sb.lastIndexOf("1003"));  
//        }else{
//            doc = sb.toString();
//        }
        doc = sb.toString();
//        String doc = sb.substring(6, sb.lastIndexOf("1003"));
        StringBuilder res = new StringBuilder(doc);
        card.setCartId(doc.substring(0, 5));    //获取卡箱号
        card.setCartCycleNum(doc.substring(5, 11));  //获取卡箱循环次数
        String cardOrderNum = doc.substring(11, 14);                             //获取通行卡在卡箱的顺序号
        card.setCscNum(cardOrderNum);
        card.setVehClass(doc.substring(14, 16));   //获取车型
        card.setKeySet(doc.substring(16, 18));
        String vehPlateNum = new String(HexBin.decode(doc.substring(18, 24)));   //收费员确认的车牌后三位
        card.setVehPlateNum(vehPlateNum);
        String lprPlateNum = new String(HexBin.decode(doc.substring(24, 30)));   //获取车牌识别的车牌后三位
        card.setLprPlateNum(lprPlateNum);
        res.delete(32, 34);
        res.replace(18, 24, vehPlateNum);
        res.delete(16, 18);
//        card.setSection_06_info(res);

//        System.out.println("卡片解析类的数据06块==========="+res);
        return res.toString();
    }

    /**
     * 解析07块的内容，即全车牌部分
     *
     * @param card 卡片实体类
     * @return 解析后的结果
     */
    public static String parse07(Card card) {
        StringBuilder sb = card.getSection_08_info();
        int i = sb.lastIndexOf("1003");
        String doc;
//        if (i > 0) {
//            doc = sb.substring(6, sb.lastIndexOf("1003"));
//        } else {
//            doc = sb.toString();
//        }
        doc = sb.toString();
//        String doc = sb.substring(6, sb.lastIndexOf("1003"));
        String fullLpr = "";
        try {
            fullLpr = new String(HexBin.decode(doc.substring(0, 24)), "gbk").trim();
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        card.setFullVehPlateNum(fullLpr);
        String plateColor = new String(HexBin.decode(doc.substring(24, 26)));
        card.setPlateColor(plateColor);
        StringBuilder res = new StringBuilder(doc);
        res.delete(32, 34);
//          System.out.println("卡片解析类的数据08块==========="+card.toString());
        return res.replace(24, 26, plateColor).replace(0, 24, fullLpr).toString();
    }

    /**
     * 将16进制的卡号，转换成10进制的可识别的卡号
     *
     * @param num 获取到的10进制的卡号
     * @return 返回可识别的卡号
     */
    public static String parseCardNo(String num) {
        num = num.replace(" ", "").trim();
        StringBuffer sb = new StringBuffer();
        for (int i = num.length(); i > 0; i = i - 2) {       //先反转字符串
            sb.append(num.substring(i - 2, i));
        }
        long no = LongUtils.parseHexString(sb.toString());      //将16进制的字符串转成数字
        sb = new StringBuffer(Long.toString(no));
//        if(sb.length()<10){                               //如果数字的长度小于10，则在前面补0至10的长度
//            for(int i=0;i<=10-sb.length();i++){
//                sb.insert(0, "0");
//            }
//        }
        return StringUtil.toLength(sb.toString(), 10);
    }

    /**
     * 解析ETC卡内部文件标识为15的信息 包含卡片发行方、卡片类型、卡片的版本、卡片的序列号、卡片的生效日期、卡片的有效截至日期、15文件中的全车牌、
     * 用户类型、绑定标识、车牌的颜色
     *
     * @param card ETC卡实体类
     */
    public static void pare15(CpuCard card) {
        String sb = card.getInfo15();
        try {
            card.setIssuer(sb.substring(0, 16));     //发行方
            card.setCardType(IntegerUtils.parseHexString(sb.substring(16, 18)) + "");              //卡片类型
            card.setCardVersion(sb.substring(18, 20));                //卡片版本
            String serial = sb.substring(20, 40);
            String issuer = card.getIssuer().substring(0, 8);
//            Issuer iss = ParamCacheQuery.queryIssuer(issuer);
//            if (iss != null && iss.getTransNetId() == 1) {//长三角五省一市ETC卡需要进行网络编码转换
//                serial = StringUtil.toLength(iss.getProvinceCode(), 2) + serial.substring(2);
//            }
            card.setCardSerial(serial);                                         //卡片序列号
            card.setStartDate(sb.substring(40, 48));                            //生效日期
            card.setEndDate(sb.substring(48, 56));                              //有效截至日期
            String str = sb.substring(56, 80);
            String plateNum = new String(HexBin.decode(sb.substring(56, 80)), "gbk").trim();
            plateNum = checkSpecialPlateNum(plateNum);//检验车牌中是否有非汉字字母以及数字的字符
            card.setPlateInCard15(plateNum); //15文件中的车牌
            card.setFullVehPlateNum(plateNum);//车辆全车牌以0015文件中车牌为准
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        int i = IntegerUtils.parseHexString(sb.substring(80, 82));//用户类型
        if (i / 10 == 0) {
            card.setUserType("0" + i);
        } else {
            card.setUserType("" + i);
        }
        int color;
        if (card.getCardVersion().startsWith("4")) {//新国标ETC卡
            color = IntegerUtils.parseHexString(sb.substring(82, 84));                  //车牌颜色
            card.setVehClass(IntegerUtils.parseHexString(sb.substring(84, 86)) + "");                           //车型
        } else {//旧国标ETC卡
            card.setBindFlag(IntegerUtils.parseHexString(sb.substring(82, 84)));       //绑定标识
            color = IntegerUtils.parseHexString(sb.substring(84, 86));                  //车牌颜色
        }

        if (color == 0) {
            card.setPlateColor("U");
        } else if (color == 1) {
            card.setPlateColor("Y");
        } else if (color == 2) {
            card.setPlateColor("B");
        } else if (color == 3) {
            card.setPlateColor("W");
        } else {
            card.setPlateColor("");
        }
        //处理部分省份将车牌颜色做为车牌号码首字母的特殊ETC卡
        String plateNum = card.getFullVehPlateNum();
        String col = decodePlateCol(plateNum.substring(0, 1));
        if (col != null) {//车牌号码首字母为车牌颜色
            card.setPlateColor(col);//重置车牌颜色
            card.setFullVehPlateNum(plateNum.substring(1));//重置车牌号码
            card.setPlateInCard15(plateNum.substring(1));//重置车牌号码
        }

    }

    /**
     * 解析ETC卡内部文件标识为19的信息 包含：复合应用类型标识符、记录长度、应用的锁定标识、入口的路段和站，入口车道、入口时间
     * 车型、卡流通状态，标识站，入口收费员工号，入口班次，车牌，出口收费路段和站
     *
     * @param card 卡片实体类
     */
    public static void pare19(CpuCard card) {
        //已经转换的19文件的内容==AA 29 00 4301 0511 01 53FF6667 01 01 000000000000000000 000012 02 CFE645544330303500000000 0000 0000
        String sb = card.getInfo19();
        card.setRoadid(sb.substring(10, 12));         //入口路段
        card.setStationid(sb.substring(12, 14));     //入口站
        String str = sb.substring(14, 16);
        card.setLaneId("E" + StringUtil.hexToNum(sb.substring(14, 16), 2));        //入口车道
        String time = sb.substring(16, 24);          //入口时间
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.FULL_TIME_PATTERN);
        Timestamp date = new Timestamp(LongUtils.parseHexString(time) * 1000);
        card.setDhm(date);                          //入口时间
        if (card.getCardVersion().startsWith("4")) {//新国标卡
            //新国标规定0015文件中记录了车型，车型信息需要从0015文件中获取
        } else {
            //旧国标中车型只有在0019文件中才有
            card.setVehClass(sb.substring(25, 26));      //车型
        }
        card.setLaneStatus(sb.substring(26, 28));        //流通状态 
        String enstaff = sb.substring(46, 52);//解析入口员工号，16进制存储，需解析为10进制
        card.setStaffId(hexToStaffid(enstaff, 6));       //入口员工号,以16进制形式存储,解析为10进制
        card.setEnJobNum(sb.substring(52, 54));       //入口工班号
        try {
            String plateNum = new String(HexBin.decode(sb.substring(54, 78)), "gbk").trim();
            plateNum = checkSpecialPlateNum(plateNum);//检测车牌非法字符
            card.setPlateInCard19(plateNum);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * 将16进制员工号转码为10进制员工号
     *
     * @param hexStaffid 16进制员工号
     * @param len 10进制员工号的长度，不足前面补零
     * @return 10进制员工号
     */
    public static String hexToStaffid(String hexStaffid, int len) {
        int i = IntegerUtils.parseHexString(hexStaffid);
        return StringUtil.toLength(i, len);
    }

    /**
     * 反编译通行卡序列号
     *
     * @param cardSerial
     * @return
     */
    public static String unParseCardNo(String cardSerial) {
        long i = LongUtils.parseString(cardSerial);
        String str = StringUtil.changeLongToHex(i, 8);
        StringBuilder sb = new StringBuilder(8);
        int len = str.length();
        sb.append(str.substring(len - 2, len)).append(str.substring(len - 4, len - 2)).append(str.substring(len - 6, len - 4)).append(str.substring(len - 8, len - 6));
        return sb.toString();
    }

    /**
     * 检测发行方是否是长三角五省一市(上海，江苏，浙江，安徽，福建，江西)卡片
     *
     * @param issuer 发行方前八位
     * @return
     */
    public static boolean checkIssuer(String issuer) {
        List<String> list = new ArrayList();
        list.add("C9CFBAA3");//上海
        list.add("BDADCBD5");//江苏
        list.add("D5E3BDAD");//浙江
        list.add("B0B2BBD5");//安徽
        list.add("B8A3BDA8");//福建
        list.add("BDADCEF7");//江西
        return list.contains(issuer);
    }

    /**
     * 车牌号码由（简体）汉字字母以及数字组成，将车牌中不符合规定的字符删掉，返回修改后的车牌
     *
     * @param plateNum 车牌号码
     * @return 确认符合规定的车牌号码
     */
    public static String checkSpecialPlateNum(String plateNum) {
        if (plateNum == null) {
            return null;
        }
        String str = plateNum;
        String regex1 = "[\u4e00-\u9fa5]";//汉字正则表达式
        String regex2 = "[0-9]+";//正整数正则表达式
        String regex3 = "[A-Za-z]+";//大写字母正则表达式
        str = str.replaceAll(regex1, "");
        str = str.replaceAll(regex2, "");
        str = str.replaceAll(regex3, "");
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            plateNum = plateNum.replace(temp, " ");
        }
        plateNum = plateNum.replaceAll(" ", "").toUpperCase();
        return plateNum;
    }

    /**
     * 将中文车牌颜色转为英文缩写，如蓝—U
     *
     * @param chPlateColor 中文车牌颜色
     * @return 英文车牌颜色缩写
     */
    public static String decodePlateCol(String chPlateColor) {
        if (chPlateColor == null) {
            return null;
        }
        String str = null;
        switch (chPlateColor) {
            case "蓝":
                str = "U";
                break;
            case "黄":
                str = "Y";
                break;
            case "黑":
                str = "B";
                break;
            case "白":
                str = "W";
                break;
            case "红":
                str = "R";
                break;
            case "绿":
                str = "G";
                break;
            default:
                break;

        }
        return str;
    }

}
