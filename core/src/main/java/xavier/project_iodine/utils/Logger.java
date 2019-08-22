package xavier.project_iodine.utils;


public class Logger {

    public static void logError(String text){
        System.out.printf(Type.ERROR.getColor() + text + Type.ERROR.getClear() + "\n");
    }

    public static void log(Type type, String text){
        System.out.printf(type.getColor() + text +type.getClear() + "\n");
    }

    public enum Type{
        ERROR(3),
        WARNING(2),
        REGISTRY(1),
        NORMAL(0);

        private int value;

        Type(int value){
            this.value = value;
        }

        public String getColor(){
            switch (value){
                case 3:
                    return "\u001B[31;1m";
                case 2:
                    return "\u001B[33m";
                case 1:
                    return "\u001B[34m";
                case 0:
                    return "\u001B[32m";
                default:
                    return "\u001B[0m";
            }
        }

        public int getValue() {
            return value;
        }

        public String getClear(){
            return "\u001B[0m";
        }
    }
}
