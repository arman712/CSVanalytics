package com.company.CSVanalytics.util;

import com.company.CSVanalytics.domain.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingProduct {

    public static List<Product> getSortedList(List<Product> products){
        return products.stream().
                sorted(Comparator.comparing(Product::getPrice)).
                collect(Collectors.toList());
    }
}
