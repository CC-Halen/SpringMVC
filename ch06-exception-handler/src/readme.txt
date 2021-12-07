ch01-springmvc: springmvc注解式开发

需求： 用户发起一个请求， springmvc接收请求， 显示请求的处理结果

servlet的实现方式：
       jsp发起----servlet---jsp显示结果


步骤：
1.新建web 应用
2.加入web依赖
  spring-webmvc依赖（springmvc框架依赖）， servlet依赖。

3.声明springmvc核心对象DispatcherServlet.
  1)DispatcherServlet是一个Servlet对象。
  2)DispatcherServlet叫做前端控制器（front controller）
  3)DispatcherServlet作用：
     1.在servlet的init（）方法中，创建springmvc中的容器对象。
       WebApplicationContext ctx = new ClassPathXmlApplicationContext("appliationContext.xml")


     2.作为servlet，接收请求。

4.创建一个jsp，发起请求

补充：创建异常类MyUserException，子类NameException、AgeException

5.创建一个普通的类，作为控制器使用（代替之前的servlet）
  1）在类的上面加入@Controller注解
  2）在类中定义方法， 根据请求的参数name、age的值抛出异常

6.创建作为结果的jsp页面

补充：异常处理类
1）类上面加上@Controller注解
2）类中定义方法处理异常，方法上面加上@ExceptionHandler

补充：创建异常处理的jsp页面

7.创建springmvc的配置文件（spring的配置文件一样）
  1）声明组件扫描器，指定@Controller注解所在的包名
  2）声明视图解析器对象
  补充：
  3）声明组件扫描器，找到@ControllerAdvice注解包名
  4）声明注解驱动

8.使用逻辑视图名称
