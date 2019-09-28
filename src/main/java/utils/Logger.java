package utils;

public class Logger {
    public static void log(Type t, String message){
        System.out.println(t.getName() + " : " + message);
    }

    enum Type {
        WARNING(""),
        ERROR("");

        private String name;
        Type(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }
}
