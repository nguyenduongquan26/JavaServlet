package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryRepository;
import model.ItemRepository;

@WebServlet("/home.html")
public class HomeController extends Controller {
	final private CategoryRepository catRepository = new CategoryRepository();
	final private ItemRepository repository = new ItemRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", catRepository.getCategories());
		req.setAttribute("items", repository.getItems());
		render("home/index", req, resp);
	}
	
}
