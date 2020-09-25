package com.example.exam_second.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NumberConverter implements Converter<String,Double> {
    @Override
    public Double convert(String source) {
        try{
            return Double.valueOf(source);
        }
        catch (Exception e)
        {
            return -1.0;
        }
    }
}
