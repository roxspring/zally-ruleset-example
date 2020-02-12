# Zally RuleSet Example

Note this is work in progress!!

## ExampleEgoRule

A daft example rule which simply insists that API descriptions refer to "Example Corp".

## Gradle

```bash
./gradlew build
```

Note that there is currently no official public maven repository to supply dependencies.
This example uses a http://jitpack.io repository to access a branch build for now.

## Docker

The intention is that a test server can be run via docker using the following commands:

```bash
docker build . -t zally_example
docker run --rm -it -p8000:8000 zally_example
```

Note that there are currently no official public docker images to run your ruleset in.
This example assumes a local `zally_server` image exists with the server built and
still doesn't work because I haven't figured out a good way of injecting the rules into
the image such that the server picks them up!

## Testing

All being well you should be able to browse to the following location and
confirm your custom rules are included:

http://localhost:8000/supported-rules

Note that due to work in progress, the custom rules will not show up yet.