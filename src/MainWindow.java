import javax.swing.JFrame;

public class MainWindow extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    public MainWindow(){
        super("My First Window"); //Заголовок окна
        setBounds(100, 100, 1000, 1000); //Если не выставить
        //размер и положение
        //то окно будет мелкое и незаметное
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при
        //закрытии окна закрывалась и программа,
        //иначе она останется висеть в процессах
    }

    public static void main(String[] args) { //эта функция может быть и в другом классе
        MainWindow mainWindow = new MainWindow(); //Создаем экземпляр нашего приложения
        mainWindow.add(new GraphicsPanel());
        mainWindow.setVisible(true); //С этого момента приложение запущено!
    }



}
