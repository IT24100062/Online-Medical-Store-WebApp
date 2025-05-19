package com.onlinepharmacy.servlet;

import com.onlinepharmacy.model.Supplier;
import com.onlinepharmacy.model.LocalSupplier;
import com.onlinepharmacy.model.InternationalSupplier;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class EditSupplierServlet extends HttpServlet {
    private static final String FILE_PATH = "/WEB-INF/data/suppliers.txt";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            response.sendRedirect("viewSuppliers");
            return;
        }
        Supplier supplier = findSupplierById(id, request);
        if (supplier == null) {
            response.sendRedirect("viewSuppliers");
            return;
        }
        request.setAttribute("supplier", supplier);
        request.getRequestDispatcher("/editSupplier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String companyName = request.getParameter("companyName");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        Supplier original = findSupplierById(id, request);

    
}
