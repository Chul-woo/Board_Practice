package kr.kcw.practice.VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Criteria {
	
	private static final Logger logger = LoggerFactory.getLogger(Criteria.class);
	
	private int page;	// ������ ������
	private int perPageNum;	// �������� ������ ��������
	
	//limit �������� ���� �κп� �ʿ��� ���� ��ȯ(mybatis���� ���)
	public int getPageStart() {
		return (this.page - 1) * this.perPageNum;
	}
	
	public Criteria() {	// ���� default �����ڷ� �⺻ ��ü ���� �� �ʱⰪ ����
		this.page = 1;	// ����ڰ� �������� ������ 1
		this.perPageNum = 10;	// �������� �⺻ 10���� ����ϵ��� ����		
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		logger.info("---------------������ ǥ�� ���� --------------");
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		}else {
			this.perPageNum = perPageNum;
		}
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
