/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package au.com.telstra.simcardactivator.Foundation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ActuationResult {
    private boolean success;

    @Override
    public String toString() {
        return "ActuationResult{" +
                "success=" + success +
                '}';
    }
}
