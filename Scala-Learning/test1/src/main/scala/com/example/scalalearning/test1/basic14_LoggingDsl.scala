package com.example.scalalearning.test1

object LoggingDsl {
  def main(args: Array[String]): Unit = {
    println("=== Scala Logging DSL ===\n")
    val logContext = LoggingContext(user = "scala-user", requestId = "req-123")
    logContext.info("Starting pipeline").append("step", "1").info("Step 1 done")
    logContext.withField("module", "basic14").warn("Low disk space")
  }

  case class LoggingContext(user: String, requestId: String, fields: Map[String, String] = Map.empty) {
    def info(message: String): LoggingContext = log("INFO", message)
    def warn(message: String): LoggingContext = log("WARN", message)
    def withField(key: String, value: String): LoggingContext = copy(fields = fields + (key -> value))
    private def log(level: String, message: String): LoggingContext = {
      val meta = (fields ++ Map("user" -> user, "requestId" -> requestId)).map { case (k, v) => s"$k=$v" }.mkString(" ")
      println(s"[$level] $message ($meta)")
      this
    }
    def append(key: String, value: String): LoggingContext = withField(key, value)
  }
}
