package fr.amu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Product;
import fr.amu.models.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    
	@Override
	public void addProduct(Product product)
	{
		productDAO.add(product);
	}

	@Override
	public Product getProduct(int id) {
		return productDAO.findById(id);
	}

	@Override
	public void removeProduct(int id) {
		Product product = new Product();
        product.setId(id);
        productDAO.delete(product);
	}

	@Override
	public List<Product> getProduct() {
		return productDAO.findAll();
				}

	@Override
	public List<Product> getCategoryProduct(String category) {
		return productDAO.findByCategory(category);
	}

}
