package com.knoldus.demo

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.util.Success

class CounterSpec
  extends TestKit(ActorSystem("TestCount"))
  with ImplicitSender
  with AnyWordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "A Counter actor" must {
    "increment counter if Increment msg is received" in {
      val counter = TestActorRef[Counter]
      counter ! Increment
      counter.underlyingActor.counter shouldBe 1
    }

    "return counter value if Display msg is received" in {
      val counter = TestActorRef[Counter]
      implicit val timeout:Timeout = 20.seconds
      val count = counter ? Display
      assert(count.isCompleted && count.value.contains(Success(0)))
    }
  }

}
