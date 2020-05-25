package MyProject.service;

import MyProject.db.LikesDb;
import MyProject.entity.Like;

public class LikeService {
    private final String str;
    private LikesDb likesDb;

    public LikeService(String str) {
        this.str = str;
        this.likesDb  = new LikesDb();
    }

    public boolean addLike(int userid, int liked){
        System.out.println(userid);
        System.out.println(liked);
        return  likesDb.add(new Like(userid, liked), str);
    }
}
