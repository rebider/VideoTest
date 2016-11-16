package ui;

import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import nc.ui.mes.video.SAA7134;
import org.apache.log4j.Logger;
import tool.VideoInstruction;
import vo.Constant;

/**
 * 视频及字符叠加测试界面
 *
 * @author WangGuodong
 */
public class VideoJFrame extends javax.swing.JFrame {

    /**
     * Creates new form VideoJFrame
     */
    public VideoJFrame() {
        initComponents();
        setTitle(Constant.SOFT_NAME+Constant.SOFT_VERSION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        panel3 = new java.awt.Panel();
        panel4 = new java.awt.Panel();
        panel5 = new java.awt.Panel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("视频及字符叠加测试");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        panel1.setPreferredSize(new java.awt.Dimension(440, 400));
        panel1.setLayout(new java.awt.CardLayout());

        panel2.setBackground(java.awt.Color.pink);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        panel1.add(panel2, "card2");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        panel1.add(panel3, "card2");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        panel1.add(panel4, "card2");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        panel1.add(panel5, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "字符叠加测试"));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton9.setText("显示车道号");
        jButton9.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);

        jTextField3.setText("XXX");
        jTextField3.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel5.add(jTextField3);

        jLabel1.setText("XXX可以是大写英文字母与数字0～9。");
        jPanel5.add(jLabel1);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton10.setText("显示收费员ID");
        jButton10.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10);

        jTextField4.setText("XXXXX");
        jTextField4.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel6.add(jTextField4);

        jLabel2.setText("XXXXX是数字00000～99999");
        jPanel6.add(jLabel2);

        jButton11.setText("清除收费员ID");
        jButton11.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11);

        jPanel2.add(jPanel6);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton12.setText("显示入口站");
        jButton12.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton12);

        jTextField6.setText("XXXX");
        jTextField6.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel8.add(jTextField6);

        jLabel3.setText("XXXX为4位数字，取值范围0000～9999");
        jPanel8.add(jLabel3);

        jButton13.setText("清除入口站");
        jButton13.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13);

        jPanel2.add(jPanel8);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton14.setText("显示车型和费额");
        jButton14.setMaximumSize(new java.awt.Dimension(93, 23));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton14);

        jTextField8.setText("XXXXXX");
        jTextField8.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel10.add(jTextField8);

        jLabel4.setText("前2个X为1位车型；后4位X为数字，表示费额。当X为空格键码时，只显示车型，不显示费额");
        jPanel10.add(jLabel4);

        jPanel2.add(jPanel10);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton15.setText("清除车型和费额");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton15);

        jPanel2.add(jPanel11);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton16.setText("显示车类");
        jButton16.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton16);

        jTextField10.setText("XX");
        jTextField10.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel12.add(jTextField10);

        jLabel5.setText("XX为2位0～9数字 ");
        jPanel12.add(jLabel5);

        jButton17.setText("清除车类");
        jButton17.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton17);

        jPanel2.add(jPanel12);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton18.setText("显示车牌号");
        jButton18.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton18);

        jTextField12.setText("XXX");
        jTextField12.setPreferredSize(new java.awt.Dimension(66, 21));
        jPanel14.add(jTextField12);

        jLabel6.setText("XXX为3位0～9数字");
        jPanel14.add(jLabel6);

        jButton19.setText("清除车牌号");
        jButton19.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton19);

        jPanel2.add(jPanel14);

        jButton7.setText("截图");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setText("注：中文路径会导致截图失败");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // 清除车牌号
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        logger.info("清除车牌号");
        vi.hidePlate();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // 显示车道:
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField3.getText();
        logger.info("显示车道：" + str);
        vi.showLane(str);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // 显示收费员id
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField4.getText();
        logger.info("显示收费员id：" + str);
        vi.showStaff(str);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // 隐藏收费员id
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        logger.info("隐藏收费员id");
        vi.hideStaff();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // 显示入口:
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField6.getText();
        logger.info("显示入口：" + str);
        vi.showEntry(str);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // 清空入口:
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        logger.info("隐藏入口");
        vi.hideEntry();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // 显示车型及收费额
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField8.getText();
        if (str.length() < 6) {
            JOptionPane.showMessageDialog(rootPane, "车型及收费额内容长度错误");
        }
        String vehClass = str.substring(0, 2);
        String fare = str.substring(2, 6);
        logger.info("显示车型：" + vehClass + "收费额：" + fare);
        vi.showVeh(vehClass, fare);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // 清除车型及收费额
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        logger.info("清除车型及收费额");
        vi.hideVeh();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // 显示车种
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField10.getText();
        logger.info("显示车种：" + str);
        vi.showVehType(str);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // 清除车种
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        logger.info("清除车种");
        vi.hideVehType();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // 显示车牌号
        if (vi == null) {
            JOptionPane.showMessageDialog(rootPane, "字符叠加设备尚未启动");
            return;
        }
        String str = jTextField12.getText();
        logger.info("显示车牌号：" + str);
        vi.showPlate(str);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        grab();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VideoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    // End of variables declaration//GEN-END:variables
    public void init() {
        this.addWindowListener(new WindowAdapter() { //new 一个WindowAdapter 类 重写windowClosing方法 //WindowAdapter是个适配器类 具体看jdk的帮助文档 
            @Override
            public void windowClosing(WindowEvent e) { //这里写对话框 
                if (JOptionPane.showConfirmDialog(null, "退出", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    exit();
                }
            }
        });
        initComp();
    }

    /**
     * 退出
     */
    public void exit() {
        dispose();
        stopVideoMonitor();
        running = false;
        if (vi != null) {
            vi.exit();
        }
    }

    public void initComp() {
        initVideo();
    }

    public void open() {
        setLocationRelativeTo(null);
        setVisible(true);
        startVideoMonitor();
        running = true;
        initVideoInstruction();
        videoMonitor();
    }

    Logger logger = Logger.getLogger(VideoJFrame.class.getName());
    SAA7134 saa;
    //视频监控标志
    boolean videoMonitorFlag;
    byte[] videoBuffer;
    boolean running;

    /**
     * 视频初始化
     */
    public final void initVideo() {
        //插入视频代码
        logger.info("开始加载视频...");
        List<Panel> panelList = new ArrayList<Panel>();
        panelList.add(panel2);
        panelList.add(panel3);
        panelList.add(panel4);
        panelList.add(panel5);
        try {
            saa = new SAA7134(panelList, panel1);
        } catch (Throwable ex) {
            logger.info("视频异常", ex);
        }
        logger.info("加载视频结束");
    }

    /**
     * 抓拍视频图像，注意与captureVideo方法区别，captureVideo方法用于上班之后（视频已经显示），grab方法用于上班之前（视频未显示）
     *
     */
    public void grab() {
        Thread t = new Thread() {
            @Override
            public void run() {
                if (saa != null) {
                    saa.grap();//抓拍图像
                }
            }
        };
        t.start();
    }

    /**
     * 显示视频
     */
    public void showVideo() {
        panel2.setVisible(true);
        startVideoMonitor();//显示视频后开启视频监控
    }

    /**
     * 隐藏视频
     */
    public void hideVideo() {
        stopVideoMonitor();//隐藏视频时停止视频监控
        panel2.setVisible(false);
    }

    private void videoMonitor() {
        Thread vidoeMonitorThread = new Thread("vidoeMonitorThread") {
            @Override
            public void run() {
                while (running) {
                    if (videoMonitorFlag) {//是否监控视频（视频显示后才进行视频监控）
                        try {
                            Robot rob = new Robot();
                            Rectangle rec = new Rectangle(panel2.getLocationOnScreen(), panel2.getSize());
                            BufferedImage bi = rob.createScreenCapture(rec);
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            ImageIO.write(bi, "gif", out);
                            out.close();
                            boolean flag = false;
                            byte[] buffer = out.toByteArray();
                            if (videoBuffer == null) {
                                videoBuffer = buffer;
                                continue;
                            } else {
                                if (!Arrays.equals(videoBuffer, buffer)) {
                                    flag = true;//视频正常
                                } else {
                                    flag = false;//视频异常
                                }
                                videoBuffer = buffer;
                            }
                            if (!flag && videoMonitorFlag) {//视频异常，重新显示视频
                                logger.info("视频监控发现视频未正常显示，重新启动视频");
                                if (saa != null) {
                                    saa.closeSAA7134();
                                }
                                Thread.sleep(1000);
                                if (videoMonitorFlag) {
                                    initVideo();//重新加载视频
                                    showVideo();
                                }
                            }
                        } catch (Exception ex) {
                            logger.info("视频监控异常", ex);
                        }
                    }
                    try {
                        Thread.sleep(5000);//每5秒钟进行一次检测
                    } catch (Exception ex) {
                    }
                }
            }
        };
        vidoeMonitorThread.start();
    }

    /**
     * 开始进行视频监控
     */
    public void startVideoMonitor() {
        videoMonitorFlag = true;
    }

    /**
     * 停止进行视频监控
     */
    public void stopVideoMonitor() {
        videoMonitorFlag = false;
    }

    VideoInstruction vi;//视频字符叠加

    public void initVideoInstruction() {
        vi = new VideoInstruction();
        vi.init();
    }

}