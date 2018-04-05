package com.liyafeng.practice;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by liyafeng on 16/11/2017.
 */

public class Java {


    interface a {
        public static int b = 1;

        public abstract void aa();
    }

    static abstract class b {
        int a = 1;

        public void a() {

        }

        protected abstract void b();
    }

    //region Java基础

    /**
     * =====================
     * ### Java基础
     * =====================
     * */

    /**
     * 1.接口和抽象类的区别
     * http://www.importnew.com/12399.html
     */
    void a1() {
        /*
        * 从微观上说
        * 一个类能实现多个接口，但只能继承一个抽象类
        * 接口中只能有公有的抽象方法,而抽象类中可以有抽象方法，也可以没有抽象方法，也可以有普通方法
        * 接口中只能定义静态成员变量，而抽象类中可以定义非静态成员变量
        *
        * 相同点是他们都不能被实例化
        *
        * 从宏观上说
        * 定义抽象类是为了捕捉子类的通用特性，通用的实现逻辑可以在抽象类中完成，而接口中不能有逻辑
        * 而接口定义的是一种约定，实现这个接口就代表实现了接口中方法提供的服务
        *
        *
        *
        * */
    }

    /**
     * 说说String ，StringBuilder ,StringBuffer的区别
     * -------------------------
     * String如何保证不可变？为什么设计成不可变的？
     */
    public void a1_1() {
        /*
        * String 是一个不可变的字符序列
        * StringBuilder是可变的字符序列，他在单线程中使用，比速度StringBuffer更快
        * StringBuffer是线程安全的可变的字符序列，原理就是在每个方法中加上synchronized
        * 他们两个操作的是一个字符数组，而String操作的是常量池中的数据
        * ==================
        * String 是final类，里面是final 的char[]数组，而且是private的，
        * 也没有提供修改char[]内容的方法，所以String是不可变的
        * ------------------------
        * 主要是为了安全，比如放入hashmap中，本来是相等的，后来就变成其他字符串
        * 那么会引起数据混乱
        * 线程安全，每个线程取出的字符串是相等的
        * 减少空间占用，相同的字符串可以指向内存中的同一空间。
        */
        new StringBuffer().append(1);
    }

    /**
     * 说说Java的三大特性？如何理解多态？
     * http://www.runoob.com/java/java-polymorphism.html
     */
    public void a1_2() {
        /*
        * 多态，封装，继承
        * 封装意思是隐藏类中的实现细节，只暴露它的方法
        * 继承，子类继承父类中的特性，减少重复代码
        * 多态，就是父类引用指向子类对象，当父类引用调用方法的时候，调用的是子类重写的方法
        * 就是一个行为有多种实现方式
        * 多态的三个必要条件，继承，重写，父类引用指向子类对象
        * override
        */
    }

    /**
     * == 和equals 和hashcode()的关系和区别
     */
    public void a1_3() {
        /*
        * ==对于基本数据类型比较的是值，对引用类型比较的是引用值
        * Object中的equals 方法里面用的也是 ==
        * ==一般用于判断两个对象的地址是否相等，而equal一般是覆盖后用于
        * 判断值是否相等
        * -----------------------------
        * hashcode方法是用在java集合框架中的 散列表 中的，比如hashmap hashset hashtable
        * Object中的hashcode返回的是对象内存地址的映射值
        * 而重写equals一般要重写hashcode，在hashmap中会用hashcode判断两个对象的hash值
        * 如果只重写equals而不重写hashcode会在hashmap中存着两个“相等”的key
        * 这个相等表示equals是相等的，而在hashmap中却表示两个不同的值
        *
        */
        Object o = new Object();
        o.equals(o);
        o.hashCode();
        "sf".equals("a");
        new HashMap<>().put(null, null);
    }

    /**
     * {@link java.io.Serializable} 和{@link android.os.Parcelable} 的区别
     * https://www.cnblogs.com/trinea/archive/2012/11/09/2763213.html
     */
    public void a1_4() {
        /*
        * 都是序列化，Serializable是个标记接口，而Parcelable是将对象写入
        * Parcel对象中，反序列化也是从Parcel中读取
        * ------------------
        * Parcelable转为android系统设计，用于在不同进程间传递，因为他是通过内存读写来
        * 序列化和反序列化的。所以速度快，内存占用少。
        * 而Serializable是通过反射来读取和写入。所以速度慢，占用临时变量多
        * 但是它可以序列化到本地存储，或者网络传输。
        */
    }


    /**
     * 有几种内部类？他们的使用场景
     */
    public void a1_5() {
        /*
        * 静态内部类，非静态内部类，局部内部类，匿名内部类
        * -------
        * 外部类只能单继承，这时可以让内部类来继承，实现继承多个类
        */

        //局部内部类，作用域只在这个方法，别处引用不到
        final int num = 3;
        class InnerClass {
            int n = num;
        }
        InnerClass a;
    }

    /**
     * 局部内部类和闭包的区别？
     */
    public Object a1_6() {
        /*
        * 闭包就是把函数以及变量包起来，使得变量的生存周期延长
        * -----------------
        * 当函数可以记住记住并访问所在的词法作用域，即使函数是在当前词法作用域之外执行，就会形成闭包
        * ---------------------
        * 这样，我们在main函数中调用a1_6().toString(),就会输出8
        * 因为count和 InnerClass在方法结束后就应该被销毁了
        * 但是在外部却能调用，这就形成了闭包
        * =======================
        * 区别：闭包是个概念。。而局部内部类是java语法中类声明的一种？？？
        */

        final int count = 8;
        class InnerClass {
            @Override
            public String toString() {
                return count + "";
            }
        }
        return new InnerClass();
    }


    /**
     * string 转换成 integer的方式及原理
     */
    public void a1_7() {
        /*
        *  Integer.parseInt("0");
        *  原理就是取每一位字符，转化为数字，然后result*10 +这一位数字
        *  从index =0 的时候开始取字符
        */
        Integer.parseInt("0123");
    }


    /**
     * Java instanceof 关键字是如何实现的？
     * https://www.zhihu.com/question/21574535/answer/18989437
     */
    public void a1_8() {
       /*
       * 先简单介绍一下instanceof的字节码操作：
       * 确定对象是否为给定的类型指令格式：instanceof|indexbyte1|indexbyte2指令执行前后的栈顶状态：
       * ……，objectref=>
       * ……，result
       * 描述：indexbyte1和indexbyte2用于构造对当前类的常量池的索引，
       * objectref为reference类型，可以是某个类，数组的实例或者是接口。
       * 基本的实现过程：对indexbyte1和indexbyte2构造的常量池索引进行解析，
       * 然后根据java规范判断解析的类是不是objectref的一个实例，最后在栈顶写入结果。
       */
    }

    /**
     * 静态代理和动态代理的区别，什么场景使用？
     */
    public void a1_9() {
        /*
        * 静态代理，实际上就是指的设计模式中的代理模式，代理类在运行之前就已经
        * 产生了class文件。（代理模式，代理类和委托类都实现同一接口，然后我们执行代理类
        * 中的方法）
        * 动态代理，使用java reflect包中，Proxy类，将委托类的类加载器，和接口传入
        * 里面用native方法动态创建代理类，然后通过反射来创建代理类的对象，我们
        * 调用代理类的方法，就会执行InvocationHandler中的invoke方法，
        * 在这个方法中我们可以加入附加逻辑
        * =======================场景===============
        * 静态代理一般是我们对于项目中的业务逻辑进行代理
        * 而静态代理适合aop，面向切面编程，比如加统计日志
        */

        //会创建一个代理类的对象，实现了委托类的所有接口中的方法
        Object o = Proxy.newProxyInstance(Java.class.getClassLoader(), Java.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("执行前处理");
                Object invoke = method.invoke(proxy, args);//proxy是真正的执行者，就是委托类
                System.out.println("执行后处理");
                return invoke;
            }
        });
        o.toString();//这个是代理对象
    }


    /**
     * 说说Java的异常体系
     * ==================
     * 说说try-with-resources
     */
    public void a1_10(Context context) {
        /*
        * 结构见下图
        * Throwable是异常的顶级类，子类有Error和Exception类
        * Error是程序无法处理的错误，比如OutOfMemoryError，这时Jvm会强制
        * 终止进程。
        * Exception是程序能处理的异常，它又分运行时异常和非运行时异常
        * RuntimeException 是运行时异常，他是由我们的业务逻辑出错而导致的
        * 我们可以选择捕获或者捕获，编译时不强制要求，比如NullPointException
        * OutOfIndexException 。
        * 非运行时异常一般可能由外界环境引起的异常，比如IOException,SQLException
        * 这些要求我们在编译的时候就要捕获。否则编译不通过
        * =======================try-with-resources ======================
        * try( Closeable c =init()){
        * }catch(Exception e){
        * }
        * jdk7 加入
        * 就是在括号内创建的对象，会在最后调用他的close()方法
        * 就省去我们写finally了，比如IO流，锁
        */
        context.getResources().getDrawable(R.drawable.throwable);
        //Throwable
        //Error
        //Exception

    }


    /**
     * 说说你对Java注解的理解（Annotation）
     * http://gityuan.com/2016/01/23/java-annotation/
     * 说说注解处理器
     * https://docs.oracle.com/javase/8/docs/api/javax/annotation/processing/Processor.html
     */
    public void a1_11() {
        /*
        * @Documented //生成文档
        * @Retention(RetentionPolicy.RUNTIME) //表示保留此注解到什么时候
        * @Target(ElementType.METHOD) //注解在哪里使用
        * @Inherited //是否继承
        * public @interface CustomSubscribe {
        *     boolean sticky() default false;
        *     int priority() default 0;
        * }
        * //使用方法
        * @CustomSubscribe(sticky = true,priority = 1)
        * public void fun(){}
        * ===============系统注解==============
        * @Target(ElementType.METHOD)
        * @Retention(RetentionPolicy.SOURCE)
        * public @interface Override {
        * }
        * ==================注解的意义========================
        * 注解也叫元数据
        * 注解是JDK1.5版本开始引入的一个特性，用于对代码进行说明，可以对包、类、接口、字段、方法参数、局部变量等进行注解。它主要的作用有以下四方面：
        * 生成文档，通过代码里标识的注解生成javadoc文档。 @Documented
        * 编译检查，通过代码里标识的注解让编译器在编译期间进行检查验证。 @Override
        * 编译时动态处理，编译时通过代码里标识的注解动态处理，例如动态生成代码。//比如GreenDao的注解
        * 运行时动态处理，运行时通过代码里标识的注解动态处理，
        *     例如使用反射注入实例。//比如EventBus，可以动态的取出注解，判断是主线程执行还是子线程
        *     //比图Dragger2的依赖注入，就是运行时进行引用和实例的关联
        * ===============注解的原理===================
        * 定义完注解，编译后其实是一个普通接口继承Annotation接口，然后我们通过动态代理
        * 为这个接口产生对应的实例类，然后我们就可以取得里面的值
        * java注解是怎么实现的？ - 曹旭东的回答 - 知乎
ht      * https://www.zhihu.com/question/24401191/answer/37601385
        */
    }


    /**
     * 说一下泛型原理，并举例说明
     */
    public void a1_12() {
        /*
        * 类型擦除
        * ----------
        * 最好能说出不同jdk之间的区别，说出编译后的class是什么样的。
        */
    }


    /**
     * 堆和栈在内存中的区别是什么
     * (解答提示：可以从数据结构方面以及实际实现方面两个方面去回答)？
     * jvm
     */
    public void a1_13() {
        /*
        * 数据结构上，堆是一种特殊的二叉树，栈是一种先进后出的数据结构
        * jvm中，我们执行一个方法，方法中的参数，局部变量，都压入栈中，
        * 方法执行完毕后自动释放
        *
        * 而对象都存储在堆中，由垃圾回收算法回收内存
        */
    }


    /**
     * 什么是深拷贝和浅拷贝、延时拷贝
     * https://segmentfault.com/a/1190000010648514
     */
    public void a1_14() {
        /*
        * 浅拷贝就是新创建一个对象，将原对象的基本数据类型值拷贝过去
        * 将引用类型的变量的引用值复制过去。
        *
        * 深拷贝，就是类中的引用类型变量也创建一个新的对象，将新的对象
        * 的引用拷贝过去。
        * Object的clone方法是浅拷贝。（而且要实现Cloneable）这是个标记接口，实现它就代表我们允许它进行拷贝
        * 如果要实现深拷贝，两个方法
        * 1.重写clone方法，将里面引用类型的变量也调用clone方法，直到类中没有
        * 引用数据类型即可
        * 2.实现Serializeable接口，使用写入输入对象流，然后再从输入流中读取
        * 读取出来后的对象就是深拷贝的对象。
        * -----------------
        * 延时拷贝用起来和深拷贝一样，但是拷贝的时候先进行浅拷贝，
        * 每拷贝一次计数器加一
        * 当引用类型的值发生改变的时候，我们就创建计数个对象。
        */
    }


    /**
     * 说说Unsafe类，里面有哪些操作？
     * https://www.jianshu.com/p/09477cec1478
     * http://blog.csdn.net/aesop_wubo/article/details/7537278
     * http://mishadoff.com/blog/java-magic-part-4-sun-dot-misc-dot-unsafe/
     */
    public void a1_15() {
        /*
        *  他可以直接操作jvm的内存，只用类加载器是系统的主加载器才能使用
        *  ===========用反射的方式获取======================
        *   Field f = Unsafe.class.getDeclaredField("theUnsafe");
        *    f.setAccessible(true);
        *    Unsafe unsafe = (Unsafe) f.get(null);
        *  =============================
        * 1.可以分配内存，扩充内存，释放内存
        * 2.修改对象的字段值，即使他是私有的
        * 3.线程的挂起和恢复
        * 4.CAS操作(compare and swap) 这是一种乐观操作\ 原子操作
        *  compareAndSwapInt(Object obj, long offset, int expect, int update);
        *                    操作对象，    偏移量        期望值      更新值
        *  当我们偏移量的变量的当前值和期望值一样的时候，我们将这个变量改为更新值
        *  获取head字段的偏移量（这个是相对对象内存地址偏移多少）
        *  long HEAD = U.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("head"))
        *
        */
    }
    //endregion

    //region Java线程

    /**
     * =====================
     * ### 线程
     * 推荐阅读书籍《Java并发编程实战》
     * =====================
     * 线程中的锁就是那个对象，对象就是锁，也叫内置锁，监视器，monitor ,监视器锁，互斥锁，可重入锁
     *
     * 一个线程获取锁的唯一方式就是进入这个锁的代码块
     *
     * race conditions 竞态条件，线程执行顺序的不确定
     *
     * java重排序 http://www.infoq.com/cn/articles/java-memory-model-2#anch94124
     *
     * */

    /**
     * sleep和wait有什么区别
     */
    public void a2() {
        /*
        * 首先线程有6种状态，new waiting runnable blocked ,timed waiting ,terminated
        * 见下图
        * 首先sleep是Thread中的方法，而wait是Object中的方法
        * 调用wait，线程必须在synchronized中调用，也就是说调用wait之前
        * 线程必须先获取锁，否则会抛出异常java.lang.IllegalMonitorStateException
        * 然后调用wait后，线程释放锁，进入阻塞队列，直到被同一对象notify
        *
        * sleep 和 wait都是让线程进入阻塞状态，但是sleep是指定时间后恢复运行状态
        * 而wait需要notify，而且操作和锁有关
        *=================总结==========================
        * sleep 后不会释放锁， wait后会释放锁
        * sleep必须指定阻塞时间，而wait可以不指定
        * wait后能被notify和interrupt打断，而sleep只能被interrupt打断
        *
        */

        Thread.yield();
        int thread_status = R.drawable.thread_status;
    }

    /**
     * 什么是线程安全？
     */
    public void a2_1() {
        /*
        * 多个线程访问某个类时，这个类始终都表现出正确的行为，那么我们就说这个类时线程安全的
        *
        * 无状态：不包含任何字段，也不包含对其他类中字段的引用（只包含局部变量）
        * 无状态对象一定是线程安全的
        */
    }

    /**
     * volatile关键字有什么作用
     * http://aleung.github.io/blog/2012/09/17/Java-volatile-/
     */
    public void a2_2() {
        /*
        * volatile只能保证变量的可见性，就是说保证每次读取变量的时候是最新的值
        * 而不是保存在寄存器中的值，它不能保证i++的原子性
        *
        * 标记为volatile的变量表明这个变量是共享的，所以编译器不会将
        * 这个该变量上的操作和其他内存操作一起重排序
        * 也不会将变量寄存在寄存器或对其他处理器不可见的地方
        *
        * 写入相当于退出同步代码块，读取的时候是进入同步代码块
        *
        * volatile的一个典型应用就是多线程中，作为while(flag)退出的标记
        * volatile boolean flag;
        * 因为jvm在server环境（应用环境）时，会进行优化，将在while内没有改变的变量提取到循环外部
        * 所以就成了 flag = true ; while(true)，这就导致了死循环，或者说循环没有及时退出
        *
        *
        *
        */
    }


    /**
     * 线程池的原理？
     */
    public void a2_3() {
        /*
        * 线程池会指定核心线程数，和最大线程数，根据这个来创建线程
        * 里面会进行死循环，从任务队列中取任务，如果没有任务就阻塞
        * 有任务就唤醒执行。除了核心线程其他线程有超时时间，超过超时时间
        * 线程就会中断
        * 线程池好处就是不用频繁创建线程了，最大可创建500w个线程，2^29-1;
        * 剩下两位是状态；
        */
    }


    /**
     * 多线程中的安全队列通过什么实现？
     */
    public void a2_4() {
        /*
        * 通过AbstractQueuedSynchronizer
        */
    }


    /**
     * 进程和线程的区别
     * http://www.ruanyifeng.com/blog/2013/04/processes_and_threads.html
     * https://www.jianshu.com/p/7ce30a806c51
     */
    public void a2_5() {
        /*
        * 进程和线程都是cpu执行的一个时间段，线程共享进程的资源
        *
        */
    }

    /**
     * 开启线程的三种方式？各自优缺点？
     */
    public void a2_6() {
        /*
        * 1.继承Thread
        * 2.实现Runnable接口
        * 3.实现Callable，用FutureTask来实现线程（这个类其实也实现了Runnable）
        *
        * 实现接口的方式优点就是还能够继承其他类，而且可以访问同一个Runnable中的对象
        * 缺点就是如果引用当前线程必须用Thread.currentThread()
        *
        * 继承的优点是用this可以访问线程中的一些变量
        * 缺点就是不能继承其他类了
        */


    }

    /**
     * 如何控制某个方法允许并发访问线程的个数？他的原理是什么？
     */
    public void a2_7() {
        /*
        * 用Semaphore类，执行到一个方法时申请信号量加1，超过时等待
        * 它的原理是内部使用了AbstractQueuedSynchronizer
        *
        */
    }


    /**
     * 说说Thread中的interrupt?interrupted 和isInterrupted区别？
     * http://www.cnblogs.com/skywang12345/p/3479949.html
     */
    public void a2_8() {
        /*
        * interrupt 中断阻塞线程（wait sleep join），阻塞位置抛出
        * InterruptedException
        * 如果线程不是阻塞，那么就只是将标记设置为true
        * 这个方法的作用就是将线程阻塞的状态打破，然后线程的阻塞方法比如wait等
        * 会抛出个异常
        * 如果线程不是阻塞的，那么调用这个方法只是标记为阻塞，线程仍然正常
        * 执行
        * ================================
        * interrupted是检测标记并将标记设置为false
        * isInterrupted仅返回检测的标记
        */
    }

    /**
     * 谈谈wait/notify关键字的理解?为什么他们都要在同步代码块中？
     */
    public void a2_9() {
        /*
        * 他们必须在同步代码块中是为了防止竞态条件。
        * 比如有很多消费者线程等待资源，这时一个生产者生产了一个资源，
        * 然后notifyAll了，如果没有锁，那么所有的消费者线程都会抢占这一个
        * 资源，会造成不可预知的结果，这是不能接受的
        * 而且生产者加锁也是为了安全，只有生产者准备就绪，释放锁的时候
        * 消费者线程才能获取到锁。
        */
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    /**
     * 什么导致线程阻塞？
     */
    public void a2_10() {
        /*
        * Thread.sleep 这个不会放弃锁
        * wait方法 这个阻塞后会放弃锁
        * Thread.yield() 有可能导致阻塞
        * thread.join方法，会阻塞等待thread线程执行完
        * IO操作和Socket操作都是阻塞式操作
        */

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();

        Thread.yield();
    }

    /**
     * Thread.yield()有什么作用？什么场景使用？
     */
    public void a2_11() {
        /*
        * 使线程放弃cpu使用权限，一般可以用来复现bug，或者设计并发线程结构
        * 注意，这个放弃cpu使用权限，但是不放弃锁
        */
    }

    /**
     * thread join 是什么作用？
     */
    public void a2_12() {
        /*
        * 首先这个线程对象中的方法，thread.join();
        * 是调用线程，等待thread线程执行完后再继续执行
        *
        * 调用线程等待对象线程死亡，这个时候调用线程阻塞。
        * 里面原理就是 用 isAlive判断线程是否存活，如果存活，就wait（）
        * 如果不存活了，就跳出循环继续执行
        */
        try {
            Thread thread = new Thread();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程如何关闭？
     */
    public void a2_13() {
        /*
        * 1.thread.stop() 这个已经废弃了,因为他不安全的,因为他会在任意逻辑处终止执行
        * 因为stop后线程中持有的锁会立刻释放掉，就导致并发的逻辑不可控制
        * 2.推荐使用变量标记的方式来终止线程，while(flag>0)  volatile flag
        *
        */
        Thread.currentThread().isInterrupted();
        Thread.currentThread().stop();
    }


    /**
     * 讲一下java中同步的方法?
     * http://www.cnblogs.com/paddix/p/5405678.html
     */
    public void a2_14() {
        /*
        * 同步是为了防止多个线程访问同一资源，所以要排队访问线程
        * 1.可以用 关键字synchronized，优点就是使用方便，缺点是他是互斥锁，不能是共享锁，不够灵活，
        * synchronized 配合wait notify 来实现阻塞和唤醒
        * 2.可以用AbstractQueuedSynchronizer 的子类来实现同步
        * 其实Lock子类是用来代替synchronized的，内部的实现原理还是AQS的内部类
        * 配合 Condition await signal 来实现阻塞和唤醒
        * 用到AQS的类，比如Semaphore,ReentrantLock,CountDownLatch
        * ==============原理======================
        * 1.synchronized原理是对象锁，存储对象的内存中有一个标记
        * 当线程进入锁，标记加1，退出锁标记减1，来实现同步，这个操作也是CAS
        * 底层也有一个等待队列，
        * 2.AQS的原理是使用UnSafe类中的CAS（Compare and swap）操作来标记
        * 线程进入退出，使用park 和unpark来实现线程阻塞等待，然后当有线程释放锁的时候
        * 会从等待队列中取线程来唤醒，让他继续持有锁。
        */
    }

    /**
     * java中如何保证数据的一致性？
     */
    public void a2_15() {
        /*
        * 1.使用同步锁
        * 2.使用volatile关键字
        */
    }

    /**
     * 什么是互斥锁、共享锁？
     * 什么是乐观锁？什么是自旋？
     * 什么是CAS操作？什么是ABA问题？
     * 什么是公平锁？什么是非公平锁？
     * 什么是轻量级锁？什么是偏量锁？
     * http://www.cnblogs.com/paddix/p/5405678.html
     * http://www.cnblogs.com/javaminer/p/3892288.html
     * https://www.zhihu.com/question/55075763
     */
    public void a2_16() {
        /*
        *
        */
    }

    /**
     * synchronized 关键字的原理？
     * http://www.cnblogs.com/paddix/p/5367116.html
     */
    public void a2_17() {
        /*
        *
        */
    }

    /**
     * volatile关键字作用和原理?
     * http://www.cnblogs.com/paddix/p/5428507.html
     */
    public void a2_18() {
        /*
        * 1.可以防止重排序
        * 2.可见性，一个线程修改了这个变量，另一个线程取到的是最新值，
        * 3.原子性，long double分为高32位和低32位，我们写入的时候有可能只写了
        *  低32位，然后这个时候读取出的数值就是错的。
        *
        */
    }


    /**
     * AbstractQueuedSynchronizer原理？
     */
    public void a2_19() {
        /*
        * 里面用status 标记线程状态
        * 用CAS操作和UnSafe类的park和unpark来实现线程阻塞和唤醒
        * 用双向列表来存储没有获取到锁的线程
        */
    }

    /**
     * ReentrantLock 原理？
     * https://www.jianshu.com/p/fe027772e156
     */
    public void a2_20() {
        /*
        * 内部用AQS实现了公平锁和非公平锁，重写的tryAcquire 和tryRelease
        * 来实现公平和非公平
        */
    }

    /**
     * 死锁的四个必要条件？如何防止死锁？
     */
    public void a2_21() {
        /*
        * 1.互斥条件：一个资源在同一时间只能被一个线程占有
        * 2.不可剥夺(抢占)条件:在一个线程未使用完这个资源时，其他线程不可抢占
        * 3.占有且(又)申请条件：一个线程已经占有一个资源，而他又去申请另一个资源
        * 4,循环等待条件：所有线程都申请新的资源，从而形成一个循环
        * ==========如何解决===========
        * 1.预防，只要打破四个条件中的一个就可以预防
        * 2.避免，可以用一个安全队列来判断是否即将产生死锁
        * 3.检测与恢复，用一个二维数组存储线程当前持有的资源，和即将申请的资源，
        * 每隔一段时间检测一次，如果发现线程持有的资源和要申请的资源已经形成死锁
        * 那么可以将其中的一个线程中断，释放资源，打破死锁
        *
        */
    }


    /**
     * 多线程断点上传原理?多线程断点下载（续传）原理？
     */
    public void a2_22() {
        /*
        * 多线程的原理就是每个线程负责文件 指定字节范围的下载、上传
        * =============下载=================
        * 下载可以用http协议的If-Match: etag，和Range : bytes=%d-
        * 的请求头，来指定从文件的哪里开始下载
        * 如果是断点下载就返回206的响应码，否则第一次下载就返回200
        * ===============上传===================
        * 上传需要和服务器协商，可以用http也可以用socket
        * 需要告知服务器，你这次上传是从哪个字节开始
        */
    }
    //endregion

    //region Java集合

    /**
     * HashMap的实现原理
     * ------------------------
     * 如何减少hash碰撞？
     */
    public void a3_1() {
        /*
        * 数组加链表，拉链法实现的散列表
        */
    }

    /**
     * 常用java集合框架简介
     * {@link java.util.Collection}
     * {@link java.util.Map}
     * ----------------------
     * http://wiki.jikexueyuan.com/project/java-collection/linkedhashmap.html
     */
    public void a3_2() {
        /*
         * 总体有两种接口，Collection 和 Map
         *
         * Collection=>{List ，Set，Queue }
         * Collection是“集合”的抽象 ，
         * -----------------------------
         * List 是代表有序的集合 An ordered collection (also known as a <i>sequence</i>)
         * Queue  元素优先处理的集合 A collection designed for holding elements prior to processing.
         * Set 一个没有重复元素的集合 A collection that contains no duplicate elements
         * -------------------------
         * List下有{
         *  Vector ，可增长和收缩的对象数组，线程安全，方法上加入synchronized
         *  ArrayList 可调整大小的对象数组，和Vector类似，只不过他没有同步锁
         *  LinkedList 双向链表，实现了List和Deque接口，
         *  CopyOnWriteArrayList （java.util.concurrent.）线程安全的随机访问列表 A thread-safe random-access list
         *  写入的时候是将数组复制到一个新的数组，然后再新的数组中写入，然后，引用指向
         *  新的数组（在写入时拷贝）
         * }
         * -----------------------------------
         * Set下有
         * {
         * =》SortedSet
         * =》NavigableSet
         *   TreeSet(内部是TreeMap实现)
         * ****************************
         * HashSet (内部是HashMap实现 )
         * **********************************
         * android.support.v4.util.ArraySet
         * 数组实现，二分法查找
         *
         * }
         *
         * =======================================
         * Queue下
         * {
         * =>AbstractQueue
         * PriorityQueue 一个基于最大/小堆的优先队列
         * *******************************
         * BlockingQueue(支持读取等待，和存储等待的队列)
         * 比如现在队列是空，我们调用读取，会等待队列中有数据再读取
         * =》ArrayBlockingQueue
         * =>LinkedBlockingQueue
         * =>PriorityBlockingQueue
         *
         * *****************************************
         * Deque(双向队列)
         *  =》LinkedList
         *  +>ArrayDeque （里面用数组实现，可变大小）
         *  ->BlockingDeque-> LinkedBlockingDeque
         *
         * }
         *
         * =====================================
         * Map(一个键值对映射的对象，key只有唯一值)
         * An object that maps keys to values.  A map cannot contain duplicate keys;
         * each key can map to at most one value.
         *
         * ------------------------------
         * Map
         * {
         * *****************************
         * HashMap 一个基于散列表的Map实现 ，键值可以为null
         * （拉链法的散列表）
         * *******************************
         * =>SortedMap(key排序的map，按Comparator升序排序 )
         * => NavigableMap(导航的Map,比如小于某个数字的最大key)
         * TreeMap 是他们的子类，都实现了他们的特性
         * *******************************
         * HashTable 散列表实现的Map，键值非null，和HashMap差不多，只不过他的方法都加入了同步锁
         * *******************************
         * ConcurrentMap=>
         * ConcurrentHashMap(线程安全的HashMap，里面使用了分段锁)
         * *******************************
         * LinkedHashMap 是HashMap的子类，提供有序的访问HashMap
         * http://wiki.jikexueyuan.com/project/java-collection/linkedhashmap.html
         * accessOrder =true //代表按访问顺序排序（访问一个元素，插入到顺序结尾），
         * false，我们遍历的时候就是按插入时的顺序遍历
         * **************************************
         * android.support.v4.util.ArrayMap
         * 里面是数组加二分法查找hash实现
         * 他更节省内存，因为只用数组存储，但是它只适合小数据量，几百个数据下
         * 和HashMap的性能不相差50%。
         * }
         *
         *
        */
    }

    /**
     * 并发集合了解哪些？
     * （线程安全的集合）
     */
    public void a3_3() {
        /*
        * java.util.concurrent 包下的
        * ConcurrentHashMap(分段锁)
        * CopyOnWriteArrayList（方法锁，加写时复制）（这个在遍历的时候线程安全，但是遍历的可能不是最新数组）
        * ConcurrentLinkedQueue（sun.misc.Unsafe 用这个类保持线程安全）
        */
        Collection<Object> collection = Collections.synchronizedCollection(new ArrayList<Object>());
        new Hashtable<>();
        new Vector<>();//这个在遍历的时候还是线程不安全

    }

    /**
     * RandomAccess接口有什么用？
     */
    public void a3_4() {
        /*
        * 这是一个标记接口
        * 实现这个接口的List，表明它有能力提供 快速的随机访问数组的能力，
        * 比如ArrayList, 因为它可以通过索引在常数时间内访问任一元素
        *
        * 这个接口的作用是我们可以判断一个List是否实现了RandomAccess
        * 当实现的时候，我们可以用for循环来遍历数组
        * 如果没有实现（比如LinkedList），我们推荐用Iterator的方式遍历，
        * 如果用For循环会慢很多。
        */
    }


    /**
     * Iterator 和 Enumeration区别?
     */
    public void a3_5() {
        /*
        * 他们都是用来遍历集合的
        * Enumeration jdk1出的，Iterator是jdk2出的，是前者的升级
        * 主要两点不同
        * <li> Iterators allow the caller to remove elements from the
        *      underlying collection during the iteration with well-defined
        *      semantics.
        * <li> Method names have been improved.
        *
        */
    }


    /**
     * 说说Arrays和Collections 类的作用？
     */
    public void a3_6() {
        /*
        * 都是工具类
        * Arrays主要对数据进行操作，主要是查找，复制，排序
        * Collections对Collection对象操作，复制，查找，变成同步的集合
        *
        */
    }


    /**
     * 如何实现二叉树深度优先和广度优先的遍历？
     */
    public void a3_7() {
        /*
        * 深度优先遍历可以用递归方法来遍历
        * 广度优先遍历可以用一个栈来存储上一层已经遍历的节点
        * 然后将新遍历的节点加入栈，直到栈空
        */
    }

    /**
     * 堆和树的区别?
     */
    public void a3_8(Context context) {
        /*
        * 堆是一种特殊的树（我们通常讲的堆就是二叉堆）
        * 当一颗二叉树中的节点都大于等于他们的子节点的时候，这个二叉树是“堆有序”的
        * “堆有序”的“完全二叉树”叫做“二叉堆”，“二叉堆”简称为“堆”
        * 二叉堆的特性使得他可以用来实现优先队列。
        */
        context.getResources().getDrawable(R.drawable.tree);
    }

    /**
     * LinkedHashMap作用？原理？
     * http://wiki.jikexueyuan.com/project/java-collection/linkedhashmap.html
     */
    public void a3_9() {
        /*
        * 有序的HashMap(按插入顺序，或者访问顺序)
        * =================原理==============
        * 原理就是重写了 addEntry方法 也从写了createEntry 如果是新加入的，那么加入Entry链表的头结点
        * LinkedHashMapEntry<K,V> extends HashMapEntry<K,V>  里面重写了recordAccess方法，
        * 每次访问，如果accessOrder=true(按访问顺序)，然后就把这个Entry加入头部
        * LinkedHashMapEntry 是一个双向列表的格式
        *
        *
        */
    }
    //endregion

    //region Java网络

    /**
     * =====================
     * ### 网络
     * =====================
     * */

    /**
     * 说说断点下载
     */
    public void a6() {
        /*
        * 在http请求头中加入 range字段， range:bytes=0-
        * 然后加入etag，If-Match:asdfasdfa
        * 第一次请求的时候可以不用传etag，服务器相应200
        * 返回数据和Etag,将Etag保存到本地
        * 下次请求获取本地以下载文件的字节数，然后加上
        * range:bytes=1024-
        * If-Match:asdfasdfa
        * 服务器会响应206，如果服务器返回206，就用RandomAccessFile .seekTo()
        * 到最后一个字节，然后再继续写入
        */
    }

    /**
     * 说说多线程断点下载
     */
    public void a7() {
        /*
        * 和断点下载一样，开启多个线程，每个线程请求指定范围的数据，
        * 首先获取文件的总大小，用get方式请求文件，然后getContentLength获取文件长度
        * 用RandomAccessFile写入文件
        */
    }


    /**
     * 描述一次网络请求的流程?
     */
    public void a7_1(Context context) {
        /*
        * 1, 请求dns
        * 封装好http请求，用网络框架请求，比如Android原生的HttpUrlConnection
        * 或者OkHttp（这些底层都是用的Socket来请求）
        * 网络框架请求dns服务器，然后返回域名的ip地址
        * 2,建立Tcp\ip连接
        * 通过三次握手来确认双方都准备好接收和发送请求了。
        * 3.发起请求
        * 然后用Tcp/ip协议（Socket实现）请求对方ip，
        * 经过Socket封包，根据TCP协议封包，根据Ip协议封包，传入数据链路层
        * 我们的网卡会将请求，通过网线或者WiFi发到路由，然后路由通过转发
        * 达到指定ip的主机，主机通过拆包，发给指定 进程（比如tomcat）（它监听了端口号）
        * 4.接收到请求和返回响应
        * 这个进程接收到数据后进行拆包，最终返回http请求交给上层应用处理
        * 处理完后将结果写入响应流，客户端接收到响应流
        * 5.结束Tcp\ip连接
        *  用四次挥手，服务端释放连接资源（节省内存）
        *
        */
        context.getResources().getDrawable(R.drawable.http);
    }

    /**
     * 说说三次握手和四次挥手？为什么要这样做？
     * https://github.com/jawil/blog/issues/14
     * https://hit-alibaba.github.io/interview/basic/network/TCP.html
     */
    public void a7_2(Context context) {
        /*
        * 三次握手和四次挥手是Tcp协议中定义，所以他们是建立Tcp连接和断开的基石
        * 利用TCP头部的SYN ACK标记来进行三次握手、
        *
        * ================为什么要这样做？=======================
        * 为了防止已失效的连接请求报文段突然又传送到了服务端，因而产生错误，浪费服务端资源
        *
        */
        context.getResources().getDrawable(R.drawable.tcp_shake_hand);
        context.getResources().getDrawable(R.drawable.tcp_connection_made_three_way_handshake);
        context.getResources().getDrawable(R.drawable.tcp_connection_closed_four_way_handshake);
    }


    /**
     * HttpUrlConnection 和 okhttp关系?
     * <p>
     * http://www.maplejaw.com/2016/07/22/HttpURLConnection-%E6%BA%90%E7%A0%81%E8%A7%A3%E8%AF%BB/
     */
    public void a7_3() {
        /*
        * 都是实现Http协议的网络请求框架，
        * HttpURLConnection是个抽象类，android4.4后
        * HttpURLConnection使用OkHttp来实现的。
        */
    }

    /**
     * 什么是WebSocket?
     * 如何在Android中使用WebSocket?
     *
     * https://www.liaoxuefeng.com/wiki/001434446689867b27157e896e74d51a89c25cc8b43bdb3000/001472780997905c8f293615c5a42eab058b6dc29936a5c000
     */
    public void a7_4() {
        /*
        * webSocket也是一种协议，基于tcp的，使用这种协议必须要服务端和客户端都实现相应的逻辑
        * 也是基于tcp协议，提供双向的数据通道
        * http协议是一次请求和响应后就断开连接了，webSocket是可以保持长连接的
        * 首先客户端用socket发送请求
        * GET ws://localhost:3000/ws/chat HTTP/1.1
        * Host: localhost
        * Upgrade: websocket
        * Connection: Upgrade
        * Origin: http://localhost:3000
        * Sec-WebSocket-Key: client-random-string
        * Sec-WebSocket-Version: 13
        * ----------------------
        * 该请求和普通的HTTP请求有几点不同：
        *   GET请求的地址不是类似/path/，而是以ws://开头的地址；
        *   请求头Upgrade: websocket和Connection: Upgrade表示这个连接将要被转换为WebSocket连接；
        *   Sec-WebSocket-Key是用于标识这个连接，并非用于加密数据；
        *   Sec-WebSocket-Version指定了WebSocket的协议版本。
        * -------------------
        * 然后服务器响应
        * HTTP/1.1 101 Switching Protocols
        * Upgrade: websocket
        * Connection: Upgrade
        * Sec-WebSocket-Accept: server-random-string
        *
        * 浏览器和服务器就可以随时主动发送消息给对方。
        * 消息有两种，一种是文本，一种是二进制数据。通常，我们可以发送JSON格式的文本
        *
        * Android4.4以上支持
        *
        * =====================如何在Android中使用WebSocket?======================
        * https://blog.csdn.net/moxiouhao/article/details/77840168
        *
        *
        *
        */
    }
    
    /**
     * 从网络加载一个10M的图片，说下注意事项?
     * */
    public void a7_5(){
        /*
        * 使用断点下载，先存储到磁盘中，然后通过inSampleSize来进行合理的缩放
        * 再加载到内存中
        */
    }

    /**
     * TCP与UDP的区别?
     * */
    public void a7_6(){
        /*
        * TCP：
        * 1面向连接 ，建立连接需要开销较多(时间，系统资源)
        * 2传输可靠(保证数据正确性,保证数据顺序)、
        * 3传输是面向字节流，用于传输大量数据(流模式)
        * 4，tcp报文首部需要20字节
        * 5。一对一，端口对端口的
        * UDP：
        * 1面向非连接，速度快，没有拥塞机制
        * 2传输不可靠、
        * 3传输面向数据报，用于传输少量数据(数据包模式)
        * 4 首部需要8个字节
        * 5可以广播一对多
        */
    }


    /**
     * HTTP1.0与1.1与2.0的区别?
     * SPDY 是什么？
     * https://www.jianshu.com/p/52d86558ca57
     * https://www.zhihu.com/question/34074946
     * */
    public void a7_7(){
        /*
        * ===================1.1 和1.0的区别===========================
        * 1：添加了请求头
        * Http1.1新增了Host请求头，这就使得我们可以在同一IP的同一端口来指定不同的服务主机
        * 新增了Connection请求头，keep-alive表示不关闭tcp连接，这就使得一次tcp连接能发送多个http请求
        *       close表示关闭
        * 添加了range请求头，支持了断点下载
        * 添加了cache-control请求头，优化了服务器时间和客户端时间不一致导致缓存过期或者不过期的问题
        * 2.添加了响应码
        * 101 表示切换了协议，支持了WebSocket
        * 412 比如断点下载的ETag不匹配，返回错误
        * ==========================2.0和1.x的区别=======================
        * 互联网工程任务组（IETF）2015年5推出
        * 1.单一长连接，向单个域名的请求，会用一个tcp连接，这样就减少三次握手带来的开销
        *   而且克服了tcp慢启动（一开始会会限制最大传输速度，如果响应成功，会提高传输速度）
        * 2.（多路复用）head of line blocking 是http1.x的特性，一个请求没有响应之前，后面的请求将会阻塞
        *       所以我们用二进制分帧的形式将多个请求合并为一个，每个请求编号
        * 3.二进制分帧（Frame），在Http协议和Tcp协议之间加入 二进制分帧层（Binary Framing）
        *   将 http请求头加入到HEADER frame 中，将请求体加入  DATA frame 中
        * 4.首部压缩 ，SPDY 使用的是通用的DEFLATE 算法，而 HTTP/2 则使用了专门为首部压缩而设计的 HPACK 算法
        * 5.服务端推送（Server Push、Cache Push），一个请求可以有多个响应，比如我们请求A，那么服务端可以
        *   响应A后，再返回响应B,这样就相当于主动推送了（这在首页初次请求很多资源时很有用）
        *
        * ===================SPDY 是什么？===================
        * （SPeeDY）快速的，是Google用来加快网络速度，降低延迟。
        * 是google为了改进Http1.x的缺陷来制定的协议，后来Http2.0出来，Google就不维护这个协议了
        * 全力支持Http2.0，Http2.0也是根据这个协议改进而来
        *
        */
    }
    
    /**
     * HTTP与HTTPS的区别
     * https何实现安全性?/tls层的实现原理?
     * 如何验证证书的合法性?
     * https中哪里用了对称加密，哪里用了非对称加密？
     * 对加密算法（如RSA）等是否有了解?
     * http://www.techug.com/post/https-ssl-tls.html
     * https://www.barretlee.com/blog/2015/10/05/how-to-build-a-https-server/
     *
     * */
    public void a7_8(Context context){
        /*
        * ============HTTP与HTTPS的区别=====================
        * 总的区别就是安全 https并不是修改了http协议，而是http协议加上了tls协议或者ssl协议
        * 1.https是在http下层加入了tls层（传输层安全协议）
        * 2 url头部不同，
        * 3 端口不同，
        * 4 http内容明文，https是密文
        * ================https何实现安全性?/tls层的实现原理=================
        * 1客户端告知服务端可使用的 几套加密算法（对称加密+非对称加密+hash算法）
        * 2.服务器返回选择的一套加密算法，和数字证书（CA颁发，里面用CA私钥加密了服务器的公钥和网站信息）
        * 3.客户端接收到，验证数字证书的合法性，用正规CA机构的公钥解密，成功则数字证书合法
        *   解密后得到服务器的公钥。
        *   此时客户端生成随机密码，然后用公钥加密，发送给服务端
        * 4.服务端 用私钥解密 得到随机密码。（此时只有客户端和服务端知道随机密码）
        *   然后服务端将握手消息用随机密码加密发送
        * 5.客户端用随机密码解密 握手消息。此时tls握手完成，客户端以后发送的数据都用随机密码加密后传输
        * ======================如何验证（数字）证书的合法性?==============
        * 浏览器内置根证书，验证数字证书链接合法性（用公钥解密，能成功就是合法）
        * 或者去指定CA机构获取公钥解密
        * =================https中哪里用了对称加密，哪里用了非对称加密？===========
        * 随机密码传递给服务器用了非对称加密
        * 内容的传输用了对称加密
        *
        */
        context.getResources().getDrawable(R.drawable.http_hand_shake_1);
    }
    //endregion

    //region JVM知识

    /**
     * 哪些情况下的对象会被垃圾回收机制处理掉?
     * /jvm垃圾回收机制是怎样的?
     * <p>
     * https://yunfengsa.github.io/2015/11/12/android-jvm-gc/
     */
    public void a8_1() {
        /*
        *
        * 虚拟机中的内存区域分为新生代和老年代，新分配的对象被存储在新生代中
        * 当需要申请内存而内存空间不足时，就触发Minor GC来回收新生代的内存，
        * 如果没被回收的对象就讲它年龄+1，一般到15的时候对象会被转移到老年代
        * 老年代占满，会触发Major GC，回收老年代的垃圾对象
        * 直到所有内存都占满，就触发Full GC，回收所有内存空间中的垃圾对象
        * Android使用的是标记-清除算法来回收垃圾对象
        *
        * 另外的GC算法还有复制算法（就是定义两个大小相等的区域，一次GC把非垃圾对象
        * 复制到另一块内存中，这样减少了内存碎片）
        * 标记-整理算法，标记非垃圾对象，并且整理到连续的内存中
        */
    }

    //endregion
}
