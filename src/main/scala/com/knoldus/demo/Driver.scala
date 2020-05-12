package com.knoldus.demo

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.routing.RoundRobinPool
import akka.util.Timeout

import scala.concurrent.duration._

object Driver extends App {
Thread.sleep(5000)
  val system = ActorSystem("Count")
  val props = Props[Counter]
  val actor = system.actorOf(props, "increment")
//  val actor = system.actorOf(RoundRobinPool(3).props(props).withDispatcher("my-dispatcher"), "increment")
  implicit val timeout: Timeout = 10.seconds
  for (i <- 1 to 10) {
    actor ! Increment
    actor ? Display
  }
  system.terminate()
}
