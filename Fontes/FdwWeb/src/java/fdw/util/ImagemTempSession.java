/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.util;

import fdw.web.SessionBean1;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedro
 */
public class ImagemTempSession extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       BufferedInputStream input = null;
       BufferedOutputStream output = null;
       try {
           SessionBean1 sessBean = (SessionBean1) request.getSession().getAttribute("SessionBean1");
          
           byte[] image = sessBean.getImagemTemp();
           sessBean.setImagemTemp(null);
           String filename = "Imagem.jpg";

            response.setContentType(getServletContext().getMimeType(filename));
            response.setContentLength(image.length);
            response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");

            input = new BufferedInputStream(new ByteArrayInputStream(image));
            output = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[8192];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            if (output != null) output.close();
            if (input != null) input.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Retorna a imagem do prato guardado no request.";
    }// </editor-fold>

}
