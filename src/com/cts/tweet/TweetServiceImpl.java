package com.cts.tweet;

import javax.annotation.Resource;

public class TweetServiceImpl implements TweetService {

	@Resource
	public TweetDao tweetDao;
	
	@Override
	public String userRigistration(String firstName, String email, String password) {
		return tweetDao.userRigistration(firstName, email, password);
	}

}
