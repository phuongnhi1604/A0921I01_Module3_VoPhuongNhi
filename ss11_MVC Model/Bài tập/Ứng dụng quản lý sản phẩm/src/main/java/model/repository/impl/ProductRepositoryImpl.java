package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    static private Map<Integer,Product> productMap = new HashMap<>();
    static {
        productMap.put(1,new Product(1,"Laptop Dell","Laptop",120000));
        productMap.put(2,new Product(2,"Samsung Galaxy","SmartPhone",130000));
        productMap.put(3,new Product(3,"OPPO A37","SmartPhone",140000));
        productMap.put(4,new Product(4,"LG TV","TiVi",150000));
        productMap.put(5,new Product(5,"Laptop Acer","Laptop",160000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(),product);
        System.out.println("Them moi thanh cong");
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for(Product product : productMap.values()){
            if(product.getName().equals(name)){
                products.add(product);
            }
        }
        return products;
    }


}
