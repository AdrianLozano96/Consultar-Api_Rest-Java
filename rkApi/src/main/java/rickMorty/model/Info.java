package rickMorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Info {
    public Integer count;
    public Integer pages;
    public Object next;
    public Object prev;
}
