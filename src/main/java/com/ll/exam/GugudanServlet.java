package com.ll.exam;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan") // 루트를 지정해준 것임
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 들어오는 파라미터를 UTF-8로 해석
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");// HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.


        int dan = Integer.parseInt(req.getParameter("dan"));
        int limit = Integer.parseInt(req.getParameter("limit"));


        resp.getWriter().append("<h1>%d단</h1>\n".formatted(dan));

        for (int i=1; i<=limit; i++){
            resp.getWriter().append("<div>%d * %d = %d</div>\n".formatted(dan, i, dan*i));
        }
    }
}