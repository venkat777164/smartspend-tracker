package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
  private final ProductRepository repo;
  public ProductService(ProductRepository repo){ this.repo = repo; }

  public Product save(Product p){ return repo.save(p); }
  public List<Product> findAll(){ return repo.findAll(); }
  public List<Product> findByCategory(String category){
    if (category==null || category.isBlank()) return repo.findAll();
    return repo.findByCategoryIgnoreCase(category);
  }
}
