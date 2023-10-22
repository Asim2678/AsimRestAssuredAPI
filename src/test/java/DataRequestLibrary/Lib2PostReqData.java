package DataRequestLibrary;

import org.json.JSONObject;

public class Lib2PostReqData {
    String strName = "MAsim";
    String strRole = "TL";

    // getter and setter are set to call the values in the TestStringFromJsonFile class
    public String getStrName(){
        return strName;
    }
    public void setStrName (String strName){
        this.strName = strName;

    }
    public String getStrRole(){
        return strRole;
    }
    public void setStrRole(String strRole){
        this.strRole= strRole;
    }

    //--------------

    public JSONObject DataJsonCreateUser(){
        JSONObject jsonUserData = new JSONObject();
        jsonUserData.put("name", strName);
        jsonUserData.put("job", strRole);
        return jsonUserData;
    }
}
