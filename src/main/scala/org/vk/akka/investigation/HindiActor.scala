package org.vk.akka.investigation

import akka.actor.{Actor, Props, ActorSystem}

class HindiActor extends Actor {
  def receive = {
    // General strings as messages? Actor anti-pattern
    case "Good Morning" =>
      println ("Actor: Shubh Prabhat") // Do some actual work here
    case "How are you?" =>
      println ("Actor: Main theek hun, aap kaise ho?")
  }
}

object HindiActorMain {
  val system = ActorSystem("HindiActor")
  val actor = system.actorOf(Props[HindiActor], "Shrimaan")

  def send(msg: String) = {
    println(s"Me: $msg")
    actor ! msg
    Thread.sleep(100) // actor anti-pattern
  }

  def main(args: Array[String]) {
    send("Good Morning")
    send("How are you?")
    system.shutdown()
  }
}