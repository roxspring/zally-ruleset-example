import de.zalando.zally.core.AbstractRuleSet
import de.zalando.zally.rule.api.Rule
import java.net.URI

class ExampleRuleSet: AbstractRuleSet() {

    override val url: URI = URI.create("https://github.com/roxspring/zally-ruleset-example/")

    override fun url(rule: Rule): URI = url.resolve("#${rule.id.toLowerCase()}")
}


