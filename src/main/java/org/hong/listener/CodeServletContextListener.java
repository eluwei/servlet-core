package org.hong.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ClassName: CodeServletContextListener
 * @Description: (用来测试手动添加配置listener)
 * @author hong
 * @date 17:22
 * @version v1.1
 */
public class CodeServletContextListener implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("这是一个手动添加的listener.");
    }
}
