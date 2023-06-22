package au.com.telstra.simcardactivator.Foundation;

/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown= true)
public class SimCard {
    private String iccid;
    private String customerEmail;
    private boolean active;

    @Override
    public String toString() {
        return super.toString();
    }
}
