package com.example.scalalearning.test2

object basic10_StatefulService {
  def main(args: Array[String]): Unit = {
    println("=== basic10: Stateful service ===")
    val initial = ServiceState.Idle
    val commands = List(ServiceCommand.Start, ServiceCommand.Process("msg"), ServiceCommand.Stop)

    val finalState = commands.foldLeft(initial) { (state, command) =>
      println(s"Processing $command from $state")
      state.transition(command)
    }

    println(s"final state -> $finalState")
  }

  sealed trait ServiceState {
    def transition(command: ServiceCommand): ServiceState
  }

  object ServiceState {
    case object Idle extends ServiceState {
      def transition(command: ServiceCommand): ServiceState = command match {
        case ServiceCommand.Start => Running(0)
        case _ => Idle
      }
    }

    final case class Running(count: Int) extends ServiceState {
      def transition(command: ServiceCommand): ServiceState = command match {
        case ServiceCommand.Process(_) => Running(count + 1)
        case ServiceCommand.Stop => Idle
        case ServiceCommand.Start => Running(count)
      }
    }
  }

  sealed trait ServiceCommand
  object ServiceCommand {
    case object Start extends ServiceCommand
    case object Stop extends ServiceCommand
    final case class Process(payload: String) extends ServiceCommand
  }
}
