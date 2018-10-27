package fr.amu.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; // pour req
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.amu.models.Product;
import fr.amu.services.ProductService;

// à remplir
// aura l'annotation @Controller


@Controller
public class ProductController extends HttpServlet {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	ProductService ps;	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)	
	public String add(HttpServletRequest request, Map<String, Object> model) throws ServletException, IOException
	{
		Product p = new Product();
		p.setCategory(request.getParameter("category"));
		p.setDescription(request.getParameter("description"));
		p.setTitle(request.getParameter("title"));
		ps.addProduct(p);
		System.out.println(ps.getProduct().size());
		model.put("products", ps.getProduct());
		return "homepage";	
	}
	
	@PostMapping("/remove")
	public String remove (@RequestParam(value ="productId") int id, Map<String, Object> model)
	
	{
		ps.removeProduct(id);
		System.out.println(ps.getProduct().size());
		model.put("products", ps.getProduct());
		return "homepage";	
		
	}
	
	@PostMapping("/category")
	public String category(@RequestParam(value ="name") String category, Map<String, Object> model)
	
	{
		if (category.equals("all"))
		{
			model.put("products", ps.getProduct());
		}
		else
		{
			model.put("products", ps.getCategoryProduct(category));
		}
		
		return "homepage";
	}
}