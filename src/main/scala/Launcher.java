
/**
 * This launcher class, is used for fat jars,where the javafx does not need to be installed,
 * and you dont have to use the command line. 
 */
public class Launcher {
    public static void main(String[] args) {
        // https://taylorial.com/tools/jar/
        // TLDR this is used as a target for our jar file, this makes the jar file bigger, but also means
        // you dont need to run it in the cmd line and have jfx insalled.
        Main.main(args);
    }
}