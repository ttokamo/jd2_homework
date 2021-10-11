package by.academy.it.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "personalInfoServlet", urlPatterns = "/info")
public class PersonalInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter out = resp.getWriter();
            String nameRegex = "[a-zA-Z]+"; // Проверка на содержание только букв в имени
            String numberRegex = "[0-9]+"; // Проверка на содержание только цифр в номере
            String emailRegex = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$"; // Псевдо проверка на правильность ввода почты
            String name = req.getParameter("name");
            String number = req.getParameter("number");
            String email = req.getParameter("email");

            if (name.matches(nameRegex) && number.matches(numberRegex) && email.matches(emailRegex)) {
                out.println("Name: " + name);
                out.println("Telephone number: " + number);
                out.println("Email: " + email);
            } else {
                out.println("<html><center> Please, fill in all fields correct </center></html>");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
