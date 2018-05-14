object TestPma {
  def main(args: Array[String]): Unit = {
    println("ok")
    val m = org.saddle.Mat(2,2, Array(1.1,2.2,3.3,4.4))
    val s = stat.kmeans.matToSparse(m)
    val r = stat.kmeans.apply(m, org.saddle.mat.rand(2,2), 5)
    println(r)
    stat.kmeans.plot(s, r, 5)
  }
}
