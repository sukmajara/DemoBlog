package com.demo.Blog.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.Blog.DTO.CreateRequestDTO;
import com.demo.Blog.DTO.DataBlog;
import com.demo.Blog.DTO.DeleteRequestDTO;
import com.demo.Blog.DTO.ResponseCreateDTO;
import com.demo.Blog.DTO.ResponseDeleteDTO;
import com.demo.Blog.DTO.ResponseGetAllDTO;
import com.demo.Blog.DTO.ResponseGetDetailDTO;
import com.demo.Blog.DTO.ResponseUpdateDTO;
import com.demo.Blog.DTO.UpdateRequestDTO;
import com.demo.Blog.domain.Blog;
import com.demo.Blog.repository.BlogRepository;
import com.demo.Blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogRepository blogrepo;

	@Override
	public ResponseEntity<ResponseGetAllDTO> getAll(int offset, int record) {
		ResponseGetAllDTO rgto = new ResponseGetAllDTO();
		try {
			Page<Blog> blogResponse = blogrepo
					.findAll(PageRequest.of(offset, record).withSort(Sort.by(Sort.Direction.ASC, "id")));

			if (blogResponse != null) {
				rgto.setResCode(HttpStatus.OK.toString().substring(0, 3));
				rgto.setResMsg("Success");
				rgto.setRecord(String.valueOf(blogResponse.getNumberOfElements()));
				rgto.setMessage(blogResponse.getContent());
				return new ResponseEntity<>(rgto, HttpStatus.OK);
			} else {
				rgto.setResCode(HttpStatus.NOT_FOUND.toString().substring(0, 3));
				rgto.setResMsg("Data empty please create data first");
				rgto.setRecord("0");
				rgto.setMessage(null);
				return new ResponseEntity<>(rgto, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			rgto.setResCode(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0, 3));
			rgto.setResMsg("Error fetching data: " + e.getMessage());
			rgto.setRecord("0");
			rgto.setMessage(null);
			return new ResponseEntity<>(rgto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseGetDetailDTO> getDetail(int blogId) {
		ResponseGetDetailDTO rgto = new ResponseGetDetailDTO();
		DataBlog dgto = new DataBlog();
		try {
			Blog blogResponse = blogrepo.findById(blogId).get();

			LocalDateTime create = blogResponse.getCreated_at();
			LocalDateTime update = blogResponse.getUpdated_at();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

			String createDate = create.format(formatter);
			String updateDate = update != null ? update.format(formatter) : "";

			dgto.setId(String.valueOf(blogResponse.getId()));
			dgto.setTitle(blogResponse.getTitle());
			dgto.setBody(blogResponse.getBody());
			dgto.setAuthor(blogResponse.getAuthor());
			dgto.setCreated_at(createDate);
			dgto.setUpdated_at(updateDate);

			rgto.setResCode(HttpStatus.OK.toString().substring(0, 3));
			rgto.setResMsg("Success");
			rgto.setMessage(dgto);
			return new ResponseEntity<ResponseGetDetailDTO>(rgto, HttpStatus.OK);
		} catch (NoSuchElementException r) {
			rgto.setResCode(HttpStatus.NOT_FOUND.toString().substring(0, 3));
			rgto.setResMsg("Data Not Found");
			return new ResponseEntity<ResponseGetDetailDTO>(rgto, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			rgto.setResCode(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0, 3));
			rgto.setResMsg("Data Not Found (" + e + ")");
			return new ResponseEntity<ResponseGetDetailDTO>(rgto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseCreateDTO> createBlog(CreateRequestDTO cdto) {
		ResponseCreateDTO response = new ResponseCreateDTO();
		DataBlog data = new DataBlog();

		LocalDateTime originalDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = originalDateTime.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDate, formatter);

		try {
			Blog blog = new Blog();
			blog.setTitle(cdto.getTitle());
			blog.setBody(cdto.getBody());
			blog.setAuthor(cdto.getAuthor());
			blog.setCreated_at(parsedDateTime);
			blogrepo.save(blog);

			List<Blog> newId = blogrepo.getNewestID();
			data.setId(String.valueOf(newId.get(0).getId()));
			data.setTitle(cdto.getTitle());
			data.setAuthor(cdto.getAuthor());
			data.setBody(cdto.getBody());
			data.setCreated_at(parsedDateTime.toString());
			data.setUpdated_at("");

			response.setResCode(HttpStatus.OK.toString().substring(0, 3));
			response.setResMsg("Success");
			response.setMessage(data);

			return new ResponseEntity<ResponseCreateDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = (e.getCause() != null) ? e.getCause().getMessage() : "";
			return new ResponseEntity<>(
					new ResponseCreateDTO(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0, 3),
							"Error Create Data, Please Contact Administrator (" + errorMessage + ")", null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseUpdateDTO> updateBlog(UpdateRequestDTO udto) {
		DataBlog data = new DataBlog();
		ResponseUpdateDTO response = new ResponseUpdateDTO();
		Blog blogResponse = blogrepo.findById(Integer.parseInt(udto.getId())).get();

		LocalDateTime create = blogResponse.getCreated_at();

		LocalDateTime originalDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedUpdate = originalDateTime.format(formatter);
		String formattedCreate = create.format(formatter);
		LocalDateTime parsedDateTime = LocalDateTime.parse(formattedUpdate, formatter);

		try {
			Blog blog = blogrepo.findById(Integer.parseInt(udto.getId())).get();
			blog.setTitle(udto.getAuthor());
			blog.setBody(udto.getBody());
			blog.setAuthor(udto.getAuthor());
			blog.setUpdated_at(parsedDateTime);
			blogrepo.save(blog);

			data.setId(udto.getId());
			data.setTitle(udto.getAuthor());
			data.setBody(udto.getBody());
			data.setAuthor(udto.getAuthor());
			data.setCreated_at(formattedCreate);
			data.setUpdated_at(formattedUpdate);

			response.setResCode(HttpStatus.OK.toString().substring(0, 3));
			response.setResMsg("Success");
			response.setMessage(data);
			return new ResponseEntity<ResponseUpdateDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ResponseUpdateDTO(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0, 3),
							"Error Update Data (" + e.getCause().getMessage() + ")", null),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseDeleteDTO> deleteBlog(DeleteRequestDTO ddto) {
		ResponseDeleteDTO response = new ResponseDeleteDTO();

		try {
			blogrepo.findById(Integer.parseInt(ddto.getId())).get();
			blogrepo.deleteById(Integer.parseInt(ddto.getId()));
			response.setResCode(HttpStatus.OK.toString().substring(0, 3));
			response.setResMsg("Delete ID " + ddto.getId() + " Success");
			return new ResponseEntity<ResponseDeleteDTO>(response, HttpStatus.OK);
		} catch (NoSuchElementException r) {
			response.setResCode(HttpStatus.NOT_FOUND.toString().substring(0, 3));
			response.setResMsg("Data Not Found");
			return new ResponseEntity<ResponseDeleteDTO>(response, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			response.setResCode(HttpStatus.INTERNAL_SERVER_ERROR.toString().substring(0, 3));
			response.setResMsg("Id not found");
			return new ResponseEntity<ResponseDeleteDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
