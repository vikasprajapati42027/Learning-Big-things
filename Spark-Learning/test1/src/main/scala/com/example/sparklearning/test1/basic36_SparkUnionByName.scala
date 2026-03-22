package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic36_SparkUnionByName {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic36_SparkUnionByName").master("local[*]").getOrCreate()
    import spark.implicits._

    val df1 = Seq((1, "a")).toDF("id", "value")
    val df2 = Seq(("b", 2)).toDF("value", "id")

    val unioned = df1.unionByName(df2, allowMissingColumns = true)
    unioned.show()

    spark.stop()
  }
}
