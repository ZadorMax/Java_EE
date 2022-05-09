package com.example.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Objects;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;

@WebMvcTest(BookController.class)
class DemoApplicationTests {

	@MockBean
	private BookService booksService;
	@Autowired
	private MockMvc mockMvc;

//	@Test
//	@SneakyThrows
//	void saveBook() {
//
//		byte[] book = Objects.requireNonNull(DemoApplicationTests.class.getResourceAsStream("/request.json")).readAllBytes();
//		Book bookObj = new Book("abc", "1234", "Zador Max");
//
//		when(booksService.getAll()).thenReturn(List.of(bookObj));
//
//		mockMvc.perform(
//						post("/save")
//								.content(book)
//								.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().json(new String(Objects.requireNonNull(DemoApplicationTests.class.getResourceAsStream("/response.json")).readAllBytes())));
//
//		verify(booksService).add(any());
//		verify(booksService).getAll();
//	}
//
//	@Test
//	@SneakyThrows
//	void getAllBooks() {
//
//		Book book = new Book("abc", "1234", "Zador Max");
//		//Book bookObj2 = new Book("abc", "1234", "Zador Max");
//		when(booksService.getAll()).thenReturn(List.of(book));
//
//		mockMvc.perform(
//						get("/findAll")
//								.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().json(new String(Objects.requireNonNull(DemoApplicationTests.class.getResourceAsStream("/response.json")).readAllBytes())));
//
//		verify(booksService).getAll();
//	}

}
