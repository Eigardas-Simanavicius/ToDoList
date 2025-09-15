
import scalafx.stage.Stage
import scalafx.scene.{Group, Scene}
import scalafx.scene.layout.VBox

import scala.collection.mutable.ListBuffer
/**
 * This class holds all the main page gui elements and updates them as needed
 */
class MainPage(stage: Stage,root: Group, scene: Scene, tm: TaskManager):

    var personalTaskList: ListBuffer[Task] = ListBuffer()
    var taskGuiList: ListBuffer[VBox] = ListBuffer()
    root.getChildren.addAll(tm.button,tm.deleteButton)

    // updates the task list when called. 
    def updateTaskList(taskList: ListBuffer[Task]): Unit =
        // this is very brute force, it removes all the gui elements and then remakes them
      // a better method would be to only change the ones we need to, however for something as small as this, not necessary, tho if I revisit this ill probably clean it up
      taskGuiList.map(root.getChildren.remove(_))
      for i <- taskList.indices do
        val task = GuiBuilder.buildTask(i, taskList(i),tm)
        taskGuiList.append(task)
        root.getChildren.add(task)

