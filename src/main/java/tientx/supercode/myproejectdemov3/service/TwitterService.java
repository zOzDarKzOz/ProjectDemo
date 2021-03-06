/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tientx.supercode.myproejectdemov3.service;

import twitter4j.IDs;
import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author zOzDarKzOz
 */
public interface TwitterService
{

    ResponseList<Status> getTwFavorites(String screenName)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwFavorites(Long idUser)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwFavorites(String screenName, Integer count)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwFavorites(Long idUser, Integer count)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserTimeline(String screenName)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserTimeline(Long idUser)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserTimeline(Long idUser, Integer count)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserHomeTimeline(String screenName)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserHomeTimeline(Long idUser)
            throws TwitterException, InterruptedException;

    ResponseList<Status> getTwUserHomeTimeline(Long idUser, Integer count)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFriendList(String screenName)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFriendList(Long idUser)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFollowerList(String screenName,
                                                    Long cursor, Integer count)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFollowerList(Long idUser, Long cursor,
                                                    Integer count)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFriendListId(String screenName,
                                                    Long cursor,
                                                    Integer count)
            throws TwitterException, InterruptedException;

    PagableResponseList<User> getTwUserFriendListId(Long idUser, Long cursor,
                                                    Integer count)
            throws TwitterException, InterruptedException;

    IDs getListRetweeterId(Long idStatus, Integer count, Long cursor)
            throws TwitterException, InterruptedException;
}
