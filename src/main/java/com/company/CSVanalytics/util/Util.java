package com.company.CSVanalytics.util;

import com.company.CSVanalytics.domain.Product;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Util {

    public static File[] getFiles(String dir) {
        File file = new File(dir);
        if (file.listFiles().length != 0) {
            return file.listFiles();
        }

        return null;
    }


    public static ConcurrentLinkedQueue<String> getFilesPaths(File[] files) {

        return Arrays.stream(files)
                .map(File::getAbsolutePath)
                .collect(Collectors.toCollection(ConcurrentLinkedQueue::new));
    }


    public static void trimList(List<Product> products) {
        products.removeIf(p -> StringUtils.isEmpty(p.getName()) &&
                StringUtils.isEmpty(p.getCondition()) && StringUtils.isEmpty(p.getState())
                && p.getPrice() == 0.0);
    }

    public static File  writeResult(List<Product> resultProducts, String packagePath, String fileName) {

        int duplicateIdCount = 0;
        int size = resultProducts.size();


        List<Product> resultList = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            if (resultList.size() == 1000) {
                break;
            }

            if (duplicateIdCount == 20) {
                boolean duplicate = false;

                for (int j = 0; j < resultList.size(); j++) {


                    if (resultProducts.get(i).getId() == resultList.get(j).getId()) {
                        duplicate = true;
                        break;
                    }

                }
                if (!duplicate) {
                    resultList.add(resultProducts.get(i));
                }

            } else {
                resultList.add(resultProducts.get(i));
                duplicateIdCount++;

            }
        }
        return SimpleCSVWriter.toCSVFile(resultList, packagePath, fileName);
    }


}
