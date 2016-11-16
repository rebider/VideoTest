package tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TooManyListenersException;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;
import org.apache.log4j.Logger;
import util.IntegerUtils;
import util.SetCOMs;

/**
 * 用于控制与字符叠加器通信的实体类
 *
 * @author
 */
public class VideoInstruction implements Runnable, SerialPortEventListener {

    Logger logger = Logger.getLogger(VideoInstruction.class.getName());
    private String portName;//串口名
    private int baudRate;//波特率
    private int dataBits;//数据位
    private int stopBits;//停止位
    private int parity;//校验位
    private int logLevel;//日志级别
    private InputStream input;//串口数据读取流
    private OutputStream output;//串口数据输出流
    private Thread thread;//控制字符叠加器的线程
    SerialPort port;

    /**
     * 字符叠加器初始化
     */
    public void init() {
        try {
            String info = SetCOMs.getVi();
            if (info != null) {
                logger.info("启用字符叠加器：" + info);
                String[] buffer = info.split(",");
                portName = buffer[0];
                baudRate = IntegerUtils.parseString(buffer[1]);
                dataBits = IntegerUtils.parseString(buffer[2]);
                stopBits = IntegerUtils.parseString(buffer[3]);
                parity = IntegerUtils.parseString(buffer[4]);
                logLevel = IntegerUtils.parseString(buffer[6]);
                //开启串口
                port = (SerialPort) CommPortIdentifier.getPortIdentifier(portName).open("video", 2000);
                port.setDTR(true);
                port.setRTS(true);
                port.notifyOnDataAvailable(true);
                port.setSerialPortParams(baudRate, dataBits, stopBits, parity);
                port.addEventListener(this);
                input = port.getInputStream();
                output = port.getOutputStream();
                thread = new Thread(this);
                thread.start();
            }
        } catch (NoSuchPortException | UnsupportedCommOperationException | PortInUseException | TooManyListenersException | IOException ex) {
            logger.info("字符叠加器初始化失败", ex);
        }

    }

    /**
     * 字符叠加显示车道号
     *
     * @param lane 车道号
     */
    public void showLane(String lane) {
        String info = "L" + lane;
        sendOrder(info);
    }

    /**
     * 隐藏车道号（接口未提供方法，灵活利用显示车道号方法实现）
     */
    public void hideLane() {
        showLane("   ");
    }

    /**
     * 更新当前日期yyyy-MM-DD 要求：每天至少在0：00时发1次日期更新。
     */
    public void showDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//数据格式中无短线连接
        String strDate = sdf.format(date);
        sendOrder("D" + strDate);
    }

    /**
     * 更新当前时间hh:mm:ss 要求：每1小时至少发1次时间更新。
     */
    public void showTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String strTime = sdf.format(date);
        sendOrder("T" + strTime);
    }

    /**
     * 显示收费员ID号
     *
     * @param staffId 收费员ID号
     */
    public void showStaff(String staffId) {
        String order = "N" + staffId;
        sendOrder(order);
    }

    /**
     * 清楚收费员ID号
     */
    public void hideStaff() {
        String order = "b";
        sendOrder(order);
    }

    /**
     * 显示入口站名
     *
     * @param entry 入口收费站为4位数字，取值范围0000～9999，其他的数字无效
     */
    public void showEntry(String entry) {
        String order = "E" + entry;
        sendOrder(order);
    }

    /**
     * 清楚入口收费站
     */
    public void hideEntry() {
        String order = "E0000";
        sendOrder(order);
    }

    /**
     * 显示车型和费额
     *
     * @param vehClass 车型 2位数字，表示车型
     * @param fare 费额 4位数字，表示费额
     */
    public void showVeh(String vehClass, String fare) {
        if (vehClass == null) {
            vehClass = "";
        }
        if (fare == null) {
            fare = "";
        }
        while (vehClass.length() < 2) {
            vehClass = "0" + vehClass;
        }
        int index = fare.indexOf(".");
        if (index > 0) {
            fare = fare.substring(0, index);
        }
        while (fare.length() < 4) {
            fare = " " + fare;
        }
        if (fare.length() > 4) {
            fare = fare.substring(0, 4);
        }
        String order = "F" + vehClass + fare;
        sendOrder(order);
    }

    /**
     * 清除车型和费额
     */
    public void hideVeh() {
        String order = "B";
        sendOrder(order);
    }

    /**
     * 只显示车型
     *
     * @param vehClass 车型
     */
    public void showVehClass(String vehClass) {
        showVeh(vehClass, "    ");
    }

    /**
     * 显示车类（车种）
     *
     * @param vehType 车类（车种）
     */
    public void showVehType(String vehType) {
        if (vehType == null) {
            return;
        }
        while (vehType.length() < 2) {
            vehType = "0" + vehType;
        }
        String order = "t" + vehType;
        sendOrder(order);
    }

    /**
     * 隐藏车类（车种）
     */
    public void hideVehType() {
        String order = "C";
        sendOrder(order);
    }

    /**
     * 显示车牌号(3位0～9数字)
     *
     * @param plate 车牌号 3位0～9数字,若不是3位数字，需要对其进行提取，取其后三位数字，不足补0
     */
    public void showPlate(String plate) {
        if (plate == null) {
            plate = "000";
        }
        String tempPlate = plate.replaceAll("\\D", "");//删除车牌中的非数字
        while (tempPlate.length() < 3) {//车牌补足三位
            tempPlate = "0" + tempPlate;
        }
        tempPlate = tempPlate.substring(tempPlate.length() - 3);
        String order = "P" + tempPlate;
        sendOrder(order);
    }

    /**
     * 清楚车牌号
     */
    public void hidePlate() {
        String order = "p";
        sendOrder(order);
    }

    /**
     * 向字符叠加器发送指令，以<LF>10开头，<CR>13结尾
     *
     * @param order
     */
    private synchronized void sendOrder(String order) {
        try {
            if (output != null) {
                output.write(10);
                output.write(order.getBytes());
                output.write(13);
                output.flush();
                if (logLevel == 1) {//根据日志级别判断是否记录详细日志
                    logger.info(portName + " send:" + 10 + " " + order + " " + 13);
                }
            }
        } catch (IOException ex) {
            logger.info("向字符叠加器发送指令出现异常", ex);
        }
    }

    /**
     * 退出视频字符叠加控制
     */
    public void exit() {
        try {
            running = false;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (Exception ex) {
            logger.info("关闭字符叠加出现异常", ex);
        }
    }
    /**
     * 运行标识符
     */
    private boolean running = true;

    @Override
    public void run() {
        hideEntry();
        hideLane();
        hidePlate();
        hideStaff();
        hideVehType();
        hideVeh();
        while (running) {
            showDate();
            showTime();
            try {
                Thread.sleep(60 * 1000);//每分钟与字符叠加器进行一次时间同步
            } catch (InterruptedException ex) {
            }
        }
        port.close();
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        System.out.println(sdf.format(new Date()));
    }

}
