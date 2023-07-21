package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validator.PrimeCalculator;
import validator.InputValidator;

@WebServlet(name = "PrimeServlet", urlPatterns = "/calculate")
public class PrimeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String upperBoundStr = request.getParameter("upperBound");

        if (InputValidator.isValidPositiveNumber(upperBoundStr)) {
            int upperBound = Integer.parseInt(upperBoundStr);
            List<Integer> primes = PrimeCalculator.calculatePrimes(upperBound);
            request.setAttribute("primes", primes);
            request.setAttribute("upperBound", upperBound);
        } else {
            request.setAttribute("errorMessage", "Please enter a valid positive number.(Server-side)");
            // Clear the primes and upperBound attributes when there's an error
            request.removeAttribute("primes");
            request.removeAttribute("upperBound");
        }

        doGet(request, response);
    }

}
