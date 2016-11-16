package videotest;

import org.apache.log4j.Logger;
import ui.VideoJFrame;
import vo.Constant;

/**
 * 视频及字符叠加测试
 *
 * @author Wang Guodong
 */
public class VideoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.getLogger(VideoTest.class).info(Constant.SOFT_NAME+Constant.SOFT_VERSION);
        VideoJFrame videoJFrame = new VideoJFrame();
        videoJFrame.init();
        videoJFrame.open();
    }

}
