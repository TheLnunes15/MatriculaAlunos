package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Nunes
 */
@WebServlet(name = "TurmasSelecionadas", urlPatterns = {"/TurmasSelecionadas"})
public class TurmasSelecionadas extends HttpServlet {
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
            String numRec = request.getParameter("numRec");
            int num = Integer.parseInt(numRec);
            String[] matricula = request.getParameterValues("matricula");
            String[] nome = request.getParameterValues("nome");
            String[] curso = request.getParameterValues("codigo");
            String[] codigo = request.getParameterValues("CodDisc");
            String[] disciplina = request.getParameterValues("NomeDisc");
            String[] turma = request.getParameterValues("turma");
            String[] horario1 = request.getParameterValues("horario1");
            String[] horario2 = request.getParameterValues("horario2");
            String[] horario3 = request.getParameterValues("horario3");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Solicitação de Matrícula</title>");
            out.println("<style type=\"text/css\">" +
                "<!-- " +
                "body {background-color:beige; color:black; font-size:90%}"+
                "td   {font-size: 90%; background-color:white; color: black}" +
                "input {background-color:white}" +
                "//--></style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Solicitação de Matrícula</h1>");
            out.println("<table border=1><tr>");
            out.println("<td><b>Matrícula</b></td>" + "<td><b>Nome</b></td>" + "<td><b>Curso</b></td>"
                            + "<td><b>Código</b></td>" + "<td><b>Disciplina</b></td>"
                            + "<td><b>Turma</b></td>" + "<td><b>Horário 1</b></td>"
                            + "<td><b>Horário 2</b></td>" + "<td><b>Horário 3</b></td>"
                            + "</tr>");
	    int i = 0;
            int j = 0;
            while((i < num) && (j < num)) {
                String ok = request.getParameter("box[" + i + "]");
                String ko = request.getParameter("n");
                
                if(horario1[i].equals("2132")){
                   horario1[i] = "Seg: 13-15"; 
                }
                
                if(horario1[i].equals("6154")){
                   horario1[i] = "Sex: 15-19"; 
                }
                
                if(horario1[i].equals("3172")){
                   horario1[i] = "Ter: 17-19"; 
                }
                
                if(horario2[i].equals("5152")){
                   horario2[i] = "Qui: 15-17"; 
                }
                
                if ((ok != null) && (ko != null)){
                     out.println("<tr><td>" + matricula[j] + "</td>"
                                + "<td>" + nome[j] + "</td>"
                                + "<td>" + curso[j] + "</td>"
                                + "<td>" + codigo[i] + "</td>"
                                + "<td>" + disciplina[i] + "</td>" 
                                + "<td>" + turma[i] + "</td>" 
                                + "<td>" + horario1[i] + "</td>" 
                                + "<td>" + horario2[i] + "</td>"                                 
                                + "<td>" + horario3[i] + "</td></tr>");                                           
                }   
                 i++;
	    }
                out.println("</table>");
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
