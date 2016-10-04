package CodingInterviews.chapter2;

public class Singleton {
    public static void main(String args[]) {

    }
}

/**
 * 简单单例模式,未考虑线程安全
 */
class Singleton1 {

    private Singleton1() {
    }

    private static Singleton1 singleton = null;

    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}

/**
 * 考虑线程安全,效率不高
 */
class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 singleton = null;

    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

/**
 * 考虑线程安全,效率提升
 */
class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 singleton = null;

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

/**
 * 考虑线程安全,静态内部类
 */
class Singleton4 {
    private Singleton4() {
    }

    private static Singleton4 singleton = null;

    public static final Singleton4 getInstance() {
        return Nested.singleton;
    }

    private static class Nested {
        private static final Singleton4 singleton = new Singleton4();
    }
}

/**
 * 类加载时实例化,饿汉模式
 */
class Singleton5 {
    private Singleton5() {
    }

    private static final Singleton5 singleton = new Singleton5();

    public static Singleton5 getInstance() {
        return singleton;
    }
}