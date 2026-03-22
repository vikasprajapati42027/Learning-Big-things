package com.example.scalalearning.test2

object basic49_MergeSorter {
  def main(args: Array[String]): Unit = {
    println("=== basic49: Merge sorter ===")
    println(mergeSort(List(3, 1, 2, 5, 4)))
  }

  def mergeSort(list: List[Int]): List[Int] =
    list match {
      case Nil => Nil
      case single :: Nil => List(single)
      case _ =>
        val (left, right) = list.splitAt(list.length / 2)
        merge(mergeSort(left), mergeSort(right))
    }

  def merge(left: List[Int], right: List[Int]): List[Int] =
    (left, right) match {
      case (Nil, _) => right
      case (_, Nil) => left
      case (lHead :: lTail, rHead :: rTail) if lHead <= rHead => lHead :: merge(lTail, right)
      case (lHead :: lTail, rHead :: rTail) => rHead :: merge(left, rTail)
    }
}
