/**
 *
 * @author Emilio Barrera
 */
package Controllers;

import Models.Customer;
import Models.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerServlet", urlPatterns =
{
    "/CustomerServlet"
})
public class CustomerServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        try (PrintWriter out = response.getWriter())
        {
//            //Get Data
            int idCustomer = Integer.parseInt(request.getParameter("txtIdCustomer"));
            String name = request.getParameter("txtName");
            int age = Integer.parseInt(request.getParameter("txtAge"));
            int Idcategory = Integer.parseInt(request.getParameter("txtCategory"));

            int result;
            String message = "Error to Save new Cutomer in the DB.";

            Customer customer = new Customer(idCustomer, name, age, Idcategory, name);
            CustomerDAO customerDAO = new CustomerDAO();

            if (request.getParameter("btnSave") != null)
            {
                result = customerDAO.InsertCustomer(customer);

                if (result != 0)
                {
                    message = "Data SaveSuccessfuly.";
                 
                }

            }
            else if (request.getParameter("btnEdit") != null)
            {
                result = customerDAO.EditCustomer(customer);

                if (result != 0)
                {
                    message = "Data edited Successfuly.";
                }

            }
            else if (request.getParameter("btnDelete") != null)
            {
                result = customerDAO.DeleteCustomer(customer);

                if (result != 0)
                {
                    message = "Data was Delete Successful.";

                }

            }

            request.setAttribute("message", message);
            request.getRequestDispatcher("/customers.jsp").forward(request, response);

        }
        catch (Exception e)
        {
            System.out.println("ERROR to Save new Cutomer in the Cutomer Servlet: " + e.getLocalizedMessage());
        }
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
