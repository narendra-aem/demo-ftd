package ftd.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables=Resource.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class CTAModel {

    @ValueMapValue
    @Required
    private String title;

    @ValueMapValue
    @Optional
    private String link;

    @ValueMapValue
    @Optional
    private String target;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getTarget() {
        return target;
    }
}
