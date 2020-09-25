package com.example.examination.common;

import com.example.examination.model.Category;
import com.example.examination.repository.CategoryRepository;
import com.example.examination.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.util.Locale;

public class CategoryFormater implements Converter<String, Category> {
    @Autowired
    CategoryService categoryService;

    @Override
    public Category convert(String source) {
        categoryService.findById(2);
        return new Category();
    }
}


//public class StringToEmployeeConverter
//        implements Converter<String, Employee> {
//
//    @Override
//    public Employee convert(String from) {
//        String[] data = from.split(",");
//        return new Employee(
//                Long.parseLong(data[0]),
//                Double.parseDouble(data[1]));
//    }
//}
