package com.example.spark

import org.apache.spark.sql.SparkSession

object SparkApp {
  def main(args: Array[String]): Unit = {
    // 1. Create SparkSession with HDFS and Hive Support
    // We provide configs matching your docker-compose container names natively.
    val spark = SparkSession.builder()
      .appName("Test3 Spark App")
      // Connect to the Spark Master container in the Docker network
      .master("spark://spark-master:7077") 
      // Point Spark to HDFS NameNode
      .config("spark.hadoop.fs.defaultFS", "hdfs://namenode:8020")
      // Point Spark to Hive Metastore
      .config("hive.metastore.uris", "thrift://hive-metastore:9083")
      // Allow Hive Support to create/query tables
      .enableHiveSupport()
      .getOrCreate()

    println("Spark Session created successfully!")

    // 2. Create some sample data
    val data = Seq(
      ("Alice", 28),
      ("Bob", 25),
      ("Charlie", 35)
    )

    // 3. Create a DataFrame
    // You need to import implicits to convert Scala sequences to DataFrames
    import spark.implicits._
    val df = data.toDF("Name", "Age")

    // 4. Show the data
    println("Here is our initial DataFrame:")
    df.show()

    // 5. Example: Write Data to HDFS
    println("Writing data to HDFS at /user/spark/sample_data...")
    // This will create a folder directly in your datanode/namenode setup
    df.write.mode("overwrite").csv("hdfs://namenode:8020/user/spark/sample_data")
    println("Successfully wrote data to HDFS!")

    // 6. Example: Query Hive
    println("Creating a sample database and table in Hive...")
    spark.sql("CREATE database IF NOT EXISTS test_db")
    // Save structure and data to a real Hive table backed by MySQL metastore
    df.write.mode("overwrite").saveAsTable("test_db.sample_table")
    
    println("Selecting data from Hive to verify:")
    spark.sql("SELECT * FROM test_db.sample_table").show()

    // 5. Stop the Spark session to release resources
    spark.stop()
  }
}
