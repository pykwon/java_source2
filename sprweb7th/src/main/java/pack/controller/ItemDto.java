package pack.controller;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDto {
	private String id, name;
	private int price;
	private LocalDate regDate;
}
