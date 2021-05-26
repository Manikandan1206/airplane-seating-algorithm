package com.aeroplane.servlet;

import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aeroplane.main.AeroplaneSeatingAlgorithm;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Servlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String inputArray = request.getParameter("input-array").trim();
		int noOfPassengers = Integer.parseInt(request.getParameter("no-of-passengers"));
		String filterNumbersFromInput = inputArray.replaceAll("[^0-9]", "");
		int[][] givenInput = Arrays.stream(filterNumbersFromInput.split("(?<=\\G.{2})")).map(s -> (Arrays.stream(s.split("(?<=\\G.{1})")).mapToInt(Integer::parseInt).toArray())).toArray(int[][]::new);
		AeroplaneSeatingAlgorithm aeroplaneSeatingAlgorithm = new AeroplaneSeatingAlgorithm();
		List<int[][]> allSeats = aeroplaneSeatingAlgorithm.doSeatingAlgorithm(givenInput, noOfPassengers);
		allSeats.stream().forEach(seats -> {
			for(int i=0;i<seats.length;i++) {
				for(int j=0;j< seats[i].length;j++) {
				System.out.print(seats[i][j] +" ");
				}
				System.out.print(" ");
			}
			System.out.print("   ");
		});
		request.setAttribute("allSeats", allSeats);
		 RequestDispatcher requestDispatcher = request
                 .getRequestDispatcher("/display-seating-arrangement.jsp");
         requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
