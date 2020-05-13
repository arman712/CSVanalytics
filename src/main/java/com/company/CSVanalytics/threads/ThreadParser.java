package com.company.CSVanalytics.threads;

import com.company.CSVanalytics.domain.Product;
import com.company.CSVanalytics.parsers.CSVParser;
import com.company.CSVanalytics.util.GlobalData;
import com.company.CSVanalytics.util.SortingProduct;
import com.company.CSVanalytics.util.Util;

import java.io.IOException;
import java.util.List;

public class ThreadParser implements Runnable {

    private String path;

    public ThreadParser(String path) {
        this.path = path;
        new Thread(this).start();


    }


    @Override
    public void run() {

        try {
            List<Product> productList = CSVParser.getProductList(path);
            Util.trimList(productList);
            List<Product> sortedProducts = SortingProduct.getSortedList(productList);
            List<Product> resultList = sortedProducts.subList(0, 1000);
            synchronized (GlobalData.getResultProducts()) {
                GlobalData.getResultProducts().addAll(resultList);
                GlobalData.setThreadCount(GlobalData.getThreadCount()-1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
