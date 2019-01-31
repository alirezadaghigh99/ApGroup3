package Model.USER;

import java.util.ArrayList;

public class Profile  {
    private String userName ;
    private String nickName ;
    private ArrayList<String>usersList = new ArrayList<>();
    public Profile(String userName, String nickName) {
        if (!usersList.contains(userName))
        {
            this.userName=  userName ;
        }
        this.nickName = nickName;
    }

}
