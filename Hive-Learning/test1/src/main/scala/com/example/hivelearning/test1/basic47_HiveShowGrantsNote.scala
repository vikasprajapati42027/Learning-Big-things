package com.example.hivelearning.test1

object basic47_HiveShowGrantsNote {
  def main(args: Array[String]): Unit = {
    println("Use SHOW GRANT to view privileges in Hive (when authorization enabled).")
    println("  SHOW GRANT USER alice ON TABLE db.tbl;")
    println("Align with Ranger/Sentry policies if in use.")
  }
}
