package DataRequestLibrary;

import org.json.JSONObject;

public class LibReqResData {
    String strName = "Asim";
    String strRole = "QL";


    public JSONObject DataJsonCreateUser(){
        JSONObject jsonUserObject =new JSONObject();
        jsonUserObject.put("name", strName);
        jsonUserObject.put("job", strRole);

        return jsonUserObject;
    }
//
//    public String getStrName(){
//        return strName;
//    }
//    public void setStrName(String strName){
//        this.strName=strName;
//    }

}
