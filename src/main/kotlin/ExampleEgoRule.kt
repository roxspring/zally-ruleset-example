import de.zalando.zally.core.toJsonPointer
import de.zalando.zally.rule.api.*

@Rule(
    ruleSet = ExampleRuleSet::class,
    id = "ExampleEgoRule",
    severity = Severity.MUST,
    title = "Reference Example Corp in API descriptions"
)
class ExampleEgoRule {

    private val ego = "\\bExample\\sCorp\\b"
        .toRegex(RegexOption.IGNORE_CASE)

    @Check(severity = Severity.MUST)
    fun checkInfoDescription(context: Context): Violation? {
        return context.api.info?.description.let { description ->
            val pointer = "/info/description".toJsonPointer()
            when {
                description == null -> Violation("Missing reference to Example Corp!", pointer)
                ego in description -> null
                else -> Violation("Missing reference to Example Corp!", pointer)
            }
        }
    }


}

