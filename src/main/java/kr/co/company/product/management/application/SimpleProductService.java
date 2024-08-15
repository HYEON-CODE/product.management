package kr.co.company.product.management.application;

import kr.co.company.product.management.domain.Product;
import kr.co.company.product.management.infrastructure.ListProductRepository;
import kr.co.company.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {

    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        // ProductDto -> Product
        Product product = modelMapper.map(productDto, Product.class);

        // Repository를 호출
        Product savedProduct = listProductRepository.add(product);

        // Product -> ProductDto
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        // ProductDto 반환
        return savedProductDto;
    }
}
