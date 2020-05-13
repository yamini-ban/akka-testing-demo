package com.knoldus.demo

import akka.actor.ActorSystem
import akka.pattern.ask
import akka.util.Timeout
import com.knoldus.demo.Counter.{Display, Increment}

import scala.concurrent.duration._

object Driver extends App {

  val system = ActorSystem("Count")
  val actor = system.actorOf(Counter.props, "increment")
//  val actor = system.actorOf(RoundRobinPool(3).props(props).withDispatcher("my-dispatcher"), "increment")
  implicit val timeout: Timeout = 10.seconds
  for (i <- 1 to 10) {
    actor ! Increment
    actor ? Display
  }
  system.terminate()
}
