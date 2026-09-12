# E-Commerce Big Data Analytics
## Project Description
This project analyzes an E-Commerce dataset containing over 1 million order records using the Hadoop ecosystem. The workflow covers loading data into HDFS, running MapReduce jobs for core aggregations, and using Apache Pig for deeper, more flexible analysis on top of the same dataset.

## Technologies Used
- Hadoop HDFS 3.2.4
- Apache Pig 0.18.0
- Java for the MapReduce part
- Windows

## Project Workflow
E-Commerce Dataset
↓
HDFS
↓
MapReduce
↓
Apache Pig
↓
Analysis Results

## Folder Structure
```
ECommerceBigData/
├── 1_dataset/
├── 2_mapreduce/
├── 3_classes/
├── 4_jar/
└── 5_pig/
```

## MapReduce Analysis
1. OrderCount (Driver, Mapper, Reducer) — Total Order Count
2. CategorySales (Driver, Mapper, Reducer) — Category-wise Total Sales
3. AvgOrderValue (Driver, Mapper, Reducer) — Average Order Value by Country
4. ProfitByPaymentMethod (Driver, Mapper, Reducer) — Total Profit by Payment Method

## Apache Pig Analysis
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

## Dataset
The E-Commerce Order dataset (`ecommerce_dataset_+1m.csv`) is used for this project.Didn't upload the actual file here since it's too large for git.

## Author
Anamika Roy
