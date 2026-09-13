
# Big Data Analytics of E-Commerce Sales Transactions Using Hadoop MapReduce and Apache Pig

This project analyzes an E-Commerce dataset using the Hadoop ecosystem. The workflow covers loading data into HDFS, running MapReduce jobs for core aggregations, and using Apache Pig for deeper, more flexible analysis on top of the same dataset.




## Technologies Used
- Hadoop HDFS 3.2.4
- Apache Pig 0.18.0
- Java for the MapReduce part
- Windows
## Project Workflow
E-Commerce Dataset ->HDFS ->MapReduce ->Apache Pig->Analysis Results


## Folder Structure
ECommerceBigData
1.dataset -> the raw csv (not uploaded here, too big)
2.mapreduce -> MapReduce driver/mapper/reducer code
3.classes -> compiled classes (not uploaded) 
4.jar -> the jar used to run MapReduce jobs
5.pig  -> all the .pig scripts
6.README.md
7.Ecommerce_project_report.pdf

## Dataset
The E-Commerce Order dataset (`ecommerce_dataset_+1m.csv`) is used for this project.
```cmd
hdfs dfs -put ecommerce_dataset_+1m.csv /ecommerce/input/
```
## MapReduce Analysis(4 jobs)
1. OrderCount (Driver, Mapper, Reducer) — Total Order Count
2. CategorySales (Driver, Mapper, Reducer) — Category-wise Total Sales
3. AvgOrderValue (Driver, Mapper, Reducer) — Average Order Value by Country
4. ProfitByPaymentMethod (Driver, Mapper, Reducer) — Total Profit by Payment Method

To see the output:
```cmd
hdfs dfs -cat /ecommerce/output/mapreduce/<OutputName>/part-r-00000
```
## Apache Pig Analysis (10 Scripts)
1. RowCountCheck 
2. TotalOrderCount
3. CategoryWiseSales
4. AvgOrderValueByCountry
5. PaymentMethodDistribution
6. MonthlySalesTrend
7. Top10BestSellingProducts
8. Top10CountriesByRevenue
9. BrandWiseTotalProfit
10. DeliveryStatusBreakdown

Run from inside the `pig/` folder:
```cmd
pig -x mapreduce <script_name>.pig
```
To see the output:
```cmd
hdfs dfs -cat /ecommerce/output/pig/<OutputName>/part-*
```
## Author

Anamika Roy