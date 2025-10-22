package poly.edu.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Builder.Default
    private String photo = "no-photo.jpg";

    private boolean gender;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Min(value = 100, message = "Lương phải >= 100")
    @Digits(message = "Lương không đúng định dạng", integer = 10, fraction = 2)
    @NotNull(message = "Lương không được để trống")
    private Double salary;

    private Integer level;
}
