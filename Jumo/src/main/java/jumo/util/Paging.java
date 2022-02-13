package jumo.util;

public class Paging {

	private int totalPage;
	private int pageBlock;
	private int startPage;
	private int endPage;
	private int currentPage;
	
	private StringBuffer pageHtml = new StringBuffer();

	public Paging(int countProductAll, int pageBlock, int pageSize, int currentPage, String url) {
		totalPage = countProductAll / pageSize +
			(countProductAll%pageSize==0 ? 0 : 1); 
		this.pageBlock = pageBlock;
		
		startPage = (int)((currentPage-1)/pageBlock)*pageBlock + 1;
		endPage = startPage + pageBlock-1;
		if(endPage>totalPage) { // endPage가 페이지수보다 크다면 endPage를 페이지블록만큼 제한
			endPage = totalPage;
		}
		
		this.currentPage = currentPage;
		
		// pageHtml을 작성
		makePageHtml(url);
	}
	
	private void makePageHtml(String url) {
		pageHtml.append("<div class=\"row mt-5\">");
		pageHtml.append("<div class=\"col text-center\">");
		pageHtml.append("<div class=\"block-27\">");
		pageHtml.append("<ul>");
		if(startPage>pageBlock) {
			pageHtml.append("<li><a href=\"allList.al?page=" + (startPage-pageBlock) + "\">&lt;</a></li>");
		}
		
		for(int i=startPage;i<=endPage;i++) {
			pageHtml.append("<li class=\"active\">");
			if(i!=currentPage) {
				pageHtml.append("<li><a href=\"allList.al?page=" + i + "\">" + i + "</a></li>");				
			} else {
				pageHtml.append("<li class=\"active\"><span>" + i+ "</span>");				
			}
		}
		
		if(endPage<totalPage) {
			pageHtml.append("<li><a href=\"allList.al?page=" + (startPage+pageBlock) + "\">&gt;</a></li>");			
		}
		
		pageHtml.append("</ul></div></div></div>");
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
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

	public StringBuffer getPageHtml() {
		return pageHtml;
	}	
}