import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher{
//    public void launch(){
//        String[] contextPaths=new String[]{"META-INF/app-context.xml"};
//        new ClassPathXmlApplicationContext(contextPaths);
//    }

    public  void launch(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppContext.class);
        context.refresh();
    }
}
