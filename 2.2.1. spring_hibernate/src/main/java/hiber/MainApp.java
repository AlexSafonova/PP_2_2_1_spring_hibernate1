package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Jonny", "Kubrick", "coolJonny@bk.ru");
      User user2 = new User("Marco", "Polo", "letsPlaygame@gmail.com");
      User user3 = new User("Jacob", "Wolfe", "ouuuuuuu@bk.com");
      Car car1 = new Car("BMW", 1);
      Car car2 = new Car("Mercedes", 2);
      Car car3 = new Car("Audi", 3);
      user1.setCar(car2);
      user2.setCar(car3);
      user3.setCar(car1);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      System.out.println(userService.getUserbyCar("BMW", 1));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }


      context.close();
   }
}
