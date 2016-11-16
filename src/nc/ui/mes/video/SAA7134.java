package nc.ui.mes.video;

import com.sun.jna.Native;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class SAA7134 {

    static Logger logger = Logger.getLogger(SAA7134.class.getName());
    private Canvas canvas;
    private Container parent;
    private Panel panel;
    private List<Panel> panelList;
    String jawtpath = System.getProperty("java.home") + System.getProperty("file.separator") + "bin" + System.getProperty("file.separator") + "jawt.dll";
    private List<Canvas> cdList = new ArrayList();
    private List<File> imgList = new ArrayList();

    static {
        try {
            logger.info(System.getProperty("java.library.path"));
            System.loadLibrary("saa7134");
        } catch (Exception e) {
            throw new RuntimeException("can not found saa7134.dll in java.libary.path");
        }
    }

    public SAA7134(Canvas canvas, Container parent) {
        this.canvas = canvas;
        this.parent = parent;

        init();
    }

    public SAA7134(List<Canvas> canList, Container videoPanel) {
        this.cdList = canList;
        this.parent = videoPanel;
        init();
    }

    public SAA7134(Panel panel, Container parent) {
        this.panel = panel;
        this.parent = parent;
        init();
    }

    public SAA7134(List<Panel> panelList, Panel parent) {
        this.panelList = panelList;
        this.parent = parent;
        init();
    }

    private void init() {
        long frameHwnd = Native.getComponentID(this.parent);
        logger.info("Frame 窗口句柄是：" + frameHwnd);
        boolean ret = initSAA7134(frameHwnd);
        int devNum = getDeviceNum();
        logger.info("当前设备数：" + devNum);
        for (int i = 0; i < devNum; i++) {
            long hwnd = Native.getComponentID(this.panelList.get(0));
            logger.info(0 + "号窗口句柄：" + hwnd);
            if (!start(hwnd, i)) {
                logger.info(" start captureDevice faild!");
            }
        }
    }

    private void setLayOut(int devNum) {
        int size = devNum;
        int columns;
        int row;
        if (size < 2) {
            row = 1;
            columns = 1;
        } else {
            row = 2;
            columns = size / row;
            if (size % row != 0) {
                row++;
            }
        }
        this.parent.setLayout(new GridLayout(row, columns, 5, 5));
    }

    public void grap() {
        int devNum = getDeviceNum();
        File dir = new File("temp");
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }
        String filename = dir.getAbsolutePath() + File.separator + "videoTemp.jpg";
        grap(filename, 0);
    }

    private native int getDeviceNum();

    private native boolean start(long paramLong, int paramInt);

    private native boolean initSAA7134(long paramLong);

    public native void closeSAA7134();

    private native void grap(String paramString, int paramInt);
}
