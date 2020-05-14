package com.knoldus.demo

import akka.actor.ActorSystem
import akka.testkit.{EventFilter, ImplicitSender, TestActorRef, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class CounterSpec
  extends TestKit(ActorSystem("TestCount", ConfigFactory.parseString("""akka.loggers = ["akka.testkit.TestEventListener"]""")))
    with ImplicitSender
    with AnyWordSpecLike
    with Matchers
    with BeforeAndAfterAll {

  import Counter._

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "A Counter actor" should {
    "increment counter if Increment message is received" in {
      val counter = TestActorRef[Counter]
      counter ! Increment
      counter.underlyingActor.counter shouldBe 1
    }

    "log counter value if Display message is received" in {
      val counter = TestActorRef[Counter]
      EventFilter.info(source = counter.path.toString, pattern = "0", occurrences = 1) intercept {
        counter ! Display
      }
    }
  }

}
