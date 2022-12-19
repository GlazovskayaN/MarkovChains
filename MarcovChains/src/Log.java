public class Log {
    private String ip, id, actions, link;

    public Log(LogFormat logFormat, String s) {
        int index = 0;
        boolean t = false;
        boolean g = false;
        String st;
        String str = "";
        char[] ch = s.toCharArray();
        char[] mass;
        for (char c : ch) {
            if(c==' '){
                if(t){
                    g=false;
                }else{
                    g=true;
                    index++;
                    str="";
                }

            }
            if (c == '"') {
                if (g) {
                    g = false;
                    index--;
                }
                if (!t) {
                    t = true;
                    index++;
                    str="";
                } else {
                    t = false;
                }
            }
            if (c == (']') || c == ('[')) {
                if (g) {
                    g = false;
                    index--;
                }
                if (!t) {
                    t = true;
                    index++;
                    str="";
                } else {
                    t = false;
                }

            }
            if (t||g||(index==0)) {
                if((c!='"')&&(c!='[')&&(c!=']')){
                st = Character.toString(c);
                str = str + st;}
            }
        if(index== logFormat.getIpIndex()){
            this.ip=str;
        }
            if(index== logFormat.getIdIndex()){
                this.id=str;
            }
            if(index== logFormat.getActionsIndex()){
                this.actions=str;
            }
//            if(index== logFormat.getLinkIndex()){
//                this.link=str;
//            }
        }

    }
    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getActions() {
        return actions;
    }

//    public String getLink() {
//        return link;
//    }
}
