package com.knoldus.demo

import akka.actor.{Actor, ActorLogging, Props}

object Counter {
  sealed trait Message
  case object Display extends Message
  case object Increment extends Message

  def props: Props = Props(new Counter)
}

class Counter extends Actor with ActorLogging{

  import Counter._

  var counter = 0
  override def receive: Receive = {
    case Increment => counter = counter + 1
      log.info(counter.toString)
    case Display => log.info(counter.toString)
      sender ! counter
  }
}
