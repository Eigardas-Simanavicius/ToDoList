import javafx.scene.control.Button
import scalafx.stage.Stage
import scalafx.scene.Group

class MainPage(stage: Stage,root: Group):

  private val newTaskButton = Button("+")
  newTaskButton.setPrefSize(100, 100)
  newTaskButton.setLayoutX(850)
  newTaskButton.setLayoutY(50)
  newTaskButton.applyCss()
  root.getChildren.addAll(newTaskButton)





