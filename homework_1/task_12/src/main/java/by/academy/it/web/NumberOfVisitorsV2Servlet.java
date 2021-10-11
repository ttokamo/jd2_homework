package by.academy.it.web;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class NumberOfVisitorsV2Servlet extends HttpServlet {
    private String path;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setContentType("image/jpeg");
            BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setFont(new Font("Serif", Font.ITALIC, 30));
            graphics.setColor(Color.GREEN);
            path = getServletContext().getInitParameter("visitorsLogV2");
            int count;

            if (readNumberOfVisitorsFromFile() != null) {
                count = Integer.parseInt(readNumberOfVisitorsFromFile());
            } else {
                count = 0;
            }
            count++;
            writeNumberOfVisitorsToFile(count);
            graphics.drawString("Number of visitors: " + count, 300, 300);
            ServletOutputStream out = resp.getOutputStream();
            ImageIO.write(image, "jpeg", out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void writeNumberOfVisitorsToFile(int count) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path)));
            writer.write(count + "");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readNumberOfVisitorsFromFile() {
        String count = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
            count = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
