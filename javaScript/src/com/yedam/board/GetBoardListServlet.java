package com.yedam.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dev.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@WebServlet("/GetBoardListServlet")
public class GetBoardListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public GetBoardListServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      BoardDAO dao = new BoardDAO();
      List<Board> boardList = dao.getBoardList();
      //JASON PARSE
      JSONObject obj = new JSONObject();
      JSONArray ary = new JSONArray();
      for (Board e : dao.getBoardList()) {
         obj.put("boardNo", e.getBoardNo());
         obj.put("content", e.getContent());
         obj.put("lastName", e.getWriter());
         obj.put("date", e.getDate());
         ary.add(obj);
      }
      PrintWriter out = response.getWriter();
      out.print(ary.toString());
      //JASON PARSE 수동
      /*String brdJson = "[";
      int rCnt = 0;
      int totalCnt = boardList.size();
      for (Board b : boardList) {
         brdJson += "{\"boardNo\":" + b.getBoardNo() 
               + ",\"content\":\"" + b.getContent() 
               + "\",\"writer\":\"" + b.getWriter()
               + "\",\"date\":\""+b.getDate()
               + "\"}";
         if (++rCnt != totalCnt)
            brdJson += ",";
      }
      brdJson += "]";
      PrintWriter out = response.getWriter();
      out.print(brdJson.toString());*/
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }
}