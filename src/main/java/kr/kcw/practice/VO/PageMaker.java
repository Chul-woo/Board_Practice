package kr.kcw.practice.VO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private static final Logger logger = LoggerFactory.getLogger(PageMaker.class);
	
	private Criteria cri; //page, perPageNum 가지고 있음
	
	private int totalCount;	// 전체 글 수
	private int startPage;	// 게시글 번호에 따른 페이지 시작 번호
	private int endPage;	// 게시글 번호에 따른 마지막 번호
	private boolean prev;	// 이전 버튼 누를 수 있는 경우 구분
	private boolean next;	// 다음 버튼 누를 수 있는 경우 구분
	
	private int displayPageNum = 10;	// 화면 하단에 보여지는 페이지 갯수
	private int tempEndPage;
	
	private void calcData() {
		
		logger.info("----------------------페이지 계산-----------------------");
		
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		this.tempEndPage = tempEndPage;
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public int getTempEndPage() {
		return tempEndPage;
	}
	public void setTempEndPage(int tempEndPage) {
		this.tempEndPage = tempEndPage;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		return uriComponents.toUriString();
	}
	
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword", encoding(((SearchCriteria)cri).getKeyword()))
				.build();
		return uriComponents.toUriString();
	}

	private Object encoding(String keyword) {
		if(keyword == null || keyword.trim().length() == 0) {
			return "";
		}
		
		try {
			return URLEncoder.encode(keyword, "UTF-8");
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
