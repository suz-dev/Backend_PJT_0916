package dto;

import java.util.Date;

public class Review {

	private String videoId;
	private int reviewId;
	private String title;
	private String content;
	private String writer;

	public Review() {
		super();
	}

	public Review(String videoId, int reviewId, String title, String content, String wirter, Date creatTime) {
		super();
		this.videoId = videoId;
		this.reviewId = reviewId;
		this.title = title;
		this.content = content;
		this.writer = wirter;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String wirter) {
		this.writer = wirter;
	}


	@Override
	public String toString() {
		return "Review [videoId=" + videoId + ", reviewId=" + reviewId + ", title=" + title + ", content=" + content
				+ ", wirter=" + writer + "]";
	}

}
