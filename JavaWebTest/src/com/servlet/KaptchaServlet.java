//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.servlet;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 利用反编译，借助Kaptcha自定义加法验证码,推荐
 */
public class KaptchaServlet extends HttpServlet implements Servlet {
    private Properties props = new Properties();
    private Producer kaptchaProducer = null;
    private String sessionKeyValue = null;
    private String sessionKeyDateValue = null;

    public KaptchaServlet() {
    }

    public void init(ServletConfig conf) throws ServletException {
        super.init(conf);
        ImageIO.setUseCache(false);
        Enumeration initParams = conf.getInitParameterNames();

        while(initParams.hasMoreElements()) {
            String config = (String)initParams.nextElement();
            String value = conf.getInitParameter(config);
            this.props.put(config, value);
        }

        Config config1 = new Config(this.props);
        this.kaptchaProducer = config1.getProducerImpl();
        this.sessionKeyValue = config1.getSessionKey();
        this.sessionKeyDateValue = config1.getSessionDate();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setDateHeader("Expires", 0L);
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
        resp.setHeader("Pragma", "no-cache");
        resp.setContentType("image/jpeg");

        String capText = this.kaptchaProducer.createText();         //获取验证码值
//---------------------------------------------------------------------------
//        源代码

//        req.getSession().setAttribute(this.sessionKeyValue, capText);   //验证码值加入session
//        req.getSession().setAttribute(this.sessionKeyDateValue, new Date());    //加时间确保刷新
//        BufferedImage bi = this.kaptchaProducer.createImage(capText);           //制作图片

//        修改后代码
        String s1 = capText.substring(0,1);
        String s2 = capText.substring(1,2);
        int r = Integer.valueOf(s1).intValue()+Integer.valueOf(s2).intValue();
        req.getSession().setAttribute(this.sessionKeyValue, String.valueOf(r));     //结果保存于session
        req.getSession().setAttribute(this.sessionKeyDateValue, new Date());    //加时间确保刷新
        BufferedImage bi = this.kaptchaProducer.createImage(s1 + "+" + s2 +"=?");
//---------------------------------------------------------------------------


        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(bi, "jpg", out);
    }
}
