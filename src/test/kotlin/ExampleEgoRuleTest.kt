import de.zalando.zally.core.DefaultContextFactory
import de.zalando.zally.test.ZallyAssertions
import org.junit.Test

class ExampleEgoRuleTest {

    private val cut = ExampleEgoRule()

    @Test
    fun `spec with valid description has no violations`() {

        // language = YAML
        val context = DefaultContextFactory().getOpenApiContext("""
            openapi: 3.0.0
            info:
              title: Example API Title
              version: 1.0.0
              description: This is an API from Example Corp.
        """.trimIndent())

        val violations = cut.checkInfoDescription(context)

        ZallyAssertions.assertThat(violations)
            .isNull()
    }

    @Test
    fun `spec with no description has a violation`() {

        // language = YAML
        val context = DefaultContextFactory().getOpenApiContext("""
            openapi: 3.0.0
            info:
              title: Example API Title
              version: 1.0.0
        """.trimIndent())

        val violations = cut.checkInfoDescription(context)

        ZallyAssertions.assertThat(violations)
            .descriptionEqualTo("Missing reference to Example Corp!")
            .pointerEqualTo("/info/description")
    }

    @Test
    fun `spec with invalid description has a violation`() {

        // language = YAML
        val context = DefaultContextFactory().getOpenApiContext("""
            openapi: 3.0.0
            info:
              title: Example API Title
              version: 1.0.0
              description: Nothing to see here
        """.trimIndent())

        val violations = cut.checkInfoDescription(context)

        ZallyAssertions.assertThat(violations)
            .descriptionEqualTo("Missing reference to Example Corp!")
            .pointerEqualTo("/info/description")
    }
}