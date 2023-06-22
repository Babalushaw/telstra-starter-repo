package au.com.telstra.simcardactivator.Foundation;

/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown= true)
public class SimCard {
    @NonNull
    private String iccid;
    @NonNull
    private String customerEmail;
    private boolean active;

    @Override
    public String toString() {
        return super.toString();
    }
}
