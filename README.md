# PMGChallenge
Coding interview challenge for PMG  

This program takes in a number of CSV that have the same columns, and combines them into a new one.  
It will also add a new column that contains the filename from where the data was originally from.

To run:  

1. Download or clone the respository 
2. In a terminal change into the folder PMGChallenge-master
3. There is a folder called /csv-combiner/fixtures which has 3 csv files ready to combine (feel free to move them elsewhere)
4. run: javac Main.java
5. run: java Main ./csv-combiner/fixtures/clothing.csv ./csv-combiner/fixtures/accessories.csv ./csv-combiner/fixtures/household_cleaners.csv (or the path of the files if you moved them)
6. The new file contents will be printed to your terminal and there will be a new CSV file in the directory called new.csv
