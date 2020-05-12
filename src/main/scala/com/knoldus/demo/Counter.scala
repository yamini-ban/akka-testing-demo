package com.knoldus.demo

import akka.actor.{Actor, ActorLogging}

class Counter extends Actor with ActorLogging{
  var counter = 0
  override def receive: Receive = {
    case Increment => counter = counter + 1
      log.info(counter.toString)
    case Display => log.info(counter.toString)
      sender ! counter
  }
}
