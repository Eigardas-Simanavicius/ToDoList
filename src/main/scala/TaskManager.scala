import Main.stage
import javafx.scene.control.Button
import scalafx.scene.Scene
import scalafx.scene.Group


import scala.collection.mutable.ListBuffer

class TaskManager(root: Group, scene: Scene):

  var button = GuiBuilder.buildnewTaskButton(this)
  var deleteButton = GuiBuilder.deleteButtonBuild(this)
  private var mainPage: MainPage = MainPage(stage,root,scene,this)
  var selectedTask:  Task = _
  var ts = TaskBuilder(root,this)


  private var taskList: ListBuffer[Task] = ListBuffer()
  def newTask(): Unit =
    ts.buildTask()

  def taskCreater(name: String, dueDate: Array[Int]): Unit =
    var newTask = Task(dueDate(0),dueDate(1),name)
    button.setDisable(false)
    addToList(newTask)

  def addToList(newTask: Task):Unit =
    taskList += newTask
    if(taskList.size > 1){
     taskList = taskList.sortBy(r => (r.day) + (r.month) )
    }
    taskList.foreach(r => println(r.day))
    mainPage.updateTaskList(getList())


  def getList(): ListBuffer[Task] =
    taskList


  def selectTask(taskNumber: Int): Unit =
    mainPage.taskGuiList.foreach(_.setStyle("fx-background-color: #edc555"))
    selectedTask = taskList(taskNumber)

  def deleteTask(): Unit =
    if selectedTask != null then
      taskList.remove(taskList.indexOf(selectedTask))
      mainPage.updateTaskList(taskList)
      selectedTask = null
