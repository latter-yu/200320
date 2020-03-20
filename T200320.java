

class Test {
    //main2
    //static：
    //1.只可调用一份，在方法区内（方法区存放的是static修饰的变量）
    //2.所有静态方法只可用类名调用
    //3.不依赖与对象
    public int a;
    public static int b;
}

class Person {
    //main1
    //class:定义类（自定义类型）:类 --> 对象（实体）
    //声明一个类：Person(类名 -- 大驼峰形式)
    //类的成员可以包含以下：字段(属性、成员变量)、方法、代码块、内部类和接口等。
    public String name;
    //属性(成员变量)
    //访问修饰限定符: public、private、protected
    public int age = 3;
    //赋初值的第一种方法
    //赋初值的第一种方法
    public int tall;
    public static int count;
    //静态成员属性(静态成员变量)  在内存方法区中，只有一份
    //static: 不属于对象，属于类本身，需用类名调用，否则会有警告

    public final int SIZE1 = 10;
    //常量 --> 不能被修改   属于对象
    //一个属性存放在哪个区域，和是否被final修饰无关
    public static final int SIZE2 = 100;
    //常量  属于类本身（static修饰）

    //行为(成员方法) --> 相当于方法(可不用关键字static修饰)
    //用对象调用
    public void eat() {
        System.out.println("吃饭！");
        //依然在栈上
    }

    public static void func() {
        System.out.println("static");
        //静态成员方法内，不可以访问非静态数据成员，用类调用
        //例：不可访问age, 可访问count；
        //因此main方法只可调用有static修饰的方法
    }
}

public class T200320 {

    public static void main2(String[] args) {
        Test test1 = new Test();

        test1.a++;
        Test.b++;
        System.out.println(test1.a);//1
        System.out.println(Test.b);//1

        System.out.println();

        Test test2 = new Test();
        test2.a++;
        Test.b++;
        System.out.println(test2.a);//1
        System.out.println(Test.b);//2
    }

    public static void main1(String[] args) {
        Person person = new Person();
        //实例化一个对象：（new 是一个关键字）
        //类名 + 变量名 = new + 类名（）;

        //输出：引用.属性（行为）
        System.out.println(person.age);//3
        System.out.println(person.name);//null
        //成员变量若没有赋予初始值，那么它的值默认为对应类型的0值
        //String等引用类型：null  int: 0  char: '\u0000'  boolean: false  double: 0.0  float: 0.0f

        person.tall = 180;
        //赋初值的第二种方法
        System.out.println(person.tall);//180
        System.out.println(Person.count);//0
        person.eat();//吃饭！
        Person.func();
        //所有的静态（static）方法或者属性，都需要通过类名来调用 --> 不依赖于对象

        System.out.println(person.SIZE1);//10
        System.out.println(Person.SIZE2);//100
    }
}
