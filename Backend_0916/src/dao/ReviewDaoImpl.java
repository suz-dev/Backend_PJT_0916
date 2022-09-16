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
		for (Review updateReveiw : reviewList) {
			if (updateReveiw.getReviewId() == review.getReviewId()) {
				reviewList.set(updateReveiw.getReviewId() - 1, review);
			}
		}
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
	public Review getReview(int reviewId) {
		Review tmp = new Review();
		for (Review review : reviewList) {
			if (review.getReviewId() == reviewId) {
				tmp = review;
			}
		}
		return tmp;
	}

	@Override
	public void deleteReview(int reviewId) {
		reviewList.remove(reviewId-1);
	}

}
