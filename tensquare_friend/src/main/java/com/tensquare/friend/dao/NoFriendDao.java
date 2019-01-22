package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huachen
 * @create 2019-01-22 9:24
 */

public interface NoFriendDao extends JpaRepository<NoFriend, String> {

    public NoFriend findByUseridAndFriendid(String userid, String friendid);


}
