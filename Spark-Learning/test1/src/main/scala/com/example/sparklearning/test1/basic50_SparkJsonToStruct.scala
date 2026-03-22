package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.from_json
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object basic50_SparkJsonToStruct {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic50_SparkJsonToStruct").master("local[*]").getOrCreate()
    import spark.implicits._

    val schema = StructType(Seq(StructField("id", IntegerType), StructField("name", StringType)))
    val json = Seq("""{"id":1,"name":"alice"}""").toDF("payload")
    val parsed = json.select(from_json($"payload", schema).as("obj")).select("obj.*")
    parsed.show()

    spark.stop()
  }
}
