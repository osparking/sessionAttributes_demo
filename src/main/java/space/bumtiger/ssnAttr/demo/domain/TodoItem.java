package space.bumtiger.ssnAttr.demo.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoItem {
	private String description;
	private LocalDateTime createDate;
}
