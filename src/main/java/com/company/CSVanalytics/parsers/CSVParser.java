package com.company.CSVanalytics.parsers;

import com.company.CSVanalytics.domain.Product;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVParser {

    public static List<Product> getProductList(String CSVPath) throws IOException {

        Path myPath = Paths.get(CSVPath);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<Product> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Product.class);


            CsvToBean<Product> csvToBean = new CsvToBeanBuilder<Product>(br)
                    .withType(Product.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();


        }
    }

}
