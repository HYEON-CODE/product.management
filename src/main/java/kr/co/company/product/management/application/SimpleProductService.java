package kr.co.company.product.management.application;

import kr.co.company.product.management.domain.Product;
import kr.co.company.product.management.infrastructure.ListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;

    @Autowired
    public SimpleProductService(ListProductRepository listProductRepository) {
        this.listProductRepository = listProductRepository;
    }

    public Product add(Product product) {
        Product savedProduct = listProductRepository.add(product);
        return savedProduct;
    }
}
