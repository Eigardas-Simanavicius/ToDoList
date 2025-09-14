
import javafx.scene.control.Button
import scalafx.scene.{Group, Scene}


import scala.swing.event.{Key, MouseEntered}
import scalafx.scene.control.{Label, TextField}

import scalafx.scene.shape.Rectangle
class TaskBuilder(root: Group,tm: TaskManager):


  var dueDate: Array[Int] = Array.fill(2) {0}
  var name = ""


  def buildTask(): Unit =

    var enterButton = Button("Enter")
    var textList: List[TextField] = List.fill(3)(TextField())
    textList.foreach(_.setLayoutX(400))
    textList.foreach(_.setPrefWidth(200))

    var box = GuiBuilder.boxBuilder()

    textList(0).setPromptText("Enter Name of task")
    textList(1).setPromptText("Enter due day of task")
    textList(2).setPromptText("Enter due month of task (1-12)")

    textList(0).setLayoutY(400)
    textList(1).setLayoutY(450)
    textList(2).setLayoutY(500)

    GuiBuilder.enterButtonBuilder(enterButton)

    root.getChildren.addAll(box,textList(0),textList(1),textList(2), enterButton)
    enterButton.setOnMouseClicked(event => {
      name = textList(0).getText()
      dueDate(0) = textList(1).getText().toInt
      dueDate(1) = textList(2).getText().toInt

      root.getChildren.removeAll(box,textList(0),textList(1),textList(2), enterButton)
      tm.taskCreater(name,dueDate)
    })


