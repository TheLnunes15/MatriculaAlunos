package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Nunes
 */
@WebServlet(name = "ListarTurmas", urlPatterns = {"/ListarTurmas"})
public class ListarTurmas extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";        
    static final String DATABASE_URL = "jdbc:mysql://localhost/alunos";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String matricula = request.getParameter("matricula");
            Connection conn;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Turmas</title>");
            out.println("<style type=\"text/css\">" +
                "<!-- " +
                "body {background-color:beige; color:black; font-size:90%}"+
                "td   {font-size: 90%; background-color:white; color: black}" +
                "input {background-color:white}" +
                "//--></style>");
            out.println("</head>");
            out.println("<body>");
       
            out.println("<h1>Listar Disciplinas e Turmas</h1>");
            out.println("<h2>Tabela Disciplinas e Turmas</h2>");
	       try {
	            Class.forName(JDBC_DRIVER );
	            conn = DriverManager.getConnection(DATABASE_URL, 
                            "root", "admin" );
	            Statement st = conn.createStatement();
                    Statement ts = conn.createStatement();
                    Statement r = conn.createStatement();
                    
	            ResultSet rec = st.executeQuery(
	                "SELECT * " +
	                "FROM turmas ");
                    
                    ResultSet rdis = ts.executeQuery(
                        "SELECT * " +
	                "FROM disciplinas ");
                    
                    ResultSet ral = r.executeQuery(
                        "SELECT * " +
	                "FROM alunos " + "WHERE " +
                        "(matricula='" + matricula + "')" +
	                "ORDER BY nome"); 
                    
                    out.println("<table border=1><tr>");
	            out.println("<td><b>Código</b></td>" + "<td><b>Disciplina</b></td>"
                            + "<td><b>Turma</b></td>" + "<td><b>Horário 1</b></td>"
                            + "<td><b>Horário 2</b></td>" + "<td><b>Horário 3</b></td>"
                            + "<td><b>Selecionar</b></td>" + "</tr>");
                    out.println("<form action=\"TurmasSelecionadas\"> ");
                    
                    int i = 0;
                    int j = 0;
                    
                    while(ral.next()) {
                        out.println("<input type=\"hidden\" name=\"matricula\" value=\""
                        + ral.getString(1) + "\" size=\"12\" readonly=\"true\" /><br />"
                        + "<input type=\"hidden\" name=\"nome\" value=\"" 
                        + ral.getString(2) + "\" size=\"40\" readonly=\"true\" /><br />"
                        + "<input type=\"hidden\" name=\"codigo\" value=\""
                        + ral.getString(3) + "\" size=\"3\" readonly=\"true\" /><br />");
                        j++;
                    }
                        out.println("<input type=\"hidden\" name=\"n\" value=\""
                        + j + "\" size=\"3\" readonly=\"true\" /><br />");
                    
                    while(rec.next() && rdis.next()) {
                        out.println("<tr><td><input type=\"text\" name=\"CodDisc\" value=\""
                                + rdis.getString(1) + "\" size=\"8\" readonly=\"true\" /><br /></td>"
                                + "<td><input type=\"text\" name=\"NomeDisc\" value=\""
                                + rdis.getString(2) + "\" size=\"30\" readonly=\"true\" /><br /></td>"
                                + "<td><input type=\"text\" name=\"turma\" value=\""
                                + rec.getString(2) + "\" size=\"3\" readonly=\"true\"/><br /></td>"
                                + "<td><input type=\"text\" name=\"horario1\" value=\""
                                + rec.getString(3) + "\" size=\"4\" readonly=\"true\"/><br /></td>"
                                + "<td><input type=\"text\" name=\"horario2\" value=\""
                                + rec.getString(4) + "\" size=\"4\"/><br /></td>" 
                                + "<td><input type=\"text\" name=\"horario3\" value=\""
                                + rec.getString(5) + "\" size=\"4\"/><br /></td>" 
                                + "<td><input type=\"checkbox\" name=\"box[" 
                                + i + "]\" value=" + i + "</td></tr>"); 
                        i++;
	            }
                    String num = Integer.toString(i);
                    out.println("</table>");
                    out.println("<br/><input type='submit' value='Enviar' name='enviar' />");
                    out.println("<input type='hidden' name='numRec' value='"
                              + num + "' />");
                    out.println("</form>");
	            st.close();
                    ts.close();
                    r.close();
	        } catch (SQLException s) {
	            out.println("SQL Error: " + s.toString() + " "
	                + s.getErrorCode() + " " + s.getSQLState());
	        } catch (Exception e) {
	            out.println("Error: " + e.toString()
	                + e.getMessage());
	        }
	    
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
