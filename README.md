# HAEGroup Test


### Simple launcher application
This repo uses only Android Standard Libraries


## Static analysis

We use [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to keep our codebase in sync with our code style. Formatting runs automatically as a git pre-commit hook.
If you wish to run it manually run:
```bash
# Run lint and display issues
./gradlew ktlintCheck
```

To fix the issues, run:
```bash
# Run lint and try to fix issues automatically (not all issues are fixable this way)
./gradlew ktlintFormat
```