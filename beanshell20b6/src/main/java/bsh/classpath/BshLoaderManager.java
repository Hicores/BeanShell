package bsh.classpath;

import java.util.HashSet;

public class BshLoaderManager {
    private static final HashSet<ClassLoader> loaders = new HashSet<>();
    public static void addClassLoader(ClassLoader loader){
        loaders.add(loader);
    }
    public static Class<?> findClass(String className) throws ClassNotFoundException {

        for (ClassLoader loader : loaders){
            try{
                return loader.loadClass(className);
            }catch (ClassNotFoundException ignored){ }
        }
        System.out.println("BshClassLoader, can't load class "+className);
        throw new ClassNotFoundException("Can't load class " + className + " in extra classloaders.");
    }
}
