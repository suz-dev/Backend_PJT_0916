package dao;

import java.util.List;

import dto.Review;

public interface ReviewDao {

	// 리뷰 등록
	public void writeReview(Review review);

	// 리뷰 수정
	public void updateReview(Review review);

	// 리뷰 목록
	public List<Review> getReviewList(String videoId);

	// 리뷰 상세
	public Review getReview(int reviewId);

	// 리뷰 삭제
	public void deleteReview(int reviewId);
}
