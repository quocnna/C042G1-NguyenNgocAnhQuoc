package com.example.blog.service;

import com.example.blog.Common.StringUtil;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blog.setCreatedOn(LocalDate.now());
        blogRepository.save(blog);
    }

    @Override
    public void deleteByIds(int[] ids) {
        Arrays.stream(ids).forEach(i->blogRepository.deleteById(i));
    }

    @Override
    public Page<Blog> search(String by, String val, Pageable pageable) {
        if("All".equals(by) || val.isEmpty())
            return blogRepository.searchAll(val,pageable);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("Category".equals(by)?"category.name":by.toLowerCase(),contains().ignoreCase());

        Blog blog =  Blog.builder().title(val).content(val).likes(StringUtil.parseIntegerOrDefault(val)).category(Category.builder().name(val).build()).build();
        return blogRepository.findAll(Example.of(blog,matcher),pageable);
    }
}
