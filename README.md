# Zally RuleSet Example

Note this is work in progress!!

## ExampleEgoRule

A daft example rule which simply insists that API descriptions refer to "Example Corp".

## Gradle

```bash
./gradlew build
```

Note that there is currently no official public maven repository to supply dependencies.
This example uses a http://jitpack.io repository to access the latest `master-SNAPSHOT`.
Tracked in Zally issue [#964](https://github.com/zalando/zally/issues/964).

## Docker

A test server can be run via docker using the following commands:

```bash
docker build . -t zally_example
docker run --rm -it -p8000:8000 zally_example
```

Note that there are currently no official public docker images to run your ruleset in.
This example assumes a local `zally_server` image exists with the server built.
Tracked in Zally issue [#761](https://github.com/zalando/zally/issues/761).

The rules are patched into zally.jar during the build phase for now,
one day there should be a much cleaner mechanism but for now this is
the best I could come up with.
Tracked in Zally issue [#560](https://github.com/zalando/zally/issues/560).

## Testing

Use a browser to load the server's list of supported rules:

http://localhost:8000/supported-rules

All being well you should be able to see reference to `ExampleEgoRule` and
a link back to this document in the resulting JSON.
