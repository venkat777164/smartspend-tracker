package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@Controller
public class ProductController {
  private final ProductService service;
  public ProductController(ProductService service){ this.service = service; }

  @GetMapping("/") public String home(){ return "index"; }

  @GetMapping("/add")
  public String showAddForm(Model model){
    model.addAttribute("product", new Product());
    return "add-product";
  }

  @PostMapping("/add")
  public String addProduct(@RequestParam String name,
                           @RequestParam BigDecimal price,
                           @RequestParam String category){
    service.save(new Product(name, price, category));
    return "redirect:/products";
  }

  @GetMapping("/products")
  public String list(@RequestParam(required=false) String category, Model model){
    model.addAttribute("products", service.findByCategory(category));
    model.addAttribute("selectedCategory", category==null ? "" : category);
    return "list-products";
  }
}
