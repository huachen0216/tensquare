package com.tensquare.friend.service;

import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author huachen
 * @create 2019-01-22 9:10
 */

@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    public int addFriend(String userid, String friendid) {
        // userid 到 friendid是否有数据
        // 有，重复添加
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
        if (friend != null) {
            return 0;
        }
        // 没有，往好友表中添加数据，userid到friend方向的type为0
        friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend);

        // friendid 到 userid 是否有数据
        // 有， 双方的状态都改为1
        if (friendDao.findByUseridAndFriendid(friendid, userid) != null) {
            friendDao.updateIslike("1", friendid, userid);
            friendDao.updateIslike("1", userid, friendid);
        }
        return 1;
        // 没有，不处理


    }

    public int addNoFriend(String userid, String friendid) {
        // 判断是不是非好友
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        // 如果是
        if (noFriend != null) {
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        friendDao.deletefriend(userid, friendid);

        friendDao.updateIslike("0", friendid, userid);
        NoFriend noFriend = new NoFriend();
        noFriend.setFriendid(friendid);
        noFriend.setUserid(userid);
        noFriendDao.save(noFriend);
    }
}
