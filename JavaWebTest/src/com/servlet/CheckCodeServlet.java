package com.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Apple on 2017/4/6.
 */
@WebServlet(name = "CheckCodeServlet", urlPatterns = "/com/servlet/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        图片数据缓存区
        BufferedImage image = new BufferedImage(68,25,BufferedImage.TYPE_INT_RGB);
//        绘制图片
        Graphics g = image.getGraphics();
//        获取颜色
        Color color = new Color(200,150,255);
//      背景色
        g.setColor(color);
//      填充背景色
        g.fillRect(0,0,68,25);
//      验证码域
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        Random random = new Random();
        int len = ch.length, index;
        StringBuffer strbuff = new StringBuffer();
        for (int i=0; i<4; i++) {
            index = random.nextInt(len);
            g.setColor(new Color(random.nextInt(88),random.nextInt(188),random.nextInt(255)));
            g.drawString(ch[index]+"",(i*15)+3,18);
            strbuff.append(ch[index]);
        }
//        将验证码内容存入session
        request.getSession().setAttribute("piccode", strbuff.toString());
//        输出图片
        ImageIO.write(image, "JPG", response.getOutputStream());
    }
}
