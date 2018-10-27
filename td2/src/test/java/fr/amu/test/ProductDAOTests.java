/* à finir plus tard */ 

package fr.amu.test;



import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.amu.models.Product;
import fr.amu.models.ProductDAO;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductDAOTests {
// la base de données est auto remplie grâce à src/main/java/resources/data.sql
	/*	@Autowired
		ProductDAO prdao;
		
		Integer add(Product product) ;
		
		
		@Override
		public Integer add(Product product) {
		String sql = "INSERT INTO products(category,productTitle,img,description,date) values(?,?,?,?,?)";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		// nom d ela column générée
		String id_column = "ID";
		// the update method takes an implementation of PreparedStatementCreator which could be a lambda, la
		méthode update a besoin d
		'
		un preparedSatementCreator pour modifier sa valeur de sortie
		//
		'
		con
		'
		est la connection JDBC cachée par JDBCTemplate
		jt.update(con -> {
		PreparedStatement ps = con.prepareStatement(sql,
		// comme avant on suit l
		'
		ordre des ? dans la requete SQL
		new String[]{id_column}); // cet array de String correspond aux clés utilisées pour récupérer les valeur
		//(ordre important, ici en premier car ID est en premier dans CREATE TABLE)
		ps.setString(1, product.getCategory());
		ps.setString(2, product.getProductTitle());
		ps.setString(3, product.getImg());
		ps.setString(4, product.getDescription());
*/
}