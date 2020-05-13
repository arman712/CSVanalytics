package com.company.CSVanalytics.util;

import com.company.CSVanalytics.domain.Product;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SimpleCSVWriter {

    static public File toCSVFile(List<Product> products, String path, String name) {
        File pathFile = new File(path);
        pathFile.mkdirs();
        File returnFile = new File(path +"\\" + name + ".csv");
        try {

            CSVWriter writer = new CSVWriter(new FileWriter(returnFile));
            writer.writeNext(new String[]{"id","name","condition","state","price"});


            for (Product product : products) {
                writer.writeNext(new String[]{String.valueOf(product.getId()), product.getName(), product.getCondition(), product.getState(), String.valueOf(product.getPrice())});

            }

            writer.flush();
            writer.close();
            return returnFile;
        } catch (IOException e) {

            return null;
        }
    }
}
