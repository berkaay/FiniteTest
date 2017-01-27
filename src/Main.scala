import java.lang.Boolean

import scala.util.Random

/**
  * Created by berkay on 25/01/2017.
  */
object Main {
  def main(args :Array[String]) : Unit = {
    var mainFsm:FSM = new FSM
    mainFsm.nextState(mainFsm.currentState,mainFsm.currentInputs,mainFsm.states)


  }
  abstract class State() {
    def order()
    def waiterComes()
    def doesNotOrder()
    def noWaiterComes()
  }
  class CustomerIn() extends State{

    def order(): Unit ={
      println("go to S1")
    }

    def waiterComes(): Unit ={
      println("stay in s0")
    }

    def doesNotOrder(): Unit ={
      println("stay in s0")
    }

    def noWaiterComes(): Unit ={
      println("stay in s0")
    }
    override def toString() : String = {
      "CustomerIn"
    }
  }

  class OrderedCustomer() extends State{

    def order(): Unit ={
      println("go to S1")
    }

    def waiterComes(): Unit ={
      println("stay in s3")
    }

    def doesNotOrder(): Unit ={
      println("stay in s1")
    }

    def noWaiterComes(): Unit ={
      println("stay in s2")
    }
    override def toString() : String = {
      "OrderedCustomer"
    }

  }

  class WaiterComes() extends State{

    def order(): Unit ={
      println("go to S0")
    }

    def waiterComes(): Unit ={
      println("stay in s0")
    }

    def doesNotOrder(): Unit ={
      println("stay in s0")
    }

    def noWaiterComes(): Unit ={
      println("stay in s0")
    }
    override def toString() : String = {
      "WaiterComes"
    }

  }

  class NoWaiterComes() extends State{

    def order(): Unit ={
      println("go to S2")
    }

    def waiterComes(): Unit ={
      println("stay in s3")
    }

    def doesNotOrder(): Unit ={
      println("stay in s2")
    }

    def noWaiterComes(): Unit ={
      println("stay in s2")
    }

    override def toString() : String = {
      "NoWaiterComes"
    }
  }


  object State extends Enumeration {
    type State = Value
    val CUSTOMERIN, ORDEREDCUSTOMER, WAITERCOMES, NOWAITERCOMES = Value
  }

  class FSM {
    val states = Map("0" -> new CustomerIn, "1" -> new OrderedCustomer, "2" -> new WaiterComes, "3" -> new NoWaiterComes)
    var currentState = 0
    var currentInputs = Map("order" -> null, "noOrder" -> null, "waiter" -> null, "noWaiter" -> null)

    def nextState(currentState: Int, currentInputs: Map[String, Boolean], states: Map[String, State]): Int = {
      if (currentState == 0) {
        var input = currentInputs.get("order")
        if (input == Some(true)) {
          return 1
        } else if (input == Some(false)) {
          return 0
        }

    } else if (currentState == 1) {
        var input = currentInputs.get("waiter")
        if (input == Some(true)) {
          return 2
        } else if (input == Some(false)) {
          return 3
        }

    } else if (currentState == 2) {
        var input = currentInputs.get("waiter")
        if (input == Some(true)) {
          return 2
        } else if (input == Some(false)) {
          return 3
        }
    } else if (currentState == 3) {
      return 0
    }
  return -1
//      currentState match {
//          case states.get("0") => {
//            println("lol")
//          }
//          case states.get("1") => {
//            println("lol")
//          }
//          case states.get("2") => {
//            println("lol")
//          }
//          case states.get("3") => {
//            println("lol")
//          }
//        }
    }


  }



}