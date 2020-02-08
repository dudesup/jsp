package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(name = "StudentServlet", value = "/student")
public class Servlet extends HttpServlet {

    private List<Student> students;

    @Override
    public void init() throws ServletException {
        super.init();
        students = Arrays.asList(
                new Student("Patrycja", "Guz", LocalDate.of(1986, 10, 19)),
                new Student("Rafał", "Guz", LocalDate.of(1986, 05, 25)),
                new Student("Zuzanna", "Guz", LocalDate.of(2015, 05, 05)),
                new Student("Jakub", "Guz", LocalDate.of(2012, 06, 06)));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String letter = req.getParameter("param");
        String birthYear = req.getParameter("year");


        PrintWriter printWriter = resp.getWriter();

        students.stream().filter(student -> {
            return letter == null || student.getSurname().startsWith(letter);
        })
                .filter(student -> {
                    return birthYear == null || student.getBirthDate().getYear() > getIntegerValue(birthYear);
                }).forEach(printWriter::print);

    }

    private Integer getIntegerValue(String number) {
        return Integer.valueOf(number);
    }


}


