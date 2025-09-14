
import scalafx.stage.Stage
import scalafx.scene.{Group, Scene}
import scalafx.scene.layout.VBox

import scala.collection.mutable.ListBuffer

class MainPage(stage: Stage,root: Group, scene: Scene, tm: TaskManager):

    var personalTaskList: ListBuffer[Task] = ListBuffer()
    var taskGuiList: ListBuffer[VBox] = ListBuffer()
    root.getChildren.addAll(tm.button,tm.deleteButton)


    def updateTaskList(taskList: ListBuffer[Task]): Unit =
      taskGuiList.map(root.getChildren.remove(_))
      for i <- taskList.indices do
        val task = GuiBuilder.buildTask(i, taskList(i),tm)
        taskGuiList.append(task)
        root.getChildren.addAll(task)

