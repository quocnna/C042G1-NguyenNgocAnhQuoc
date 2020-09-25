package com.example.exam_second.service;

import com.example.exam_second.common.StringUtil;
import com.example.exam_second.model.Book;
import com.example.exam_second.model.Category;
import com.example.exam_second.model.Product;
import com.example.exam_second.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product t) {
        productRepository.save(t);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(e->productRepository.deleteById(e));
    }

    @Override
    public Page<Product> search(String by, String val, Pageable pageable) {
        if("All".equals(by) || val.isEmpty())
            return productRepository.searchAll(val,pageable);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("Category".equals(by)?"category.name":by.toLowerCase(),contains().ignoreCase());

        Product product =  Product.builder().name(val).startPrice(StringUtil.parseIntegerOrDefault(val)).category(Category.builder().name(val).build()).build();
        return productRepository.findAll(Example.of(product,matcher),pageable);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
