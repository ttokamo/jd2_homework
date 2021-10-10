package web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

public class NumberOfVisitorsServlet extends HttpServlet {
    private String path;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        path = getServletContext().getInitParameter("visitorsLog");
        int count;

        if (readNumberOfVisitorsFromFile() != null) {
            count = Integer.parseInt(readNumberOfVisitorsFromFile());
        } else {
            count = 0;
        }
        count++;
        writeNumberOfVisitorsToFile(count);
        out.println("<h1>Number of visitors: " + count + "</h1>");
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
