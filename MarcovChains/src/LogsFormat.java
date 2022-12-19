public class LogsFormat {
    char separator =' ';

    public int Ip(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != 'h') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }

    public int Action(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != 'm') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }

    public int Id(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != 'l') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }

    public int Link(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != '{' && args[i + 2] != 'R') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }

    public int file(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != 'f') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }

    public int firstLine(char[] args) {
        int num = 0;
        int i = 0;
        while (args[i] != '%' && args[i + 1] != 'r') {
            if (args[i] == ' ') {
                num++;
            }
        }
        return num;
    }
}




