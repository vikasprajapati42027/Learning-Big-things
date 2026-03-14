public enum EnumSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.println("Enum Singleton is thread-safe and safe from Reflection!");
    }
}
