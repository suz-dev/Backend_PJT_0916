package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Review;

public class ReviewDaoImpl implements ReviewDao {

	private List<Review> reviewList = new ArrayList<Review>();
	private static ReviewDaoImpl instance = new ReviewDaoImpl();

	private ReviewDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static ReviewDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void writeReview(Review review) {
		reviewList.add(review);
	}

	@Override
	public void updateReview(Review review) {
		int idx = -1;
		for(int i=0; i<reviewList.size(); i++) {
			if(reviewList.get(i).getVideoId().equals(review.getVideoId()) && reviewList.get(i).getReviewId() == review.getReviewId()) {
				idx = i;
			}
		}
		
		reviewList.set(idx, review);
	}

	@Override
	public List<Review> getReviewList(String videoId) {
		List<Review> tmp = new ArrayList<>();
		for (Review review : reviewList) {
			if (review.getVideoId().equals(videoId)) {
				tmp.add(review);
			}
		}

		return tmp;
	}

	@Override
	public void deleteReview(Review review) {
		reviewList.remove(review);
	}

}
