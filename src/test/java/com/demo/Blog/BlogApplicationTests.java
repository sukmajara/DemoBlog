package com.demo.Blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.Blog.DTO.CreateRequestDTO;
import com.demo.Blog.DTO.DeleteRequestDTO;
import com.demo.Blog.DTO.GetAllRequestDTO;
import com.demo.Blog.DTO.ResponseCreateDTO;
import com.demo.Blog.DTO.ResponseDeleteDTO;
import com.demo.Blog.DTO.ResponseGetAllDTO;
import com.demo.Blog.DTO.ResponseGetDetailDTO;
import com.demo.Blog.DTO.ResponseUpdateDTO;
import com.demo.Blog.DTO.UpdateRequestDTO;
import com.demo.Blog.domain.Blog;
import com.demo.Blog.repository.BlogRepository;
import com.demo.Blog.serviceImpl.BlogServiceImpl;

class BlogApplicationTests {

	@Mock
	private BlogRepository blogrepo;

	@InjectMocks
	private BlogServiceImpl blogService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		LocalDateTime originalDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = originalDateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDate, formatter);

		Blog Blog = new Blog();
		Blog.setTitle("Title 1");
		Blog.setBody("Body 1");
		Blog.setAuthor("Author 1");
		Blog.setCreated_at(parsedDateTime);
		Blog.setUpdated_at(parsedDateTime);

		when(blogrepo.findById(1)).thenReturn(Optional.of(Blog));

		List<Blog> mockNewestIdList = new ArrayList<>();
		mockNewestIdList.add(Blog); //
		when(blogrepo.getNewestID()).thenReturn(mockNewestIdList);
		
		Page<Blog> mockPage = Mockito.mock(Page.class);
	    when(blogrepo.findAll(PageRequest.of(0, 10).withSort(Sort.by(Sort.Direction.ASC, "id")))).thenReturn(mockPage);
	}

	@AfterEach
	void deleteData() throws Exception {
		Mockito.reset(blogrepo);
	}

	@Test
	void testGetAllMovie() {
		GetAllRequestDTO gadto = new GetAllRequestDTO();
		gadto.setOffset(0);
		gadto.setRecord(10); 
		ResponseEntity<ResponseGetAllDTO> responseEntity = blogService.getAll(gadto.getOffset(), gadto.getRecord());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void testGetDetailMovie() {
		ResponseEntity<ResponseGetDetailDTO> responseEntity1 = blogService.getDetail(1);
		assertEquals(HttpStatus.OK, responseEntity1.getStatusCode());
	}

	@Test
	void testCreateMovie() {

		LocalDateTime originalDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = originalDateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDate, formatter);

		CreateRequestDTO crto = new CreateRequestDTO();
		crto.setTitle("Title 1");
		crto.setBody("Body 1");
		crto.setAuthor("Auth");

		ResponseEntity<ResponseCreateDTO> responseEntity = blogService.createBlog(crto);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void testUpdateMovie() {
		UpdateRequestDTO upto = new UpdateRequestDTO();
		upto.setId("1");
		upto.setTitle("Title 2");
		upto.setBody("Body 2");
		upto.setAuthor("Auth 2");

		ResponseEntity<ResponseUpdateDTO> responseEntity = blogService.updateBlog(upto);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	void testDeleteMovie() {
		DeleteRequestDTO ddto = new DeleteRequestDTO();
		ddto.setId("1");
		ResponseEntity<ResponseDeleteDTO> responseEntity = blogService.deleteBlog(ddto);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
