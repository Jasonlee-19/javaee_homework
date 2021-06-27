package com.swufe.javaee.request_response;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.SquareAvatar;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

@WebServlet(name = "AvatarGeneratorServlet" , value =  "/AvatarGeneratorServlet")
public class AvatarGeneratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        Avatar avater1 = SquareAvatar.newAvatarBuilder().build();
        long a = new Random().nextLong();
        byte[] b= avater1.createAsPngBytes(a);
        BufferedImage result = avater1.create(a);
        ImageIO.write(result, "PNG", response.getOutputStream());
    }
}

