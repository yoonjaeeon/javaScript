package com.yedam.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/GetDeptListServlet")
public class GetDeptListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public GetDeptListServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // response.getWriter().append("Served at: ").append(request.getContextPath());
      DeptDAO dao = new DeptDAO();
      List<Departments> deptList = dao.getDeptList();
      // JASON PARSE
      JSONObject obj = new JSONObject();
      JSONArray ary = new JSONArray();
      for (Departments e : dao.getDeptList()) {
         obj.put("depatmentId", e.getDepartmentId());
         obj.put("departmentName", e.getDepartmentName());
         obj.put("managerId", e.getManagerId());
         obj.put("locationId", e.getLocationId());
         ary.add(obj);
      }
      PrintWriter out = response.getWriter();
      out.print(ary.toString());
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doGet(request, response);
   }

}