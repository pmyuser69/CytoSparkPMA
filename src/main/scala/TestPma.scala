import org.nspl._
import org.nspl.awtrenderer._
import org.nspl.saddle._
import org.saddle.{Mat, _}
import stat.kmeans.KMeansResult
import stat.sparse.SMat



object TestPma {
  def main(args: Array[String]): Unit = {

    println("ok")
    val m = org.saddle.Mat(2,2, Array(1.1,2.2,3.3,4.4))
    val s = stat.kmeans.matToSparse(m)
    val r = stat.kmeans.apply(m, org.saddle.mat.rand(2,2), 5)
    println(r)

    val p = plot2(s, r, 2)
    show(p)

    stat.kmeans.plot(s, r, 5)

    println("done")
  }

  def plot2(data: SMat, res: KMeansResult, max: Int) = {

    val projections = 0 until max combinations (2) map { g =>
      val c1 = g(0)
      val c2 = g(1)
      val col1 = data.map(s => s.values.first(c1).getOrElse(0d)).toVec
      val col2 = data.map(s => s.values.first(c2).getOrElse(0d)).toVec
      xyplot(
        Mat(col1, col2, res.clusters.map(_.toDouble)) -> point(
          labelText = false,
          color = DiscreteColors(res.clusters.length)))()
    }

    sequence(projections.toList, TableLayout(4))

  }

}
