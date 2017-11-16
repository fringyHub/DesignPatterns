package SingletonPattern;


class Singleton {
    private static Singleton instance;
    private Singleton() { }

    public static Singleton getInstance() {
        if(instance == null)
            instance = new Singleton();
        return instance;
    }
}

class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() { }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class ThreadSafeSingleton {
    private volatile static ThreadSafeSingleton instance;
    private ThreadSafeSingleton() { }

    public static ThreadSafeSingleton getInstance() {
        if(instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if(instance == null)
                    instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
}


public class Main {

    public static void main(String args[]) {

    }
}
