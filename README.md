# CSVanalytics

This is a small console program that works with CSV files. The user sets the path to the folder where many CSV files are stored (it is important that each file is structured specifically for the product class and have 5 columns: product identifier (integer), name (string),
condition (line), state (line), price (float)) that can contain more than a million lines. The program analyzes all the files located in the user-specified folder, creates a new CSV file by the name specified by the user in the folder also specified by the user, and records the cheapest 1000 products in the created CSV file, given the rule of not repeating the product identifier more than 20 times.
The user also sets the maximum number of threads simultaneously working in the system.
