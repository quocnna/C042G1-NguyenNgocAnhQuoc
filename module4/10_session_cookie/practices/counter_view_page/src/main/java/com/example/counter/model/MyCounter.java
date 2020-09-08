package com.example.counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyCounter {
    private int count;

    public int increment() {
        return count++;
    }
}
