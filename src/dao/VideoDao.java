package dao;

import java.util.List;

import dto.Video;

public interface VideoDao {
	
	public List<Video> selectAll();

	public Video selectVideo(String VideoId);

	public List<Video> selectPartFitVideo(String part);
	
}
