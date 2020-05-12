package com.knoldus.demo

sealed trait CounterMsg

case object Display extends CounterMsg
case object Increment extends CounterMsg
