import javafx.scene.control.Button
import scalafx.stage.Stage
import scalafx.scene.{Group, Scene}
import scalafx.Includes.*
import scalafx.event
import scalafx.geometry.Insets
import scalafx.scene.layout.{StackPane, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Text

/**
 * This object builds guiObjects and sets them up 
 */
object GuiBuilder:
  // buils new task button
  def buildnewTaskButton(tm: TaskManager): Button =
    var button = Button("+")
    button.setPrefSize(100, 100)
    button.setLayoutX(850)
    button.setLayoutY(50)
    button.getStyleClass.clear()
    button.getStyleClass.add("button")

    button.setOnMouseClicked(event => {
     button.disable = true
      tm.newTask()
    })

    button
  
  // builds enter button
  def enterButtonBuilder(button: Button): Unit = 
    button.getStyleClass.clear()
    button.getStyleClass.add("button")
    button.setLayoutX(400)
    button.setLayoutY(550)
    button.setPrefWidth(200.00)



  // builds the box which is used to play textfields for 
  def boxBuilder(): Rectangle =
    var rectangle = Rectangle(375,375,250,250)
    rectangle.setFill(Color.rgb(179, 156, 93,0.5))
    rectangle.stroke = Color.Black
    rectangle.strokeWidth = 1
    rectangle

  // builds the task gui
  def buildTask(Number: Int, task: Task, tm: TaskManager): VBox =
    
  // going to use a vbox
    var vbox = VBox()
    vbox.setLayoutX(70)
    // Y layout math is like this as tasks get added they dont stack onto each other 
    vbox.setLayoutY(70 + (Number * 120))
    vbox.getStyleClass.add("task")
    var text = Text(task.name)
    var text2 = Text("Due date: " + task.day.toString + " / " + task.month.toString)


    vbox.setPadding(Insets(10))
    vbox.setPrefWidth(400)
    vbox.setPrefHeight(100)
    vbox.setSpacing(40)

    text.setLayoutX(80)
    text.setLayoutY(85 + (Number * 120))

    vbox.getChildren.addAll(text,text2)


    vbox.setOnMouseClicked(event => {
      tm.selectTask(Number)
      if tm.selectedTask != null then
      vbox.setStyle("-fx-background-color: #d8aa28;")
    })

    vbox

  // builds the delete button gui 
  def deleteButtonBuild(taskManager: TaskManager):  Button =
    var button = Button("Delete")
    button.setPrefSize(100, 100)
    button.setLayoutX(850)
    button.setLayoutY(200)
    button.getStyleClass.clear()
    button.getStyleClass.add("button")

    button.setOnMouseClicked(event => {
      taskManager.deleteTask()
    })

    button