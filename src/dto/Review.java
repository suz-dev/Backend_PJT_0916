package dto;

import java.util.Date;

public class Review {

	private String videoId;
	private int reviewId;
	private String title;
	private String content;
	private String wirter;
	private Date creatTime;

	public Review() {
		super();
	}

	public Review(String videoId, int reviewId, String title, String content, String wirter, Date creatTime) {
		super();
		this.videoId = videoId;
		this.reviewId = reviewId;
		this.title = title;
		this.content = content;
		this.wirter = wirter;
		this.creatTime = creatTime;
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

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Override
	public String toString() {
		return "Review [videoId=" + videoId + ", reviewId=" + reviewId + ", title=" + title + ", content=" + content
				+ ", wirter=" + wirter + ", creatTime=" + creatTime + "]";
	}

}
