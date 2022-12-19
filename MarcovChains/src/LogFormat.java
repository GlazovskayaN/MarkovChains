public class LogFormat {
    private int ipIndex, idIndex, actionsIndex, linkIndex;

    public LogFormat(String logFormat) {
        int i = -1;
        String[] logsFormat = logFormat.split(" ");
        for (String str : logsFormat) {
            if (str.contains("%r")) {
                actionsIndex = i;
            }

//            else if (str.contains("%{Referer}i")) {
//                linkIndex = i;
//            }
            else if (str.contains("%l")) {
                idIndex = i;
            }

            else if (str.contains("%h")) {
                ipIndex = i;
            }
            i++;
        }
    }

    public int getIpIndex() {
        return ipIndex;
    }

    public int getIdIndex() {
        return idIndex;
    }

    public int getActionsIndex() {
        return actionsIndex;
    }
//public int getLinkIndex(){return linkIndex}

}
