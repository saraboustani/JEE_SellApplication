// à remplir selon l'interface montrée dan le PDF
// Pas nécessaire de créer réellement l'interface, c'est un indicatif pour les méthodes à mettre
package fr.amu.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Product;

import java.util.List;

@Service

public interface ProductService 
{
	
	void addProduct(Product product);
    Product getProduct(int id);
    void removeProduct(int id);
    List<Product> getProduct();
    List<Product> getCategoryProduct(String category);
	
	
}

