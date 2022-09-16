package dao;

import java.util.ArrayList;
import java.util.List;
import dto.Video;

public class VideoDaoImpl implements VideoDao {

	private List<Video> videoList;

	private static VideoDaoImpl instance = new VideoDaoImpl();

	private VideoDaoImpl() {
		videoList = new ArrayList<Video>();
		videoList.add(new Video("1", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "ThankyouBUBU", "https://www.youtube.com/embed/gMaB-fG4u4g",0));
		videoList.add(new Video("2", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "전신", "ThankyouBUBU", "https://www.youtube.com/embed/swRNeYw1JkY",0));
		videoList.add(new Video("3", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/54tTYO-vU2E",0));
		videoList.add(new Video("4", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "ThankyouBUBU", "https://www.youtube.com/embed/QqqZH3j_vH0",0));
		videoList.add(new Video("5", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "김강민", "https://www.youtube.com/embed/tzN6ypk6Sps",0));
		videoList.add(new Video("6", "저는 하체 식주의자 입니다", "하체", "GYM종국", "https://www.youtube.com/embed/u5OgcZdNbMo",0));
		videoList.add(new Video("7", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "ThankyouBUBU", "https://www.youtube.com/embed/PjGcOP-TQPE",0));
		videoList.add(new Video("8", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "SomiFit", "https://www.youtube.com/embed/7TLk7pscICk",0));
	}

	public static VideoDaoImpl getInstance() {
		return instance;
	}

	@Override
	public Video selectVideo(String VideoId) {
		Video tmp = new Video();

		for (Video video : videoList) {
			if (video.getId().equals(VideoId)) {
				tmp = video;
			}
		}
		return tmp;
	}

	@Override
	public List<Video> selectPartFitVideo(String part) { // 부위별
		List<Video> tmp = new ArrayList<>();
		for (Video video : videoList) {
			if (video.getPart().equals(part)) {
				tmp.add(video);
			}
		}
		return tmp;
	}

	@Override
	public List<Video> selectAll() {

		return videoList;
	}
	

}
