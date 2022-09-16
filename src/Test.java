
import java.util.Date;

import dao.ReviewDaoImpl;
import dao.VideoDaoImpl;
import dto.Review;

public class Test {

	public static void main(String[] args) {

		VideoDaoImpl video = VideoDaoImpl.getInstance();

		System.out.println(video.selectAll());
		System.out.println(video.selectVideo("1"));
		System.out.println(video.selectPartFitVideo("하체"));

		Date nowDate = new Date();
		ReviewDaoImpl review = ReviewDaoImpl.getInstance();
		review.writeReview(new Review("1", 1, "title", "content", "writer", nowDate));
		review.writeReview(new Review("1", 2, "title", "content", "writer", nowDate));
		review.writeReview(new Review("1", 3, "title", "content", "writer", nowDate));
		review.writeReview(new Review("1", 4, "title", "content", "writer", nowDate));

		System.out.println(review.getReviewList("1"));

		review.updateReview(new Review("1", 1, "22", "22", "2", nowDate));
		System.out.println(review.getReviewList("1"));
		
		review.deleteReview(1);
		System.out.println("del");
		System.out.println(review.getReviewList("1"));

	}
}
