package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import model.BillDetail;
import model.BillRepository;
import model.Item;
import model.ItemRepository;

@WebServlet("/order/detail.html")
public class OrderDetailController extends Controller {
	private BillRepository repository = new BillRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Bill obj = repository.getBill(id);
		req.setAttribute("bill", obj);
		req.setAttribute("details", obj.getDetails());
		
		render("order/detail", req, resp);
	}
}
