import de.zalando.zally.core.AbstractRuleSet
import java.net.URI

class ExampleRuleSet: AbstractRuleSet() {

    override val url: URI = URI.create("https://example.com/")
}


