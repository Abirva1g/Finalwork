package API.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteCreationDTO {
    private Integer id;
    private String name;
    private String content;
    private String color;
    private Integer priority;
    private List<Note> notes;
}

