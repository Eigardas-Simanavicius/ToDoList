import Main.stage
import javafx.scene.control.Button
import scalafx.scene.Scene
import scalafx.scene.Group


import scala.collection.mutable.ListBuffer
/**
 * Class which focuses on managing the tasks
 */
class TaskManager(root: Group, scene: Scene):

  var button = GuiBuilder.buildnewTaskButton(this)
  var deleteButton = GuiBuilder.deleteButtonBuild(this)
  private var mainPage: MainPage = MainPage(stage,root,scene,this)
  var selectedTask:  Task = _
  var ts = TaskBuilder(root,this)


    // tasklist hold all the tasks
  private var taskList: ListBuffer[Task] = ListBuffer()
    // collects the task details
  def newTask(): Unit =
    ts.buildTask()

  // creates the tasks and its logic
  def taskCreater(name: String, dueDate: Array[Int]): Unit =
    var newTask = Task(dueDate(0),dueDate(1),name)
    button.setDisable(false)
    addToList(newTask)

  // adds the task to the list, sorting the tasklist by due date
  def addToList(newTask: Task):Unit =
    taskList += newTask
    if(taskList.size > 1){
      // this is quite a useful function to be able to sort things like this
     taskList = taskList.sortBy(r => (r.day) + (r.month) )
    }
    mainPage.updateTaskList(getList())

// returns the taskList
  def getList(): ListBuffer[Task] =
    taskList


  // called on a task when it is selected
  def selectTask(taskNumber: Int): Unit =
    mainPage.taskGuiList.foreach(_.setStyle("fx-background-color: #edc555"))
    selectedTask = taskList(taskNumber)

  // deletes a task from the task list
  def deleteTask(): Unit =
    if selectedTask != null then
      taskList.remove(taskList.indexOf(selectedTask))
      mainPage.updateTaskList(taskList)
      selectedTask = null
