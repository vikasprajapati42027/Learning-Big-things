package com.example.hdfslearning.test1

object basic33_HdfsFsImageBrowseNote {
  def main(args: Array[String]): Unit = {
    println("fsimage browsing: use offline image viewer to inspect namespace without a running NN.")
    println("Example: hdfs oiv -i fsimage_0000000000001234567 -o fsimage.txt -p FileDistribution")
    println("Useful for troubleshooting quotas, path counts, and large directory hotspots.")
  }
}
