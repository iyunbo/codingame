package puzzle.medium.Skynet

import scala.collection.mutable
import scala.math._
import scala.util._

/**
  * Auto-generated code below aims at helping you parse
  * the standard input according to the problem statement.
  **/
object Player extends App {

  def update(graph: Vector[Vector[Int]], edge: (Int, Int)): Vector[Vector[Int]] = {
    if (!graph(edge._1).contains(edge._2)) {
      val g = graph.updated(edge._1, graph(edge._1) :+ edge._2)
      return g.updated(edge._2, graph(edge._2) :+ edge._1)
    }
    graph
  }

  def createGraph(nodeCount: Int): Vector[Vector[Int]] = {
    var graph = Vector[Vector[Int]]()
    (1 to nodeCount).foreach(x => graph = graph :+ Vector[Int]())
    graph
  }

  def nextEdgeToCut(graph: Vector[Vector[Int]], agent: Int, gateways: Seq[Int]): String = {
    var allPaths = Vector[mutable.Stack[Int]]()
    gateways.foreach(g => allPaths = allPaths :+ findPathToGateway(graph, agent, g))
    val paths = allPaths.filter(_.nonEmpty)
    if (paths.isEmpty) {
      return "error"
    }
    val targetPath = paths.minBy(_.length)
    val last = targetPath.pop()
    targetPath.pop() + " " + last
  }

  def searchDFS(graph: Vector[Vector[Int]], target: Int, path: mutable.Stack[Int]): mutable.Stack[Int] = {
    require(graph != null && target >= 0 && graph.length > target && path != null && path.nonEmpty)
    val current = path.top
    if (current == target) {
      return path
    }
    graph(current).filter(!path.contains(_)).foreach(x => {
      val p = searchDFS(graph, target, path.push(x))
      if (p.nonEmpty && p.top == target) return p
    })
    mutable.Stack[Int]()
  }

  def searchBFS(graph: Vector[Vector[Int]], target: Int, path: mutable.Stack[Int]): mutable.Stack[Int] = {
    require(graph != null && target >= 0 && graph.length > target && path != null && path.nonEmpty)
    val current = path.top
    if (graph(current).contains(target)) {
      return path.push(target)
    }
    graph(current).filter(!path.contains(_)).foreach(x => {
      val p = searchBFS(graph, target, path.push(x))
      if (p.nonEmpty && p.top == target)
        return p
    })
    mutable.Stack[Int]()
  }

  def findPathToGateway(graph: Vector[Vector[Int]], origin: Int, target: Int): mutable.Stack[Int] = {
    searchBFS(graph, target, mutable.Stack(origin))
  }

  // n: the total number of nodes in the level, including the gateways
  // l: the number of links
  // e: the number of exit gateways
  val Array(n, l, e) = for (i <- readLine split " ") yield i.toInt
  var graph = createGraph(n)
  for (i <- 0 until l) {
    // n1: N1 and N2 defines a link between these nodes
    val Array(n1, n2) = for (i <- readLine split " ") yield i.toInt
    graph = update(graph, (n1, n2))
  }
  var gateways = mutable.Seq[Int]()
  for (i <- 0 until e) {
    val ei = readInt // the index of a gateway node
    gateways = gateways :+ ei
  }

  // game loop
  while (true) {
    val si = readInt // The index of the node on which the Skynet agent is positioned this turn

    // Write an action using println
    // To debug: Console.err.println("Debug messages...")

    // Example: 0 1 are the indices of the nodes you wish to sever the link between
    println(nextEdgeToCut(graph, si, gateways))
  }


}


