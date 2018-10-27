package fr.amu.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired	
	JdbcTemplate jt;
	
	@Override
	public void add(Product product) {
		String sql = "INSERT INTO products(category,productTitle,description) values (?,?,?)";
		jt.update(sql, product.getCategory(),product.getTitle(),product.getDescription());
	}

	@Override
	public void update(Product product) {
		String sql = "Update products set category=?, productTitle=?, description =? where id=?";
	    jt.update(sql, product.getCategory(),product.getTitle(),product.getDescription());
	}

	@Override
	public void delete(Product product) {
		String sql = "delete from products where id=?";
	   jt.update(sql, product.getId());
		
	}

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM products";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jt.query(sql, rowMapper);
	}

	@Override
	public Product findById(Integer id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jt.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Product> findByCategory(String category) 
	{
		String sql = "SELECT * FROM products WHERE category = ?";
		return jt.query(sql, new Object[] {category}, new BeanPropertyRowMapper<>(Product.class));
	}
}