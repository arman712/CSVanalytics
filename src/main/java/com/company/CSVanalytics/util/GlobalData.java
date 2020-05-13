package com.company.CSVanalytics.util;

import com.company.CSVanalytics.domain.Product;

import java.util.ArrayList;

public class GlobalData {


        private static int threadCount=0;

        private static ArrayList<Product> resultProducts=new ArrayList<>();

        public static synchronized ArrayList<Product> getResultProducts() {
            return resultProducts;
        }

        public static synchronized void setResultProducts(ArrayList<Product> resultProducts) {
            GlobalData.resultProducts = resultProducts;
        }

        public static  synchronized int getThreadCount() {
            return threadCount;
        }

        public static synchronized void setThreadCount(int threadCount) {
            GlobalData.threadCount = threadCount;
        }
    }

