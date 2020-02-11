package br.com.babypet.utils.models;

import java.util.List;

import org.springframework.data.domain.Page;

public class PageModel <T, M> {
	private Long totalElements;
	private Integer totalPages;
	private Integer pageSize;
	private Integer pageNumber;
	private List<M> content;

	public Long getTotalElements() {
		return totalElements;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}
	
	public List<M> getContent() {
		return content;
	}
	
	public void setContent(Page<T> page) {
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.pageSize = page.getSize();
		this.pageNumber = page.getNumber();
	}
	
	public void setContentList(List<M> content) {
		
		this.content = content;
	}

}
