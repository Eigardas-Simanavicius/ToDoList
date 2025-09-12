
import javafx.scene.control.Button
import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.*
import scalafx.scene.paint.Color.*
import scalafx.scene.text.Text
import scalafx.scene.Group
import scalafx.stage.Stage

import scala.language.implicitConversions

object Main extends JFXApp3 :

  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage
    var root = Group()
    val scene = Scene(root,1000,1000)
    scene.fill = Color.rgb(237, 210, 135)
    stage.setTitle("Stuff Organiser")
    stage.setScene(scene)
    
    MainPage(stage,root)
   

    stage.show()




