package com.demo.Blog.service;

import org.springframework.http.ResponseEntity;

import com.demo.Blog.DTO.CreateRequestDTO;
import com.demo.Blog.DTO.DeleteRequestDTO;
import com.demo.Blog.DTO.ResponseCreateDTO;
import com.demo.Blog.DTO.ResponseDeleteDTO;
import com.demo.Blog.DTO.ResponseGetAllDTO;
import com.demo.Blog.DTO.ResponseGetDetailDTO;
import com.demo.Blog.DTO.ResponseUpdateDTO;
import com.demo.Blog.DTO.UpdateRequestDTO;

public interface BlogService {
	public ResponseEntity<ResponseGetAllDTO> getAll(int offset, int record);
	public ResponseEntity<ResponseGetDetailDTO> getDetail(int blogId);
	public ResponseEntity<ResponseCreateDTO> createBlog(CreateRequestDTO cdto);
	public ResponseEntity<ResponseUpdateDTO> updateBlog(UpdateRequestDTO udto);
	public ResponseEntity<ResponseDeleteDTO> deleteBlog(DeleteRequestDTO ddto);


}
