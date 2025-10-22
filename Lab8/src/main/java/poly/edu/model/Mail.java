package poly.edu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mail {
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private String filenames;
}
