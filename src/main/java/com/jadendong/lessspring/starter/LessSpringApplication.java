package com.jadendong.lessspring.starter;

import com.jadendong.lessspring.beans.BeanFactory;
import com.jadendong.lessspring.core.ClassScanner;
import com.jadendong.lessspring.web.handler.HandlerManager;
import com.jadendong.lessspring.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

/**
 * @author jaden
 */
public class LessSpringApplication {

    public static void run(Class<?> cls, String[] args) {
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());

            BeanFactory.initBean(classList);
            HandlerManager.resolveMappingHandler(classList);

            classList.forEach(it -> System.out.println(it.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
