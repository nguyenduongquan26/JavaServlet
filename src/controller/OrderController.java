package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import model.BillDetail;
import model.BillRepository;
import util.Helper;

@WebServlet("/order.html")
public class OrderController extends Controller {
	
	BillRepository repository = new BillRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("bill", repository.getBills());
		
		render("order/index", req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Helper.RandomLong();
		String name = req.getParameter("fullName");
		String tel = req.getParameter("tel");
		String[] itemId = req.getParameterValues("itemId");
		String[] qty = req.getParameterValues("qty");
		String[] pri = req.getParameterValues("pri");
		List<BillDetail> listBillDetails = new LinkedList<>();
		for(int i = 0;i<itemId.length;i++) {
			BillDetail obj = new BillDetail(id, Integer.parseInt(itemId[i]), Integer.parseInt(pri[i]), Short.parseShort(qty[i]));
			listBillDetails.add(obj);
		}
		Bill obj = new Bill(id, name, tel);
		obj.setDetails(listBillDetails);
		repository.add(obj);
		repository.addBillList(listBillDetails);
		redirect("order/detail.html?id="+id, req, resp);
	}
}
