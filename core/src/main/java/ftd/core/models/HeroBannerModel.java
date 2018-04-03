package ftd.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

/**
 *
 * The "adaptables" for a Sling Model is the key element.
 * All the injected fields are looked up via a set of Injectors. More documentation can be
 * found here: http://sling.apache.org/documentation/bundles/models.html#available-injectors
 *
 */

@Model(
        adaptables=Resource.class,
        defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL,
        resourceType = "ftd/components/content/heroBanner"
    )
// name=the required name of the exporter
// extensions = the extensions this exporter is registered to
// selector = defaults to "model", can override as needed.
@Exporter(name="jackson", extensions = "json",
            options = {
                    /**
                     * - MapperFeature: Enumeration that defines the simple on/off features to set for ObjectMapper and accessible via ObjectReader and Object Writer
                     * (http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.8.5/com/fasterxml/jackson/databind/MapperFeature.html)
                     * - SerializationFeature: Enumeration that defines simple on/off features that affect the way java Objects are serialized
                     * (http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.8.5/com/fasterxml/jackson/databind/SerializationFeature.html)
                     */
                @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true"),
                @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value= "false")
            }
        )
public class HeroBannerModel {

    @Inject
    @Optional
    private String title;

    @Inject
    @Optional
    private String description;

    @Inject
    @Optional
    private String url;

    @Inject
    @Optional
    private String fileName;

    @Inject
    @Optional
    private String fileReference;

    @Inject
    @Optional
    private String file;

    @Inject
    @Optional
    private String alt;

    @Inject
    @Optional
    private String linkURL;

    @Inject
    @Optional
    private String ctaTitle;

    @Inject
    @Optional
    private String ctaLink;

    @Inject
    @Optional
    private String target;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    @JsonIgnore
    public String getFileName() {
        return fileName;
    }

    @JsonProperty(value = "imageUrl")
    public String getFileReference() {
        return fileReference;
    }

    @JsonIgnore
    public String getFile() {
        return file;
    }

    public String getAlt() {
        return alt;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public String getCtaTitle() {
        return ctaTitle;
    }

    @JsonProperty(value="ctaURL")
    public String getCtaLink() {
        return ctaLink;
    }

    public String getTarget() {
        return target;
    }
}
