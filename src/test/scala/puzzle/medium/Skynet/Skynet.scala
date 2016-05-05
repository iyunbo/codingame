package puzzle.medium.Skynet

import org.scalatest.{FlatSpec, Matchers}
import puzzle.medium.Skynet.Player._

import scala.collection.mutable

/**
  * Created by iyunbo on 05/05/16.
  */
class Skynet extends FlatSpec with Matchers {

  it should "find a path by DFS if exists" in {
    searchDFS(graph, 6, mutable.Stack(1)).top should be(6)
  }

  it should "find a path by BFS if exists" in {
    searchBFS(graph, 6, mutable.Stack(1)).top should be(6)
  }

  it should "return the path with target at the end" in {
    findPathToGateway(graph, 1, 6).top should be(6)
  }

  it should "return the path in a star graph" in {
    nextEdgeToCut(star, 5, Seq(0)) should be("5 0")
  }

  it should "print the next edge to cut" in {
    nextEdgeToCut(graph, 1, Seq(8, 4, 7, 6)) should be("1 8")
  }

  it should "return error if no path found" in {
    nextEdgeToCut(diconected, 0, Seq(2)) should be("error")
  }

  it should "return empty if no path found" in {
    findPathToGateway(diconected, 0, 2).isEmpty should be(true)
  }

  it should "initialize an empty graph" in {
    createGraph(5).length should be(5)
  }

  it should "insert an edge into graph" in {
    val newGraph = update(graph, (0, 4))
    newGraph(0) should contain(4)
    newGraph(4) should contain(0)
  }

  it should "do nothing when inserting an existing edge" in {
    val newGraph = update(update(graph, (0, 4)), (0, 4))
    update(graph, (0, 4)) should be(newGraph)
  }

  val graph = Vector(
    Vector(1, 8),
    Vector(0, 3, 8),
    Vector(3, 6),
    Vector(1, 2, 4, 5),
    Vector(3, 7),
    Vector(3, 6, 7),
    Vector(2, 5),
    Vector(4, 5),
    Vector(0, 1, 2)
  )

  val star = Vector(
    Vector(9, 1, 6, 2, 8, 4, 5, 7, 3, 10),
    Vector(2, 0, 10),
    Vector(1, 3, 0),
    Vector(2, 4, 0),
    Vector(5, 3, 0),
    Vector(11, 4, 0, 6),
    Vector(11, 7, 0, 5),
    Vector(6, 8, 11, 0),
    Vector(9, 7, 0),
    Vector(0, 8, 10),
    Vector(1, 9, 0),
    Vector(6, 5, 7)
  )

  val diconected = Vector(
    Vector(),
    Vector(2),
    Vector()
  )

}
